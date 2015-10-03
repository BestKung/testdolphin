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
    
    $scope.savePatient = function (){
        $http.post('/savepatient',$scope.patient).success(function (data){
            console.log('success');
        });
    };
    
    
     $('.datepicker').pickadate({
        selectMonths: true,
        selectYears: 200,
        format: 'yyyy-mm-dd',
        container: 'body'
    });
});