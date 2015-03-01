$(document).ready(function() {
	"use strict"

	var url = "http://private-38c95-equationsolver.apiary-mock.com/";
	$("#testClicker").click(function() {
		$.get(url, {
			"anton": "haha"
		}).then(function(response) {
			console.log(response);
		});
	});
});
