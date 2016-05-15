/**
 * Created by daidongyang on 5/15/16.
 */

'use strict'

rangerApp.controller('searchCtrl', ['$scope', '$http', function ($scope, $http) {
    $scope.results = [];

    $scope.setoff_location = {
        id : '0',
        name : 'Shanghai',
        fatherId : '0'
    };

    $scope.search_condition = {
        'search_str': null,
        'setoff_location_id': 0,
        'first_result': 0,
        'result_size': 20,
        'order': 0,
        'min_price': -1,
        'max_price': -1,
        'min_duration': -1,
        'max_duration': -1
    };

    $scope.search = function(search_condition){
        console.log(search_condition);
        $http.post('/Ranger/api/searchproduct/list', search_condition)
            .success(function (data) {
                $scope.results = data;
                console.log(data);
            })
            .error(function (err) {
                alert(err);
            });
    };

    $scope.test = function(search_condition){
        console.log(search_condition);
        $http.post('/Ranger/api/searchproduct/test', search_condition)
            .success(function(data){
                console.log(data);
                alert(data);
            })
            .error(function(err){
                alert(err);
            });
    };

    $scope.get_locations = function(father_id){

    }

}]);
