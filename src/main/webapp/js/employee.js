var app = angular.module('employee', []);
var app = angular.module('employee')
        .controller('employeeController', function ($scope, $http, $compile) {
            $scope.authoritys = {};
            $scope.departments = {};
            $scope.employee = {};
            $scope.image;
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
                }
            }

            getDepartment();
            function getDepartment() {
                $http.get('/getdepartment').success(function (data) {
                    $scope.departments = data;
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
                if (!!$scope.image) {
                    saveFile();
                    console.log('true');
                }
                saveEmployee();
            };

            function saveEmployee() {
                $http.post('/saveemployee', $scope.employee)
                        .success(function (data) {
                            console.log('save success');
                        }).error(function (data) {
                });
            }
            function saveFile() {
                var fd = new FormData();
                fd.append('file', $scope.image);
                $http.post('/saveemployeeimage', fd, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': undefined}
                });
            };


            NoImage();
            function NoImage () {
                $http.get('/getnoimage').success(function (data) {
                    document.getElementById('employee-picture').src = "data:image/jpg;base64,"+data.content;
                    console.log(data.content);
                });
            };
            function onOpen(){
                alert("Hello");
            }
            $('.datepicker').pickadate({
                selectMonths: true,
                selectYears: 200,
                format: 'yyyy-mm-dd',
                container: 'body'         
            });
            
           
            $('select').material_select();

            $('#select-sex').click(function () {
                $('#label-sex').addClass('active');
            });
            $('#select-marrytatus').click(function () {
                $('#label-marrystatus').addClass('active');
            });
            $('#select-blood').click(function () {
                $('#label-blood').addClass('active');
            });
            $('#select-department').click(function () {
                $('#label-department').addClass('active');
            });

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
    