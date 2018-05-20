(function () {
    angular.module('primeiraApp').controller('BillingCycleCtrl',
        [
            '$http',
            'msgs',
            BillingCycleController
        ])

    function BillingCycleController($http, msgs) {
        const vm = this
        vm.billingCycle = {}

        vm.create = function () {
            const url = 'http://localhost:3003/api/billingCycles'
            $http.post(url, vm.billingCycle)
                .then(function (response) {
                    vm.billingCycle = {}
                    msgs.addSuccess('Operação realizada com sucesso!')
                }).catch(function (response) {
                    console.log(response)
                    msgs.addError(response.data.errors)
                })
        }

    }
})()