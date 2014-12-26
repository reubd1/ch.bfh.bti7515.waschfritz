var machineServices = angular.module('machineServices', ['ngResource']);
machineServices.factory('Machine', ['$resource', function ($resource) {
    console.log("service")
    //return $resource('machines/:machineId', {machineId:'@id'});
    return $resource('machines/:machineId', {machineId: '@id'}, {
        'update': {method: 'PUT'}
    });
}]);