angular.module("campus").config(["$stateProvider", function($stateProvider) {

  $stateProvider.state("init.signin", {
    url: "/signin",
    views: {
        "content@": {
            templateUrl: "assets/parts/signin/signin.html",
            controller: "SignInCtrl"
        }
    }
  });

}]);
