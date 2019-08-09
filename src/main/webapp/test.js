function Test($scope, $http) {
    $http.get('http://localhost:8080/get_user').
    success(function(data) {
        $scope.user = data;
    });
}