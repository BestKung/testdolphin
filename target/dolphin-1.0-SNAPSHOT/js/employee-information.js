angular.module('employee-information',[]);
angular.module('employee-information').controller('employeeInformationController',function ($scope , $http){
    $scope.employees = {};
    $scope.page;
    $scope.row;
    checkMobile();
    function checkMobile() {
                var $mobile = $(window).outerWidth() < 995;
                if ($mobile) {
                    $('th').removeAttr('style');
                }
            }
   
    getEmployees();
    function getEmployees(){
        $http.get('/employees', {params: {page: $scope.row, size: $scope.totalRow}}).success(function (data){
            $scope.employees = data;
        }).error(function (data){
            
        });
    }
    
    
});