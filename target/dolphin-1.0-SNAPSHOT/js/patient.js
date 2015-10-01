angular.module('patient',[]);
angular.module('patient').controller('patientController',function($scope , $http){
    
    $scope.patient = {};
    $scope.medicalHistory = {};
    
    getMedicalHistory();
    function getMedicalHistory(){
        $http.get('/getmedicalhistory').success(function (data){
            $scope.medicalHistory = data;
        });
    }    
    
    
     $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 200,
        format: 'yyyy-mm-dd',
        container: 'body'
    });
});