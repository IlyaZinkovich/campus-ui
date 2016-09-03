angular.module('campus').controller('HeaderCtrl', ['$scope', '$rootScope', '$state', 'localStorageService', function($scope, $rootScope, $state, localStorageService) {

    $('#menu-toggle').click(function(e) {
        e.preventDefault();
        $('#wrapper').toggleClass('toggled');
    });

    $scope.logout = function() {
      localStorageService.set('user', null);
      $state.go('login');
    };
}]);
