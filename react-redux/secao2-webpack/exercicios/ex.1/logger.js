//Criando função recebe um texto exibe no console de degub
//Que sera disponibilizada pela padrao de modulos do node, CommonsJS
function info(text){
    console.log(`INFO: ${text}`)
}

//Expondo a funcao criada
module.exports = { info }