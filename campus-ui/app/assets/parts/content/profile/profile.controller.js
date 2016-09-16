angular.module('campus').controller('ProfileCtrl', ['$scope', '$rootScope', 'StudentService', function($scope, $rootScope, StudentService) {

    $scope.changeImage = function() {
        StudentService.updateProfileImage($rootScope.user.id, $scope.imagePath);
    }
}]);
