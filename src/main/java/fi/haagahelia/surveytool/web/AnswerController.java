package fi.haagahelia.surveytool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haagahelia.surveytool.domain.Answer;
import fi.haagahelia.surveytool.domain.AnswerRepository;

@Controller
public class AnswerController {
	@Autowired
	private AnswerRepository answerRepository;
	
	// REST-method for saving answer
	
	@PostMapping(value = "/saveanswer")
	public @ResponseBody Answer saveRestAnswer(@RequestBody Answer answer) {
		
		return answerRepository.save(answer);
		
	}
	

}
