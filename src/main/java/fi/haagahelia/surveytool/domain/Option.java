package fi.haagahelia.surveytool.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

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
	
	@ManyToMany(mappedBy = "options")
	@JsonIgnoreProperties("options")
	private Set<Answer> answers = new HashSet<>();

	// Constructors
	
	public Option() {}

	public Option(Set<Answer> answers) {
		super();
		this.answers = answers;
	}

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
	
	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", content=" + content + ", question=" + question + ", answers="
				+ answers + "]";
	}	
	
}
