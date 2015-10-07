angular.module('doctor-information', []);
angular.module('doctor-information').controller('doctorInformationController', function (employeeService, $scope, $http) {

    $scope.doctors = {};
    $scope.doctorDetail = {};
    $scope.preScroll;
    $scope.search = {};
    $scope.currentPage = 0;
    $scope.size = 0;
    var page = 0;
    var totalDoctor = 0;
    var totalPage = 0;
    
     checkMobile();
    function checkMobile() {
        var $mobile = $(window).outerWidth() < 995;
        if ($mobile) {
            $('th').removeAttr('style');
            $('.topic-detail').css('fontSize', 13);
        }
    }

    getDoctor();
    function getDoctor() {
        $http.get('/getdoctor', {params: {page: page, size: $scope.size}}).success(function (data) {
            $scope.doctors = data;
        });
    }

    $scope.UpdateDoctor = function () {
        employeeService.doctorUpdate = $scope.doctorDetail;
        location.href = "#/doctor";
    };

    $scope.moreDetail = function (detail) {
        $scope.preScroll = $(window).scrollTop();
        $('body,html').animate({scrollTop: 400}, "400");
        $scope.doctorDetail = detail;
         $scope.doctorDetail.age = new Date().getFullYear() - new Date($scope.doctorDetail.birthDate).getFullYear();
        var topic = document.getElementsByClassName('topic-detail');
        for (var i = 0; i < topic.length; i++) {
            if (topic[i].innerHTML == "") {
                topic[i].innerHTML = '-';
            }
        }
        if (!!detail.doctorPicture) {
            document.getElementById('img-employee').src = "data:image/jpg;base64," + $scope.doctorDetail.doctorPicture.content;
        }
        else {
            $http.get('/getnoimage').success(function (data) {
                console.log(data);
                console.log('error');
                document.getElementById('img-employee').src = "data:image/jpg;base64," + data.contentImage;
            });
        }
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


    $scope.searchData = function () {
        searchData();
    };

    function searchData() {
        $http.post('/searchdoctor', $scope.search, {params: {page: page, size: $scope.size}}).success(function (data) {
            $scope.doctors = data;
            countSearchDoctor();
        });
    }

    $scope.selectGetOrSearch = function () {
        selectGetOrSearch();
    };

    function selectGetOrSearch() {
        if (!!$scope.search.keyword) {
            searchData();
        }
        else {
            getDoctor();
        }
    }

    $scope.clickDelete = function () {
        $('#modal-delete').openModal({dismissible: false});
    };

    $scope.deleteDoctor = function () {
        $http.post('/deletedoctor', $scope.doctorDetail).success(function (data) {
            selectGetOrSearch();
            toPreScroll();
            $('span#close-card').trigger('click');
        });
    };

    function countSearchDoctor() {
        $http.post('/countsearchdoctor', $scope.search, {params: {page: page, size: $scope.row}}).success(function (data) {
            $scope.totalDoctor = data;
            findTotalPage();
        });
    }

    countDoctor();
    function countDoctor() {
        $http.get('/countdoctor').success(function (data) {
            $scope.totalDoctor = data;
            findTotalPage();
        });
    }

    function findTotalPage() {
        var totalpages = parseInt($scope.totalDoctor / $scope.size);
        if (($scope.totalDoctor % $scope.size) != 0) {
            totalpages++;
        }
        totalPage = totalpages;
        console.log(totalPage);
    }


    $scope.firstPage = function () {
        if (!$('#first-page').hasClass('disabled')) {
            page = 0;
            $scope.currentPage = page;
            selectGetOrSearch();
            if (page == 0) {
                $('#first-page').addClass('disabled');
                $('#pre-page').addClass('disabled');
            }
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.prePage = function () {
        if (!$('#first-page').hasClass('disabled')) {
            page--;
            $scope.currentPage = page;
            selectGetOrSearch();
            if (page == 0) {
                $('#first-page').addClass('disabled');
                $('#pre-page').addClass('disabled');
            }
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.nextPage = function () {
        if (!$('#final-page').hasClass('disabled')) {
            page++;
            $scope.currentPage = page;
            selectGetOrSearch();
            if (page == totalPage - 1) {
                $('#next-page').addClass('disabled');
                $('#final-page').addClass('disabled');
            }
            $('#pre-page').removeClass('disabled');
            $('#first-page').removeClass('disabled');
        }
    };

    $scope.finalPage = function () {
        if (!$('#final-page').hasClass('disabled')) {
            page = totalPage - 1;
            $scope.currentPage = page;
            selectGetOrSearch();
            if (page == totalPage - 1) {
                $('#final-page').addClass('disabled');
                $('#next-page').addClass('disabled');
            }
            $('#pre-page').removeClass('disabled');
            $('#first-page').removeClass('disabled');
        }
    };



});