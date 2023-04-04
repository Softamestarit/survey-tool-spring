package fi.haagahelia.surveytool.web;

import java.util.ArrayList;
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
public class SurveyController {
	
	@Autowired
	private SurveyRepository surveyRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	//REST method, add new survey
		@PostMapping("/surveys")
		public @ResponseBody Survey addSurveyRest(@RequestBody Survey survey) {
			return surveyRepository.save(survey);
		}
	
	// REST api-call which gets all surveys and returns them as JSON
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) surveyRepository.findAll();
	}
	
	@GetMapping("/add-survey")
	public String addNewSurvey(Model model){
		model.addAttribute("survey", new Survey());
		return "add-survey";
	}
	
	@PostMapping("/save-survey")
	public String saveSurvey(Survey survey) {
		surveyRepository.save(survey);
		return "redirect:../surveys";
	}
	
	// REST api-call which gets all questions and returns them as JSON
	@GetMapping("/questions")
	public @ResponseBody List<Question> questionListRest() {
		return (List<Question>) questionRepository.findAll();
	}
	
	// REST api-call that gets all questions based in surveyId and returns them as JSON
	@GetMapping("/surveys/{id}")
	public @ResponseBody Optional<Survey> findSurvey(@PathVariable("id") Long surveyId){
		return surveyRepository.findById(surveyId);
	}
}
