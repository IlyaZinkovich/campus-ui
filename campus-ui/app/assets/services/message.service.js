angular.module('campus').factory('MessageService',
    ['$http', 'SERVER_HOST', 'MESSAGES_PER_PAGE',
    function($http, SERVER_HOST, MESSAGES_PER_PAGE) {

    function getMessagesForStudent(studentId) {
        return $http.get(SERVER_HOST + '/v1/groups/messages', {
            params: {
                studentId: studentId,
                page: 0,
                size: MESSAGES_PER_PAGE
            }
        });
    }

    function getGroupMessages(groupId) {
        return $http.get(SERVER_HOST + '/v1/groups/' + groupId + '/messages', {
            params: {
                page: 0,
                size: MESSAGES_PER_PAGE
            }
        });
    }

    function postGroupMessage(groupId, message) {
        return $http.post(SERVER_HOST + '/v1/groups/' + groupId + '/messages', message);
    }

    return {
        getMessagesForStudent: getMessagesForStudent,
        getGroupMessages: getGroupMessages,
        postGroupMessage: postGroupMessage
    };
}]);
