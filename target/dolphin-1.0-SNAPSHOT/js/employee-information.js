angular.module('employee-information', []);
angular.module('employee-information').controller('employeeInformationController', function (employeeService, $scope, $http) {
    $scope.employees = {};
    $scope.page = 0;
    $scope.row = 10;
    $scope.currentPage = 1;
    $scope.searchData = {};
    $scope.preScroll = 0;
    $scope.employeeDetail = {};
    $scope.selectEmployee = {};
    var preCard = 0;
    var employeeImage = {};
    var totalEmployees = getTotalEmployee();

    checkMobile();
    function checkMobile() {
        var $mobile = $(window).outerWidth() < 995;
        if ($mobile) {
            $('th').removeAttr('style');
            $('.topic-detail').css('fontSize', 13);
        }
    }

    getEmployees();
    function getEmployees() {
        $http.get('/staffs', {params: {page: $scope.page, size: $scope.row}}).success(function (data) {
            $scope.employees = data;
        }).error(function (data) {

        });
    }

    getTotalEmployee();
    function getTotalEmployee() {
        $http.get('/totalstaff').success(function (data) {
            totalEmployees = data;
            return data;
        });
    }

    function findTotalPages() {
        console.log('Total employee' + totalEmployees);
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

    $scope.searcEmployee = function () {
        $http.post('/searchstaff', $scope.searchData).success(function (data) {
            $scope.employees = data;
            if (!!data.hasLength) {
                $scope.employees = data;
            }
        }).error(function (data) {

        });
    };

    $scope.detailEmployee = function (emp) {
        $scope.preScroll = $(window).scrollTop();
        $('body,html').animate({scrollTop: 500}, "400");
        $scope.employeeDetail = emp;
        console.log(emp.staffPicture);
        $scope.employeeDetail.age = new Date().getFullYear() - new Date($scope.employeeDetail.birthDate).getFullYear();
        var topic = document.getElementsByClassName('topic-detail');
        for (var i = 0; i < topic.length; i++) {
            if (topic[i].innerHTML == "") {
                topic[i].innerHTML = '-';
            }
        }
        console.log(emp.staffPicture);
        if (!!emp.staffPicture) {
            console.log('has image');
            document.getElementById('img-employee').src = "data:image/jpg;base64," + emp.staffPicture.contentImage;
        }
        else {
            $http.get('/getnoimage').success(function (data) {
                console.log(data);
                console.log('error');
                document.getElementById('img-employee').src = "data:image/jpg;base64," + data.contentImage;
            });
        }
    };


    $scope.clickDelete = function (emp) {
        $('#modal-delete').openModal({dismissible: false});
        console.log('click Delete : ' + emp);
        $scope.selectEmployee = emp;
    };

    $scope.updateEmployee = function (emp) {
        employeeService.employeeUpdate = emp;
        console.log(emp);
      //  console.log('--------------------------++++'+employeeService.employeeUpdate.staffPicture.contentImage);
        location.href = '#/employee';
    };

    $scope.deleteEmployee = function () {
        console.log('delete' + $scope.selectEmployee);
        $http.post('/deletestaff', $scope.selectEmployee).success(function (data) {
            console.log('delete success');
            $scope.selectEmployee = {};
            getEmployees();
            toPreScroll();
            $('span#close-card').trigger('click');
        }).error(function (data) {

        });
        $('i#close-card').trigger('click');
    };

    $scope.cancel = function () {
        toPreScroll();
        $('span#close-card').trigger('click');
    };

    function toPreScroll() {
        $('body,html').animate({scrollTop: $scope.preScroll}, "0");
    }

    $scope.toPreScroll = function () {
        toPreScroll();
    };

    checkLoaderPage();
    function checkLoaderPage() {
        console.log(findTotalPages());
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