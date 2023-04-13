package fi.haagahelia.surveytool.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long surveyId;
	private String title;

	@OneToMany (cascade = CascadeType.ALL, mappedBy = "survey")
	@JsonIgnoreProperties("survey")
	private List<Question> questions;

	// Constructors
	public Survey(Long surveyId, String title, List<Question> questions) {
		super();
		this.surveyId = surveyId;
		this.title = title;
		this.questions = questions;
	}

	public Survey(String title, List<Question> questions) {
		super();
		this.title = title;
		this.questions = questions;
	}

	public Survey(String title) {
		super();
		this.title = title;
	}

	public Survey() {
		super();
	}

	// Getters
	public Long getSurveyId() {
		return surveyId;
	}

	public String getTitle() {
		return title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	// Setters
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "surveyId=" + surveyId + ", title=" + title + "]";
	}
}
