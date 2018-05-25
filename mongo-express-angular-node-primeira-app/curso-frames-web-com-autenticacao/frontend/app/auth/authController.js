(function () {
    angular.module('primeiraApp').controller('AuthCtrl',
        [
            '$location',
            'msgs',
            AuthController
        ])
    function AuthController($location, msgs) {
        const vm = this

        vm.loginMode = true

        vm.changeMode = () => vm.loginMode = !vm.loginMode

        vm.login = () => {
            console.log(`Login... ${vm.user.email}`)
        }

        vm.signup = () => {
            console.log(`Signup... ${vm.user.email}`)
        }

        vm.getUser = () => ({ name: 'JKAVDEV', email: 'jhonatan@gmail.com' })

        vm.logout = () => { console.log('Saindo doido...........') }
    }
})()