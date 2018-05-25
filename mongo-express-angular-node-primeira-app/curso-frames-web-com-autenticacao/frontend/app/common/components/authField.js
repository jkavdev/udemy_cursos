(function () {
    angular.module('primeiraApp').component('authField', {
        bindings:
            {
                id: '@',
                label: '@',
                type: '@',
                grid: '@',
                icon: '@',
                model: '=',
                placeholder: '@',
                hide: '<'
            },
        controller:
            function () {
                const self = this
                this.$onInit = () => self.iconClasses = `glyphicon glyphicon-${self.icon} form-controlfeedback`
            },
        template:
            `
            <div class="form-group has-feedback">
                <input ng-model="$ctrl.model" id="{{ $ctrl.id }}" class="formcontrol" type="{{ $ctrl.type }}" 
                    placeholder="{{ $ctrl.placeholder }}" ng-hide="$ctrl.hide" />
                <span class="{{ $ctrl.iconClasses }}"></span>
            </div>
        `
    })
})()