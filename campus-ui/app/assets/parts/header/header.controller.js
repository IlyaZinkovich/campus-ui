angular.module("campus").controller("HeaderCtrl", ["$scope", "$rootScope", "$state", "localStorageService", function($scope, $rootScope, $state, localStorageService) {

  $scope.isAuthorized = localStorageService.cookie.get("isAuthorized");

  $scope.logout = function () {
    localStorageService.set("isAuthorized", false);
    $state.reload();
  };
}]);
