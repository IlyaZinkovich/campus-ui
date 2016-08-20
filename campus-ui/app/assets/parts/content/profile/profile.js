angular.module("campus").config(["$stateProvider", function($stateProvider) {

  $stateProvider.state("init.profile", {
    url: "/profile",
    views: {
        "content@": {
            templateUrl: "assets/parts/content/profile/profile.html",
            controller: "ProfileCtrl"
        }
    }
  });

}]);
