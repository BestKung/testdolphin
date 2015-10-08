angular.module('detailHeal', []);
angular.module('detailHeal').controller('detailHealController', function ($scope, $http) {

    $scope.detailHeals = {};
    $scope.detailHeal = {};
    $scope.orderHeals = [];
    $scope.patients = {};
    $scope.doctors = {};
    $scope.listSelectHeals = {};

    loadDetailHeal();
    function loadDetailHeal() {
        $http.get('/loaddetailheal').success(function (data) {
            $scope.detailHeals = data;
        }).error(function (data) {

        });
    }

    loadPatient();
    function loadPatient() {
        $http.get('/getpatient').success(function (data) {
            $scope.patients = data;
            $scope.detailHeal.patient = data.content[0];
        });
    }

    loadDoctor();
    function loadDoctor() {
        $http.get('/getdoctor').success(function (data) {
            $scope.doctors = data;
            $scope.detailHeal.doctor = data.content[0];
        });
    }

    loadListSelectHeal();
    function loadListSelectHeal() {
        $http.get('/loadlistselectheal').success(function (data) {
            $scope.listSelectHeals = data;
            $scope.nameListOrderheal = data.content[0];
        }).error(function (data) {
        });
    }


    $scope.addSelectHeal = function (name) {
        if (!$scope.amountListSelectHeal || $scope.amountListSelectHeal === 0) {
            Materialize.toast('การุณากรอกจำนวนด้วยครับ', 3000, 'rounded');
        } else {
            if ($scope.orderHeals.length === 0) {
                $scope.orderHeals.push({'listSelectHeal': $scope.nameListOrderheal,
                    'value': $scope.amountListSelectHeal});
                $scope.nameListOrderheal = '';
                $scope.amountListSelectHeal = '';
            } else {
                var flag = false;
                var temp = 0;
                for (var i = 0; i < $scope.orderHeals.length; i++) {
                    if ($scope.orderHeals[i].listSelectHeal.name === name.name) {
                        temp = Number($scope.orderHeals[i].value) + Number($scope.amountListSelectHeal);
                        $scope.orderHeals[i] = {'listSelectHeal': $scope.nameListOrderheal,
                            'value': temp};
                        $scope.nameListOrderheal = '';
                        $scope.amountListSelectHeal = '';
                        flag = true;
                        break;
                    }
                }
                if (flag === false) {
                    $scope.orderHeals.push({'listSelectHeal': $scope.nameListOrderheal,
                        'value': $scope.amountListSelectHeal});
                    $scope.nameListOrderheal = '';
                    $scope.amountListSelectHeal = '';
                }
            }

        }
        loadListSelectHeal();
    };
    $scope.removeSelectHeal = function (name) {
        var index = -1;
        var rowData = eval($scope.orderHeals);
        for (var i = 0; i < rowData.length; i++) {
            if (rowData[i].listSelectHeal.name === name) {
                index = i;
                break;
            }
        }
        if (index === -1) {
            Materialize.toast('บางอย่างผิดพลาด', 3000, 'rounded');
        }
        $scope.orderHeals.splice(index, 1);
    };
    
    $scope.saveDetailheal = function () {
                $http.post('/savedetailheal', $scope.detailHeal).success(function (data) {
                    $http.post('/saveorderheal', $scope.orderHeals).success(function (data) {
                        Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
                        loadDetailHeal();
                        $scope.detailHeal = {};
                        $scope.orderHeals = [];
                        $scope.nameListPayHeal = '';
                        $scope.amountListPayHeal = '';
                        loadListSelectHeal();
                        loadPatient();
                        loadDoctor();
                    }).error(function (data, status, header, cofig) {
                        Materialize.toast('ผิดพลาดsavedetailHeal', 3000, 'rounded');
                    });
                }).error(function (data, status, header, cofig) {

                });

            };

    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 200,
        format: 'yyyy-mm-dd',
        container: 'body'
    });

    $(document).ready(function () {
        $('.modal-trigger').leanModal();
    });


});

