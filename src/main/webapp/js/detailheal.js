angular.module('detailHeal', []);
angular.module('detailHeal').controller('detailHealController', function ($scope, $http) {

    $scope.orderHeals = {};

    loadOrderHeal();
    function loadOrderHeal() {
        $http.get('loadorderheal').success(function (data) {
            $scope.orderHeals = data;
            console.log($scope.orderHeals);
        }).error(function (data) {

        });
    }


    $scope.actionSelectHeal = function () {
        $('#modalSelectHeal').openModal({dismissible: false});
    };

    $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 200,
        format: 'yyyy-mm-dd',
        container: 'body'
    });

});

