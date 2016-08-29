angular.module("campus").config(["$stateProvider", function($stateProvider) {

    $stateProvider.state("login", {
        url: "/login",
        templateUrl: "assets/parts/login/login.html",
        controller: "LoginCtrl",
        authenticate: false
    })

}]);
