angular.module('doctor', []);
angular.module('doctor').controller('doctorController', function ($scope, $http) {
    $scope.error = {};
    $scope.doctor = {};
    $scope.password = "";
    $scope.image;

    checkMobile();
    function  checkMobile() {
        var $mobile = $(window).outerWidth() < 995;
        if ($mobile) {
            $('#nav-topic').css('display', 'none');
            $('body').css('overflow-y', 'hidden');
            $('#select-sex').css('width', 'calc(100% - 3rem)');
            $('#select-marrytatus').css('width', 'calc(100% - 3rem)');
            $('#select-blood').css('width', 'calc(100% - 3rem)');
            $('#select-department').css('width', 'calc(100% - 3rem)');
            $('#select-workstatus').css('width', 'calc(100% - 3rem)');
        }
    }

    $scope.saveDoctor = function () {
        if (confirmPassword()) {
            $http.post('/savedoctor', $scope.doctor).success(function (data) {

            }).error(function (data) {
                $scope.error = data;
                $('body,html').animate({scrollTop: 0}, "600");
            });
        }
        else{
            console.log('error valid password!');
            $('body,html').animate({scrollTop: 0}, "600");
        }
    };


    $scope.selectPicture = function () {
        var fd = new FormData();
        fd.append('file', $scope.image);
        $http.post('/selectpicture', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
                .success(function (data) {
                    $scope.doctor.doctorPicture = data;
                });
    };


    $scope.comparePassword = function () {
        if ((!!$scope.password) && (!!$scope.doctor.password)) {
            if ($scope.password == $scope.doctor.password) {
                $('#confirm').css('color', '#64dd17');
                $('#confirm').html('done');
            }
            if ($scope.password != $scope.doctor.password) {
                $('#confirm').css('color', 'red');
                $('#confirm').html('clear');
            }
        }
        else {
            $('#confirm').html('');
        }
    };

    function confirmPassword() {
        if (($scope.password == $scope.doctor.password) || (!$scope.password) || (!$scope.doctor.password)) {
            return true;
        }
        if ($scope.password != $scope.doctor.password) {
            return false;
        }
    }

    $scope.setBackgroundPrefixId = function () {
        var email = $scope.doctor.email;
        if (email.length != 0) {
            $('#id').css('color', '#00bcd4');
        }
        else if (email.length == 0) {
            $('#id').css('color', 'black');
        }
    };

    $scope.setBackgroundPrefixSexBlood = function () {
        var currentAddress = $scope.doctor.currentAddress;
        if (currentAddress != 0) {
            $('#sex').css('color', '#00bcd4');
            $('#blood').css('color', '#00bcd4');
        }
        else if (currentAddress == 0) {
            $('#sex').css('color', 'black');
            $('#blood').css('color', 'black');
        }
    };

    $scope.setBackgroundPrefixWorkstatus = function () {
        var mobile = $scope.doctor.mobile;
        if (mobile != 0) {
            $('#workstatus').css('color', '#00bcd4');
        }
        else if (mobile == 0) {
            $('#workstatus').css('color', 'black');
        }
    };


    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 200,
        format: 'yyyy-mm-dd',
        container: 'body'
    });

    $('select').material_select();

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#employee-picture').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#input-employee-picture').change(function () {
        readURL(this);
    });

    NoImage();
    function NoImage() {
        $http.get('/getnoimage').success(function (data) {
            document.getElementById('employee-picture').src = "data:image/jpg;base64," + data.contentImage;
        });
    }
    ;


});

app.directive('fileModel', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
});

app.directive('customOnChange', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var onChangeHandler = scope.$eval(attrs.customOnChange);
            element.bind('change', onChangeHandler);
        }
    };
});