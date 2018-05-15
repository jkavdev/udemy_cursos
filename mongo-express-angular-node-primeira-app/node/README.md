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

* nao temos acesso a variavel criada no global, pois nao atribuimos esta variavel ao global

    const PI = 3.14
    console.log(PI)
    console.log(global.PI)

* mas podemos atribuir um valor caso queiramos

    global.obj = {name: 'Olha o global funcionandooooooooooo!'}

* podemos acessar este valor em qualquer lugar

    const s1 = require('./ex04_global')
    console.log(global.obj.name)
    console.log(obj.name)        

* o `this` faz referencia ao modulo esportado, podemos ver a diferenca

    console.log(global === this) > false
    console.log(module === this) > false
    console.log(module.exports === this) > true

* podemos tambem exportar uma funcao com o `this`

    this.digaOi = () => console.log('Tá funcionandooooooooo, usando this nesta porra!')

* acessando a funcao

    const s1 = require('./ex05_module')
    s1.digaOi()    

# Gerenciamento de Pacotes

* iniciando um projeto com o gerenciador de pacotes do `Node`

    npm init

* instalando o `lodash`, `--save` indica que sera local, na pasta

    npm install lodash --save

* recebendo parametros e utilizando `backchicks`, 
* `console.log('Param informado foi ${param}')` `backchicks`

    module.exports = function(param){
        console.log(`Param informado foi ${param}`)
    }    

* chamando o modulo

    const moduloComoParametro = require('./ex07_param')
    moduloComoParametro('Olha meu Parametro AEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE')

* visualizando os argumentos passados pelo `node`    
* `process.argv` contem algumas informacoes dos parametros que sao passados pelo `node`
* verifica se o parametro passado esta entre os parametros do node `return process.argv.indexOf(param) !== -1`

    console.log(process.argv)
    function temParam(param) {
        return process.argv.indexOf(param) !== -1
    }
    if (temParam('--producao')) {
        console.log('Fullllll Atention bitchs')
    } else {
        console.log('Nao tem')
    }

* passando os parametros para `node`

    node ex08_process --producao outro massa

* recebendo dados da entrada padrao pelo angular
* `process.stdout.write` chama funcao de escrever
* `process.stdin.on('data', function(data){}` chama funcao de entrada de dados

    process.stdout.write('Usando entrada do angular!  ')
    process.stdin.on('data', function(data){
        process.stdout.write(`O que vc pensou, troucha ${data.toString()}`)
        process.exit()
    })    