package fi.haagahelia.surveytool.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.surveytool.domain.QuestionRepository;
import fi.haagahelia.surveytool.domain.Survey;
import fi.haagahelia.surveytool.domain.SurveyRepository;

//@CrossOrigin (origins="http:/localhost:8080")
@Controller
public class SurveyController {

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private QuestionRepository questionRepository;
<<<<<<< HEAD

	// REST method, add new survey
	@PostMapping("/surveys")
	public @ResponseBody Survey addSurveyRest(@RequestBody Survey survey) {
		return surveyRepository.save(survey);
	}

	// REST api-call which gets all surveys and returns them as JSON
	@GetMapping("/surveys")
	public @ResponseBody List<Survey> surveyListRest() {
		return (List<Survey>) surveyRepository.findAll();
	}

=======
	
	@GetMapping("/add-survey")
	public String addNewSurvey(Model model){
		//TODO: tämä uudestaan uuden 11.4 suunnitelman mukaan
		model.addAttribute("survey", new Survey());
		model.addAttribute("questions", questionRepository.findAll());
		return "add-survey";
	}
	
>>>>>>> e56e4aaabb51c48ffe364c97266de6419e0d85ec
	@PostMapping("/save-survey")
	public String saveSurvey(Survey survey) {
		// TODO: tämä uudestaan uuden 11.4 suunnitelman mukaan
		surveyRepository.save(survey);
		return "redirect:../surveys";
	}
<<<<<<< HEAD

	// REST api-call that gets all questions based in surveyId and returns them as
	// JSON
=======
	
	@GetMapping("/admin-page")
	public String showAdminPage(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "admin-page";
	}
	

	// REST api-call that gets all questions based in surveyId and returns them as JSON
>>>>>>> e56e4aaabb51c48ffe364c97266de6419e0d85ec
	@GetMapping("/surveys/{id}")
	public @ResponseBody Optional<Survey> findSurvey(@PathVariable("id") Long surveyId) {
		return surveyRepository.findById(surveyId);
	}
}
