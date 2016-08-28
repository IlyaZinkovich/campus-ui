angular.module("campus").controller("ProfileCtrl", ["$scope", "localStorageService", "$animate", function($scope, localStorageService, $animate) {

  $scope.user = localStorageService.cookie.get("user");

  $scope.updateUser = function () {
    localStorageService.cookie.set("user", $scope.user);
    $scope.success = "User updated successfully";
  };

}]);
