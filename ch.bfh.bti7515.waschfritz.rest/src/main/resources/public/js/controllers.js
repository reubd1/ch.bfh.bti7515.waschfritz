var machineControllers = angular.module('machineControllers', []);

machineControllers.controller('MachineListController', ['$scope', 'Machine', function ($scope, Machine) {

    $scope.currentMachine = new Machine();
    $scope.machines = Machine.query();

    $scope.eventSources = [];


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

var calControllers = angular.module('calControllers', []);
calControllers.controller('CalController', ['$scope', 'Reservation', 'Machine', 'Tenant', function ($scope, Reservation, Machine, Tenant) {

    $scope.tenants = Tenant.query();
    $scope.machines = Machine.query();

    $scope.currentReservation = {};

    $scope.events = [];
    Reservation.query().$promise.then(
        function (data) {
            angular.forEach(data, function (value, key) {
                $scope.events.push({
                    title: value.machine.name + ' - ' + value.tenant.name,
                    start: new Date(value.startDate),
                    end: new Date(value.endDate),
                    allDay: false
                });
            });
        });

    $scope.eventSources = [$scope.events];

    $scope.addReservation = function () {

        console.log($scope.currentReservation);

        // update local
        $scope.events.push({
            title: $scope.currentReservation.machine.name + ' - ' + $scope.currentReservation.tenant.name,
            start: $scope.currentReservation.startDate, // ??
            end: $scope.currentReservation.endDate,     // ??
            allDay: false
        });

        // REST call
        $scope.currentReservation = Reservation.save($scope.currentReservation);

        $scope.currentReservation = {};

    };


    // fullCalendar Config
    $scope.uiConfig = {
        calendar: {
            header: {
                left: 'month agendaWeek agendaDay',
                center: 'title',
                right: 'today prev,next'
            },
            firstDay: 1
        }
    };


    // datetimepicker config
    $scope.dateOptions = {
        startingDay: 1,
        showWeeks: false
    };

    $scope.hourStep = 1;
    $scope.minuteStep = 15;

    $scope.timeOptions = {
        hourStep: [1, 2, 3],
        minuteStep: [1, 5, 10, 15, 25, 30]
    };


}]);