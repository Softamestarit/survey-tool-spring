package fi.haagahelia.surveytool;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.surveytool.domain.Question;
import fi.haagahelia.surveytool.domain.QuestionRepository;
import fi.haagahelia.surveytool.domain.Survey;
import fi.haagahelia.surveytool.domain.SurveyRepository;

@SpringBootApplication
public class SurveyToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyToolApplication.class, args);
	}

	@Bean
	public CommandLineRunner examples(SurveyRepository surveyRepository, QuestionRepository questionRepository) {

		return (args) -> {
			
			Survey survey1 = new Survey("Kysely1");
			
			surveyRepository.save(survey1);
			
			Question question1 = new Question("Kuka on muum?", survey1);
			
			questionRepository.save(question1);

		};
	}
}
