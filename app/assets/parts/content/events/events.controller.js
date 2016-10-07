angular.module('campus').controller('EventsCtrl',
    ['$scope', '$rootScope', 'localStorageService', 'UtilService',
    'StudentService', 'MessageService', 'LikeService',

    function($scope, $rootScope, localStorageService, UtilService,
        StudentService, MessageService, LikeService) {

        $scope.page = 0;
        $scope.groupMessages = [];
        $scope.loading = false;

        $scope.currentUser = localStorageService.get('user');

        LikeService.getLikeStudents($scope.currentUser.id).then(function(response) {
            $scope.likeStudents = response.data;
        })

        $scope.nextPage = function() {
            if ($scope.loading) return;
            $scope.loading = true;
            MessageService.getMessagesForStudent($rootScope.user.id, $scope.page).then(function(response) {
                $scope.lastChunk = response.data;
                $scope.groupMessages.push.apply($scope.groupMessages, $scope.lastChunk);
                $scope.loading = false;
            }, function(error) {
                console.error('messages are not loaded');
            });
            $scope.page++;
        }

        $scope.showUserModal = function(userId, size) {
            StudentService.get(userId).then(function(data) {
                UtilService.showUserModal(data.data, 'lg');
            }, function(error) {
                console.log('error');
            });
        };
    }
]);
