angular.module('campus').factory('GroupService', ['$http', 'SERVER_HOST',
    function($http, SERVER_HOST) {

        function getStudentGroups(studentId, joined) {
            return $http.get(SERVER_HOST + '/v1/groups', {
                params: {
                    studentId: studentId,
                    joined: joined
                }
            });
        };

        function updateImage(groupId, imageUrl) {
            return $http.put(SERVER_HOST + '/v1/groups/' + groupId + '/image', imageUrl);
        };

        function getGroup(groupId) {
            return $http.get(SERVER_HOST + '/v1/groups/' + groupId);
        };

        function updateStudentInGroup(groupId, studentId, action) {
            return $http.put(SERVER_HOST + '/v1/groups/' + groupId + '/students', {}, {
                params: {
                    studentId: studentId,
                    action: action
                }
            });
        };

        return {
            getStudentGroups: getStudentGroups,
            updateImage: updateImage,
            getGroup: getGroup,
            updateStudentInGroup: updateStudentInGroup
        };
    }
]);
