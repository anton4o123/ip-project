function append_item(table_body, item, equation) {
	var row = $("<tr/>");
	row.append($("<td/>").text(item.id));
	row.append($("<td/>").text(item.user));
	row.append($("<td/>").text(item.created_at));
	if(equation) {
		row.append($("<td/>").text(item.equation));
		row.append($("<td/>").text(item.solution));
	} else {
		row.append($("<td/>").text(item.function));
		row.append($("<td/>").text(item.graphics));
	}
	table_body.append(row);
}

$(document).ready(function() {
	"use strict"
	var url = "http://private-38c95-equationsolver.apiary-mock.com/";

	$.get(url + "equations").then(function(response) {
		$.each(response, function() {
			append_item($("#equation-table tbody"), this, true);
		});
	});

	$.get(url + "functions").then(function(response) {
		$.each(response, function() {
			append_item($("#function-table tbody"), this, false);
		});
	});

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
