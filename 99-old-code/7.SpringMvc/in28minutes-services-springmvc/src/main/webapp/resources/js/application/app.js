'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', [ 'AngularSpringApp.filters',
		'AngularSpringApp.service', 'AngularSpringApp.directives', 'ngRoute']);

// Declare app level module which depends on filters, and service
App.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/todo', {
		templateUrl : 'todo/layout',
		controller : TodoController
	});

	$routeProvider.when('/address', {
		templateUrl : 'address/layout',
		controller : AddressBookController
	});

	$routeProvider.otherwise({
		redirectTo : '/todo'
	});
} ]);
