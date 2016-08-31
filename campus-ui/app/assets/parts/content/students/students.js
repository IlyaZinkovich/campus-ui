angular.module("campus").config(["$stateProvider", function($stateProvider) {
        $stateProvider.state("students", {
            url : "/students",
            parent : "init",
            abstract : true
        }).state("students.rooms", {
            url: "/rooms",
            views: {
                "content@": {
                    templateUrl: "assets/parts/content/students/students-by-rooms.html",
                    controller: "StudentsCtrl"
                }
            },
            authenticate: true
        }).state("students.list", {
            url: "/list",
            views: {
                "content@": {
                    templateUrl: "assets/parts/content/students/students.html",
                    controller: "StudentsCtrl"
                }
            },
            authenticate: true
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
