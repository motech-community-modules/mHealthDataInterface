(function() {
    'use strict';

    /* Controllers */
    var controllers = angular.module('mHealthDataInterface.controllers', []);

    controllers.controller('mHSettingsCtrl', function($scope, $http) {
             $scope.hideMessages = function() {
                $scope.saveSuccess = false;
                $scope.saveError = false;
                $scope.testSuccess = false;
                $scope.testError = false;
                $scope.retrievalError = false;
             };
             $scope.getBoolean = function(value) {
                 if (value === 'true')
                    return true;
                 else
                    return false;
             };
             $scope.hideMessages();
            $http.get('../mHealthDataInterface/applicationSettings')
                .success(function (response) {
                    //alert(response);
                    $scope.applicationSettings = response;

                   $scope.originalSettings = angular.copy($scope.applicationSettings);
                })
                .error(function (response) {
                    //alert(response);
                    $scope.retrievalError = true;
                });

             $scope.saveSettings = function (settings) {
                 $scope.hideMessages();
                 blockUI();
                 $http.post('../mHealthDataInterface/applicationSettings/save', settings).
                     success(
                        function (response) {
                            //alert($scope.msg(response.message));
                            $scope.saveSuccess = true;
                            unblockUI();
                        }
                     ).
                     error(function (response) {
                        //alert($scope.msg("mHealthDataInterface.applicationSetting.save.error.message"));
                        $scope.saveError = true;
                        unblockUI();
                     });
             };
             $scope.testSettings = function (settings) {
                $scope.hideMessages();
                blockUI();
                $http.post('../mHealthDataInterface/applicationSettings/test', settings).
                  success(
                     function (response) {

                         $scope.testSuccess = $scope.getBoolean(response.success);
                         $scope.testError = !$scope.getBoolean(response.success);
                         unblockUI();
                     }
                  ).
                  error(function (response) {

                     $scope.testError = true;
                     unblockUI();
                  });
             };
    });
}());
