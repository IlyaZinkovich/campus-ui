angular.module("campus").controller("LoginCtrl", ["$scope", "$rootScope", "$state", "localStorageService", function($scope, $rootScope, $state, localStorageService) {

  $scope.user = {
    name : "",
    password : ""
  };
  $scope.isError = false;

  $scope.check = function () {
    if ($scope.user.name == "admin" && $scope.user.password == "admin") {
      localStorageService.cookie.set("isAuthorized", true);
      $state.go("default", {} , {reload: true});
    } else {
      $scope.errorText = "user invalid";
      $scope.isError = true;
    }
  };
}]);
