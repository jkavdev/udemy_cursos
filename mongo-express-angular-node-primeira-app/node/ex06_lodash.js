const _ = require('lodash')

const alunos = [
    {nome: 'Jhonatan', nota: 5.6},
    {nome: 'Mendes', nota: 8.0},
    {nome: 'Lucas', nota: 4.6}
]

const media = _.sumBy(alunos, 'nota') / alunos.length

console.log('Medias dos alunos ', media)