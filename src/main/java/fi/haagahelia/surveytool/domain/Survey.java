package fi.haagahelia.surveytool.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long surveyId;
	private String name;

	@OneToMany
	@JsonIgnoreProperties("survey")
	@JoinColumn(name = "questionId")
	private List<Question> questions;

	// Constructors
	public Survey(Long surveyId, String name, List<Question> questions) {
		super();
		this.surveyId = surveyId;
		this.name = name;
		this.questions = questions;
	}

	public Survey(String name, List<Question> questions) {
		super();
		this.name = name;
		this.questions = questions;
	}

	public Survey(String name) {
		super();
		this.name = name;
	}

	public Survey() {
		super();
	}

	// Getters
	public Long getSurveyId() {
		return surveyId;
	}

	public String getName() {
		return name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	// Setters
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "surveyId=" + surveyId + ", name=" + name + "]";
	}

}
