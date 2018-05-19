(function () {
    angular.module('primeiraApp').controller('BillingCycleCtrl',
        [
            `$http`,
            BillingCycleController
        ])

    function BillingCycleController($http) {
        const vm = this

        vm.create = function () {
            const url = 'http://localhost:3003/api/billingSummary'
            $http.post(url, vm.billingCycle)
                .then(function (response) {
                    console.log('Tudo funcionando........')
                })
        }

    }
})()