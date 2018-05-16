# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Angular JS

* primeiro de tudo, precisamos do angular
* instalar o angular atraves do `npm` e criar um projeto `npm` 

    npm init
    npm i angular --save

* depois importar o arquivo do `angular` no `hmtl`

    <script src="node_modules/angular/angular.min.js"></script>

* criando estrutura inicial, um modulo
* indicando seu nome, e um `array` de dependencias, no caso nenhum `angular.module('app', [])`

    <script>
        angular.module('app', [])
    </script>    

* indicando que o angular tomara conta de uma parte do html, `<html ng-app="app"`
* tudo a partir de `ng-app` sera controlado pelo modulo definido como `app`

    <html ng-app="app"></html>

* executando uma expressao do angular

    <h1>Angular ta funcionado: {{true ? 'SIM' : 'NAO'}}</h1>

# Binding

* o angular atualiza os valores das expressoes de acordo com o seu model
* se o model eh alterado, a expressao tambem eh alterada, ele cria um listener para a express
* no qual ficara observando por mudancas, `Two Way databind = {{value}} <br>`
* caso necessite apenas que este valor atualize apenas uma vez, podemos usar `One time databind = {{:: value}} <br>`
* que indica ao angular que este valor sera atualizado apenas na sua primeira alteracao

    Two Way databind = {{value}} <br>
    One time databind = {{:: value}} <br>

    <input type="text" ng-model="value">        

# Controller

* criando um `controller`
* indicamos o nome do controller `angular.module('app').controller('MeuController', [`
* suas dependencias `'$scope',`
* e o controller em si `function ($scope) {}`, utilizando o `$scope`

    angular.module('app').controller('MeuController', [
            '$scope',
            function ($scope) {
                $scope.value = 10
                $scope.inc = function () {
                    $scope.value++
                }
            }
        ])

* tudo que for atribuido ao `$scope` sera disponibilizado tambem na view, `html`        

    $scope.value = 10
    <h1>{{value}}</h1>

* adicionando um `controller` na view

    <div ng-controller="MeuController">
        <h1>{{value}}</h1>
        <input type="text" ng-model="value">
        <button ng-click="inc()">Incrementar</button>
    </div>  

# Boas praticas, Controller AS

* https://johnpapa.net/ definiu algumas boas praticas com o angularjs
* uma delas e nao utilizar o `$scope` para alteracao do `controller` com a `view`

* agora temos nosso controller, nao precisando do $scope
* temos um objeto que armazenara suas informacoes, `const self = this`
* `const self = this` atribuimos no inicio, pois o valor de `this` pode alterar para outro objeto
* por garantimos que o valor seja o `controller` no inicio

    angular.module('app').controller('MeuController', [
            function () {
                const self = this
                self.value = 10
                self.inc = function () {
                    self.value++
                }
            }
        ])

* para acessar estes valores, temos que utilizar o padrao `Controller As`        
* damos um apelido ao controller `<div ng-controller="MeuController as ctrl">`
* acessando o valor do controller `<h1>{{ctrl.value}}</h1>`

    <div ng-controller="MeuController as ctrl">
        <h1>{{ctrl.value}}</h1>
        <input type="text" ng-model="ctrl.value">
        <button ng-click="ctrl.inc()">Incrementar</button>
    </div>

# Filter

* criando um `filter`    
* temos a definicao de um filtro, com nome `ùpper`
* que retorna uma funcao transformando o input passado em maiusculo
* `return function (input) { return input.toUpperCase() }`

    angular.module('app').filter('upper', function () {
        return function (input) {
            return input.toUpperCase()
        }
    })

* utilizando o `filter`, usamos o `|` para indicar o filtro
* `{{ctrl.value | upper}}`

    <h1>{{ctrl.value | upper}}</h1>    

# Factory

* criando uma `factory`    
* no qual retorna um objeto com a definicao de suas funcionalidades
* `return { upper }`

    angular.module('app').factory('utils', function () {
        function upper(input) {
            return input.toUpperCase()
        }
        return { upper }
    })

* utilizando a `factory` no `controller` `angular.module('app').controller('MeuController', [ 'utils',`

# Service

* a `service` nao difere muito da `factory`, `angular.module('app').service('utils', function () {}`
* criando uma funcao e disponilizando-a, `this.upper = function (input) {}`
* temos que atribuir os valores do services ao `this`, se nao a funcionalidade nao sera exportada

    angular.module('app').service('utils', function () {
        this.upper = function (input) {
            return input.toUpperCase()
        }
    })

# Directive

* criando uma diretiva
* definindo o nome da diretiva `angular.module('app').directive('meuRelogio', function () {}`
* definindo o tipo da diretiva `restrict: 'AE',` `A` significa atributo `<div meu-relogio></div>`, `E` significa elemento `<meu-relogio></meu-relogio>`
* `template: <h2>${new Date}</h2>` define o `html` da diretiva

    angular.module('app').directive('meuRelogio', function () {
        return {
            restrict: 'AE',
            template: `<h2>${new Date}</h2>`
        }
    })    

* utilizando a diretiva
* por padrao eh se criado a diretiva com o CamelCase padrao, `meuRelogio` vira `meu-relogio`

    <h1>Atributo</h1>
    <div meu-relogio></div>
    <hr>
    <h1>Elemento</h1>
    <meu-relogio></meu-relogio>    