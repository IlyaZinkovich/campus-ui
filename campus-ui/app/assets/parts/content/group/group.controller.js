angular.module('campus').controller('GroupCtrl',
    ['$scope', '$state', '$stateParams', '$rootScope', 'localStorageService',
    'GroupService', 'MessageService',

    function($scope, $state, $stateParams, $rootScope, localStorageService,
        GroupService, MessageService) {

        $scope.currentUser = localStorageService.get('user');

        GroupService.getStudentGroups($scope.currentUser.id, true)
            .then(function(response) {
            $scope.studentGroups = response.data;
        });

        GroupService.getGroup($stateParams.groupId)
            .then(function(response) {
            $scope.group = response.data;
            $scope.imageUrl = $scope.group.imageUrl;
            MessageService.getGroupMessages($scope.group.id).then(function(response) {
                $scope.groupMessages = response.data;
            });
        });

        $scope.changeImage = function() {
            GroupService.updateImage($stateParams.groupId, $scope.imageUrl)
                .then(function(response) {
                $scope.group.imageUrl = $scope.imageUrl;
            });
        };

        $scope.createMessage = function() {
            var message = {
                'message': $scope.messageBody,
                'studentId': $scope.currentUser.id
            }
            MessageService.postGroupMessage($scope.group.id, message)
                .then(function(response) {
                MessageService.getGroupMessages($scope.group.id).then(function(response) {
                    $scope.groupMessages = response.data;
                });
            });
        }
    }
]);
