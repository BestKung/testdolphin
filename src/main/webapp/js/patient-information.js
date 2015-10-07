angular.module('patient-information', []);
angular.module('patient-information').controller('patientInformationController', function ($scope, $http) {
    $scope.patients = {};
    $scope.patientDetail = {};
    $scope.patientDetail.patientPictureXray = {};
    $scope.patientDetail.patientPictureBefore = {};
    $scope.patientDetail.patientPictureCurrent = {};
    $scope.patientDetail.patientPictureAfter = {};
    checkMobile();
    function checkMobile() {
        var $mobile = $(window).outerWidth() < 995;
        if ($mobile) {
            $('th').removeAttr('style');
            $('.topic-detail').css('fontSize', 13);
        }
    }

    getPatient();
    function getPatient() {
        $http.get('/getpatient').success(function (data) {
            $scope.patients = data;
            console.log(data.content[0]);
            console.log('jvzhjdzvuz');
        });
    }


    $scope.clickMoreDetail = function (more) {
        $scope.preScroll = $(window).scrollTop();
        $('body,html').animate({scrollTop: 400}, "400");
        $scope.patientDetail = more;
        $scope.patientDetail.age = new Date().getFullYear() - new Date(more.birthDate).getFullYear();
        var topic = document.getElementsByClassName('topic-detail');
        for (var i = 0; i < topic.length; i++) {
            if (topic[i].innerHTML == "") {
                topic[i].innerHTML = "-";
            }
        }
        if (!!$scope.patientDetail.patientPictureXray) {
            document.getElementById('img-patientxray').src = "data:image/jpg;base64," + $scope.patientDetail.patientPictureXray.contentXrayFilm;
        }
        else {
            NoImageXray();
        }
        if (!!$scope.patientDetail.patientPictureBefore) {
            document.getElementById('img-patientbefore').src = "data:image/jpg;base64," + $scope.patientDetail.patientPictureBefore.contentBefore;
        }
        else {
            NoImageBefore();
        }
        if (!!$scope.patientDetail.patientPictureCurrent) {
          document.getElementById('img-patientcurrent').src = "data:image/jpg;base64," + $scope.patientDetail.patientPictureCurrent.contentCurrent;  
        }
        else {
            NoImageCurrent();
        }
        if (!!$scope.patientDetail.patientPictureAfter) {
           document.getElementById('img-patientafter').src = "data:image/jpg;base64," + $scope.patientDetail.patientPictureAfter.contentAfter;
        }
        else {
             NoImageAfter();
        }

    };


    function NoImageXray() {
        $http.get('/getnoimage').success(function (data) {
            document.getElementById('img-patientxray').src = "data:image/jpg;base64," + data.contentImage;
        });
    }
    ;

    function NoImageBefore() {
        $http.get('/getnoimage').success(function (data) {
            document.getElementById('img-patientbefore').src = "data:image/jpg;base64," + data.contentImage;
        });
    }
    ;

    function NoImageCurrent() {
        $http.get('/getnoimage').success(function (data) {
            document.getElementById('img-patientcurrent').src = "data:image/jpg;base64," + data.contentImage;
        });
    }
    ;

    function NoImageAfter() {
        $http.get('/getnoimage').success(function (data) {
            document.getElementById('img-patientafter').src = "data:image/jpg;base64," + data.contentImage;
        });
    }
    ;

});