var machineServices = angular.module('machineServices', ['ngResource']);
machineServices.factory('Machine', ['$resource', function ($resource) {
    console.log("service")
    //return $resource('machines/:machineId', {machineId:'@id'});
    return $resource('machines/:machineId', {machineId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);


var reservationServices = angular.module('reservationServices', ['ngResource']);
reservationServices.factory('Reservation', ['$resource', function ($resource) {
    return $resource('reservations/:reservationId', {reservationId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);


var tenantService = angular.module('tenantServices', ['ngResource']);
tenantService.factory('Tenant', ['$resource', function ($resource) {
    return $resource('tenants/:tenantId', {tenantId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);