package fi.haagahelia.surveytool.web;

import fi.haagahelia.surveytool.domain.Answer;
import fi.haagahelia.surveytool.domain.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AnswerController {
	@Autowired
	private AnswerRepository answerRepository;
	
	// REST-method for saving answer


	@PostMapping(value = "/answers")
	public @ResponseBody List<Answer> saveRestAnswers(@RequestBody List<Answer> answers) {
		return (List<Answer>) answerRepository.saveAll(answers);
	}
	

}
