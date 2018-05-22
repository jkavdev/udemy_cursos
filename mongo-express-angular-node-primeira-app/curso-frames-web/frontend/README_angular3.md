# Curso Mongo, Express, Angular 1 e Node - Primeira App do Zero com `Leonardo Moura Leitao`

# Instalar o Batarang

* o Batarang fornecera informacoes sobre a aplicacao angular

# Indicando para o angular apenas o oneWayDatabind 
* `<td>{{:: billingCycle.name }}</td>` com `::` indicamos ao angular que ele apenas precisa cuidar deste campo na renderizacao

        <tbody>
            <tr ng-repeat="billingCycle in bcCtrl.billingCycles">
                <td>{{:: billingCycle.name }}</td>
                <td>{{:: billingCycle.month }}</td>
                <td>{{:: billingCycle.year }}</td>
                <td class="table-actions">
                    <button class="btn btn-warning" ng-click="bcCtrl.showTabUpdate(billingCycle)"><i class="fa fa-pencil"></i></button>
                    <button class="btn btn-danger"  ng-click="bcCtrl.showTabDelete(billingCycle)"><i class="fa fa-trash-o"></i></button>
                </td>
            </tr>
        </tbody>
