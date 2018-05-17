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