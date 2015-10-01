var app = angular.module('app', ['checklist-model', 'ngRoute', 'employee', 'department', 'employee-information','doctor','doctor-information','patient']);
var app = angular.module('app');
app.controller('homeController', function ($scope, $http) {
    $scope.login = {};
    checkMobile();
    function  checkMobile() {
        var $mobile = $(window).outerWidth() < 995;
        if ($mobile) {
            $('#nav-topic').css('display', 'none');
            $('body').css('overflow-y', 'hidden');
            $('#view').removeAttr('style').addClass('.margin-top');
            console.log('mobile');
        }
    }

    startPageStaff();
    function startPageStaff() {
        $http.get('/startpagestaff').success(function (data) {
            $scope.login = data;
            hasLogin();
        });
    }


    function hasLogin() {
        if (!!$scope.login.id) {
            $('#login').removeClass('btn-blue').addClass('btn-red').html('Logout');
        }
    }
    
    $scope.clickLogout = function (){
        console.log(!!$('#logout').hasClass('.btn-red'));
        if(!!$scope.login.id){
            location.href="/logout";
            console.log('logout');
        }
    };


});

app.factory('employeeService', function () {
    return {
        employeeUpdate: {}, doctorUpdate : {}
    };
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
    }).when('/doctor', {
        controller:'doctorController',
        templateUrl: 'pages/doctor.html'
    }).when('/doctor/information',{
        controller:'doctorInformationController',
        templateUrl:'pages/doctor-information.html'
    }).when('/patient',{
        controller:'patientController',
        templateUrl:'pages/patient.html'
    }).otherwise({
        redirectTo: '/'
    });
});