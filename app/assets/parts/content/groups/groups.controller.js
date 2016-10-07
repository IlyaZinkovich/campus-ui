angular.module('campus').controller('GroupsCtrl',
    ['$scope', '$state', '$rootScope', 'localStorageService', 'GroupService',

    function($scope, $state, $rootScope, localStorageService, GroupService) {

        $scope.currentUser = localStorageService.get('user');

        GroupService.getStudentGroups($scope.currentUser.id, true)
            .then(function(response) {
            $scope.studentGroups = response.data;
        });

        GroupService.getStudentGroups($scope.currentUser.id, false)
            .then(function(response) {
            $scope.groupsToJoin = response.data;
        });

        $scope.goToGroup = function(groupId) {
            $state.go('group', {'groupId': groupId});
        }
    }
]);
