angular.module("campus").controller("StudentsCtrl", ["$scope", "$state", "RoomService", "ProfileService", function($scope, $state, RoomService, ProfileService) {

    $scope.isFilterExpanded = false;
    var lowAge = 16;
    var highAge = 25;
    var ageSlider = $("#ageSlider");
    ageSlider.slider({min  : lowAge, max  : highAge, value: [lowAge, highAge]});
    $scope.criteria = {
        age : [lowAge, highAge]
    };

    RoomService.getAll().then(function(response) {
        $scope.rooms = response.data;
    }, function(data) {
        console.log("error");
    });

    ProfileService.getAll("page=0&size=20").then(function(response) {
        $scope.students = response.data;
    }, function(data) {
        console.log("error");
    });

    $scope.setProfileToShow = function(profile) {
        $scope.profileToShow = profile;
    };

    $scope.toStudentsView = function() {
        $state.go("students.list");
    };

    $scope.toRoomsView = function() {
        $state.go("students.rooms");
    };

    $scope.showFilter = function() {
        $scope.isFilterExpanded = !$scope.isFilterExpanded;
    };

    $scope.filter = function() {
        var criteria = $scope.criteria;
        var query = "page=0&size=20";
        query = query.concat("&").concat("ageLow=").concat(ageSlider.slider('getValue')[0]);
        query = query.concat("&").concat("ageHigh=").concat(ageSlider.slider('getValue')[1]);
        if (criteria.gender !== "" && criteria.gender !== null) {
            query = query.concat("&").concat("gender=").concat(criteria.gender);
        }
        ProfileService.getAll(query).then(function(response) {
            $scope.students = response.data;
        }, function(data) {
            console.log("error");
        });
    };
}]);
