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
	
	@GetMapping("/add-survey")
	public String addNewSurvey(Model model){
		//TODO: tämä uudestaan uuden 11.4 suunnitelman mukaan
		model.addAttribute("survey", new Survey());
		model.addAttribute("questions", questionRepository.findAll());
		return "add-survey";
	}
	
	@PostMapping("/save-survey")
	public String saveSurvey(Survey survey) {
		//TODO: tämä uudestaan uuden 11.4 suunnitelman mukaan
		surveyRepository.save(survey);
		return "redirect:../surveys";
	}
	
	@GetMapping("/admin-page")
	public String showAdminPage(Model model) {
		model.addAttribute("surveys", surveyRepository.findAll());
		return "admin-page";
	}
	

	// REST api-call that gets all questions based in surveyId and returns them as JSON
	@GetMapping("/surveys/{id}")
	public @ResponseBody Optional<Survey> findSurvey(@PathVariable("id") Long surveyId){
		return surveyRepository.findById(surveyId);
	}
}
