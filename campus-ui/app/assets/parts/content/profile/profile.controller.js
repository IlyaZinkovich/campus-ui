angular.module("campus").controller("ProfileCtrl", ["$scope", "localStorageService", "ProfileService", function($scope, localStorageService, ProfileService) {

    $scope.userProfileId = localStorageService.cookie.get("userProfileId");

    $scope.updateUser = function () {
        localStorageService.cookie.set("user", $scope.user);
        $scope.success = "User updated successfully";
    };

    ProfileService.get($scope.userProfileId).then(function(response) {
        console.log($scope.userProfileId);
        $scope.userProfile = response.data;
        console.log($scope.userProfile);
    }, function(response) {
        console.log(response);
    })

}]);
