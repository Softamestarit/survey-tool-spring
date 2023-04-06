package fi.haagahelia.surveytool.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.surveytool.domain.Question;
import fi.haagahelia.surveytool.domain.QuestionRepository;
import fi.haagahelia.surveytool.domain.Survey;
import fi.haagahelia.surveytool.domain.SurveyRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

//@CrossOrigin (origins="http:/localhost:8080")
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
	
	/*
	 * Yritys tehdä jotain hienoa
	 * 
	 * @Transactional
	@PostMapping("/submit-survey")
		public String submitSurvey(HttpServletRequest request, Model model){
			String name = request.getParameter("name");
			String[] questions = request.getParameterValues("questions");
			Survey survey = new Survey();
			survey.setName(name);
			List <Question> questionList = new ArrayList<>();
			for(String question : questions) {
				Question newQuestion = new Question();
				newQuestion.setSurvey(survey);
				newQuestion.setContent(question);
				questionList.add(newQuestion);
			}
			System.out.println(questions);
			
			survey.setQuestions(questionList);
			System.out.println(survey.toString());
			surveyRepository.save(survey);
			return "redirect:../surveys";
		}
		
	*/ 
	
	// REST api-call that gets all questions based in surveyId and returns them as JSON
	@GetMapping("/surveys/{id}")
	public @ResponseBody Optional<Survey> findSurvey(@PathVariable("id") Long surveyId){
		return surveyRepository.findById(surveyId);
	}
}
