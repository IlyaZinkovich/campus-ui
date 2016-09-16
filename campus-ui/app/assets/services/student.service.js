angular.module('campus').factory('StudentService', ['$http', 'SERVER_HOST', function($http, SERVER_HOST) {

    function getStudents(criteria, page, size) {
        return $http.get(SERVER_HOST + '/v1/students', {
            params: {
                name: criteria.name,
                ageLow: criteria.ageLow,
                ageHigh: criteria.ageHigh,
                gender: criteria.gender,
                faculty: criteria.faculty,
                speciality: criteria.speciality,
                course: criteria.course,
                group: criteria.group,
                page: page,
                size: size
            }
        });
    }

    function getProfile(profileId) {
        return $http.get(SERVER_HOST + '/v1/students/' + profileId);
    }

    function createProfile(profile) {
        return $http.post(SERVER_HOST + '/v1/students', profile);
    }

    function deleteProfile(profileId) {
        return $http.delete(SERVER_HOST + '/v1/students/' + profileId);
    }

    function updateProfile(profile) {
        return $http.put(SERVER_HOST + '/v1/students/' + profile.id, profile);
    }

    function updateProfileImage(profileId, imagePath) {
        return $http.put(SERVER_HOST + '/v1/students/' + profileId + '/image', {
            'imagePath': imagePath
        });
    }

    return {
        create: createProfile,
        delete: deleteProfile,
        update: updateProfile,
        get: getProfile,
        getAll: getStudents,
        updateProfileImage: updateProfileImage
    };
}]);
