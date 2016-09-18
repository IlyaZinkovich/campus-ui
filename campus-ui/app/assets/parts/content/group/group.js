angular.module('campus').config(['$stateProvider', function($stateProvider) {

    $stateProvider.state('group', {
        url: '/groups/{groupId}',
        parent : 'init',
        views: {
            'content': {
                templateUrl: 'assets/parts/content/group/group.html',
                controller: 'GroupCtrl'
            }
        }
    });

}]);
