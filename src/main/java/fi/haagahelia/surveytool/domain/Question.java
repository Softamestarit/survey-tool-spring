package fi.haagahelia.surveytool.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private String content;
	
	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name= "surveyId")
	private Survey survey;

	
	//Constructors
	public Question(Long questionId, String content, Survey survey) {
		super();
		this.questionId = questionId;
		this.content = content;
		this.survey = survey;
	}

	public Question(String content, Survey survey) {
		super();
		this.content = content;
		this.survey = survey;
	}

	public Question() {
		super();
	}

	//Getters
	public Long getQuestionId() {
		return questionId;
	}

	public String getContent() {
		return content;
	}

	public Survey getSurvey() {
		return survey;
	}

	//Setters
	
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", content=" + content + "]";
	}
}
