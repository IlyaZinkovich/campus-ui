angular.module("campus").controller("StudentsCtrl", ["$scope", "RoomService", function ($scope, RoomService) {

    $scope.rooms = RoomService.getAll();


}]);
