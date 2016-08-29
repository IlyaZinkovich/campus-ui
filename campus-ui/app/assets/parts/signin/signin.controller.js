angular.module("campus").controller("SignInCtrl", ["$scope", "$rootScope", "$state", "localStorageService", function($scope, $rootScope, $state, localStorageService) {

    $scope.user = {
        login : "",
        password : ""
    };
    $scope.isError = false;

    $scope.checkUser = function () {
        if ($scope.user.login == "1" && $scope.user.password == "1") {
            localStorageService.cookie.set("isAuthorized", true);
            var userProfileId = 7;
            localStorageService.cookie.set("userProfileId", userProfileId);
            $state.go("default", {} , {reload: true});
        } else {
            $scope.errorText = "user invalid";
            $scope.isError = true;
        }
    };
}]);
