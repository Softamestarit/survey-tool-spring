package fi.haagahelia.surveytool.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Option {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;
	private String content;

	@ManyToOne
	@JsonIgnoreProperties("options")
	@JoinColumn(name="questionId")
	private Question question;

	// Constructors
	
	public Option() {}

	public Option(Long optionId, String content, Question question) {
		super();
		this.optionId = optionId;
		this.content = content;
		this.question = question;
	}

	public Option(String content, Question question) {
		super();
		this.content = content;
		this.question = question;
	}
	
	public Option(Question question) {
		super();
		this.question = question;
	}
	
	public Option(String content) {
		super();
		this.content = content;
	}
	
	// Getters + Setters
	
	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionType [optionId=" + optionId + ", content=" + content + "]";
	}	
}
