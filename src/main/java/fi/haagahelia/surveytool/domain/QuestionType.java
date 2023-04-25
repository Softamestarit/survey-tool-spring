package fi.haagahelia.surveytool.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class QuestionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long typeId;
	private String type;

	@OneToMany (cascade = CascadeType.ALL, mappedBy = "type")
	@JsonIgnoreProperties("questiontype")
	private List<Question> questions;

	// Constructors
	
	public QuestionType() {
		super();
	}

	public QuestionType(Long typeId, String type, List<Question> questions) {
		super();
		this.typeId = typeId;
		this.type = type;
		this.questions = questions;
	}

	public QuestionType(String type, List<Question> questions) {
		super();
		this.type = type;
		this.questions = questions;
	}
	
	public QuestionType(String type) {
		super();
		this.type = type;
	}

	public QuestionType(List<Question> questions) {
		super();
		this.questions = questions;
	}
	
	// Getters + Setters

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuestionType [typeId=" + typeId + ", type=" + type + "]";
	}

	
}
