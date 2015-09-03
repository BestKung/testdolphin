angular.module('employee-information', []);
angular.module('employee-information').controller('employeeInformationController', function ($scope, $http) {
    $scope.employees = {};
    $scope.page = 0;
    $scope.row = 10;
    $scope.currentPage = 1;
    $scope.searchData = {};
    $scope.preScroll = 0;
    var totalEmployees = totalEmployees;
    checkMobile();
    function checkMobile() {
        var $mobile = $(window).outerWidth() < 995;
        if ($mobile) {
            $('th').removeAttr('style');
        }
    }

    getEmployees();
    function getEmployees() {
        $http.get('/employees', {params: {page: $scope.page, size: $scope.row}}).success(function (data) {
            $scope.employees = data;
        }).error(function (data) {

        });
    }

    getTotalEmployee();
    function getTotalEmployee() {
        $http.get('/totalemployee').success(function (data) {
            totalEmployees = data;
        });
    }

    function findTotalPages() {
        var totalPages = parseInt(totalEmployees / $scope.row);
        if ((totalEmployees % $scope.row) != 0) {
            totalPages++;
        }
        return totalPages;
    }

    $scope.getEmployees = function () {
        $scope.page = 0;
        $scope.currentPage = 1;
        getEmployees();
        checkLoaderPage();
    };

    $scope.searchEmployee = function () {
        $http.post('/searchemployee', $scope.searchData).success(function (data) {
            $scope.employees = data;
            if (!!data.hasLength) {
                $scope.employees = data;
            }
        }).error(function (data) {

        });
    };

    $scope.toPreScroll = function () {
        $('body,html').animate({scrollTop: $scope.preScroll}, "0");
    };

    $scope.detailEmployee = function () {
        $scope.preScroll = $(window).scrollTop()
        $('body,html').animate({scrollTop: 500}, "400");
    };

    checkLoaderPage();
    function checkLoaderPage() {
        if ($scope.currentPage == 1 && findTotalPages() == $scope.currentPage) {
            $('#first-page').addClass('disabled');
            $('#pre-page').addClass('disabled');
            $('#next-page').addClass('disabled');
            $('#final-page').addClass('disabled');

        }
        else if ($scope.currentPage == 1 && findTotalPages() > $scope.currentPage) {
            $('#first-page').addClass('disabled');
            $('#pre-page').addClass('disabled');
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    }
    $scope.firstPage = function () {
        if (!$('#first-page').hasClass('disabled')) {
            $scope.page = 0;
            getEmployees();
            $scope.currentPage = 1;
            $('#first-page').addClass('disabled');
            $('#pre-page').addClass('disabled');
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.prePage = function () {
        if (!$('#pre-page').hasClass('disabled')) {
            $scope.page--;
            getEmployees();
            $scope.currentPage = $scope.page + 1;
            if ($scope.currentPage == 1) {
                $('#first-page').addClass('disabled');
                $('#pre-page').addClass('disabled');
            }
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.nextPage = function () {
        if (!$('#next-page').hasClass('disabled')) {
            $scope.page++;
            getEmployees();
            $scope.currentPage = $scope.page + 1;
            if ($scope.currentPage == findTotalPages()) {
                $('#next-page').addClass('disabled');
                $('#final-page').addClass('disabled');
            }
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    };

    $scope.finalPage = function () {
        if (!$('#final-page').hasClass('disabled')) {
            $scope.page = findTotalPages() - 1;
            getEmployees();
            $scope.currentPage = findTotalPages();
            $('#next-page').addClass('disabled');
            $('#final-page').addClass('disabled');
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    };


});