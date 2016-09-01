angular.module("campus").controller("StudentsRoomsCtrl", ["$scope", "ROOMS_PER_PAGE", "$uibModal", "RoomService", "ProfileService", "UtilService",
  function($scope, ROOMS_PER_PAGE, $uibModal, RoomService, ProfileService, UtilService) {

    $scope.floor = 1;

    $scope.getAll = function (floor) {
      RoomService.getAll(floor).then(function(response) {
          $scope.rooms = response.data;
      }, function(data) {
          console.log("error");
      });
    };

    $scope.showUserModal = function (userId, size) {
      ProfileService.get(userId).then(function(data) {
        UtilService.showUserModal(data.data, "lg");
      }, function(error) {
        console.log("error");
      });
    };

    $scope.getAll($scope.floor);

}]);
