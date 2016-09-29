angular.module('campus').factory('LikeService', ['$http', 'SERVER_HOST', 'SERVER_HOST', function($http, SERVER_HOST, SERVER_HOST) {

    function like(likeObj) {
        return $http.post(SERVER_HOST + '/v1/likes', likeObj);
    }

    function getLikeStudents(studentId) {
        return $http.get(SERVER_HOST + '/v1/students/likes/' + studentId)
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

    function findStudentIdsForMessageLikes(messageId) {
        return $http.get(SERVER_HOST + '/v1/likes/students', {
            params : {
                messageId : messageId
            }
        })
    }

    return {
        like: like,
        getLikeStudents: getLikeStudents,
        checkIfLikeExists: checkIfLikeExists,
        findStudentIdsForMessageLikes: findStudentIdsForMessageLikes
    };
}]);
