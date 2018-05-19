(function () {
    angular.module('primeiraApp').controller('BillingCycleCtrl',
        [
            `$http`,
            BillingCycleController
        ])

    function BillingCycleController($http) {
        const vm = this
        vm.billingCycle = {}

        vm.create = function () {

            console.log(vm.billingCycle)

            const url = 'http://localhost:3003/api/billingSummary'
            $http.post(url, vm.billingCycle)
                .then(function (response) {
                    console.log('Tudo funcionando........')
                })
        }

    }
})()