(function () {
    angular.module('primeiraApp').controller('DashboardCtrl',
        [
            `$http`,
            DashboardController
        ])

    function DashboardController($http) {
        const vm = this
        const url = 'http://localhost:3003/api/billingSummary'

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

    }
})()