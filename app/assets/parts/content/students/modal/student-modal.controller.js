angular.module('campus').controller('StudentsModalCtrl', ['$scope', 'LikeService',
    '$uibModalInstance', 'localStorageService', 'student', 'GroupService',
    '$state', 'toggleLikesModal',

    function($scope, LikeService, $uibModalInstance, localStorageService,
        student, GroupService, $state, toggleLikesModal) {

        $scope.student = student;
        $scope.currentUser = localStorageService.get('user');
        $scope.toggleLikesModal = toggleLikesModal;

        LikeService.checkIfLikeExists($scope.currentUser.id, $scope.student.id, "STUDENT_TO_STUDENT").then(function(response) {
            $scope.checkIfLikeExists = response.data;
        });

        $scope.likeProfile = function() {
            LikeService.like({
                    from: $scope.currentUser.id,
                    to: student.id,
                    type: "STUDENT_TO_STUDENT"
                })
                .then(function(response) {
                    $scope.checkIfLikeExists = response.data;
                });
        };

        $scope.close = function() {
            $uibModalInstance.dismiss();
        };

        GroupService.getStudentGroups(student.id, true).then(function(response) {
            $scope.groupsStudentJoined = response.data;
        });

        $scope.goToGroup = function(groupId) {
            $scope.close();
            $state.go('group', {'groupId': groupId});
        }
    }
]);
