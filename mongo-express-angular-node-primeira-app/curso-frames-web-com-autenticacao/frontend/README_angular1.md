# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Aplicando boas praticas

* nao utilizando o `$scope` para conversar com a `view`
* exportando um objeto que conterara os valores do `controller` `const vm = this`

    const vm = this
    vm.getSummary = function () {
        $http.get(url)
            .then(function (response) {
                const { credit = 0, debt = 0 } = response.data
                vm.credit = credit
                vm.debt = debt
                vm.total = credit - debt
            })
    }

    vm.getSummary()

* usando padrao ControllerAs
* damos um apelido ao controller `ng-controller="DashboardCtrl as dashboard"`
* e utilizamos o apelido `{{ dashboard.credit | number: 2}}"`

    <section class="content" ng-controller="DashboardCtrl as dashboard">
        <value-box grid="4" color-class="bg-green" icon-class="fa-blank"
            value="R$ {{ dashboard.credit | number: 2}}" text="Total de créditos"></value-box>
        <value-box grid="4" color-class="bg-red" icon-class="fa-credit-card"
            value="R$ {{ dashboard.debt | number: 2}}" text="Total de débitos"></value-box>
        <value-box grid="4" color-class="bg-blue" icon-class="fa-money"
            value="R$ {{ dashboard.total | number: 2}}" text="Total consolidado"></value-box>
    </section>    

* padrao modulos autocontidos
* removendo as variaveis do scopo global
* padrao

    (function(){
        conteudo_angular
    })()

    (function () {
        angular.module('primeiraApp').controller('DashboardCtrl',
            [ `$http`, ])
        function DashboardController($http) { }
    })()

# Mensagens com `tastr`    

* configurando utils para mensagens
* itera sobre as mensagens `msgs.forEach(msg => toastr[method](msg, title))` e chama o `toastr` para `method(error, success, warning)` passado
* indica apenas os metodos a serem expostos, acessados `return { addSuccess, addError }`

     function addMsg(msgs, title, method) {
        if (msgs instanceof Array) {
            msgs.forEach(msg => toastr[method](msg, title))
        } else {
            toastr[method](msgs, title)
        }
    }
    function addSuccess(msgs) {
        addMsg(msgs, 'Sucesso', 'success')
    }
    function addError(msgs) {
        addMsg(msgs, 'Erro', 'error')
    }

    return { addSuccess, addError }

* utilizando o messages

    msgs.addSuccess('Operação realizada com sucesso!')   

# criando requisicao de atualizacao de dados

* criando a funcao de reset dos dados `vm.refresh = function () { $http.get(url).then(function (response) {}`
* chamando quando criarmos um ciclo de pagamento `$http.post(url, vm.billingCycle).then(function (response) { vm.refresh() }`
* e quando este controller for invocado `vm.refresh()`

    vm.refresh = function () {
            $http.get(url)
                .then(function (response) {
                    vm.billingCycle = {}
                    vm.billingCycles = response.data
                })
        }
        vm.create = function () {
            $http.post(url, vm.billingCycle)
                .then(function (response) {
                    vm.refresh()
                })
        }
        vm.refresh()
    }     

# Controle de abas

* teremos uma `factory` que abstraira o controle das abas, apenas contendo as abas a serem exibidas
* `function show(owner, { tabList = false, tabCreate = false, tabUpdate = false, tabDelete = false, }` temos uma funcao
* que tem um dono e recebe um objeto com os atributos com valores padroes
* aqui atribuimos o valor do dono `owner.tabList = tabList`

    function TabsFactory() {
        function show(owner, {
            tabList = false,
            tabCreate = false,
            tabUpdate = false,
            tabDelete = false,
        }) {
            owner.tabList = tabList
            owner.tabCreate = tabCreate
            owner.tabUpdate = tabUpdate
            owner.tabDelete = tabDelete
        }
        return { show }
    }        

* indicando quais abas a serem exibidos de inicio
* como estamos usando o `controller`, atribuimos o proprio `controller` como dono e quais abas a serem exibidas

    tabs.show(vm, { tabList: true, tabCreate: true })    

* escondendo o conteudo das abas com o ng-if

    <li ng-if="bcCtrl.tabList">list-aba</li>    
    <li ng-if="bcCtrl.tabCreate">create-aba</li>    
    <li ng-if="bcCtrl.tabUpdate">update-aba</li>    
    <li ng-if="bcCtrl.tabDelete">delete-aba</li>    

    <div class="tab-pane" id="tabList" ng-include="'billingCycle/list.html'" ng-if="bcCtrl.tabList"></div>
    <div class="tab-pane" id="tabCreate" ng-include="'billingCycle/form.html'" ng-if="bcCtrl.tabCreate"></div>
    <div class="tab-pane" id="tabUpdate" ng-include="'billingCycle/form.html'" ng-if="bcCtrl.tabUpdate"></div>
    <div class="tab-pane" id="tabDelete" ng-include="'billingCycle/form.html'" ng-if="bcCtrl.tabDelete"></div>

    <button class="btn btn-info" ng-if="bcCtrl.tabUpdate">Alterar</button>
    <button class="btn btn-danger" ng-if="bcCtrl.tabDelete">Excluir</button>