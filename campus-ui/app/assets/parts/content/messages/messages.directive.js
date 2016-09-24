angular.module('campus').directive('groupMessages', function (){
    return {
        restrict: 'E',
        scope: {
            messages: '='
        },
        templateUrl: 'assets/parts/content/messages/messages.html',
        controller: function($scope, $state, localStorageService, LikeService) {

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
        }
    }
});
