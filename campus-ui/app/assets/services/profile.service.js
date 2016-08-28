angular.module('campus').factory('ProfileFactory', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function getProfiles() {
        return $http.get(SERVER_HOST + "/v1/profiles");
    }

    function getProfile(profileId) {
        return $http.get(SERVER_HOST + "/v1/profiles/" + profileId);
    }

    function createProfile(profile) {
        return $http.post(SERVER_HOST + "/v1/profiles", profile);
    }

    function deleteProfile(profileId) {
        return $http.delete(SERVER_HOST + "/v1/profiles/" + profileId);
    }

    function updateProfile(profile) {
        return $http.post(SERVER_HOST + "/v1/profiles/" + profile.id, profile);
    }

    return {
        create: createProfile,
        delete: deleteProfile,
        update: updateProfile,
        get: getProfile,
        getAll: getProfiles
    };
}]);