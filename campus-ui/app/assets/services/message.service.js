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

    function getGroupMessages(groupId) {
        return $http.get(SERVER_HOST + '/v1/groups/' + groupId + '/messages');
    }

    return {
        getMessagesForStudent: getMessagesForStudent,
        getGroupMessages: getGroupMessages
    };
}]);
