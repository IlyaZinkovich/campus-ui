angular.module('campus').controller('StudentsListCtrl', ['$scope', '$state', 'STUDENTS_PER_PAGE', 'ProfileService', 'UtilService',
    function ($scope, $state, STUDENTS_PER_PAGE, ProfileService, UtilService) {

    $scope.page = 0;

    $scope.view = 'list';

    $scope.showUserModal = function (userId, size) {
        ProfileService.get(userId).then(function(data) {
            UtilService.showUserModal(data.data, 'lg');
        }, function(error) {
            console.log('error');
        });
    };

    $scope.filterStudents = function () {
        ProfileService.getAll($scope.filterCriteria, $scope.page, STUDENTS_PER_PAGE).then(function(response) {
            $scope.students = response.data;
        }, function(data) {
            console.log('error');
        });
    };

    var rawCriteria = {
        ageLow: 16,
        ageHigh: 25
    }

    $scope.filterCriteria = angular.copy(rawCriteria);

    $scope.filterStudents($scope.filterCriteria);

    $scope.clearFilter = function () {
        $scope.filterCriteria = angular.copy(rawCriteria);
        $scope.filterStudents();
    }
}]);
