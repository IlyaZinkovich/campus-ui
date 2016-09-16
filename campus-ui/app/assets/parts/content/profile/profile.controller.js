angular.module('campus').controller('ProfileCtrl', ['$scope', '$rootScope',
    'localStorageService','StudentService', function($scope, $rootScope,
        localStorageService, StudentService) {

    $rootScope.imagePath = $scope.user.imagePath;

    $scope.changeImage = function() {
        StudentService.updateImage($rootScope.user.id, $scope.imagePath)
            .then(function(response) {

            $rootScope.user.imagePath = $scope.imagePath;
            localStorageService.set('user', $rootScope.user);
        });
    }
}]);
