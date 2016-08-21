angular.module("campus").controller("LoginCtrl", ["$scope", "$rootScope", "$state", "localStorageService", function($scope, $rootScope, $state, localStorageService) {

  $scope.user = {
    login : "",
    password : ""
  };
  $scope.isError = false;

  $scope.checkUser = function () {
    if ($scope.user.login == "1" && $scope.user.password == "1") {
      localStorageService.cookie.set("isAuthorized", true);
      var user = {
        name : "Mike",
        age : 10,
        id : 15,
        room : 601
      };
      localStorageService.cookie.set("user", user);
      $state.go("default", {} , {reload: true});
    } else {
      $scope.errorText = "user invalid";
      $scope.isError = true;
    }
  };
}]);
