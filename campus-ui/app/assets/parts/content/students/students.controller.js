angular.module("campus").controller("StudentsCtrl", ["$scope", "RoomService", function ($scope, RoomService) {

    RoomService.getAll().then(function(response) {
        $scope.rooms = response.data;
        console.log($scope.rooms);
    }, function(data) {
        console.log("error");
    });

    $scope.setProfileToShow = function(profile) {
        $scope.profileToShow = profile;
        console.log(profile);
    };
}]);
