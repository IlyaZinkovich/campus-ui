angular.module('campus').factory('AuthService', ['$http', '$rootScope', 'SERVER_HOST', '$state', 'localStorageService', function($http, $rootScope, SERVER_HOST, $state, localStorageService) {

  function checkAccess (event, toState, toParams, fromState, fromParams) {

        if (toState.data !== undefined) {
          if (toState.data.noLogin !== undefined && toState.data.noLogin) {

          }
        } else {
          if (localStorageService.get('user')) {
            $rootScope.user = localStorageService.get('user');
          } else {
            event.preventDefault();
            $state.go('login');
          }
        }
    }

    function authenticate(credentials) {
        return $http.post(SERVER_HOST + '/v1/auth', credentials);
    }

    function isAuthenticated() {
        return localStorageService.get('user') !== null;
    }

    return {
        isAuthenticated: isAuthenticated,
        authenticate: authenticate,
        checkAccess : checkAccess
    };
}]);
