angular.module('campus').factory('LikeService', ['$http', 'SERVER_HOST', 'RELATIONSHIP_SERVER_HOST', function($http, SERVER_HOST, RELATIONSHIP_SERVER_HOST) {

    function like(likeObj) {
        return $http.post(RELATIONSHIP_SERVER_HOST + '/v1/likes', likeObj);
    }

    function getLikeStudents(studentId) {
        return $http.get(SERVER_HOST + '/v1/likes/students/' + studentId)
    }

    function checkIfLikeExists(from, to, type) {
        return $http.get(RELATIONSHIP_SERVER_HOST + '/v1/likes', {
            params: {
                from: from,
                to: to,
                type: type
            }
        });
    }
    return {
        like: like,
        getLikeStudents: getLikeStudents,
        checkIfLikeExists: checkIfLikeExists
    };
}]);
