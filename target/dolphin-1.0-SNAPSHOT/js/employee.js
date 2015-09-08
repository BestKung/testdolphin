var app = angular.module('employee', []);
var app = angular.module('employee')
        .controller('employeeController', function ($scope, $http, $compile) {
            $scope.authoritys = {};
            $scope.departments = {};
            $scope.department = "";
            $scope.employee = {};
            $scope.image;
            $scope.error = {};
            $scope.password = "";
            var byteArray;
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
                    $('#select-workstatus').css('width', 'calc(100% - 3rem)')
                }
            }


            $scope.comparePassword = function () {
                if ((!!$scope.password) && (!!$scope.employee.password)) {
                    if ($scope.password == $scope.employee.password) {
                        $('#confirm').css('color', '#64dd17');
                        $('#confirm').html('done');
                    }
                    if ($scope.password != $scope.employee.password) {
                        $('#confirm').css('color', 'red');
                        $('#confirm').html('clear');
                    }
                }
                else{
                    $('#confirm').html('');
                }
            };
            
                function confirmPassword (){
                    if (($scope.password == $scope.employee.password) || (!$scope.password) || (!$scope.employee.password)) {
                        return true;
                    }
                    if ($scope.password != $scope.employee.password) {
                        return false;
                    }
                }


            getDepartment();
            function getDepartment() {
                $http.get('/getdepartment').success(function (data) {
                    $scope.departments = data;
                    $scope.employee.department = data.content[0];
                });
            }

            getAuthority();
            function getAuthority() {
                $http.get('/getauthority')
                        .success(function (data) {
                            $scope.authoritys = data;
                        }).error(function (data) {

                });
            }

            $scope.saveEmployee = function () {
                if(confirmPassword()){
                    if (!!$scope.image) {
                    saveFile();
                }
                saveEmployee();
                console.log('save success');
                }
                else{
                    console.log('password error');
                     $('body,html').animate({scrollTop: 0}, "600");
                }
            };

            function saveEmployee() {
                $http.post('/saveemployee', $scope.employee)
                        .success(function (data) {

                        }).error(function (data) {
                    $scope.error = data;
                    $('body,html').animate({scrollTop: 0}, "600");
                });
            }
           
            function saveFile() {
                var fd = new FormData();
                fd.append('file', $scope.image);
                $http.post('/saveemployeeimage', fd, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                });
            }
            ;


            NoImage();
            function NoImage() {
                $http.get('/getnoimage').success(function (data) {
                    document.getElementById('employee-picture').src = "data:image/jpg;base64," + data.content;
                });
            };

            $scope.setBackgroundPrefixId = function () {
                var email = $scope.employee.email;
                if (email.length != 0) {
                    $('#id').css('color', '#00bcd4');
                }
                else if (email.length == 0) {
                    $('#id').css('color', 'black');
                }
            };

            $scope.setBackgroundPrefixSexBloodMarryStatus = function () {
                var currentAddress = $scope.employee.currentAddress;
                if (currentAddress != 0) {
                    $('#sex').css('color', '#00bcd4');
                    $('#blood').css('color', '#00bcd4');
                    $('#marrystatus').css('color', '#00bcd4');
                }
                else if (currentAddress == 0) {
                    $('#sex').css('color', 'black');
                    $('#blood').css('color', 'black');
                    $('#marrystatus').css('color', 'black');
                }
            };

            $scope.setBackgroundPrefixDepartmentWorkstatus = function () {
                var mobile = $scope.employee.mobile;
                if (mobile != 0) {
                    $('#department').css('color', '#00bcd4');
                    $('#workstatus').css('color', '#00bcd4');
                }
                else if (mobile == 0) {
                    $('#department').css('color', 'black');
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

            $("#input-employee-picture").change(function () {
                readURL(this);
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
    