(function () {
    angular.module('primeiraApp').controller('BillingCycleCtrl',
        [
            `$http`,
            BillingCycleController
        ])

    function BillingCycleController($http) {
        const vm = this
        const url = 'http://localhost:3003/api/billingSummary'

        vm.create = function () {
            console.log('Tudo funcionando........')
            // $http.post(url, vm.billingCycle)
            //     .then(function (response) {
            //         console.log('Tudo funcionando........')
            //     })
        }

    }
})()