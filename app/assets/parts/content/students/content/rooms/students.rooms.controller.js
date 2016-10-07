angular.module('campus').controller('StudentsRoomsCtrl', ['$scope', 'ROOMS_PER_PAGE', '$uibModal', 'RoomService', 'StudentService', 'UtilService',
    function($scope, ROOMS_PER_PAGE, $uibModal, RoomService, StudentService, UtilService) {

        $scope.view = 'rooms';

        $scope.showUserModal = function(userId, size) {
            StudentService.get(userId).then(function(data) {
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

        $scope.filterStudents = function() {
            if ($scope.filterCriteria.floor != previousFloor) {
                RoomService.getAll($scope.filterCriteria).then(function(response) {
                    $scope.rooms = response.data;
                    previousFloor = $scope.filterCriteria.floor;
                    filterStudentsManually();
                }, function(data) {
                    console.log('error');
                });
            }
            if ($scope.rooms != null) {
                filterStudentsManually();
            }
        };

        function filterStudentsManually() {
            var criteria = $scope.filterCriteria;
            $scope.rooms.forEach(function(room) {
                room.students.forEach(function(student) {
                    hideStudent(student, criteria);
                })
            });
        }

        function criteriaExists(criteria) {
            return (criteria != null && criteria !== '') ? true : false;
        }

        function calculateAge(birthday) {
            birthday = new Date(birthday);
            var ageDifMs = Date.now() - birthday.getTime();
            var ageDate = new Date(ageDifMs);
            return Math.abs(ageDate.getUTCFullYear() - 1970);
        }

        function hideStudent(student, criteria) {
            if ((criteriaExists(criteria.ageLow) && criteria.ageLow > calculateAge(student.birthDate)) ||
                (criteriaExists(criteria.ageHigh) && criteria.ageHigh < calculateAge(student.birthDate)) ||
                (criteriaExists(criteria.name) &&
                    !((student.firstName + ' ' + student.lastName).toUpperCase().includes(criteria.name.toUpperCase()) ||
                        (student.lastName + ' ' + student.firstName).toUpperCase().includes(criteria.name.toUpperCase()))) ||
                (criteriaExists(criteria.gender) && criteria.gender !== student.gender) ||
                (criteriaExists(criteria.faculty) && criteria.faculty !== student.faculty) ||
                (criteriaExists(criteria.speciality) && criteria.speciality !== student.speciality) ||
                (criteriaExists(criteria.course) && criteria.course !== student.course.toString()) ||
                (criteriaExists(criteria.group) && criteria.group !== student.group.toString())) {
                student.hide = true;
            } else {
                student.hide = false;
            }
        }

        $scope.filterStudents($scope.filterCriteria);

        $scope.clearFilter = function() {
            $scope.filterCriteria = angular.copy(rawCriteria);
            $scope.filterStudents();
        }
    }
]);
