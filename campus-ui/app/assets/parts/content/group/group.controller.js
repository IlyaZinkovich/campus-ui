angular.module('campus').controller('GroupCtrl', ['$scope', '$state', '$stateParams', '$rootScope', 'localStorageService',
    'GroupService', 'MessageService',

    function($scope, $state, $stateParams, $rootScope, localStorageService,
        GroupService, MessageService) {

        $scope.currentUser = localStorageService.get('user');

        GroupService.getGroup($stateParams.groupId)
            .then(function(response) {
                $scope.group = response.data;
                $scope.imageUrl = $scope.group.imageUrl;
                MessageService.getGroupMessages($scope.group.id).then(function(response) {
                    $scope.groupMessages = response.data;
                });
                GroupService.getStudentGroups($scope.currentUser.id, true)
                    .then(function(response) {
                        $scope.studentGroups = response.data;
                        checkIfStudentJoinedGroup();
                    });
            });

        $scope.join = function() {
            GroupService.updateStudentInGroup($scope.group.id, $scope.currentUser.id, 'ADD').then(function(response) {
                $scope.studentGroups.push($scope.group);
                checkIfStudentJoinedGroup();
            });
        };

        $scope.leave = function() {
            GroupService.updateStudentInGroup($scope.group.id, $scope.currentUser.id, 'DELETE').then(function(response) {
                var index = $scope.studentGroups.indexOf($scope.group);
                $scope.studentGroups.splice(index, 1);
                checkIfStudentJoinedGroup();
            });
        };

        function checkIfStudentJoinedGroup() {
            $scope.studentInGroup = $scope.studentGroups.map(function(group) {
                return group.id;
            }).indexOf($scope.group.id) >= 0;
        }

        $scope.changeImage = function() {
            GroupService.updateImage($stateParams.groupId, $scope.imageUrl)
                .then(function(response) {
                    $scope.group.imageUrl = $scope.imageUrl;
                });
        };

        $scope.postMessage = function() {
            var message = {
                'message': $scope.messageBody,
                'studentId': $scope.currentUser.id
            }
            MessageService.postGroupMessage($scope.group.id, message)
                .then(function(response) {
                    MessageService.getGroupMessages($scope.group.id).then(function(response) {
                        $scope.groupMessages = response.data;
                    });
                    $scope.messageBody = '';
                });
        }
    }
]);
