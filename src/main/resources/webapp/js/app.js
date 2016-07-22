(function () {
    'use strict';

    /* App Module */

    angular.module('mHealthDataInterface', ['motech-dashboard', 'mHealthDataInterface.controllers', 'mHealthDataInterface.directives', 'mHealthDataInterface.services', 'ngCookies'])
        .config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.
                when('/mHealthDataInterface/settings', {templateUrl: '../mHealthDataInterface/resources/partials/settings.html', controller: 'mHSettingsCtrl'});
    }]);
}());
