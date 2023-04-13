package fi.haagahelia.surveytool.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.surveytool.domain.Question;
import fi.haagahelia.surveytool.domain.QuestionRepository;
import fi.haagahelia.surveytool.domain.Survey;
import fi.haagahelia.surveytool.domain.SurveyRepository;

@Controller
public class QuestionController {

	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	//REST method, add new question
	@PostMapping("/questions")
	public @ResponseBody Question addQuestionRest(@RequestBody Question question) {
		return questionRepository.save(question);
	}
	
	// REST api-call which gets all questions and returns them as JSON
	@GetMapping("/questions")
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) questionRepository.findAll();
	}
	
	// REST api-call that gets all questions based in surveyId and returns them as JSON
	@GetMapping("/questions/{id}")
	public @ResponseBody Optional<Question> findQuestion(@PathVariable("id") Long questionId){
		return questionRepository.findById(questionId);
	}
	
	@GetMapping("/admin/survey/{id}")
	public String getQuestionsOfSurvey(@PathVariable("id") Long surveyId, Model model) {
		Optional<Survey> surveyOptional = surveyRepository.findById(surveyId);
		//TODO: handle survey not found
		model.addAttribute("survey", surveyOptional.get());
		model.addAttribute("questions", surveyOptional.get().getQuestions());
		model.addAttribute("newQuestion", new Question());
		return "survey-page";
	}
}
