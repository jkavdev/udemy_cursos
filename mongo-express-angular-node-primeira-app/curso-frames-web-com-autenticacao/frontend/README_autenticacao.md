# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Exibindo Usuario
* definimos para o angular gerenciar estes dados de exibicao apenas uma vex `{{:: auth.getUser().name }}`
* link para a acao de logout `<a href ng-click="auth.logout()">Sair</a>`

        <a href class="dropdown-toggle" data-toggle="dropdown">
            <img src="/assets/imgs/user.jpg" class="user-image" alt="User Image">
            <span class="hidden-xs">{{:: auth.getUser().name }}</span>
        </a>
        <ul class="dropdown-menu">
            <li class="user-header">
                <img src="/assets/imgs/user.jpg" class="img-circle" alt="User Image">
                <p>
                    {{:: auth.getUser().name }}
                    <small>{{:: auth.getUser().email }}</small>
                </p>
            </li>
            <li class="user-footer">
                <div class="pull-right">
                    <a href class="btn btn-default btn-flat" ng-click="auth.logout()">Sair</a>
                </div>
            </li>
        </ul>

* atribuindo o controler ao navbar e definindo pagina de exibicao do usuario `<li ng-include="'/template/header/navbar/user.html'" ng-controller="AuthCtrl as auth"></li>`

        <a href class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu" ng-include="'/template/header/navbar/user.html'" ng-controller="AuthCtrl as auth"></li>
            </ul>
        </div>        

* controller do usuario

                angular.module('primeiraApp').controller('AuthCtrl',
                    [
                        '$location',
                        'msgs',
                        AuthController
                    ])
                function AuthController($location, msgs) {
                    const vm = this
                    vm.getUser = () => ({ name: 'JKAVDEV', email: 'jhonatan@gmail.com' })
                    vm.logout = () => { console.log('Saindo doido...........') }
                }