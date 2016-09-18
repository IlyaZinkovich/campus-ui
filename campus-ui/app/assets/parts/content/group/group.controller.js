angular.module('campus').controller('GroupCtrl',
    ['$scope', '$state', '$stateParams', '$rootScope', 'localStorageService', 'GroupService',

    function($scope, $state, $stateParams, $rootScope, localStorageService, GroupService) {

        $scope.currentUser = localStorageService.get('user');

        GroupService.getStudentGroups($scope.currentUser.id, true)
            .then(function(response) {
            $scope.studentGroups = response.data;
        });

        GroupService.getGroup($stateParams.groupId)
            .then(function(response) {
            $scope.group = response.data;
            $scope.imageUrl = $scope.group.imageUrl;
        });

        $scope.changeImage = function() {
            GroupService.updateImage($stateParams.groupId, $scope.imageUrl)
                .then(function(response) {
                $scope.group.imageUrl = $scope.imageUrl;
            });
        };
    }
]);
