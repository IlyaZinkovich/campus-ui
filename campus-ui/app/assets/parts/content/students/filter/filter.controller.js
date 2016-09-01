angular.module("campus").controller("FilterCtrl", ["$scope", "$state", "ProfileService", "RoomService",
  function($scope, $state, ProfileService, RoomService) {

    $scope.view = "rooms";
    $scope.ageLow = 16;
    $scope.ageHigh = 25;
    $scope.page = 0;
    $scope.criteria = {
        ageLow: 16,
        ageHigh: 25,
        floor: 1
    };

    $scope.clearFiter = function() {
        $scope.criteria = {
            name: "",
            ageLow: 16,
            ageHigh: 25,
            gender: "",
            faculty: "",
            speciality: "",
            course: "",
            group: "",
            floor: 1
        };
        $scope.filterStudents();
        $scope.filterRooms();
    };

    $scope.filterStudents = function(page, size) {
        ProfileService.getAll($scope.criteria, page, size).then(function(response) {
            $scope.students = response.data;
        }, function(data) {
            console.log("error");
        });
    };

    $scope.filterRooms = function(page, size) {
        RoomService.getAll($scope.criteria, page, size).then(function(response) {
            $scope.rooms = response.data;
        }, function(data) {
            console.log("error");
        });
    };

    $scope.toListView = function () {
      $scope.view = "list";
      $state.go("students.list");
    };

    $scope.toRoomsView = function () {
      $scope.view = "rooms";
      $state.go("students.rooms");
    };

}]);
