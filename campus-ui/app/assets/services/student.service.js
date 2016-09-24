angular.module('campus').factory('StudentService', ['$http', 'SERVER_HOST',
    function($http, SERVER_HOST) {

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

    function getStudent(studentId) {
        return $http.get(SERVER_HOST + '/v1/students/' + studentId);
    }

    function createStudent(student) {
        return $http.post(SERVER_HOST + '/v1/students', student);
    }

    function deleteStudent(studentId) {
        return $http({method: 'DELETE', url:
            SERVER_HOST + '/v1/students/' + studentId    
        });
    }

    function updateStudent(student) {
        return $http.put(SERVER_HOST + '/v1/students/' + student.id, student);
    }

    function updateImage(studentId, imagePath) {
        return $http.put(SERVER_HOST + '/v1/students/' + studentId + '/image', imagePath);
    }

    return {
        create: createStudent,
        delete: deleteStudent,
        update: updateStudent,
        get: getStudent,
        getAll: getStudents,
        updateImage: updateImage
    };
}]);
