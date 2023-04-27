package fi.haagahelia.surveytool.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	@Column(nullable=false)
	private String content;

	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "surveyId")
	private Survey survey;
	
	@ManyToOne
	@JsonIgnoreProperties("questions")
	@JoinColumn(name = "typeId")
	private QuestionType type;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
	@JsonIgnoreProperties("question")
	//@JoinColumn(name = "answerId")
	private List<Answer> answers;
	
	@OneToMany
	@JsonIgnoreProperties("question")
	private List<Option> options;

	// Constructors
	
	public Question(Long questionId, String content, Survey survey, QuestionType type, List<Answer> answers, List<Option> options) {
		super();
		this.questionId = questionId;
		this.content = content;
		this.survey = survey;
		this.type = type;
		this.answers = answers;
		this.options = options;
	}
	
	public Question(String content, Survey survey, QuestionType type, List<Answer> answers, List<Option> options) {
		super();
		this.content = content;
		this.survey = survey;
		this.type = type;
		this.answers = answers;
		this.options = options;
	}
	
	public Question(String content, Survey survey, QuestionType type, List<Answer> answers) {
		super();
		this.content = content;
		this.survey = survey;
		this.type = type;
		this.answers = answers;
	}
	
	public Question(String content, Survey survey, QuestionType type) {
		super();
		this.content = content;
		this.survey = survey;
		this.type = type;
	}

	public Question(Long questionId, String content, Survey survey) {
		super();
		this.questionId = questionId;
		this.content = content;
		this.survey = survey;
	}

	public Question(String content, Survey survey, List<Answer> answers) {
		super();
		this.content = content;
		this.survey = survey;
		this.answers = answers;
	}

	public Question(String content, Survey survey) {
		super();
		this.content = content;
		this.survey = survey;
	}

	public Question() {
		super();
	}

	// Getters
	
	public Long getQuestionId() {
		return questionId;
	}

	public String getContent() {
		return content;
	}

	public Survey getSurvey() {
		return survey;
	}

	public QuestionType getType() {
		return type;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public List<Option> getOptions() {
		return options;
	}

	// Setters

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", content=" + content + "]";
	}
}
