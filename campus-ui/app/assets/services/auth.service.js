angular.module('campus').factory('AuthService', ['$http', '$rootScope', 'SERVER_HOST', function($http, $rootScope, SERVER_HOST) {

    function authenticate(credentials) {
        return $http.post(SERVER_HOST + "/v1/auth", credentials);
    }
    function isAuthenticated() {
        return $rootScope.isAuthenticated;
    }
    return {
        isAuthenticated: isAuthenticated,
        authenticate: authenticate
    };
}]);
