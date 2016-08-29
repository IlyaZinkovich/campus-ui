angular.module("campus").controller("LoginCtrl", ["$scope", "$rootScope", "$state", "localStorageService", "AuthService",
    function($scope, $rootScope, $state, localStorageService, AuthService) {

    $scope.checkUser = function() {
        AuthService.authenticate($scope.user).then(function(response) {
            $rootScope.userProfile = response.data;
            $rootScope.isAuthenticated = true;
            $state.go("default");
        }, function(response) {
            console.error("Authentication failed");
        });
    };
}]);
