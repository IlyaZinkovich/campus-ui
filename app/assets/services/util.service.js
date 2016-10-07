angular.module('campus').factory('UtilService', ['$http', 'SERVER_HOST', '$uibModal', function($http, SERVER_HOST, $uibModal) {

    function showUserModal(user, size, toggleLikesModal) {
        var authorModal = $uibModal.open({
            templateUrl: 'assets/parts/content/students/modal/student-modal.html',
            controller: 'StudentsModalCtrl',
            size: size,
            resolve: {
                student: user,
                toggleLikesModal: toggleLikesModal
            }
        });
    }

    return {
        showUserModal: showUserModal
    };
}]);
