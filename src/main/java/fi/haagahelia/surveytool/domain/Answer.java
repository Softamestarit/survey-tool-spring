package fi.haagahelia.surveytool.domain;

import java.util.HashSet;
import java.util.Set;

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
		
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("answers")
	@JoinTable(name = "answeroption", joinColumns = @JoinColumn(name = "answerId"), inverseJoinColumns = @JoinColumn(name = "optionId"))

	private Set<Option> options = new HashSet<>();
	
	// CONSTRUCTORS

	public Answer() {

	}

	public Answer(Set<Option> options) {
		super();
		this.options = options;
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
	
	public Set<Option> getOptions() {
		return options;
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
	
	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	public void addOption(Option option) {
		this.options.add(option);
		option.getAnswers().add(this);
	}
	
	// TOSTRING

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", text=" + text + ", question=" + question + "]";
	}

}
