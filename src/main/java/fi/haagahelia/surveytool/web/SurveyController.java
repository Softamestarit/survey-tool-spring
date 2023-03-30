package fi.haagahelia.survey.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	// REST api-call which gets all surveys and returns them as JSON
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) surveyRepository.findAll();
	}
	
	// REST api-call which gets all questions and returns them as JSON
	@GetMapping("/questions")
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) questionRepository.findAll();
	}
	
	// REST api-call that gets all questions based in surveyId and returns them as JSON
	@GetMapping("/questions/{id}")
	public @ResponseBody List<Question> findQuestions(@PathVariable("id") Long surveyId){
		return (List<Question>) questionRepository.findById(surveyId);
	}
		
	
}
