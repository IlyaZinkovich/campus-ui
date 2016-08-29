angular.module("campus").controller("StudentsCtrl", ["$scope", "$state", "RoomService", "ProfileService", function($scope, $state, RoomService, ProfileService) {

    RoomService.getAll().then(function(response) {
        $scope.rooms = response.data;
    }, function(data) {
        console.log("error");
    });

    ProfileService.getAll().then(function(response) {
        $scope.students = response.data;
    }, function(data) {
        console.log("error");
    });

    $scope.setProfileToShow = function(profile) {
        $scope.profileToShow = profile;
    };

    $scope.toStudentsView = function() {
        $state.go("init.students");
    };

    $scope.toRoomsView = function() {
        $state.go("init.students.rooms");
    };
}]);
