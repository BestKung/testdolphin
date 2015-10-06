angular.module('patient', []);
angular.module('patient').controller('patientController', function ($scope, $http) {

    $scope.patient = {};
    $scope.patient.patientPicture = {};
    $scope.medicalHistory = {};
    $scope.patientPictureBefore;
    $scope.patientPictureCurrent;
    $scope.patientPictureAfter;
    $scope.patientPictureXrayFilm;

    getMedicalHistory();
    function getMedicalHistory() {
        $http.get('/getmedicalhistory').success(function (data) {
            $scope.medicalHistory = data;
        });
    }

    $scope.savePatient = function () {
        console.log($scope.patient.patientPicture);
        $http.post('/savepatient', $scope.patient).success(function (data) {
            console.log('success');
        });
    };


    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 200,
        format: 'yyyy-mm-dd',
        container: 'body'
    });


    $scope.savePictureXray = function () {
        var fd = new FormData();
        fd.append('xray', $scope.patientPictureXrayFilm);
        $http.post('/savepatientpicturexray', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
                .success(function (data) {
                    var pictureXray = {};
                    if (!!data.nameXrayFilm) {
                        console.log('true');
                        console.log(data);
                        console.log(data.contentXrayFilm);
//                        pictureXray.contentXrayFilm = data.contentXrayFilm;
//                        pictureXray.mimeTypeXrayFilm = data.mimeTypeXrayFilm;
//                        pictureXray.nameXrayFilm = data.nameXrayFilm;
//                        $scope.patient.patientPicture = pictureXray;
                    }

                });
    };

    $scope.savePictureBefore = function () {
        var fd = new FormData();
        fd.append('before', $scope.patientPictureBefore);
        $http.post('/savepatientpicturebefore', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
                .success(function (data) {
                    var pictureBefore = {};
                    if (!!data.nameBefore) {
                        console.log('true');
                        console.log(data);
//                        pictureBefore.contentBefore = data.contentBefore;
//                        pictureBefore.mimeTypeBefore = data.mimeTypeBefore;
//                        pictureBefore.nameBefore = data.nameBefore;
//                        $scope.patient.patientPicture = pictureBefore;
                    }
                });
    };

    $scope.savePictureCurrent = function () {
        var fd = new FormData();
        fd.append('current', $scope.patientPictureCurrent);
        $http.post('/savepatientpicturecurrent', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
                .success(function (data) {
                    var pictureCurrent = {};
                    if (!!data.nameCurrent) {
                        console.log('true');
                        console.log(data);
//                        pictureCurrent.contentCurrent = data.contentCurrent;
//                        pictureCurrent.mimeTypeCurrent = data.mimeTypeCurrent;
//                        pictureCurrent.nameCurrent = data.nameCurrent;
//                        $scope.patient.patientPicture = pictureCurrent;
                    }
                });
    };

    $scope.savePictureAfter = function () {
        var fd = new FormData();
        fd.append('after', $scope.patientPictureAfter);
        $http.post('/savepatientpictureafter', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
                .success(function (data) {
                    var pictureAfter = {};
                    if (!!data.nameAfter) {
                        console.log('true');
                        console.log(data);
//                        pictureAfter.contentAfter = data.contentAfter;
//                        pictureAfter.mimeTypeAfter = data.mimeTypeAfter;
//                        pictureAfter.nameAfter = data.nameAfter;
//                        $scope.patient.patientPicture = pictureAfter;
                    }
                });
    };

    function readURLBefore(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#patient-before').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#input-patient-before').change(function () {
        readURLBefore(this);
    });

    function readURLCurrent(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#patient-current').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#input-patient-current').change(function () {
        readURLCurrent(this);
    });

    function readURLAfter(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#patient-after').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#input-patient-after').change(function () {
        readURLAfter(this);
    });

    function readURLXrayFilm(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#patient-xrayfilm').attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#input-patient-xrayfilm').change(function () {
        readURLXrayFilm(this);
    });

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