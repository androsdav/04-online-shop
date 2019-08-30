const app = angular.module('app', []);

/**
 * Controller smartPhone.
 */
app.controller('smartPhoneCtrl', function ($scope, $http) {

    /**
     * @param smartPhone - smart phone.
     * @type {null}
     */
    $scope.smartPhone = [];

    /**
     * @param company - company.
     * @type {null}
     */
    $scope.id = null;

    /**
     * @param company - company.
     * @type {null}
     */
    $scope.company = null;

    /**
     * @param model - model.
     * @type {null}
     */
    $scope.model = null;

    /**
     * @param description - description.
     * @type {null}
     */
    $scope.description = null;

    /**
     * @param quantity - quantity.
     * @type {null}
     */
    $scope.quantity = null;

    $scope.order = [];

    /**
     * addSmartPhone - add smart phone.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     */
    $scope.addSmartPhone = function (company, model, description, quantity) {
        const smartPhone = {
            company: company,
            model: model,
            description: description,
            quantity: quantity
        };
        $http.post("/add_smart_phone", JSON.stringify(smartPhone))
            .then(function (response) {
                if (response.data)
                    console.log("post data submitted successfully");
            }, function error(response) {
                console.log("service not exists: " + response.status);
            });
    };

    /**
     * deleteSmartPhone - delete smart phone by id.
     * @param id - id smart phone.
     */
    $scope.deleteSmartPhone = function (id) {
        const smartPhone = {
            id: id,
            company: null,
            model: null,
            description: null,
            quantity: null
        };
        $http.post("/delete_smart_phone", JSON.stringify(smartPhone))
            .then(function (response) {
                if (response.data)
                    console.log("post data submitted successfully");
            }, function (response) {
                console.log("service not exists: " + response.status);
            });
    };

    /**
     * getAllSmartPhone - get all smart phone.
     */
    $scope.getAllSmartPhone = function () {
        $http.get("/get_all_smart_phone")
            .then(function success(response) {
                $scope.smartPhone = response.data;
            }, function error(response) {
                console.log("error" + response.headers);
            });
    };

    $scope.addToOrder = function (id, company, model, description, quantity) {
        var smartPhone = {
            id: id,
            company: company,
            model: model,
            description: description,
            quantity: quantity
        };
        $scope.order.push(smartPhone);
    };

    $scope.deleteFromOrder = function (id) {
        //$scope.order[id].quantity = $scope.order[id].quantity - 1;

        //$scope.order[$scope.order.indexOf(id)].quantity = $scope.order[$scope.order.indexOf(id)].quantity - 1;

        for ( index = 0, len = $scope.order.length; index < len; index += 1) {
            if ($scope.order[index].id === id) {
                $scope.order[index].quantity = $scope.order[index].quantity - 1;
            }
        }

        //$scope.order.splice($scope.order.indexOf(id), 1); not bad !!!!!!


    };

    //Scope.delete



});


/**
 * postCtrl - post controller.
 */
/*
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
*/