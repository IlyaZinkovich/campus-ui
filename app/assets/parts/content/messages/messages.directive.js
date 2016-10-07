angular.module('campus').directive('groupMessages', function (){
    return {
        restrict: 'E',
        scope: {
            messages: '='
        },
        templateUrl: 'assets/parts/content/messages/messages.html',
        controller: function($scope, $state, localStorageService, LikeService,
            StudentService, UtilService) {

            $scope.currentUser = localStorageService.get('user');

            $scope.checkIfStudentLikesMessage = function(message) {
                return message.likesStudentIds.indexOf($scope.currentUser.id) >= 0;
            }

            $scope.likeMessage = function(groupMessage) {
                LikeService.like({
                    from : $scope.currentUser.id,
                    to : groupMessage.id,
                    type : 'STUDENT_TO_MESSAGE'
                }).then(function(response) {
                    LikeService.findStudentIdsForMessageLikes(groupMessage.id)
                        .then(function(response){
                        groupMessage.likesStudentIds = response.data;
                    })
                });
            }

            $scope.findStudentsForMessageLikes = function(groupMessage) {
                if (groupMessage.likesStudentIds.length > 0) {
                    StudentService.getAll({
                        studentIds: groupMessage.likesStudentIds
                    }, 0, 20).then(function(response) {
                        $scope.studentForMessageLikes = response.data;
                    })
                } else {
                    $scope.studentForMessageLikes = []
                }
            }

            $scope.showUserModal = function (userId, size) {
                StudentService.get(userId).then(function(data) {
                    UtilService.showUserModal(data.data, 'lg', true);
                }, function(error) {
                    console.log('error');
                });
            };
        }
    }
});
