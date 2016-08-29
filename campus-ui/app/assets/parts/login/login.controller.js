angular.module("campus").controller("LoginCtrl", ["$scope", "$rootScope", "$state", "localStorageService", function($scope, $rootScope, $state, localStorageService) {

    $scope.checkUser = function() {
        if ($scope.user.login == "1" && $scope.user.password == "1") {
            $rootScope.isAuthenticated = true;
            $state.go("default");
        } else {

        }
    };
}]);
