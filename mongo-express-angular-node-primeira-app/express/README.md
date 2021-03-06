# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Express

* criando uma instancia do `express` e do servidor

    const express = require('express')
    const server = express()

* indicando para o servidor interceptar o `get` oara `/` e fazendo uma acao

    server.get('/', function(req, res){
        console.log('Funcionandoooooooooooooooooooooooooooo')
        res.send('<h1>Funcionandoooooooooooooooooooooooooooo</h1>')
    })

* indicando para o servidor interceptar todas as requisicoes `http` para `/teste`

    server.all('/teste', function(req, res){
        console.log('Com ALL Funcionandoooooooooooooooooooooooooooo')
        res.send('<h1>Com ALL Funcionandoooooooooooooooooooooooooooo</h1>')
    })

* indicando para o servidor interceptar todas as requisicoes `http` de acordo com a expressao definida `/api/`

    server.get(/api/, function(req, res){
        console.log('Com API na requisicao Funcionandoooooooooooooooooooooooooooo')
        res.send('<h1>Com API na requisicao Funcionandoooooooooooooooooooooooooooo</h1>')
    })

* indicando ao servidor para rodar na porta 2000 e executar um log quando subir    

    server.listen(3000, () => console.log('Olha ai o servidor rodando.................'))

* utilizando `middlewares` ao interceptar uma requisicao
* estamos indicando que interceptaremos todas as requisicoes para `/` e teremos o `next`, como parametro
* `next()` indicamos que suspederemos a interceptacao atual e passamos para a proxima interceptacao, ou configuracao
* no caso quando as outras terminaremos ele volta pra interceptacao com o `next` e segue o fluxo normal


    server.get('/', function(req, res, next){
        console.log('Funcionando antes NEEXT.................')
        next()
        console.log('Funcionando depois NEEXT.................')
    })
    server.get('/', function(req, res){
        console.log('Funcionando sem NEEXT.................')
        res.send('<h1>Funcionandoooooooooooooooooooooooooooo</h1>')
    })

* utilizando metodo com base em uma requisicao
* com `server.use('/', function(req, res){}` indicamos que temos uma `/` como base, e todo resto de requisicao entrara aqui
* `server.use('/api/teste', function(req, res){}` sera executado caso alguma requisicao satisfaca esta condicao

    server.get('/', function(req, res, next){
        console.log('Funcionando com GET.................')
        next()
    })
    server.use('/', function(req, res, next){
        console.log('Funcionando com USE.................')
        res.send('<h1>Funcionandoooooooooooooooooooooooooooo</h1>')
        next()
    })
    server.use('/api/teste', function(req, res){
        console.log('Funcionando com USE TEST.................')
    })

* mapeando uma rota de requisicao e adicionando varios middlewares
* criando a rota pra aceitar as requisicao a partir de `cliente` `server.route('/clientes')`
* e depois encadeando as chamadas aos tipos de requisicoes

    server.route('/clientes')
        .get((req, res) => res.send('Lista de clientes'))
        .post((req, res) => res.send('Adicionando cliente'))
        .put((req, res) => res.send('Alterando cliente'))
        .delete((req, res) => res.send('Removendo cliente'))

# Utilizando `Router`        

* criando uma instancia do `Router`, `const router = express.Router()`
* `router.use((req, res, next) => {}` indicando para qualquer requisicao esta rota sera chamada
* `router.get('/produtos/:id', (req, res, next) => {}` indicando uma requisicao `get` para a rota e recebendo um parametro
* no final temos que expor a rota `module.exports = router`

    const express = require('express')
    const router = express.Router()
    router.use((req, res, next) => {
        const init = Date.now()
        next()
        console.log(`Tempo = ${Date.now() - init} ms`)
    })
    router.get('/produtos/:id', (req, res, next) => {
        res.json({id: req.params.id, name: 'Outra coisa'})
    })
    router.get('/clientes/:id/:name', (req, res, next) => {
        res.json({id: req.params.id, name: req.params.name})
    })
    module.exports = router

* utilizando a rota como um conjunto de `middlewares`
* importando a rota `const router = require('./ex05_routes')`
* indicando para a requisicao `/api`, sera chamado a rota, `server.use('/api', router)`

    const router = require('./ex05_routes')
    server.use('/api', router)    

# Server e Router Singletons?    

* por padrao uma referencia para um modulo e sempre um `singleton`, `(express1 === express2) = true`
* o que nao ocorre tanto para `express1()` e `express1.Router()`, `(server1 === server2) = false` e `(router1 === router2) = false`

    const express1 = require('express')
    const express2 = require('express')
    console.log(express1 === express2)
    const server1 = express1()
    const server2 = express1()
    console.log(server1 === server2)
    const router1 = express1.Router()
    const router2 = express1.Router()
    console.log(router1 === router2)