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