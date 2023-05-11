package fi.haagahelia.surveytool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.surveytool.domain.Option;
import fi.haagahelia.surveytool.domain.OptionRepository;
import fi.haagahelia.surveytool.domain.QuestionRepository;
import fi.haagahelia.surveytool.domain.SurveyRepository;

@Controller
public class OptionController {

	@Autowired
	private OptionRepository optionRepository;

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private SurveyRepository surveyRepository;

	// REST api-call which gets all options and returns them as JSON
	@GetMapping("/options")
	public @ResponseBody List<Option> optionListRest() {
		return (List<Option>) optionRepository.findAll();
	}

	@PostMapping("/add-options")
	public String saveOptions(Option option, Model model) {
		optionRepository.save(option);

		// reinitialises option and gets question data to display already added options
		model.addAttribute("question", questionRepository.findById(option.getQuestion().getQuestionId()));
		model.addAttribute("options", option.getQuestion().getOptions());
		model.addAttribute("survey", surveyRepository.findById(option.getQuestion().getSurvey().getSurveyId()));

		return "edit-options";
	}

}
