# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Template AdminLTE

* realizando a inclusao de paginas com o `angular` `ng-include="'/template/header.html'"`
* passando o controle das `view` para `angular-route` `ui-view`

    <body class="skin-blue fixed sidebar-mini">
        <div class="wrapper">
            <header class="main-header" ng-include="'/template/header.html'"></header>
            <header class="main-sidebar" ng-include="'/template/menu.html'"></header>
            <header class="content-wrapper" ui-view></header>
            <div class="content-footer" ng-include="'/template/footer.html'"></div>
        </div>
        <script src="/assets/js/deps.min.js"></script>
        <script src="/assets/js/app.min.js"></script>
    </body>

* corrigindo posicao do `footer`    

    .main-footer{
        position: fixed;
        bottom: 0px;
        width: 100%;
    }

# Configurando as rotas
* objetos do `angular-router` que irao transitar entre as telas
* `'$stateProvider', '$urlRouterProvider',`
* `.state('dashboard', { url: '/dashboard', templateUrl: 'dashboard/dashboard.html' })`
* indica o estado, `url` indica a `url` a ser alterada no `browser`, `templateUrl`, a pagina que sera carregada em `ui-vew`
* caso nehnuma rota conhecida `$urlRouterProvider.otherwise('/billingCycle')` retorna para a rota padrao

    angular.module('primeiraApp').config(
    [
        '$stateProvider',
        '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $stateProvider
                .state('dashboard', {
                    url: '/dashboard',
                    templateUrl: 'dashboard/dashboard.html'
                })
                .state('billingCycle', {
                    url: '/billingCycles',
                    templateUrl: 'billingCycle/tabs.html'
                })

            $urlRouterProvider.otherwise('/billingCycle')
        }
    ]
)    

# Componente do conteudo do Header

* conteudo estatico, nao sofrera alteracao, apenas quando renderizado  `name: '@', small: '@',`

    angular.module('primeiraApp').component('contentHeader', {
        bindings: {
            name: '@',
            small: '@',
        },
        template: `
            <section class="content-header">
                <h1>{{ $ctrl.name }} <small>{{ $ctrl.small }}</small> </h1>
            </section>
        `
    })