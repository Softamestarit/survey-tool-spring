package fi.haagahelia.surveytool;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.surveytool.domain.Answer;
import fi.haagahelia.surveytool.domain.AnswerRepository;
import fi.haagahelia.surveytool.domain.Option;
import fi.haagahelia.surveytool.domain.OptionRepository;
import fi.haagahelia.surveytool.domain.Question;
import fi.haagahelia.surveytool.domain.QuestionRepository;
import fi.haagahelia.surveytool.domain.QuestionType;
import fi.haagahelia.surveytool.domain.QuestionTypeRepository;
import fi.haagahelia.surveytool.domain.Survey;
import fi.haagahelia.surveytool.domain.SurveyRepository;

@SpringBootApplication
public class SurveyToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyToolApplication.class, args);
	}

	@Bean
	public CommandLineRunner examples(SurveyRepository surveyRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, OptionRepository optionRepository, QuestionTypeRepository questionTypeRepository) {

		return (args) -> {
			
			Survey survey1 = new Survey("Liikuntakysely");
			
			surveyRepository.save(survey1);
			
			QuestionType type1 = new QuestionType("Radio");
			
			questionTypeRepository.save(type1);
			
			Question question1 = new Question("Kuinka monta kertaa liikut viikossa vähintään puoli tuntia?", survey1, type1);
			Question question2 = new Question("Koetko liikkuvasi tarpeeksi?", survey1, type1);
			Question question3 = new Question("Koetko lähialueellasi olevan riittävästi liikuntapaikkoja?", survey1, type1);
			Question question4 = new Question("Tukeeko koulu riittävästi liikkumistasi?", survey1, type1);
			Question question5 = new Question("Toivoisitko koulun tukevan enemmän liikkumistasi?", survey1, type1);
			Question question6 = new Question("Avaudu tähän!!", survey1, type1);			
			
			questionRepository.save(question1);
			questionRepository.save(question2);
			questionRepository.save(question3);
			questionRepository.save(question4);
			questionRepository.save(question5);
			questionRepository.save(question6);
			
			Option option1 = new Option("AAA");
			
			optionRepository.save(option1);
			
		};
	}
}
