angular.module("campus").controller("HeaderCtrl", ["$scope", "$rootScope", "$state", "localStorageService", function($scope, $rootScope, $state, localStorageService) {

  $scope.isAuthorized = localStorageService.cookie.get("isAuthorized");
  $scope.user = localStorageService.cookie.get("user");

  $scope.logout = function () {
    localStorageService.cookie.set("isAuthorized", false);
    $state.reload();
  };

  var campus = $("#campus");

  if (!$scope.isAuthorized) {
    campus.removeClass("col-lg-offset-2");
    campus.addClass("col-lg-offset-4");
  } else {
    campus.addClass("col-lg-offset-2");
    campus.removeClass("col-lg-offset-4");
  }
}]);
