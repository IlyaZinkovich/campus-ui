angular.module('campus').directive('studentsFilter', function (){

      return {
          restrict: 'E',
          scope: {
              filter: '&',
              clear: '&',
              criteria: '=',
              view: '@'
          },
          templateUrl: 'assets/parts/content/students/filter/filter.html',
          controller: function($scope, $state) {
              $scope.toListView = function() {
                  $state.go('students.list');
              };

              $scope.toRoomsView = function() {
                  $state.go('students.rooms');
              };
          }
      }

  });
