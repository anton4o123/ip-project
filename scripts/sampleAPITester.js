$(document).ready(function() {
	"use strict"
	var url = "http://private-38c95-equationsolver.apiary-mock.com/";

	$("#submitEquation").click(function() {
		$.post(url + "equations", {
			"user": $("userEquation").val(),
			"equation": $("#equation").val()
		}).then(function(response) {
			console.log(response);
		});
	});

	$("#submitFunction").click(function() {
		$.post(url + "functions", {
			"user": $("userFunction").val(),
			"function": $("#function").val()
		}).then(function(response) {
			console.log(response);
		});
	});
});
