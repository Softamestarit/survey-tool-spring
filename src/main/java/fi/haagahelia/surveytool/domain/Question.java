package fi.haagahelia.surveytool.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long questionId;
	private String name;
	
	@ManyToOne
	@JoinColumn(name= "surveyId")
	private Survey survey;

	
	//Constructors
	public Question(Long questionId, String name, Survey survey) {
		super();
		this.questionId = questionId;
		this.name = name;
		this.survey = survey;
	}

	public Question(String name, Survey survey) {
		super();
		this.name = name;
		this.survey = survey;
	}

	public Question() {
		super();
	}

	//Getters
	public Long getQuestionId() {
		return questionId;
	}

	public String getName() {
		return name;
	}

	public Survey getSurvey() {
		return survey;
	}

	//Setters
	
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", name=" + name + "]";
	}
}
