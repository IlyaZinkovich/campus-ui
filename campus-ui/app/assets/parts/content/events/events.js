angular.module("campus").config(["$stateProvider", function ($stateProvider) {
  $stateProvider.state("init.events", {
      url : "/events",
      views: {
          "content@": {
              templateUrl: "assets/parts/content/events/events.html",
              controller: "EventsCtrl"
          }
      }
  });
}]);
