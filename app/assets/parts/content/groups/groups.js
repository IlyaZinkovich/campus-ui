angular.module('campus').config(['$stateProvider', function($stateProvider) {

    $stateProvider.state('groups', {
        url: '/groups',
        parent : 'init',
        views: {
            'content': {
                templateUrl: 'assets/parts/content/groups/groups.html',
                controller: 'GroupsCtrl'
            }
        }
    });

}]);
