(function() {

	var rows = document.getElementById("resultset").getElementsByTagName("tr");
	for (var i = 0; i < rows.length; i++) {
		if (i % 2 == 1) {
			// rows[i].class+=" odd";
			rows[i].setAttribute("class", "odd")
		}
	}
})();
