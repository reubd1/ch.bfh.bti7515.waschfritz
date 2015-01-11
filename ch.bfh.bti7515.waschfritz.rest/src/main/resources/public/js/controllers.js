var machineControllers = angular.module('machineControllers', []);

machineControllers.controller('MachineListController', ['$scope', 'Machine', function ($scope, Machine) {

    $scope.currentMachine = new Machine();
    $scope.machines = Machine.query();

    $scope.eventSources = [];


    $scope.addMachine = function () {
        // check to make sure the form is completely valid
        if ($scope.machineForm.$valid) {
            $scope.currentMachine = Machine.save($scope.currentMachine);
            $scope.machines.push($scope.currentMachine);
            $scope.currentMachine = {};
            $scope.machineForm.$setPristine();
        }
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
    
    var initDates = function() {
        $scope.currentReservation = {};
        $scope.currentReservation.startDate = new Date();
        $scope.currentReservation.endDate = new Date(new Date().getTime() + 2*60*60*1000); // Now + 2 hrs        
        
    };
    
    initDates();

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
        bool = true;
        var newStartDate = $scope.currentReservation.startDate;
        var newEndDate = $scope.currentReservation.endDate;


        //loop trough all existing reservations and compare existing dates with choosen daterange
        Reservation.query().$promise.then(
            function (data) {
                angular.forEach(data, function (value, key) {
                    if(bool) {
                        var startDate = new Date(value.startDate);
                        var endDate = new Date(value.endDate);
                        // TODO: check only if same machine
                        var machine = value.machine;
                        console.log("current machineId " + $scope.currentReservation.machine.id);
                        console.log("existing " + machine.id);
                        //check if there is not already a booking in the choosen daterange
                        if ((newStartDate > endDate && newEndDate > endDate) || (newStartDate < startDate && newEndDate < startDate)) {
                           bool = true;
                        }
                        else {
                           bool = false;
                            alert("There is already a booking for this timerange");
                        }
                    }
                });
            });

        setTimeout(function() {
        if(bool && newEndDate>newStartDate && $scope.dateForm.$valid) {

            // update local
            $scope.events.push({
                title: $scope.currentReservation.machine.name + ' - ' + $scope.currentReservation.tenant.name,
                start: $scope.currentReservation.startDate, // ??
                end: $scope.currentReservation.endDate,     // ??
                allDay: false
            });
            // REST call
            $scope.currentReservation = Reservation.save($scope.currentReservation);
            $scope.dateForm.$setPristine();

        }
        else{
           alert("Reservation is not valid");
        }

            initDates();
        },3000);


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



    var app = angular.module('tabCtrl', []);

    app.controller('TabController', function () {
        this.tab = 1;

        this.setTab = function (tabId) {
            this.tab = tabId;
        };

        this.isSet = function (tabId) {
            return this.tab === tabId;
        };
    });

// create angular app
var validationControllers = angular.module('validationCtrl', []);

// create angular controller
validationControllers.controller('TenantListController', ['$scope', 'Tenant', function ($scope, Tenant) {


    $scope.currentTenant = new Tenant();
    $scope.tenants = Tenant.query();

    $scope.eventSources = [];


    // function to submit the form after all validation has occurred
    $scope.addTenant = function() {
        // check to make sure the form is completely valid
        if ($scope.tenantForm.$valid) {
            $scope.currentTenant = Tenant.save($scope.currentTenant);
            $scope.tenants.push($scope.currentTenant);
            $scope.currentTenant = {};
            $scope.tenantForm.$setPristine();
        }

    }

    $scope.deleteTenant = function (tenant) {
        Tenant.remove({tenantId: tenant.id});

        // remove tenant from array
        var index = $scope.tenants.indexOf(tenant);
        $scope.tenants.splice(index, 1);
    }

}]);

var reservationControllers = angular.module('reservationControllers', []);

reservationControllers.controller('ReservationListController', ['$scope', 'Reservation', function ($scope, Reservation) {

    $scope.currentReservation = new Reservation();
    $scope.reservations = Reservation.query();

    $scope.eventSources = [];

    $scope.deleteReservation = function (reservation) {
        Reservation.remove({reservationId: reservation.id});

        // remove reservation from array
        var index = $scope.reservations.indexOf(reservation);
        $scope.reservations.splice(index, 1);
    }
}]);