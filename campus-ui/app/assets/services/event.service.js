angular.module('campus').factory('EventService', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function getProfileEvents(profileId) {
        return $http.get(SERVER_HOST + "/v1/events/" + profileId);
    }

    return {
        getProfileEvents: getProfileEvents
    };
}]);
