angular.module("campus").controller("StudentsCtrl", ["$scope", "$state", "RoomService", "ProfileService", function($scope, $state, RoomService, ProfileService) {

    $scope.isFilterExpanded = true;

    $scope.ageLow = 16;
    $scope.ageHigh = 25;

    $scope.criteria = {
        ageLow: 16,
        ageHigh: 25,
        floor: 1
    }

    RoomService.getAll("floor=1").then(function(response) {
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
        }
        $scope.filter();
        $scope.filterRooms();
    };

    $scope.filter = function() {
        var criteria = $scope.criteria;
        var query = "page=0&size=20";
        query = query.concat("&").concat("ageLow=").concat(criteria.ageLow);
        query = query.concat("&").concat("ageHigh=").concat(criteria.ageHigh);
        if (criteria.gender !== "" && criteria.gender != null) {
            query = query.concat("&").concat("gender=").concat(criteria.gender);
        }
        if (criteria.name !== "" && criteria.name != null) {
            query = query.concat("&").concat("name=").concat(criteria.name);
        }
        if (criteria.faculty !== "" && criteria.faculty != null) {
            query = query.concat("&").concat("faculty=").concat(criteria.faculty);
        }
        if (criteria.speciality !== "" && criteria.speciality != null) {
            query = query.concat("&").concat("speciality=").concat(criteria.speciality);
        }
        if (criteria.course !== "" && criteria.course != null) {
            query = query.concat("&").concat("course=").concat(criteria.course);
        }
        if (criteria.group !== "" && criteria.group != null) {
            query = query.concat("&").concat("group=").concat(criteria.group);
        }
        ProfileService.getAll(query).then(function(response) {
            $scope.students = response.data;
        }, function(data) {
            console.log("error");
        });
    };

    $scope.filterRooms = function() {
        var criteria = $scope.criteria;
        var query = "";
        if (criteria.floor !== "" && criteria.floor != null) {
            query = query.concat("&").concat("floor=").concat(criteria.floor);
        }
        RoomService.getAll(query).then(function(response) {
            $scope.rooms = response.data;
        }, function(data) {
            console.log("error");
        });
    };
}]);
