angular.module('doctor-information', []);
angular.module('doctor-information').controller('doctorInformationController', function ($scope, $http) {

    $scope.doctors = {};
    $scope.doctorDetail = {};
    $scope.preScroll;
    $scope.search = {};
 
    getDoctor();
    function getDoctor() {
        $http.get('/getdoctor').success(function (data) {
            $scope.doctors = data;
        });
    }

    $scope.moreDetail = function (detail) {
        $scope.preScroll = $(window).scrollTop();
        $('body,html').animate({scrollTop: 400}, "400");
        $scope.doctorDetail = detail;
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
    
    
    $scope.searchData = function (){
        $http.post('/searchdoctor',$scope.search).success(function (data){
            $scope.doctors = data;
        });
    };


});