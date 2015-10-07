angular.module('unitProduct', []);
angular.module('unitProduct').controller('unitProductController', function ($scope, $http) {

    $scope.unitProduct = {};
    $scope.unitProducts = {};

    loadUnitProduct();
    function loadUnitProduct() {
        $http.get('/loadunitproduct').success(function (data) {
            $scope.unitProducts = data;
        }).error(function (data) {
        });
    }

    $scope.saveUnitProduct = function () {
        $http.post('/saveunitproduct', $scope.unitProduct).success(function (data) {
            loadUnitProduct();
            $scope.unitProduct = {};
            Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
        }).error(function (data) {

        });
    };

    $scope.clearData = function () {
        $scope.unitProduct = {};
        $('#namedepartment').removeClass('active'); // ให้ namedepartment เด้งลง
    };


    $scope.actionDelete = function (up) {
        $scope.unitProduct = up;
        $('#modal-delete').openModal({dismissible: false});
    };

    $scope.deleteUnitProduct = function () {
        $http.post('/deleteunitproduct', $scope.unitProduct).success(function (data) {
            loadUnitProduct();
            $scope.unitProduct = {};
        }).error(function (data) {

        });
    };

    $scope.updateUnitProduct = function (up) {
        $scope.unitProduct.id = up.id;
        $scope.unitProduct.name = up.name;
        $('#namedepartment').addClass('active');
        $('body,html').animate({scrollTop: 0}, "600");
    };

});


