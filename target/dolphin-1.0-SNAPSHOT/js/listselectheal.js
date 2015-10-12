angular.module('listSelectHeal', []);
angular.module('listSelectHeal').controller('listSelectHealController', function ($scope, $http) {

    $scope.listSelectHeal = {};
    $scope.listSelectHeals = {};

    loadListSelectHeal();
    function loadListSelectHeal() {
        $http.get('/loadlistselectheal').success(function (data) {
            $scope.listSelectHeals = data;
        }).error(function (data) {
        });
    }
    $scope.saveListSelectHeal = function () {
        $http.post('/savelistselectheal', $scope.listSelectHeal).success(function (data) {
            loadListSelectHeal();
            $scope.listSelectHeal = {};
            Materialize.toast('saveข้อมูลเรียบร้อย', 3000, 'rounded');
        }).error(function (data) {
        });
    };

    $scope.clearData = function () {
        $scope.listSelectHeal = {};
        $('#namedepartment').removeClass('active'); // ให้ namedepartment เด้งลง
    };

    $scope.actionDelete = function (lsh) {
        $scope.listSelectHeal = lsh;
        $('#modal-delete').openModal({dismissible: false});
    };

    $scope.deleteListSelectHeal = function () {
        $http.post('/deletelistselectheal', $scope.listSelectHeal).success(function (data) {
            loadListSelectHeal();
            $scope.listSelectHeal = {};
        }).error(function (data) {

        });
    };

    $scope.updateListSelectHeal = function (lsh) {
        $scope.listSelectHeal.id = lsh.id;
        $scope.listSelectHeal.name = lsh.name;
        $scope.listSelectHeal.price = lsh.price;
        $('#namedepartment').addClass('active');
        $('body,html').animate({scrollTop: 0}, "600");
    };

});

