window.addEventListener('load', function() {

	const editButton = document.getElementById("edit-description-button");
	const heading = document.getElementById("survey-title");
	const content = document.getElementById("survey-description");
	const editForm = document.getElementById("description-form");
<<<<<<< HEAD:src/main/resources/static/js/editDescription.js
	const editSurvey = document.getElementById("edit-title");
	
=======

>>>>>>> 2f60697d57de13bd2ae2976f9941ece45a5e5cf7:src/main/resources/static/js/survey-page-script.js
	editButton.addEventListener("click", () => {
		heading.style.display = "none";
		content.style.display = "none";
		editButton.style.display = "none";
		editForm.style.display = "block";
		editSurvey.style.display = "block";
	});

	copyresponselinkbutton.addEventListener("click", () => {
		const copyLink = document.getElementById("responselink");

		navigator.clipboard.writeText(copyLink.textContent);

		alert("Copied the link: " + copyLink.textContent);
	});
	
	src / main / resources / static / js / survey - page - script.js

});