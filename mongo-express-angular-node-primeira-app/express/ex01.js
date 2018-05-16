const express = require('express')
const server = express()

server.get('/', function(req, res){
    console.log('Funcionandoooooooooooooooooooooooooooo')
    res.send('<h1>Funcionandoooooooooooooooooooooooooooo</h1>')
})

server.all('/teste', function(req, res){
    console.log('Com ALL Funcionandoooooooooooooooooooooooooooo')
    res.send('<h1>Com ALL Funcionandoooooooooooooooooooooooooooo</h1>')
})

server.get(/api/, function(req, res){
    console.log('Com API na requisicao Funcionandoooooooooooooooooooooooooooo')
    res.send('<h1>Com API na requisicao Funcionandoooooooooooooooooooooooooooo</h1>')
})

server.listen(3000, () => console.log('Olha ai o servidor rodando.................'))