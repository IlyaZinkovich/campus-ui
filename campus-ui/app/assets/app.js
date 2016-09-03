angular.module('campus', ['ui.router', 'ui.bootstrap', 'LocalStorageModule'])
    .constant({
        SERVER_HOST: 'http://localhost:8088',
        ROOMS_PER_PAGE : 20,
        STUDENTS_PER_PAGE : 10
    })
    .config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function($stateProvider, $urlRouterProvider, $locationProvider) {
        $stateProvider.state('init', {
                abstract: true,
                views: {
                  '@' : {
                    templateUrl : 'assets/campus.html'
                  },
                  'header@init': {
                      templateUrl: 'assets/parts/header/header.html',
                      controller: 'HeaderCtrl'
                  },
                  'footer@init': {
                      templateUrl: 'assets/parts/footer/footer.html'
                  },
                  'menu@init': {
                      templateUrl: 'assets/parts/menu/menu.html',
                      controller: 'MenuCtrl'
                  }
                }
            })
            .state('default', {
                parent: 'init',
                url: '/',
                views: {
                  'content@': {
                      templateUrl: 'assets/parts/content/events/events.html',
                      controller: 'EventsCtrl'
                  }
                }
            });
        $urlRouterProvider.otherwise('/login');
        $locationProvider.html5Mode(true);
    }]).run(['$rootScope', 'AuthService', function($rootScope, AuthService) {
        $rootScope.$on('$stateChangeStart', function(event, toState, toParams, fromState, fromParams) {
          AuthService.checkAccess(event, toState, toParams, fromState, fromParams);
        });
    }]);
