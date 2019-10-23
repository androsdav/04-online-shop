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
     * @type {{quantity: null, price: null, description: null, company: null, model: null}}
     */
    $scope.addPhone = {
        id: null,
        company: null,
        model: null,
        description: null,
        quantity: null,
        price: null
    };

    /**
     * @type {{quantity: null, price: null, description: null, company: null, model: null, id: null}}
     */
    $scope.findPhone = {
        id: null,
        company: null,
        model: null,
        description: null,
        quantity: null,
        price: null
    };

    /**
     *
     * @type {{quantity: null, price: null, description: null, company: null, model: null, id: null}}
     */
    $scope.getPhone = {
        id: null,
        company: null,
        model: null,
        description: null,
        quantity: null,
        price: null
    };

    /**
     *
     * @type {{quantity: null, price: null, description: null, company: null, model: null, id: null}}
     */
    $scope.updatePhone = {
        id: null,
        company: null,
        model: null,
        description: null,
        quantity: null,
        price: null
    };

    /**
     *
     * @type {{quantity: null, price: null, description: null, company: null, model: null, id: null}}
     */
    $scope.product = {
        id: null,
        company: null,
        model: null,
        description: null,
        quantity: null,
        price: null
    };

    /**
     *
     * @type {Array}
     */
    $scope.orders = [];

    /**
     *
     * @type {{}}
     */
    $scope.order = {};

    /**
     *
     * @type {Array}
     */
    $scope.basket = [];

    /**
     *
     * @type {{firstName: null, password: null, phoneNumber: null, id: null, login: null, secondName: null}}
     */
    $scope.addUser = {
        id: null,
        login: null,
        password: null,
        firstName: null,
        secondName: null,
        phoneNumber: null,
    };

    /**
     *
     * @type {{firstName: null, password: null, phoneNumber: null, id: null, login: null, secondName: null}}
     */
    $scope.findUser = {
        id: null,
        login: null,
        password: null,
        firstName: null,
        secondName: null,
        phoneNumber: null,
    };

    /**
     *
     * @type {{firstName: null, password: null, phoneNumber: null, id: null, login: null, secondName: null}}
     */
    $scope.getUser = {
        id: null,
        login: "anonymous",
        password: null,
        firstName: null,
        secondName: null,
        phoneNumber: null,
    };

    /**
     *
     * @type {string}
     */
    $scope.information = "";

    $scope.andros = {};

    /**
     * isEmptyObject - is empty object.
     * @param object - object.
     * @returns {boolean}
     */
    $scope.isEmptyObject = function (object) {
        return angular.equals(object, "");
    };

    /**
     * addSmartPhone - add smart phone.
     * @param user - user.
     */
     $scope.saveUser = function (user) {
        $http.post("/save_user", JSON.stringify(user))
            .then(function (response) {
                if ($scope.isEmptyObject(response.data)) {
                    $scope.information = "user with login that already exists";
                } else {
                    $scope.information = "registration completed successfully";
                }
            }, function error(response) {
                console.log("service not exists: " + response.status);
            });
    };

    /**
     * findUserByLoginAndPassword - find user by login and password (sign in).
     * @param user - user.
     */
    $scope.findUserByLoginAndPassword = function (user) {
        $http.post("/find_user_by_login_and_password", JSON.stringify(user))
            .then(function success(response) {
                if ($scope.isEmptyObject(response.data)) {
                    $scope.information = "authorization was failed";
                } else {
                    $scope.information = "authorization was successful";
                    $scope.getUser = response.data;
                }
            }, function error(response) {
                console.log("error" + response.headers);
            });
    };

    /**
     * signOut - sign out.
     */
    $scope.signOut = function () {
        $scope.getUser = {
            id: null,
            login: "anonymous",
            password: null,
            firstName: null,
            secondName: null,
            phoneNumber: null,
        };
    };


    /**
     * addSmartPhone - add smart phone.
     * @param smartPhone - smart phone.
     */
    $scope.saveSmartPhone = function (smartPhone) {
        $http.post("/save_smart_phone", JSON.stringify(smartPhone))
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
                $scope.getPhone = response.data;
            }, function error(response) {
                console.log("error" + response.headers);
            });
    };

    /**
     * addSmartPhone - add smart phone.
     * @param smartPhone - smart phone.
     */
    $scope.updateSmartPhoneById = function (smartPhone) {
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
     * @param smartPhone - smart phone.
     */
    $scope.deleteSmartPhoneById = function (smartPhone) {
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
                $scope.deleteAllFromBasket();
            }, function error(response) {
                console.log("error" + response.headers);
            });
    };

    /**
     * addToBasket - adds smart phone to order.
     * @param product1 - product.
     */
    $scope.addToBasket = function (product1) {
        let product = {
            id: product1.id,
            company: product1.company,
            model: product1.model,
            description: product1.description,
            quantity: product1.quantity,
            price: product1.price
        };
        let indexInBasket = $scope.findIndexById($scope.basket, product.id);
        let indexInSmartPhones = $scope.findIndexById($scope.smartPhones, product.id);
        if (indexInBasket < 0) {
            product.quantity = 1;
            $scope.basket.push(product);
            if ($scope.smartPhones[indexInSmartPhones].quantity > 1) {
                $scope.smartPhones[indexInSmartPhones].quantity = $scope.smartPhones[indexInSmartPhones].quantity - 1;
            } else {
                $scope.smartPhones.splice(indexInSmartPhones, 1);
            }
        } else {
            $scope.basket[indexInBasket].quantity = $scope.basket[indexInBasket].quantity + 1;
            if ($scope.smartPhones[indexInSmartPhones].quantity > 1) {
                $scope.smartPhones[indexInSmartPhones].quantity = $scope.smartPhones[indexInSmartPhones].quantity - 1;
            } else {
                $scope.smartPhones.splice(indexInSmartPhones, 1);
            }
        }
    };

    /**
     * deleteFromBasket - delete from order.
     * @param product1 - product.
     */
    $scope.deleteFromBasket = function (product1) {
        let product = {
            id: product1.id,
            company: product1.company,
            model: product1.model,
            description: product1.description,
            quantity: product1.quantity,
            price: product1.price
        };
        let indexInBasket = $scope.findIndexById($scope.basket, product.id);
        let indexInSmartPhones = $scope.findIndexById($scope.smartPhones, product.id);
        if ($scope.basket[indexInBasket].quantity > 1) {
            $scope.basket[indexInBasket].quantity = $scope.basket[indexInBasket].quantity - 1;
            if (indexInSmartPhones < 0) {
                product.quantity = 1;
                $scope.smartPhones.push(product);
            } else {
                $scope.smartPhones[indexInSmartPhones].quantity = $scope.smartPhones[indexInSmartPhones].quantity + 1;
            }
        } else {
            $scope.basket.splice(indexInBasket, 1);
            if (indexInSmartPhones < 0) {
                product.quantity = 1;
                $scope.smartPhones.push(product);
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
    $scope.deleteAllFromBasket = function () {
        for (let i = 0; i < $scope.basket.length; i++) {
            $scope.basket.splice(i, 1);
            i--;
        }
    };

    /**
     * addSmartPhone - add smart phone.
     */
    $scope.saveOrder = function () {
        $scope.order.user = $scope.getUser;
        $scope.order.smartPhones = $scope.basket;
        $http.post("/save_order", JSON.stringify($scope.order))
            .then(function (response) {
                if (response.data)
                    console.log("post data submitted successfully");
                $scope.deleteAllFromBasket();
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