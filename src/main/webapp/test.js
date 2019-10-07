//const app = angular.module('app', []);

const app = angular.module('app', ['ngMaterial', 'ngMessages', 'material.svgAssetsCache']);

/**
 * Controller smartPhone.
 */
app.controller('smartPhoneCtrl', function ($scope, $http) {

    /**
     * @param smartPhone - smart phone.
     * @type {null}
     */
    $scope.smartPhones = [];

    /**
     *
     * @type {{quantity: null, price: null, description: null, company: null, model: null}}
     */
    $scope.addItem = {
        id: null,
        company: null,
        model: null,
        description: null,
        quantity: null,
        price: null
    };

    /**
     * @param company - company.
     * @type {null}
     */
    /*
    $scope.id = null;
    */

    /**
     * @param company - company.
     * @type {null}
     */
    /*
    $scope.company = null;
    */

    /**
     * @param model - model.
     * @type {null}
     */
    /*
    $scope.model = null;
    */

    /**
     * @param description - description.
     * @type {null}
     */
    /*
    $scope.description = null;
    */

    /**
     * @param quantity - quantity.
     * @type {null}
     */
    /*
    $scope.quantity = null;
    */

    /*
    $scope.price = null;
    */

    $scope.orders = [];

    /**
     * addSmartPhone - add smart phone.
     * @param addItem
     */
    $scope.saveSmartPhone = function (addItem) {
        $http.post("/save_smart_phone", JSON.stringify(addItem))
            .then(function (response) {
                if (response.data)
                    console.log("post data submitted successfully");
                }, function error(response) {
                console.log("service not exists: " + response.status);
            });
    };

    /**
     * addSmartPhone - add smart phone.
     * @param smartPhone
     */
    $scope.findSmartPhoneById = function (smartPhone) {
        $http.post("/find_smart_phone_by_id", JSON.stringify(smartPhone))
            .then(function success(response) {
                $scope.smartPhone = response.data;
            }, function error(response) {
                console.log("error" + response.headers);
            });
    };

    /**
     * addSmartPhone - add smart phone.
     * @param id - id.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     * @param price - price.
     */
    $scope.updateSmartPhoneById = function (id, company, model, description, quantity, price) {
        const smartPhone = {
            id: id,
            company: company,
            model: model,
            description: description,
            quantity: quantity,
            price: price
        };
        $http.post("/update_smart_phone_by_id", JSON.stringify(smartPhone))
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
    $scope.deleteSmartPhoneById = function (id) {
        const smartPhone = {
            id: id
        };
        $http.post("/delete_smart_phone_by_id", JSON.stringify(smartPhone))
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
    $scope.findAllSmartPhone = function () {
        $http.get("/find_all_smart_phone")
            .then(function success(response) {
                $scope.smartPhones = response.data;
                $scope.deleteAllFromOrders();
            }, function error(response) {
                console.log("error" + response.headers);
            });
    };

    /**
     * addToOrder - adds smart phone to order.
     * @param id - id.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     * @param price - price.
     */
    $scope.addToOrder = function (id, company, model, description, quantity, price) {
        let smartPhone = {
            id: id,
            company: company,
            model: model,
            description: description,
            quantity: quantity,
            price: price
        };
        let indexInOrders = $scope.findIndexById($scope.orders, id);
        let indexInSmartPhones = $scope.findIndexById($scope.smartPhones, id);
        if (indexInOrders < 0) {
            smartPhone.quantity = 1;
            $scope.orders.push(smartPhone);
            if ($scope.smartPhones[indexInSmartPhones].quantity > 1) {
                $scope.smartPhones[indexInSmartPhones].quantity = $scope.smartPhones[indexInSmartPhones].quantity - 1;
            } else {
                $scope.smartPhones.splice(indexInSmartPhones, 1);
            }
        } else {
            $scope.orders[indexInOrders].quantity = $scope.orders[indexInOrders].quantity + 1;
            if ($scope.smartPhones[indexInSmartPhones].quantity > 1) {
                $scope.smartPhones[indexInSmartPhones].quantity = $scope.smartPhones[indexInSmartPhones].quantity - 1;
            } else {
                $scope.smartPhones.splice(indexInSmartPhones, 1);
            }
        }
    };

    /**
     * deleteFromOrder - delete from order.
     * @param id - id.
     * @param company - company.
     * @param model - model.
     * @param description - description.
     * @param quantity - quantity.
     */
    $scope.deleteFromOrder = function (id, company, model, description, quantity) {
        let smartPhone = {
            id: id,
            company: company,
            model: model,
            description: description,
            quantity: quantity
        };
        let indexInOrders = $scope.findIndexById($scope.orders, id);
        let indexInSmartPhones = $scope.findIndexById($scope.smartPhones, id);
        if ($scope.orders[indexInOrders].quantity > 1) {
            $scope.orders[indexInOrders].quantity = $scope.orders[indexInOrders].quantity - 1;
            if (indexInSmartPhones < 0) {
                smartPhone.quantity = 1;
                $scope.smartPhones.push(smartPhone);
            } else {
                $scope.smartPhones[indexInSmartPhones].quantity = $scope.smartPhones[indexInSmartPhones].quantity + 1;
            }

        } else {
            $scope.orders.splice(indexInOrders, 1);
            if (indexInSmartPhones < 0) {
                smartPhone.quantity = 1;
                $scope.smartPhones.push(smartPhone);
            } else {
                $scope.smartPhones[indexInSmartPhones].quantity = $scope.smartPhones[indexInSmartPhones].quantity + 1;
            }
        }
    };

    /**
     * findIndexById - find index by id.
     * @param data - array.
     * @param id  - id.
     * @returns {number} - index.
     */
    $scope.findIndexById = function (data, id) {
        let index = -1;
        let container = data;
        for (let i = 0; i < container.length; i++) {
            if (container[i].id === id) {
                index = i;
            }
        }
        return index;
    };

    /**
     * deleteAllFromOrders - delete all from orders.
     */
    $scope.deleteAllFromOrders = function () {
        for (let i = 0; i < $scope.orders.length; i++) {
            $scope.orders.splice(i, 1);
            i--;
        }
    };

    /**
     * addSmartPhone - add smart phone.
     */
    $scope.addOrder = function () {
        $http.post("/add_order", JSON.stringify($scope.orders))
            .then(function (response) {
                if (response.data)
                    console.log("post data submitted successfully");
                $scope.deleteAllFromOrders();
            }, function error(response) {
                console.log("service not exists: " + response.status);
            });
    };

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