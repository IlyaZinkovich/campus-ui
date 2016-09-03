angular.module('campus').controller('EventsCtrl', ['$scope', '$rootScope', 'EventService', function($scope, $rootScope, EventService) {

    EventService.getProfileEvents($rootScope.user.id).then(function(response) {
        $scope.events = response.data;
    }, function(error) {
        console.error('events not loaded');
    });
}]);
