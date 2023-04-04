let index = 2
console.log('hi dad');

function addQuestion() {
    console.log('hi mom');
    const newQuestion = document.createElement("div");

    const newLabel = document.createElement("label");
    newLabel.setAttribute("for", "question" + index)
    newLabel.textContent = "Question " + index + ":";


    const newInput = document.createElement("input");
    newInput.setAttribute("type", "text");
    newInput.setAttribute("id", "question" + index);
    newInput.setAttribute("name", "questions");

    newQuestion.appendChild(newLabel);
    newQuestion.appendChild(newInput);

    const questionWrapper = document.getElementById("question-wrapper");
    questionWrapper.append(newQuestion);

    index++;

}
