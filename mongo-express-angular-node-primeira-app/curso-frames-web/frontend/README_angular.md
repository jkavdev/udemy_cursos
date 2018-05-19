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

# Funcao que retornara as classes de `grid` do `bootstrap`

* separa os numeros passados `const cols = numbers ? numbers.split(' ') : []`
* adiciona as classes `if (cols[0]) classes += `col-xs-${cols[0]}``

    function toCssClasses(numbers) {
        const cols = numbers ? numbers.split(' ') : []
        let classes = ''
        if (cols[0]) classes += `col-xs-${cols[0]}`
        if (cols[1]) classes += ` col-sm-${cols[1]}`
        if (cols[2]) classes += ` col-md-${cols[2]}`
        if (cols[3]) classes += ` col-lg-${cols[3]}`
        return classes
    }

* testando

    toCssClasses('12 4 6 2')
    "col-xs-12 col-sm-4 col-md-6 col-lg-2"
    toCssClasses('12 2')
    "col-xs-12 col-lg-2"

# Buscando os dados do sumario
* `.success(function ({ credit = 0, debt = 0 }) {}` estamos indicando para extrair as variaveis e disponibiliza-las na funcao
* atribuindo valores ao escopo `$scope.credit = credit $scope.debt = debt $scope.total = credit - debt`

    $http.get(url)
        .success(function ({ credit = 0, debt = 0 }) {
            $scope.credit = credit
            $scope.debt = debt
            $scope.total = credit - debt
        })    

* formatando os valores exibidos dos creditos debitos e total

    {{ credit | number: 2}}
    {{ debt | number: 2}}
    {{ total | number: 2}}
