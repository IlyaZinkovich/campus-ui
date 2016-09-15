angular.module('campus').controller('EventsCtrl', ['$scope', '$rootScope', 'localStorageService', 'UtilService', 'StudentService',
    'EventService', 'LikeService',

    function($scope, $rootScope, localStorageService, UtilService, StudentService, EventService, LikeService) {

        $scope.currentUser = localStorageService.get('user');

        $scope.campusEvents = [{
            title: 'Hi and welcome to the Campus!',
            body: 'Meet the people that like you too'
        }];


        LikeService.getLikeStudents($scope.currentUser.id).then(function(response) {
            $scope.likeStudents = response.data;
        })

        EventService.getProfileEvents($rootScope.user.id).then(function(response) {
            $scope.events = response.data;
        }, function(error) {
            console.error('events not loaded');
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
