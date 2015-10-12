angular.module('bill', []);
angular.module('bill').controller('billController', function ($scope, $http) {

    $scope.priceAndExpireProducts = {};
    $scope.orderHeals = {};

    loadPriceAndExpireProduct();
    function  loadPriceAndExpireProduct() {
        $http.get('/loadpriceandexpireproduct').success(function (data) {
            $scope.priceAndExpireProducts = data;
        }).error(function (data) {
        });
    }
    
    loadOrderHeal();
    function loadOrderHeal(){
      $http.get('/loadorderheal').success(function (data){
          $scope.orderHeals = data;
          console.log($scope.orderHeals);
      }).error(function (data){      
      });  
    };

   

    $scope.addrowSelectPayHeal = function (nameDetailHeal) {
        $scope.idPayheal.detailHeal = nameDetailHeal;
        console.log($scope.idPayheal.detailHeal);
        for (var i = 0; i < nameDetailHeal.payHeals_DetailHeal.length; i++) {
            $scope.orderDetailHeals.push({
                'name': nameDetailHeal.payHeals_DetailHeal[i].listPayHeal.name,
                'value': nameDetailHeal.payHeals_DetailHeal[i].value,
                'price': nameDetailHeal.payHeals_DetailHeal[i].listPayHeal.price
            });
        }
    };

    $scope.addRowSelectProduct = function (nameProduct) {
        if (!$scope.nameProduct) {
            Materialize.toast('คุณไม่ระบุข้อมูล', 3000, 'rounded');
        } else {
            if ($scope.orderProducts.length === 0) {
                $scope.orderProducts.push({'product_Lot': $scope.nameProduct,
                    'value': $scope.valueProduct});
                $scope.nameProduct = '';
                $scope.valueProduct = '';
            } else {
                var flag = false;
                var temp = 0;
                for (var i = 0; i < $scope.orderProducts.length; i++) {
                    if ($scope.orderProducts[i].product_Lot.product.name === nameProduct.product.name) {
                        temp = Number($scope.orderProducts[i].value) + Number($scope.valueProduct);
                        $scope.orderProducts[i] = {'product_Lot': $scope.nameProduct,
                            'value': temp};
                        $scope.nameProduct = '';
                        $scope.valueProduct = '';
                        flag = true;
                        break;
                    }
                }
                if (flag === false) {
                    $scope.orderProducts.push({'product_Lot': $scope.nameProduct,
                        'value': $scope.valueProduct});
                    $scope.nameProduct = '';
                    $scope.valueProduct = '';
                }
            }
        }

    };

    $scope.removeRowSelectDetailHeal = function (name) {
        var index = -1;
        var rowData = eval($scope.orderDetailHeals);
        for (var i = 0; i < rowData.length; i++) {
            if (rowData[i].name === name) {
                index = i;
                break;
            }
        }
        if (index === -1) {
            Materialize.toast('บางอย่างผิดพลาด', 3000, 'rounded');
        }
        $scope.orderDetailHeals.splice(index, 1);
    };

    $scope.removeRowSelectProduct = function (name) {
        var index = -1;
        var rowData = eval($scope.orderProducts);
        for (var i = 0; i < rowData.length; i++) {
            if (rowData[i].product_Lot.product.name === name) {
                index = i;
                break;
            }
        }
        if (index === -1) {
            Materialize.toast('บางอย่างผิดพลาด', 3000, 'rounded');
        }
        $scope.orderProducts.splice(index, 1);
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


