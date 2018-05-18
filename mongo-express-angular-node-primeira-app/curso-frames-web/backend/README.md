# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Backend da Aplicacao

* dependencias necessarias

    npm i express body-parser mongoose node-restful mongoose-paginate lodash express-query-int pm2 --save

* servidor em desenvolvimento

    npm install nodemon --save-dev    

* rodando a aplicacao
* `"dev": "nodemon"` roda em desenvolvimento
* `"production": "pm2 start loader.js --name backend"` roda em producao

    "dev": "nodemon",
    "production": "pm2 start loader.js --name backend"

# configurando o servidor da aplicacao

* `require('body-parser')` fara alguns parses do corpo da requisicao
* `server.use(bodyParser.urlencoded({ extended: true })` habilita a leitura de mais parametos/funcoes da requisicao
* `server.use(bodyParser.json())` transforma o corpo da requisicao em `json`

    const bodyParser = require('body-parser')
    const express = require('express')
    const server = express()
    server.use(bodyParser.urlencoded({ extended: true }), () => console.log('Funcionando..........'))
    server.use(bodyParser.json())
    server.listen(port, function(){
        console.log(`Olha o servidor ${port} rodando ae..................`)
    })

# Conectando com o `MongoDB`

* `require('mongoose')` objeto que contem funcionalidade de ler e configurar conexao com o `mongoDB`

    const mongoose = require('mongoose')
    module.exports = mongoose.connect('mongodb://localhost/db_finance')

* arquivo `loader.js` contem apenas chamadas aos arquivos de configuracao

    require('./config/server.js')
    require('./config/database')    

# Configurando Schema do banco de dados

* `require('node-restful')` objeto que contem funcionalidade de expor servicos rest mais facil
* `restful.mongoose` cria servicos para comunicacao com o `mongodb`
* `const creditSchema = new mongoose.Schema({})` criando o `schema` de creditos
* `const billingCycleSchema = new mongoose.Schema({})` criando `schema` que engloba os de credito e debito
* `module.exports = restful.model('BiilingCycle', billingCycleSchema)` exportando o objeto `schema` criado

    const restful = require('node-restful')
    const mongoose = restful.mongoose
    const creditSchema = new mongoose.Schema({
        name: { type: String, require: true },
        value: { type: Number, min: 0, required: true }
    })
    const debtSchema = new mongoose.Schema({
        name: { type: String, require: true },
        value: { type: Number, min: 0, required: true },
        status: {
            type: String, require: true, uppercase: true,
            enum: ['PAGO', 'PENDENTE', 'AGENDADO']
        }
    })
    const billingCycleSchema = new mongoose.Schema({
        name: { type: String, require: true },
        month: { type: Number, min: 1, max: 12, required: true },
        year: { type: Number, min: 1970, max: 2100, required: true },
        credits: [creditSchema],
        debts: [debtSchema],
    })
    module.exports = restful.model('BiilingCycle', billingCycleSchema)    

# Criando os servicos REST

* importando os schemas/node-restful `require("./billingCycle")`
* indicando quais requisicoes estarao disponiveis para este objeto `BillingCycle.methods(['get', 'post', 'put', 'delete'])`

    const BillingCycle = require("./billingCycle")
    BillingCycle.methods(['get', 'post', 'put', 'delete'])

# Configurando as Rotas do Servidor

* configurando rota do express, para interceptar todas as requisicoes `/api`

    const express = require('express')
    module.exports = function(server){
        const router = express.Router()
        server.use('/api', router)
    }    

* indicando que o modulo `router.js` necessita do `server` modulo

    const server = require('./config/server')
    require('./config/routes')(server)

* adicionando os servicos `billingCycles` a objeto rota criado
* importa o servico `const billingCycleService = require('../api/billingCycle/billingCycleService')`
* indica ao servico rest, para criar todos os servicos rest, para o `router` e url base definida `/billingCycles`

    const billingCycleService = require('../api/billingCycle/billingCycleService')
    billingCycleService.register(router, '/billingCycles')

# Testando os servicos criados

* requisitando todos os `billingCycles`

    GET /api/billingCycles HTTP/1.1
    Host: localhost:3003

* adicionando `billingCycle`

    POST /api/billingCycles HTTP/1.1
    Host: localhost:3003
    Content-Type: application/x-www-form-urlencoded

    name:Janeiro/17
    month:1
    year:2017
    credits[0][name]:Salario de janeiro
    credits[0][value]:8999
    credits[1][name]:FGTS
    credits[1][value]:1500
    debts[0][name]:Conta de água
    debts[0][value]:150
    debts[1][name]:Conta de luz
    debts[1][value]:150

# Mensagens

* alterando as mensagens de validacao

    mongoose.Error.messages.general.required = "O atributo '{path}' é obrigatorio"

* alterando as mensagens de validacao, no `schema`

    value: { type: Number, min: 0, required: [true, 'Informe o valor do débito'] }

* outras mensagens

    mongoose.Error.messages.Number.min = "O '{VALUE}' informado é menor que o limite mínimo {MIN}."
    mongoose.Error.messages.Number.max = "O '{VALUE}' informado é maior que o limite mínimo {MAX}."
    mongoose.Error.messages.String.enum = "'{VALUE}' não é válido para o atributo {PATH}."    

# Comportamento ao realizar UPDATE    

* quando realizado o `update`, o objeto de retorno nao eh o objeto alterado, e sim o objeto antigo
* `BillingCycle.updateOptions({new: true` indica para trazer o objeto novo
* `BillingCycle.updateOptions({runValidations: true})` indica ao realizar o `update` tambem verificar as validations dos campos


    BillingCycle.updateOptions({new: true, runValidations: true})

# Contantos os ciclos de pagamentos

* criando um roteamento para `/count` para obter a quantidade de ciclos de pagamento
* `BillingCycle.route('count', function (req, res, next) {}` um `route` com uma funcao `middleware`
* `BillingCycle.count(function (error, value) {}` realizando a consulta no banco de dados

    BillingCycle.route('count', function (req, res, next) {
        BillingCycle.count(function (error, value) {
            if (error) {
                res.status(500).json({ errors: [error] })
            } else {
                res.json({ value })
            }
        })
    })    
