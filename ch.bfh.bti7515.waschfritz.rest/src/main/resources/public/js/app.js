//(function () {

angular.module('washFritzApp', ['machineControllers', 'machineServices', 'tabCtrl', 'validationCtrl', 'tenantServices', 'reservationControllers', 'reservationServices']);
angular.module('calApp', ['calControllers', 'reservationServices', 'machineServices', 'tenantServices', 'ui.calendar', 'ui.bootstrap.datetimepicker']);
//})();