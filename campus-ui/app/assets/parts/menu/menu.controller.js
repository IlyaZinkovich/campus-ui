angular.module('campus').controller('MenuCtrl', ['$scope', 'localStorageService', function($scope, localStorageService) {

    $scope.isAuthorized = localStorageService.cookie.get("isAuthorized");
}]);
