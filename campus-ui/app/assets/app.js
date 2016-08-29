angular.module("campus", ["ui.router", "ui.bootstrap", "LocalStorageModule"])
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
                },
                "footer": {
                    templateUrl: "assets/parts/footer/footer.html"
                },
                "menu": {
                    templateUrl: "assets/parts/menu/menu.html",
                    controller: "MenuCtrl"
                }
            }
        })
        .state("default", {
            parent: "init",
            url: "/",
            views: {
                "content@": {
                    templateUrl: "assets/parts/content/events/events.html",
                    controller: "EventsCtrl"
                }
            }
        });
        $urlRouterProvider.otherwise("/");
        $locationProvider.html5Mode(true);
    }]).run(["$rootScope", function($rootScope) {

    }]);
