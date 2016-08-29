angular.module("campus").config(["$stateProvider", function($stateProvider) {
        $stateProvider.state("init.students", {
            url: "/students",
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
    });;
