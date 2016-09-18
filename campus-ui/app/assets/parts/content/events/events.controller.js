angular.module('campus').controller('EventsCtrl',
    ['$scope', '$rootScope', 'localStorageService', 'UtilService',
    'StudentService', 'MessageService', 'LikeService',

    function($scope, $rootScope, localStorageService, UtilService,
        StudentService, MessageService, LikeService) {

        $scope.currentUser = localStorageService.get('user');

        LikeService.getLikeStudents($scope.currentUser.id).then(function(response) {
            $scope.likeStudents = response.data;
        })

        MessageService.getMessagesForStudent($rootScope.user.id).then(function(response) {
            $scope.groupMessages = response.data;
        }, function(error) {
            console.error('messages are not loaded');
        });

        $scope.showUserModal = function(userId, size) {
            StudentService.get(userId).then(function(data) {
                UtilService.showUserModal(data.data, 'lg');
            }, function(error) {
                console.log('error');
            });
        };
    }
]);
