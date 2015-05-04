function append_item(table_body, item, equation) {
	var row = $("<tr/>");
	row.append($("<td/>").text(item.id));
	row.append($("<td/>").text(item.user));
	row.append($("<td/>").text(item.dateOfCreation));
	if(equation) {
		row.append($("<td/>").text(item.problem));
		row.append($("<td/>").text(item.solution));
	} else {
		row.append($("<td/>").text(item.problem));
		row.append($("<td/>").text(item.graphics));
	}
	table_body.append(row);
}

function getCoefficients(problem) {
	return problem;
}

$(document).ready(function() {
	"use strict"
	var url = "http://localhost:8080/EquationSolver/api/";

	$.get(url + "equation").then(function(response) {
		$.each(response, function() {
			append_item($("#equation-table tbody"), this, true);
		});
	});

	$.get(url + "function").then(function(response) {
		$.each(response, function() {
			append_item($("#function-table tbody"), this, false);
		});
	});

	$("#submitEquation").click(function() {
		$.ajax({url: "equation",
			method: "post",
			contentType: "application/json",
			data: {
			//	"user": $("userEquation").val(),
				equation: getCoefficients($("#equation").val()),
				category: 2,
				dateOfCreation: "1",
				solution: ""
			}
		}).then(function(response) {
			console.log(response);
		});
	});

	$("#submitFunction").click(function() {
		$.ajax({url: "function",
			method: "post",
			contentType: "application/json",
			data: {
			//	"user": $("userFunction").val(),
				"function": getCoefficients($("#function").val())
			}
		}).then(function(response) {
			console.log(response);
		});
	});
});
