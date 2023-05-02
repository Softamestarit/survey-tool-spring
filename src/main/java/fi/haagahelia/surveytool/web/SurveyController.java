package fi.haagahelia.surveytool.web;

import fi.haagahelia.surveytool.domain.Survey;
import fi.haagahelia.surveytool.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//@CrossOrigin (origins="http:/localhost:8080")
@Controller
public class SurveyController {

	@Autowired
	private SurveyRepository surveyRepository;

	@GetMapping("/resthome")
	public String resthomepage(){
		return "resthome";
	}
	
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
	

	// REST api-call that gets all questions based in surveyId and returns them as JSON
	@GetMapping("/surveys/{id}")
	public @ResponseBody Optional<Survey> findSurvey(@PathVariable("id") Long surveyId) {
		return surveyRepository.findById(surveyId);
	}
	
	@GetMapping("/admin")
	public String showAdminPage(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "admin-page";
	}
	
	@PostMapping("/save-survey")
	public String saveSurvey(Survey survey) {
		surveyRepository.save(survey);
		return "redirect:admin/survey/"+ survey.getSurveyId();
	}
	
	@PostMapping("/save-description")
	public String saveSurveyDescription(Survey survey) {
		surveyRepository.save(survey);
		return "redirect:admin/survey/"+ survey.getSurveyId();
	}
	
	@GetMapping("/add-new-survey")
	public String addNewSurvey(Model model) {
		model.addAttribute("newSurvey", new Survey());
		return "new-survey";
	}
	
}
