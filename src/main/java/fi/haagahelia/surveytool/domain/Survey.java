package fi.haagahelia.surveytool.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.AssertTrue;

@Entity
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long surveyId;
	
	@Column(nullable=false)
	private String title;
	
	private String description;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime startTime;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime endTime;


	@OneToMany (cascade = CascadeType.ALL, mappedBy = "survey")
	@JsonIgnoreProperties("survey")
	private List<Question> questions;

	@AssertTrue
	private boolean isEndDateLaterThanStart() {
		return (endTime.isAfter(startTime));
	}
	
	// Constructors
	
	public Survey(Long surveyId, String title, String description, LocalDateTime startTime, LocalDateTime endTime,
			List<Question> questions) {
		super();
		this.surveyId = surveyId;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.questions = questions;
	}

	public Survey(String title, String description, LocalDateTime startTime, LocalDateTime endTime,
			List<Question> questions) {
		super();
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.questions = questions;
	}

	public Survey(String title, String description, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public Survey(String title, String description) {
		super();
		this.title = title;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}
	
	public LocalDateTime getEndTime() {
		return endTime;
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
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "surveyId=" + surveyId + ", title=" + title + ", description=" + description + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}

	
}
