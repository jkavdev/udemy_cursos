const port = 3003

const bodyParser = require('body-parser')
const express = require('express')
const server = express()

server.use(bodyParser.urlencoded({ extended: true }), () => console.log('Funcionando..........'))
server.use(bodyParser.json())

server.listen(port, function(){
    console.log(`Olha o servidor ${port} rodando ae..................`)
})