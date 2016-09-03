angular.module('campus').factory('ProfileService', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function getProfiles(criteria, page, size) {
        return $http.get(SERVER_HOST + '/v1/profiles', {
          params : {
            name: criteria.name,
            ageLow: criteria.ageLow,
            ageHigh: criteria.ageHigh,
            gender: criteria.gender,
            faculty: criteria.faculty,
            speciality: criteria.speciality,
            course: criteria.course,
            group: criteria.group,
            page : page,
            size : size
          }
        });
    }

    function getProfile(profileId) {
        return $http.get(SERVER_HOST + '/v1/profiles/' + profileId);
    }

    function createProfile(profile) {
        return $http.post(SERVER_HOST + '/v1/profiles', profile);
    }

    function deleteProfile(profileId) {
        return $http.delete(SERVER_HOST + '/v1/profiles/' + profileId);
    }

    function updateProfile(profile) {
        return $http.put(SERVER_HOST + '/v1/profiles/' + profile.id, profile);
    }

    return {
        create: createProfile,
        delete: deleteProfile,
        update: updateProfile,
        get: getProfile,
        getAll: getProfiles
    };
}]);
