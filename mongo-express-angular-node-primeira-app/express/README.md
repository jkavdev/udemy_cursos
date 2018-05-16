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