package fi.haagahelia.surveytool.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long answerId;
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties("answers")
	@JoinColumn(name="questionId")
	private Question question;
	
	
	// CONSTRUCTORS

	public Answer() {

	}

	public Answer(Long answerId, String text, Question question) {
		super();
		this.answerId = answerId;
		this.text = text;
		this.question = question;
	}

	public Answer(String text, Question question) {
		super();
		this.text = text;
		this.question = question;
	}

	// GETTERS

	public Long getAnswerId() {
		return answerId;
	}

	public String getText() {
		return text;
	}

	public Question getQuestion() {
		return question;
	}

	// SETTERS

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	// TOSTRING

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", text=" + text + ", question=" + question + "]";
	}

}
