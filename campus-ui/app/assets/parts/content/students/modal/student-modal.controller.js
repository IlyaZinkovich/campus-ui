angular.module('campus').controller('StudentsModalCtrl', ['$scope', 'LikeService', '$uibModalInstance', 'localStorageService', 'student',

    function($scope, LikeService, $uibModalInstance, localStorageService, student) {

        $scope.student = student;
        $scope.currentUser = localStorageService.get('user');

        LikeService.checkIfLikeExists($scope.currentUser.id, $scope.student.id, "STUDENT").then(function(response) {
            $scope.checkIfLikeExists = response.data;
        });

        $scope.likeProfile = function() {
            LikeService.like({
                    from: $scope.currentUser.id,
                    to: student.id,
                    type: "STUDENT"
                })
                .then(function(response) {
                    $scope.checkIfLikeExists = response.data;
                });
        };

        $scope.cancel = function() {
            $uibModalInstance.dismiss();
        };

    }
]);
