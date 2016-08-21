angular.module("campus").config(["$stateProvider", function($stateProvider) {

  $stateProvider.state("init.profile", {
    url: "/profile/{id}",
    views: {
        "content@": {
            templateUrl: "assets/parts/content/profile/profile.html",
            controller: "ProfileCtrl"
        }
    }
  });

}]);
