angular.module('campus').controller('ProfileCtrl', ['$scope', '$rootScope',
    'localStorageService','StudentService', 'GroupService', function($scope, $rootScope,
        localStorageService, StudentService, GroupService) {

    $rootScope.imagePath = $scope.user.imagePath;

    $scope.changeImage = function() {
        StudentService.updateImage($rootScope.user.id, $scope.imagePath)
            .then(function(response) {

            $rootScope.user.imagePath = $scope.imagePath;
            localStorageService.set('user', $rootScope.user);
        });
    };

    GroupService.getStudentGroups($rootScope.user.id, true).then(function(response) {
        $scope.groupsStudentJoined = response.data;
    });
}]);
