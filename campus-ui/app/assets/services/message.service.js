angular.module('campus').factory('MessageService',
    ['$http', 'SERVER_HOST',
    function($http, SERVER_HOST) {

    function getMessagesForStudent(studentId) {
        return $http.get(SERVER_HOST + '/v1/groups/messages', {
            params: {
                studentId: studentId
            }
        });
    }

    return {
        getMessagesForStudent: getMessagesForStudent
    };
}]);
