angular.module('campus').controller('StudentsModalCtrl', ['$scope', 'LikeService', '$uibModalInstance', 'student',
    function($scope, LikeService, $uibModalInstance, student) {

    $scope.student = student;

    $scope.likeProfile = function(profileToLike) {
        LikeService.like({
            from: profileToLike.id,
            to: $rootScope.userProfile.id,
            likeType: 0
        })
        .then(function(response) {
        });
    };

    $scope.cancel = function () {
        $uibModalInstance.dismiss();
    };

}]);
