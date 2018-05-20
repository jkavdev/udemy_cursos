(function () {
    angular.module('primeiraApp').controller('BillingCycleCtrl',
        [
            '$http',
            'msgs',
            BillingCycleController
        ])

    function BillingCycleController($http, msgs) {
        const vm = this
        const url = 'http://localhost:3003/api/billingCycles'

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
                    msgs.addSuccess('Operação realizada com sucesso!')
                }).catch(function (response) {
                    console.log(response)
                    msgs.addError(response.data.errors)
                })
        }

        vm.refresh()
    }
})()