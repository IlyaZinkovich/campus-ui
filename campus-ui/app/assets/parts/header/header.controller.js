angular.module("campus").controller("HeaderCtrl", ["$scope", "$rootScope", "$state", "localStorageService", function($scope, $rootScope, $state, localStorageService) {
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    $scope.logout = function() {
        $rootScope.isAuthenticated = false;
        $state.go("login");
    };
}]);
