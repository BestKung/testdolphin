angular.module('bill', []);
angular.module('bill').controller('billController', function ($scope, $http) {

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


