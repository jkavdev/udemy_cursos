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

# Pagina de Registro e Login

* definindo acoes de modo de visualizacao dos `form`
* padrao a ser exibido eh a pagina de login `vm.loginMode = true`
* altera a exibicao de login para registro `vm.changeMode = () => vm.loginMode = !vm.loginMode`

        vm.loginMode = true
        vm.changeMode = () => vm.loginMode = !vm.loginMode
        vm.login = () => {
            console.log(`Login... ${vm.user.email}`)
        }
        vm.signup = () => {
            console.log(`Signup... ${vm.user.email}`)
        }    

* criando um componente para o field de login, especificado pelo template, os campos sao diferentes

        angular.module('primeiraApp').component('authField', {
            bindings:
                {
                    id: '@',
                    label: '@',
                    type: '@',
                    grid: '@',
                    icon: '@',
                    model: '=',
                    placeholder: '@',
                    hide: '<'
                },
            controller:
                function () {
                    const self = this
                    this.$onInit = () => self.iconClasses = `glyphicon glyphicon-${self.icon} form-controlfeedback`
                },
            template:
                `
                <div class="form-group has-feedback">
                    <input ng-model="$ctrl.model" id="{{ $ctrl.id }}" class="formcontrol" type="{{ $ctrl.type }}" 
                        placeholder="{{ $ctrl.placeholder }}" ng-hide="$ctrl.hide" />
                    <span class="{{ $ctrl.iconClasses }}"></span>
                </div>
            `
        })       

* formulario de login e registro
* nao exibiremos o nome em login `<auth-field model="auth.user.name" hide="auth.loginMode"></auth-field>`
* e nem a confirmacao de senha `<auth-field model="auth.user.confirm_password" hide="auth.loginMode"></auth-field>`
* os botoes variam de cada modo de exibicao
* sera exibido apenas em login `<button ng-click="auth.login()" ng-show="auth.loginMode">Entrar</button>`
* sera exibido apenas em registro `<button ng-click="auth.signup()" ng-hide="auth.loginMode">Registrar</button>`

        <div class="login-box" ng-controller="AuthCtrl as auth">
            <div class="login-box-body">
                <form>
                    <auth-field id="authName" model="auth.user.name" type="input" placeholder="Informe o Nome" hide="auth.loginMode"></auth-field>
                    <auth-field id="authEmail" model="auth.user.email" type="email" placeholder="Informe o E-mail"></auth-field>
                    <auth-field id="authPass" model="auth.user.password" type="password" placeholder="Informe a Senha"></auth-field>
                    <auth-field id="authConfirmPass" model="auth.user.confirm_password" type="password" placeholder="Confirme a Senha" hide="auth.loginMode"></auth-field>
                    <div class="row">
                        <div class="col-sm-4">
                            <button class="btn btn-primary btn-block btn-flat" ng-click="auth.login()" ng-show="auth.loginMode">Entrar</button>
                            <button class="btn btn-primary btn-block btn-flat" ng-click="auth.signup()" ng-hide="auth.loginMode">Registrar</button>
                        </div>
                    </div>
                </form>
                <br />
                <a href="javascript:;" ng-click="auth.changeMode()">
                    {{ auth.loginMode 
                        ? 'Novo usuário? Registrar aqui!' 
                        : 'Já é cadastrado? Entrar aqui!' }}
                </a>
            </div>
        </div>       

* a parte de autenticacao nao fara parte do html principal da aplicacao
* teremos outro apontando para a autenticacao da aplicacao

        <!DOCTYPE html>
        <html ng-app="primeiraApp">
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <title>Primeira App</title>
            <link rel="stylesheet" href="/assets/css/deps.min.css">
            <link rel="stylesheet" href="/assets/css/app.min.css">
        </head>
        <body class="skin-blue fixed sidebar-mini">
            <div class="wrapper" ng-include="'/auth/form.html'"></div>
            <script src="/assets/js/deps.min.js"></script>
            <script src="/assets/js/app.min.js"></script>
        </body>
        </html>            