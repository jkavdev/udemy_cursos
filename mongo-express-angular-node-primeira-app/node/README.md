# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Node

* criando uma funcao com ecmascript 6, e atribuindo a `ola`

    const ola = () => console.log('Funcionando.........')

* setInterval do node, recebe o que executar e de quando em quando, no caso de um segund

    setInterval(ola, 1000)    

* para executar, apenas ir no documento digitar o comando

    node ex01.js    

* criando uma funcao em um arquivo

    function upper(text) {
        return text.toUpperCase()
    }

* se quisermos expor esta funcao, podemos expor com o node    

    module.exports = { upper }    
    module.exports = { upper: upper }   

* importando a funcao/modulo, para isso usamos o `require('./ex02_utils')` com o caminho relatrilo

    const utils = require('./ex02_utils')

* utilizando a funcao    

    console.log(utils.upper('Funcionadoooooooooooooo............'))     

* todos os modulos sao `singleton` temos apenas uma instancia para todas as chamadas para o modulo