window.addEventListener('load', function() {

	const editButton = document.getElementById("edit-description-button");
	const heading = document.getElementById("survey-title");
	const content = document.getElementById("survey-description");
	const editForm = document.getElementById("description-form");
	const editSurvey = document.getElementById("edit-title");
	const navbarback = document.getElementById("navbar-back");
	
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
	
	navbarback.addEventListener("click", (event) => {
  event.preventDefault();
  const isConfirmed = confirm('Are you sure you want to leave?');
  if (isConfirmed) {
    window.location.href = '/admin';
  }
	});

});