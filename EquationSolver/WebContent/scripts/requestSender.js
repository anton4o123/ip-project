var home_url = "http://localhost:8080/EquationSolver/api/";

function append_article(article) {
	var div_row = $("<div/>").attr("class", "row");
	var div_col = $("<div/>").attr("class", "col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3");
	var title = $("<h3/>").attr("class", "text-center").text(article.title);
	var body = $("<p/>").attr("class", "text-center").text(article.body);
	var element = div_row.append(div_col.append(title).append(body));
	$("body > .container").append(element);
}

function post_article() {
	var article = {
		title: $("#title").val(),
		body: $("#body").val(),
		category: $("#category").val(),
		dateOfCreation: new Date().getTime()
	};
	
	$.ajax({
		url: home_url + "article",
		method: "POST",
		data: JSON.stringify(article),
		contentType: "application/json; charset=utf-8"
	}).then(function(result) {
		append_article(result);
	});
}

function get_articles() {
	$.get(home_url + "article").then(function(result) {
		result.forEach(function(entry) {
			append_article(entry);
		});
	});
}

function append_equation(equation) {
	var div_row = $("<div/>").attr("class", "row");
	var div_col = $("<div/>").attr("class", "col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3");
	var problem = $("<p/>").attr("class", "text-center").text("problem: " + equation.problem);
	var solution = $("<p/>").attr("class", "text-center").text("solution: " + equation.solution);
	var element = div_row.append(div_col.append(problem).append(solution));
	$("body > .container").append(element);
}

function post_equation() {
	var equation = {
		problem: $("#equation").val(),
		dateOfCreation: new Date().getTime(),
		category: 2,
		solution: ""
	};
	
	$.ajax({
		url: home_url + "equation",
		method: "POST",
		data: JSON.stringify(equation),
		contentType: "application/json; charset=utf-8"
	}).then(function(result) {
		append_equation(result);
	});
}

function get_equations() {
	$.get(home_url + "equation").then(function(result) {
		result.forEach(function(entry) {
			append_equation(entry);
		});
	});
}

function append_function(func) {
	var div_row = $("<div/>").attr("class", "row");
	var div_col = $("<div/>").attr("class", "col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3");
	var problem = $("<p/>").attr("class", "text-center").text("problem: " + func.problem);
	var graphics = $("<p/>").attr("class", "text-center").text("graphics: " + func.graphics);
	var element = div_row.append(div_col.append(problem).append(func.graphics));
	$("body > .container").append(element);
}

function post_function() {
	var func = {
		problem: $("#function").val(),
		dateOfCreation: new Date().getTime(),
		category: 2,
		graphics: ""
	};
	
	$.ajax({
		url: home_url + "function",
		method: "POST",
		data: JSON.stringify(func),
		contentType: "application/json; charset=utf-8"
	}).then(function(result) {
		append_function(result);
	});
}

function get_functions() {
	$.get(home_url + "function").then(function(result) {
		result.forEach(function(entry) {
			append_function(entry);
		});
	});
}