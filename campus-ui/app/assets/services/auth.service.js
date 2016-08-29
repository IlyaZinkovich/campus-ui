angular.module('campus').factory('AuthService', ['$http', '$rootScope', 'SERVER_HOST', function($http, $rootScope, SERVER_HOST) {

    function isAuthenticated() {
        return $rootScope.isAuthenticated;
    }
    return {
        isAuthenticated: isAuthenticated
    };
}]);
