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