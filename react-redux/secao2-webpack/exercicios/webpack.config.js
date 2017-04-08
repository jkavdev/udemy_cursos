//realizando referencia o webpack
const webpack = require('webpack')

//Cofiguração do webpack
module.exports = {
    //Ponte de entrar, arquivo de entrada de configuração, definicao de dependencias, etc.
    entry: './ex/index.js',
    //Configuração de saida do webpack, arquivo que será geradoJhou99346554
    output: {
        path: __dirname + '/public', 
        filename: './bundle.js'
    },
    //Configuração do servidor
    devServer: {
        port: 8080,
        contentBase: './public'
    }
}