angular.module("campus").config(["$stateProvider", function ($stateProvider) {
  $stateProvider.state("init.students", {
      url : "/students",
      views: {
          "content@": {
              templateUrl: "assets/parts/content/students/students.html",
              controller: "StudentsCtrl"
          }
      }
  });
}]);
