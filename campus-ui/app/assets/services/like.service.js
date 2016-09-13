angular.module('campus').factory('LikeService', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function like(likeObj) {
        return $http.post(SERVER_HOST + '/v1/likes', likeObj);
    }

    function checkIfLikeExists(from, to, type) {
        return $http.get(SERVER_HOST + '/v1/likes', {
            params: {
                from: from,
                to: to,
                type: type
            }
        });
    }
    return {
        like: like,
        checkIfLikeExists: checkIfLikeExists
    };
}]);
