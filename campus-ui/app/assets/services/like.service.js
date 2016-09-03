angular.module('campus').factory('LikeService', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function like(likeObj) {
        return $http.post(SERVER_HOST + '/v1/likes', likeObj);
    }

    return {
        like: like
    };
}]);
