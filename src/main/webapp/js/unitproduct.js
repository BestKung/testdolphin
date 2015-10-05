angular.module('unitProduct', []);
angular.module('unitProduct').controller('unitProductController', function ($scope, $http) {
    
    $scope.unitProducts = {};
    
    
    loadUnitProduct();
    function loadUnitProduct(){
        $http.get('/loadunitproduct').success(function (data){
            $scope.unitProducts = data;
        }).error(function (data){           
        });
    }
});


