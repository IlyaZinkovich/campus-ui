angular.module('campus').config(['$stateProvider', function($stateProvider) {

    $stateProvider.state('profile', {
        url: '/profile/{id}',
        parent : 'init',
        views: {
            'content': {
                templateUrl: 'assets/parts/content/profile/profile.html',
                controller: 'ProfileCtrl'
            }
        }
    });

}]);
