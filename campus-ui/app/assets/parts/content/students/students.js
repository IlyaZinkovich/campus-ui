angular.module('campus').config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('students', {
            url : '/students',
            parent : 'init',
            abstract : true,
            views : {
              'content' : {
                templateUrl: 'assets/parts/content/students/content/students.html'
              }
            }
        }).state('students.rooms', {
            url: '/rooms',
            views: {
                'students': {
                    templateUrl: 'assets/parts/content/students/content/rooms/students.rooms.html',
                    controller: 'StudentsRoomsCtrl'
                }
            }
        }).state('students.list', {
            url: '/list',
            views: {
                'students': {
                    templateUrl: 'assets/parts/content/students/content/list/students.list.html',
                    controller: 'StudentsListCtrl'
                }
            }
        });
    }])
    .filter('ageFilter', function() {
        function calculateAge(birthday) {
            var ageDifMs = Date.now() - birthday.getTime();
            var ageDate = new Date(ageDifMs);
            return Math.abs(ageDate.getUTCFullYear() - 1970);
        }

        return function(birthdate) {
            return calculateAge(new Date(birthdate));
        };
    });
