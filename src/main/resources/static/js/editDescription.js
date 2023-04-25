window.addEventListener('load', function (){
	
	const editButton = document.getElementById("edit-description-button");
	const heading = document.getElementById("survey-title");
	const content = document.getElementById("survey-description");
	const editForm = document.getElementById("description-form");
	
	editButton.addEventListener("click", () => {
		heading.style.display = "none";
		content.style.display = "none";
		editButton.style.display = "none";
		editForm.style.display = "block";
	});
	
});