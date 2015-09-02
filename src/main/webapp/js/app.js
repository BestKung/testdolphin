var app = angular.module('app', ['checklist-model', 'ngRoute', 'employee', 'department', 'employee-information']);
var app = angular.module('app');
app.controller('homeController', function ($scope, $http) {
    checkMobile();
    function  checkMobile() {
        var $mobile = $(window).outerWidth() < 995;
        if ($mobile) {
            $('#nav-topic').css('display', 'none');
            $('body').css('overflow-y', 'hidden');
            console.log('mobile');
        }
    }

});

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        controller: 'homeController',
        templateUrl: 'pages/home.html'

    }).when('/employee', {
        controller: 'employeeController',
        templateUrl: 'pages/employee.html'

    }).when('/department', {
        controller: 'departmentController',
        templateUrl: 'pages/department.html'
    }).when('/employee/information', {
        controller: 'employeeInformationController',
        templateUrl: 'pages/employee-information.html'
    }).when('/dector', {
        templateUrl: 'pages/doctor.html'
    }).otherwise({
        redirectTo: '/'
    });
});