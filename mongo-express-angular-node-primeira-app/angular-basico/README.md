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
