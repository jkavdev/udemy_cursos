const express = require('express')
const server = express()

server.get('/', function(req, res, next){

    console.log('Funcionando antes NEEXT.................')
    
    next()
    
    console.log('Funcionando depois NEEXT.................')

})

server.get('/', function(req, res){

    console.log('Funcionando sem NEEXT.................')

    res.send('<h1>Funcionandoooooooooooooooooooooooooooo</h1>')

})

server.listen(3000, () => console.log('Olha ai o servidor rodando.................'))