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
	CommandLineRunner examples(SurveyRepository surveyRepository, QuestionRepository questionRepository, AnswerRepository answerRepository, OptionRepository optionRepository, QuestionTypeRepository questionTypeRepository) {

		return (args) -> {
			
			// Survey 1 test data 
			LocalDateTime sDate1 = LocalDateTime.of(2023, 3, 26, 22, 11);
			LocalDateTime eDate1 = LocalDateTime.of(2023, 7, 30, 22, 11);
						
			Survey survey1 = new Survey("Liikuntakysely", "Kysely Haaga-Helian opiskelijoiden liikuntatottumuksista.", sDate1, eDate1);
			
			surveyRepository.save(survey1);
			
			QuestionType type1 = new QuestionType("text");
			QuestionType type2 = new QuestionType("radio");
			QuestionType type3 = new QuestionType("checkbox");
			
			questionTypeRepository.save(type1);
			questionTypeRepository.save(type2);
			questionTypeRepository.save(type3);

			Question question2 = new Question("Koetko liikkuvasi tarpeeksi?", survey1, type2);
			
			Option option1 = new Option("Ei", question2);
			Option option2 = new Option("Kyllä", question2);
			
			Question question3 = new Question("Koetko lähialueellasi olevan riittävästi liikuntapaikkoja?", survey1, type1);
			Question question4 = new Question("Tukeeko koulu riittävästi liikkumistasi?", survey1, type1);
			Question question5 = new Question("Miten koulu voisi tukea liikkumistasi paremmin?", survey1, type1);
			Question question1 = new Question("Mikä innostaisi sinua liikkumaan enemmän?", survey1, type1);

			questionRepository.save(question1);
			questionRepository.save(question2);
			questionRepository.save(question3);
			questionRepository.save(question4);
			questionRepository.save(question5);
			
			optionRepository.save(option1);
			optionRepository.save(option2);

			// Survey 2 test data to show answers 
			LocalDateTime sDate2 = LocalDateTime.of(2023, 5, 26, 22, 11);
			LocalDateTime eDate2 = LocalDateTime.of(2023, 7, 30, 22, 11);

			Survey survey2 = new Survey("Alkoholikysely", "Kysely Haaga-Helian opiskelijoiden alkoholitottumuksista.", sDate2, eDate2);
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
			
			// Survey 3 test data to show diagram
			
			LocalDateTime sDate3 = LocalDateTime.of(2023, 5, 11, 22, 11);
			LocalDateTime eDate3 = LocalDateTime.of(2023, 7, 30, 22, 11);

			Survey survey3 = new Survey("Hyvinvointikysely", "Kysely Haaga-Helian opiskelijoiden hyvinvoinnista.", sDate3, eDate3);
			surveyRepository.save(survey3);
			
			Question question111 = new Question("Oletko minkä vuoden opiskelija?", survey3, type2);
			Question question222 = new Question("Kuinka monta tuntia nukut keskimäärin yössä?", survey3, type2);
			Question question333 = new Question("Tupakoitko?", survey3, type1);
			
			questionRepository.save(question111);
			questionRepository.save(question222);
			questionRepository.save(question333);
			
			Option option11 = new Option("1. vuoden", question111);
			Option option22 = new Option("2. vuoden", question111);
			Option option33 = new Option("3. vuoden", question111);
			
			optionRepository.save(option11);
			optionRepository.save(option22);
			optionRepository.save(option33);
			
			Answer answer1 = new Answer();
			answer1.getOptions().add(option11);
			answerRepository.save(answer1);

			Answer answer2 = new Answer();
			answer2.getOptions().add(option11);
			answerRepository.save(answer2);
			
			Answer answer3 = new Answer();
			answer3.getOptions().add(option22);
			answerRepository.save(answer3);
			
			Answer answer4 = new Answer();
			answer4.getOptions().add(option22);
			answerRepository.save(answer4);
			
			Answer answer5 = new Answer();
			answer5.getOptions().add(option22);
			answerRepository.save(answer5);
			
			Answer answer6 = new Answer();
			answer6.getOptions().add(option33);
			answerRepository.save(answer6);
			
			Option option44 = new Option("alle 6 tuntia", question222);
			Option option55 = new Option("6-8 tuntia", question222);
			Option option66 = new Option("yli 8 tuntia", question222);
			
			optionRepository.save(option44);
			optionRepository.save(option55);
			optionRepository.save(option66);
			
			Answer answer7 = new Answer();
			answer7.getOptions().add(option44);
			answerRepository.save(answer7);

			Answer answer8 = new Answer();
			answer8.getOptions().add(option55);
			answerRepository.save(answer8);
			
			Answer answer9 = new Answer();
			answer9.getOptions().add(option55);
			answerRepository.save(answer9);
			
			Answer answer10 = new Answer();
			answer10.getOptions().add(option44);
			answerRepository.save(answer10);
			
			Answer answer11 = new Answer();
			answer11.getOptions().add(option55);
			answerRepository.save(answer11);
			
			Answer answer122 = new Answer();
			answer122.getOptions().add(option66);
			answerRepository.save(answer122);
			
			Option option77 = new Option("Kyllä", question333);
			Option option88 = new Option("En", question333);
			
			optionRepository.save(option77);
			optionRepository.save(option88);
			
			Answer answer13 = new Answer();
			answer13.getOptions().add(option77);
			answerRepository.save(answer13);

			Answer answer14 = new Answer();
			answer14.getOptions().add(option88);
			answerRepository.save(answer14);
			
			Answer answer15 = new Answer();
			answer15.getOptions().add(option88);
			answerRepository.save(answer15);
			
			Answer answer16 = new Answer();
			answer16.getOptions().add(option88);
			answerRepository.save(answer16);
			
			Answer answer17 = new Answer();
			answer17.getOptions().add(option88);
			answerRepository.save(answer17);
			
			Answer answer18 = new Answer();
			answer18.getOptions().add(option77);
			answerRepository.save(answer18);
		};
	}
}
