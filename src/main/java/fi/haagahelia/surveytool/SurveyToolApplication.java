package fi.haagahelia.surveytool;

import java.time.LocalDateTime;

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
			
			LocalDateTime sDate = LocalDateTime.of(2023, 5, 26, 22, 11);
			LocalDateTime eDate = LocalDateTime.of(2023, 7, 30, 22, 11);
			
						
			Survey survey1 = new Survey("Liikuntakysely", "Kysely Haaga-Helian opiskelijoiden liikuntatottumuksista.", sDate, eDate);
			
			surveyRepository.save(survey1);
			
			QuestionType type1 = new QuestionType("text");
			QuestionType type2 = new QuestionType("radio");
			QuestionType type3 = new QuestionType("checkbox");
			
			questionTypeRepository.save(type1);
			questionTypeRepository.save(type2);
			questionTypeRepository.save(type3);
			
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
			
			Option option1 = new Option("Kyllä");
			Option option2 = new Option("Ei");
			
			optionRepository.save(option1);
			optionRepository.save(option2);

			//testi dataa vastausten näyttämiseen 
			
			Survey survey2 = new Survey("Alkoholikysely", "Kysely Haaga-Helian opiskelijoiden alkoholitottumuksista.", sDate, eDate);
			surveyRepository.save(survey2);
			
			Question question12 = new Question("Kuinka usein juot alkoholia viikossa?", survey2, type1);
			Question question22 = new Question("Montako alkoholiannosta juot viikossa?", survey2, type1);
			Question question32 = new Question("Oletko huolissasi omasta alkoholin kulutuksesta?", survey2, type1);
			
			questionRepository.save(question12);
			questionRepository.save(question22);
			questionRepository.save(question32);
			
			
			Answer answer12 = new Answer("Kerran.", question12);
			Answer answer121 = new Answer("Kaksi kertaa.", question12);
			Answer answer22 = new Answer("Seitsemän", question22); 
			Answer answer221 = new Answer("Kolme.", question22);
			Answer answer32 = new Answer("En ole.", question32); 
			Answer answer321 = new Answer("Enpä oikeastaan.", question32);
			
			answerRepository.save(answer12);
			answerRepository.save(answer121);
			answerRepository.save(answer22);
			answerRepository.save(answer221);
			answerRepository.save(answer32);
			answerRepository.save(answer321);
		};
	}
}
