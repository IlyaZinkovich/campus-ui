angular.module('campus').controller('StudentsRoomsCtrl', ['$scope', 'ROOMS_PER_PAGE', '$uibModal', 'RoomService', 'ProfileService', 'UtilService',
    function($scope, ROOMS_PER_PAGE, $uibModal, RoomService, ProfileService, UtilService) {

    $scope.view = 'rooms';

    $scope.showUserModal = function (userId, size) {
        ProfileService.get(userId).then(function(data) {
            UtilService.showUserModal(data.data, 'lg');
        }, function(error) {
            console.log('error');
        });
    };

    var rawCriteria = {
        floor: 1,
        ageLow: 16,
        ageHigh: 25
    };

    $scope.filterCriteria = angular.copy(rawCriteria);

    $scope.filterStudents = function () {
        RoomService.getAll($scope.filterCriteria).then(function(response) {
            $scope.rooms = response.data;
        }, function(data) {
            console.log('error');
        });
    };

    $scope.filterStudents($scope.filterCriteria);

    $scope.clearFilter = function () {
        $scope.filterCriteria = angular.copy(rawCriteria);
        $scope.filterStudents();
    }
}]);
