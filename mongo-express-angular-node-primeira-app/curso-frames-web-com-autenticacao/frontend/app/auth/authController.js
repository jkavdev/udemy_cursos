(function () {
    angular.module('primeiraApp').controller('AuthCtrl',
        [
            '$location',
            'msgs',
            AuthController
        ])
    function AuthController($location, msgs) {
        const vm = this
        vm.getUser = () => ({ name: 'JKAVDEV', email: 'jhonatan@gmail.com' })

        vm.logout = () => { console.log('Saindo doido...........') }
    }
})()