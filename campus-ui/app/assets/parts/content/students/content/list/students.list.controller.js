angular.module("campus").controller("StudentsListCtrl", ["$scope", "$state", "STUDENTS_PER_PAGE", "ProfileService", "UtilService",
  function ($scope, $state, STUDENTS_PER_PAGE, ProfileService, UtilService) {

  $scope.page = 0;

  $scope.getAllProfiles = function (page, number) {
    ProfileService.getAll(page, number).then(function(response) {
        $scope.students = response.data;
    }, function(data) {
        console.log("error");
    });
  };

  $scope.showUserModal = function (userId, size) {
    ProfileService.get(userId).then(function(data) {
      UtilService.showUserModal(data.data, "lg");
    }, function(error) {
      console.log("error");
    });
  };

  $scope.getAllProfiles($scope.page, STUDENTS_PER_PAGE);

}]);
