angular.module('campus').config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('default', {
      parent: 'init',
      url: '/events',
      views: {
          'content': {
              templateUrl: 'assets/parts/content/events/events.html',
              controller: 'EventsCtrl'
          }
      }
    });
}]);
