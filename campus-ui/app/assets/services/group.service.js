angular.module('campus').factory('GroupService',
    ['$http', 'SERVER_HOST',
    function($http, SERVER_HOST) {

    function getStudentGroups(studentId, joined) {
        return $http.get(SERVER_HOST + '/v1/groups', {
            params: {
                studentId: studentId,
                joined: joined
            }
        });
    }

    return {
        getStudentGroups: getStudentGroups
    };
}]);
