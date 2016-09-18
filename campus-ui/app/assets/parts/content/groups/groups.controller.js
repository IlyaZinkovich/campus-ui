angular.module('campus').controller('GroupsCtrl',
    ['$scope', '$rootScope', 'localStorageService', 'GroupService',

    function($scope, $rootScope, localStorageService, GroupService) {

        $scope.currentUser = localStorageService.get('user');

        GroupService.getStudentGroups($scope.currentUser.id, true)
            .then(function(response) {
            $scope.studentGroups = response.data;
        });

        GroupService.getStudentGroups($scope.currentUser.id, false)
            .then(function(response) {
            $scope.groupsToJoin = response.data;
        });
    }
]);
