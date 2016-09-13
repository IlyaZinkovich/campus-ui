angular.module('campus').controller('StudentsModalCtrl', ['$scope', 'LikeService', '$uibModalInstance', 'localStorageService', 'student',

    function($scope, LikeService, $uibModalInstance, localStorageService, student) {

        $scope.student = student;
        $scope.currentUser = localStorageService.get('user');

        LikeService.checkIfLikeExists($scope.currentUser.id, $scope.student.id, "STUDENT").then(function(response) {
            $scope.checkIfLikeExists = response.data;
        });

        $scope.likeProfile = function(profileToLike) {
            LikeService.like({
                    from: profileToLike.id,
                    to: $rootScope.userProfile.id,
                    likeType: "STUDENT"
                })
                .then(function(response) {
                    $scope.checkIfLikeExists = true;
                });
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss();
        };

    }
]);
