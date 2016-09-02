angular.module("campus").controller("LoginCtrl", ["$scope", "$state", "localStorageService", "AuthService",
    function($scope, $state, localStorageService, AuthService) {

      $scope.checkUser = function() {
          AuthService.authenticate($scope.user).then(function(response) {
              localStorageService.set("user", response.data);
              $state.go("default");
          }, function(response) {
              console.error("Authentication failed");
          });
      };
}]);
