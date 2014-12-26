var machineControllers = angular.module('machineControllers', []);

machineControllers.controller('MachineListController', ['$scope', 'Machine', function ($scope, Machine) {

    $scope.currentMachine = new Machine();
    $scope.machines = Machine.query();


    $scope.addMachine = function () {
        $scope.currentMachine = Machine.save($scope.currentMachine);
        $scope.machines.push($scope.currentMachine);
        $scope.currentMachine = {};
    }

    $scope.deleteMachine = function (machine) {
        Machine.remove({machineId: machine.id});

        // remove machine from array
        var index = $scope.machines.indexOf(machine);
        $scope.machines.splice(index, 1);
    }
}]);