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

    var previousFloor;

    $scope.filterCriteria = angular.copy(rawCriteria);

    $scope.filterStudents = function () {
        if ($scope.filterCriteria.floor != previousFloor) {
            RoomService.getAll($scope.filterCriteria).then(function(response) {
                $scope.rooms = response.data;
                previousFloor = $scope.filterCriteria.floor;
            }, function(data) {
                console.log('error');
            });
        }
        if ($scope.rooms != null) {
            var criteria = $scope.filterCriteria;
            $scope.rooms.forEach(function (room) {
                room.profiles.forEach(function (profile) {
                    hideProfile(profile, criteria);
                }
            )});
        }
    };

    function criteriaExists(criteria) {
        return (criteria != null && criteria !== '') ? true : false;
    }

    function calculateAge(birthday) {
        birthday = new Date(birthday);
        var ageDifMs = Date.now() - birthday.getTime();
        var ageDate = new Date(ageDifMs);
        return Math.abs(ageDate.getUTCFullYear() - 1970);
    }

    function hideProfile(profile, criteria) {
        if ((criteriaExists(criteria.ageLow) && criteria.ageLow > calculateAge(profile.birthDate))) {
            profile.hide = true;
        } else if ((criteriaExists(criteria.ageHigh) && criteria.ageHigh < calculateAge(profile.birthDate))) {
            profile.hide = true;
        } else if (criteriaExists(criteria.name) &&
            !((profile.firstName + ' ' + profile.lastName).toUpperCase().includes(criteria.name.toUpperCase()) ||
            (profile.lastName + ' ' + profile.firstName).toUpperCase().includes(criteria.name.toUpperCase()))) {
            profile.hide = true;
        } else if (criteriaExists(criteria.gender) && criteria.gender !== profile.gender) {
            profile.hide = true;
        } else if (criteriaExists(criteria.faculty) && criteria.faculty !== profile.faculty) {
            profile.hide = true;
        } else if (criteriaExists(criteria.speciality) && criteria.speciality !== profile.speciality) {
            profile.hide = true;
        } else if (criteriaExists(criteria.course) && criteria.course !== profile.course.toString()) {
            profile.hide = true;
        } else if (criteriaExists(criteria.group) && criteria.group !== profile.group.toString()) {
            profile.hide = true;
        } else {
            profile.hide = false;
        }
    }

    $scope.filterStudents($scope.filterCriteria);

    $scope.clearFilter = function () {
        $scope.filterCriteria = angular.copy(rawCriteria);
        $scope.filterStudents();
    }
}]);
