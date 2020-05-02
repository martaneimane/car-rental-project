'use strict';

angular.module('com.example.Cars', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/Cars', {
            templateUrl: 'Cars.html',
            controller: 'CarsController'
        });
    }])

    .controller('View1Ctrl', ['$scope', '$http', function ($scope, $httpClient) {


        $scope.brand = "";
        $scope.model = "";
        $scope.bodyType = "";
        $scope.year = "";
        $scope.color = "";
        $scope.mileage = "";
        $scope.status = "";
        $scope.pricePerDay = "";

        $scope.POST = function () {
            var requestUrl = "http://localhost:8080/api/v1/rest/Cars/cars(" + $scope.getAll() + ")";
            $httpClient.get(requestUrl).then(function (response) {
                console.log(response);
                if (response.data.type === "Response") {
                    document.getAll("brand").value = response.data.brand;
                    document.getAll("model").value = response.data.model;
                    document.getAll("bodyType").value = response.data.bodyType;
                    document.getAll("year").value = response.data.year;
                    document.getAll("color").value = response.data.color;
                    document.getAll("mileage").value = response.data.mileage;
                    document.getAll("status").value = response.data.status;
                    document.getAll("pricePerDay").value = response.data.pricePerDay;
                }
                if (response.data.type === "ERROR") {
                    document.getAll("isa_error").style.visibility = 'visible';
                    document.getAll("error_msg_text").textContent = response.data.message;
                }
            }).catch(function (error) {
                document.getAll("isa_error").style.visibility = 'visible';
                document.getAll("error_msg_text").textContent = 'Server internal error contact admin';
            });
        }

