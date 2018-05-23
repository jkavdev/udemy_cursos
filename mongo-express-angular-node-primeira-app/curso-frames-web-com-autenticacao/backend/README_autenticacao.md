# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Autenticação - Backend

* dependencias a serem instaladas

    npm install --save bcrypt@1.0.2 jsonwebtoken@7.3.0

* criando arquivo que conterara a chave de para geracao do token
* `.env`, via de regra eh um arquivo que deve ser protegido, nao deve ir para git

    module.exports = {
        authSecret: 'ChaveMuitoSecreta'
    }    

# Esquema representando o usuario a ser logado

        const userSchema = new mongoose.Schema({
            name: { type: String, required: true },
            email: { type: String, required: true },
            password: { type: String, min: 6, max: 12, required: true },
        })    

# Servicos da validacao

* validando email e senha

        const emailRegex = /\S+@\S+\.\S+/
        const passwordRegex = /((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,12})/

* abstraindo camada de erros do banco, e fornecendo mensagens genericas

        const sendErrorsFromDB = (res, dbErrors) => {
            const errors = []
            _.forIn(dbErrors.errors, error => errors.push(error.message))
            return res.status(400).json({ errors })
        }        

* metodo de logar
* temos uma middleware que 
* recuperando informacoes da requisicao `const email = req.body.email || '' const password = req.body.password || ''`
* importante usar `https`, se nao estas informacoes ficam disponiveis na rede, abertas para o wireshark por exemplo
* obtendo o usario por email `User.findOne({ email }, (err, user) => {}`, temos uma callback, com o erros ou usuario buscado `(err, user)`
* comparando a senha passada com a senha do banco `bcrypt.compareSync(password, user.password)`
* gerando o token `const token = jwt.sign(user, env.authSecret, { expiresIn: "1 day" })`, passando a senha secreta mais o usuario, com expieracao de um dia
* respodendo a requisicao com o usuario e token `res.json({ name, email, token })`
* importante nao especificar na mensagem caso de erro `return res.status(400).send({ errors: ['Usuário/Senha inválidos'] })` a causa do erro

        const login = (req, res, next) => {
            const email = req.body.email || ''
            const password = req.body.password || ''
            User.findOne({ email }, (err, user) => {
                if (err) {
                    return sendErrorsFromDB(res, err)
                }
                else if (user && bcrypt.compareSync(password, user.password)) {
                    const token = jwt.sign(user, env.authSecret, { expiresIn: "1 day" })
                    const { name, email } = user
                    res.json({ name, email, token })
                } else {
                    return res.status(400).send({ errors: ['Usuário/Senha inválidos'] })
                }
            })
        }     

* validando o token
* como o token fica armazenado no browser temos que valida-lo

        const validateToken = (req, res, next) => {
            const token = req.body.token || ''
            jwt.verify(token, env.authSecret, function (err, decoded) {
                return res.status(200).send({ valid: !err })
            })
        }           

* metodo de signup
* validando senha e email `if (!email.match(emailRegex)) {} if (!password.match(passwordRegex)) {}`
* gera uma senha hash `const salt = bcrypt.genSaltSync() const passwordHash = bcrypt.hashSync(password, salt)`
* no caso quando temos uma consulta e comparamos as senhas, estamos verificando se a buscada hash, foi feita da senha a 
* ser comparada `bcrypt.compareSync(password, user.password)`
* comparando confirmacaoes e senha `if (!bcrypt.compareSync(confirmPassword, passwordHash)) { return res.status(400).send({ errors: ['Senhas não conferem.'] }) }`
* realizando a consulta no banco para verificar se ja nao existe usuario cadastrado `User.findOne({ email }, (err, user) => {}`

        const signup = (req, res, next) => {
            const name = req.body.name || ''
            const email = req.body.email || ''
            const password = req.body.password || ''
            const confirmPassword = req.body.confirm_password || ''

            if (!email.match(emailRegex)) {
                return res.status(400).send({ errors: ['O e-mail informado está invá lido'] })
            }
            if (!password.match(passwordRegex)) {
                return res.status(400).send({ errors: ["Senha precisar ter: uma letra maiúscula, uma letra minúscula, um n úmero, uma caractere especial(@#$%) e tamanho entre 6-12."] })
            }
            
            const salt = bcrypt.genSaltSync()
            const passwordHash = bcrypt.hashSync(password, salt)
            if (!bcrypt.compareSync(confirmPassword, passwordHash)) {
                return res.status(400).send({ errors: ['Senhas não conferem.'] })
            }
            User.findOne({ email }, (err, user) => {
                if (err) {
                    return sendErrorsFromDB(res, err)
                }
                else if (user) {
                    return res.status(400).send({ errors: ['Usuário já cadastrado.'] })
                }
                else {
                    const newUser = new User({ name, email, password: passwordHash })
                    newUser.save(err => {
                        if (err) {
                            return sendErrorsFromDB(res, err)
                        }
                        else { login(req, res, next) }
                    })
                }
            })
        }        