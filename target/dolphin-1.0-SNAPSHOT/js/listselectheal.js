angular.module('listSelectHeal', []);
angular.module('listSelectHeal').controller('listSelectHealController', function ($scope, $http) {

    $scope.listSelectHeals = {};

    loadListSelectHeal();
    function loadListSelectHeal() {
        $http.get('/loadlistselectheal').success(function (data) {
            $scope.listSelectHeals = data;
        }).error(function (data) {
        });
    }


});
