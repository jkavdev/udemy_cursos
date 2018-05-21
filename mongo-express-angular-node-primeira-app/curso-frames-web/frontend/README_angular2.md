# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Implementando exclusao do ciclo de pagamento

* como ja temos o objeto ciclo de pagamento quando clicamos no botao de excluir
* podemo criar a url a partir destes dados `const deleteUrl = ${url}/${vm.billingCycle._id}`

    vm.delete = function () {
        const deleteUrl = `${url}/${vm.billingCycle._id}`
        $http.delete(deleteUrl)
            .then(function (response) {
                vm.refresh()
            })
    }

* para impedir que os campos sejam editados na hora da exclusao
* podemos ter um novo atributo no componente `field` `readonly: '<'` indicara que o valor alterara o estado do componente
* indicamos ao elemento `input` para apenas leitura `<input ng-readonly="$ctrl.readonly">`

    readonly: '<'

    <input ng-readonly="$ctrl.readonly">`

* utilizando o `readonly`, indicaremos que ele sera `readonly` apenas quando for excluir `readonly="bcCtrl.tabDelete"`

    <field readonly="bcCtrl.tabDelete"></field>    

# criando o cadastro de creditos do ciclo de pagamento

* iterando sobre os creditos do ciclo `<tr ng-repeat="credit in bcCtrl.billingCycle.credits">`

    <tbody>
        <tr ng-repeat="credit in bcCtrl.billingCycle.credits">
            <td>
                <input ng-model="credit.name" class="form-control" placeholder="Informe o Nome" ng-readonly="bcCtrl.tabDelete">
            </td>
            <td>
                <input ng-model="credit.value" class="form-control" placeholder="Informe o Valor" ng-readonly="bcCtrl.tabDelete" type="number">
            </td>
            <td class="table-actions">
                <button class="btn btn-success" ng-class="{disabled: bcCtrl.tabDelete}"><i class="fa fa-plus"></i></button>
                <button class="btn btn-warning" ng-class="{disabled: bcCtrl.tabDelete}"><i class="fa fa-clone"></i></button>
                <button class="btn btn-danger" ng-class="{disabled: bcCtrl.tabDelete}"><i class="fa fa-trash-o"></i></button>
            </td>
        </tr>
    </tbody>

* utilizando a pagina criada no `form`

    <div class="col-xs-12 col-sm-6">
        <fieldset>
            <legend>Créditos</legend>
            <div ng-include="'billingCycle/creditList.html'"></div>
        </fieldset>
    </div>    

* adicionando pelo menos um credito e debito no ciclo de pagamento

    vm.billingCycle = {credits: [{}], debts: [{}]}    

# realizando as operacoes com creditos e debitos

* faremos as alteracoes com o `splice` dos creditos e debitos 
* `vm.billingCycle.credits.splice(index + 1, 0, {})` indicado para adicionar um objeto vazio na posicao `index + 1`, e nehum elemento a remover
* `vm.billingCycle.credits.splice(index + 1, 0, { name, value })` clonando o objeto, com o mesmo comportamento acima, mas agora passando um objeto com dados
* `vm.billingCycle.credits.splice(index, 1)` removendo o objeto com o `index`, e indicando a quantidade de elementos a serem removidos, apenas um

    vm.addCredit = function (index) {
        vm.billingCycle.credits.splice(index + 1, 0, {})
    }
    vm.cloneCredit = function (index, { name, value }) {
        vm.billingCycle.credits.splice(index + 1, 0, { name, value })
    }
    vm.deleteCredit = function (index) {
        if (vm.billingCycle.credits.length > 1)
        vm.billingCycle.credits.splice(index, 1)
    }
    vm.addDebt = function (index) {
        vm.billingCycle.debts.splice(index + 1, 0, {})
    }
    vm.cloneDebt = function (index, { name, value }) {
        vm.billingCycle.debts.splice(index + 1, 0, { name, value })
    }
    vm.deleteDebt = function (index) {
        if(vm.billingCycle.debts.length > 1)
        vm.billingCycle.debts.splice(index, 1)
    }    

* utilizando no formulario, com os botoes de creditos e debitos
* no angular temos acesso ao `index` atual, com o objeto `$index` `bcCtrl.addCredit($index)`

    <button ng-click="bcCtrl.addCredit($index)"></i></button>
    <button ng-click="bcCtrl.cloneCredit($index, credebtdit)"></button>
    <button ng-click="bcCtrl.deleteCredit($index)"></button>
    <button ng-click="bcCtrl.addDebt($index)"></i></button>
    <button ng-click="bcCtrl.cloneDebt($index, credebtdit)"></button>
    <button ng-click="bcCtrl.deleteDebt($index)"></button>

# Calculando os valores de creditos e debitos

* iteraremos sobre os creditos e debitos para obter o total de creditos e debitos
* `vm.billingCycle.credits.forEach(function ({ value }) {}` iterando sobre creditos e obtendo apenas o valor do credito
* `vm.billingCycle.debts.forEach(function ({ value }) {}` iterando sobre debitos e obtendo apenas o valor do debito
* `vm.credit += !value || isNaN(value) ? 0 : parseFloat(value)` icrementando o valor de creditos com value, verificamos se o valor eh valido `!value || isNaN(value)`


    vm.calculateValues = function () {
        vm.credit = 0
        vm.debt = 0
        if (vm.billingCycle) {
            vm.billingCycle.credits.forEach(function ({ value }) {
                vm.credit += !value || isNaN(value) ? 0 : parseFloat(value)
            })
            vm.billingCycle.debts.forEach(function ({ value }) {
                vm.debt += !value || isNaN(value) ? 0 : parseFloat(value)
            })
        }
        vm.total = vm.credit - vm.debt
    }    

* teremos que atualizar os calculos em pontos especificos

    vm.refresh = function () {
        vm.calculateValues()
    }
    vm.showTabUpdate = function (billingCycle) {
        vm.calculateValues()
    }
    vm.showTabDelete = function (billingCycle) {
        vm.calculateValues()
    }
    vm.cloneCredit = function (index, { name, value }) {
        vm.calculateValues()
    }
    vm.deleteCredit = function (index) {
        vm.calculateValues()
    }
    vm.cloneDebt = function (index, { name, value, status }) {
        vm.calculateValues()
    }
    vm.deleteDebt = function (index) {
        vm.calculateValues()
    }    

* e adicionando evento no campo do valor de credito e debito para atualizar os calculos
* para isso usaremos o `ng-change="bcCtrl.calculateValues()"`

    <input ng-model="debt.value" ng-change="bcCtrl.calculateValues()">
    <input ng-model="credit.value" ng-change="bcCtrl.calculateValues()">