var app = angular.module('app', []);

/**
 * postCtrl - post controller.
 */
app.controller('postCtrl', function ($scope, $http) {
    $scope.id = null;
    $scope.firstName = null;
    $scope.lastName = null;

    $scope.addUser = function (user_id, firstName, lastName) {
        var user = {
            id : user_id,
            firstName : firstName,
            lastName : lastName
        };
        $http.post("add_user", JSON.stringify(user))
            .then(function (response) {
                if (response.data)
                    console.log("post data submitted successfully");
                }, function error(response) {
                console.log("service not exists: " + response.status);
            });
    };

    $scope.getUsers = function () {
        $http.get("/get_users")
            .then(function success(response) {
                $scope.users = response.data;
            }, function error(response) {
                console.log("error" + response.headers);
            });
    };

});