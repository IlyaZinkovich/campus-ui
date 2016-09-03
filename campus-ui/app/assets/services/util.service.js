angular.module('campus').factory('UtilService', ['$http', 'SERVER_HOST', '$uibModal', function($http, SERVER_HOST, $uibModal) {

    function showUserModal (user, size) {
        var authorModal = $uibModal.open({
            templateUrl: 'assets/parts/content/students/modal/student-modal.html',
            controller: 'StudentsModalCtrl',
            size: size,
            resolve: {
                student: user
            }
        });
    }

    return {
        showUserModal : showUserModal
    };
}]);
