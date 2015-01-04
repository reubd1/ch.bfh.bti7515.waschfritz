//(function () {

angular.module('washFritzApp', ['machineControllers', 'machineServices']);
angular.module('calApp', ['calControllers', 'reservationServices', 'machineServices', 'tenantServices', 'ui.calendar', 'ui.bootstrap.datetimepicker']);
//})();