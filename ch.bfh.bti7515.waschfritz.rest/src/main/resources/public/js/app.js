//(function () {

angular.module('washFritzApp', ['machineControllers', 'machineServices', 'tabCtrl', 'validationCtrl', 'tenantServices']);
angular.module('calApp', ['calControllers', 'reservationServices', 'machineServices', 'tenantServices', 'ui.calendar', 'ui.bootstrap.datetimepicker']);
//})();