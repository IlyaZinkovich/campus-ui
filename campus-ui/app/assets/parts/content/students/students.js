angular.module("campus").config(["$stateProvider", function($stateProvider) {
        $stateProvider.state("students", {
            url : "/students",
            parent : "init",
            views : {
              "content@" : {
                templateUrl: "assets/parts/content/students/content/students.html"
              },
              "filter@students" : {
                templateUrl: "assets/parts/content/students/filter/filter.html",
                controller: "FilterCtrl"
              }
            },
            abstract : true
        }).state("students.rooms", {
            url: "/rooms",
            views: {
                "students": {
                    templateUrl: "assets/parts/content/students/content/rooms/students.rooms.html",
                    controller: "StudentsRoomsCtrl"
                },
                "filter-params" : {
                  templateUrl: "assets/parts/content/students/filter/rooms-filter/rooms-filter.html",
                  controller: "FilterCtrl"
                }
            },
            authenticate: true
        }).state("students.list", {
            url: "/list",
            views: {
                "students": {
                    templateUrl: "assets/parts/content/students/content/list/students.list.html",
                    controller: "StudentsListCtrl"
                },
                "filter-params" : {
                  templateUrl: "assets/parts/content/students/filter/students-filter/students-filter.html",
                  controller: "FilterCtrl"
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
