const express = require('express')
const server = express()

server.route('/clientes')
    .get((req, res) => res.send('Lista de clientes'))
    .post((req, res) => res.send('Adicionando cliente'))
    .put((req, res) => res.send('Alterando cliente'))
    .delete((req, res) => res.send('Removendo cliente'))

server.listen(3000, () => console.log('Olha ai o servidor rodando.................'))