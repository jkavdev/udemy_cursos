const express = require('express')
const server = express()

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

server.listen(3000, () => console.log('Olha ai o servidor rodando.................'))