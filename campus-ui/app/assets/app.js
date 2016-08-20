angular.module("campus", ["ui.router", "ui.bootstrap"])
    .constant({
      SERVER_HOST : "http://localhost:8088"
    })
    .config(["$stateProvider", "$urlRouterProvider", "$locationProvider", function($stateProvider, $urlRouterProvider, $locationProvider) {

        $stateProvider.state("init", {
            abstract: true,
            views: {
                "header": {
                    templateUrl: "assets/parts/header/header.html",
                    controller: "HeaderCtrl"
                }
            }
        }).state("default", {
            parent: "init",
            url: "/",
            views: {
                "content@": {
                    templateUrl: "assets/parts/content/campus/campus.html",
                    controller: "CampusCtrl"
                }
            }
        });
        $urlRouterProvider.otherwise("/");
        $locationProvider.html5Mode(true);
    }]);
