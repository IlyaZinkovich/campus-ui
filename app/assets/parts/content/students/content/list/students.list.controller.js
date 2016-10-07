angular.module('campus').controller('StudentsListCtrl', ['$scope', '$state', 'STUDENTS_PER_PAGE', 'StudentService', 'UtilService',
    function ($scope, $state, STUDENTS_PER_PAGE, StudentService, UtilService) {

    $scope.page = 0;

    $scope.view = 'list';

    $scope.students = [];

    $scope.loading = false;

    $scope.showUserModal = function (userId, size) {
        StudentService.get(userId).then(function(data) {
            UtilService.showUserModal(data.data, 'lg');
        }, function(error) {
            console.log('error');
        });
    };

    $scope.filterStudents = function () {
        StudentService.getAll($scope.filterCriteria, 0, STUDENTS_PER_PAGE).then(function(response) {
            $scope.students = response.data;
        }, function(data) {
            console.log('error');
        });
        $scope.page = 0;
    };

    var rawCriteria = {
        ageLow: 16,
        ageHigh: 25
    }

    $scope.filterCriteria = angular.copy(rawCriteria);

    $scope.filterStudents();

    $scope.clearFilter = function () {
        $scope.filterCriteria = angular.copy(rawCriteria);
        $scope.filterStudents();
        $scope.page = 0;
    }

    $scope.nextPage = function() {
        if ($scope.loading) return;
        if ($scope.page !== 0) {
            $scope.loading = true;
            StudentService.getAll($scope.filterCriteria, $scope.page, STUDENTS_PER_PAGE).then(function(response) {
                $scope.lastChunk = response.data;
                $scope.students.push.apply($scope.students, $scope.lastChunk);
                $scope.loading = false;
            }, function(data) {
                console.log('error');
            });
        }
        $scope.page++;
    }
}]);
