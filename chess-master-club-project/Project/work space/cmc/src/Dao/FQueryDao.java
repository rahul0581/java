package Dao;

public class FQueryDao {
	private int fqID;
	public int getFqID() {
		return fqID;
	}
	public void setFqID(int fqID) {
		this.fqID = fqID;
	}
	public String getFqName() {
		return fqName;
	}
	public void setFqName(String fqName) {
		this.fqName = fqName;
	}
	public String getFqEmail() {
		return fqEmail;
	}
	public void setFqEmail(String fqEmail) {
		this.fqEmail = fqEmail;
	}
	public String getFqSubject() {
		return fqSubject;
	}
	public void setFqSubject(String fqSubject) {
		this.fqSubject = fqSubject;
	}
	public String getFqQuestion() {
		return fqQuestion;
	}
	public void setFqQuestion(String fqQuestion) {
		this.fqQuestion = fqQuestion;
	}
	public String getFqAnswer() {
		return fqAnswer;
	}
	public void setFqAnswer(String fqAnswer) {
		this.fqAnswer = fqAnswer;
	}
	private String fqName;
	private String fqEmail;
	
	private String fqSubject;
	private String fqQuestion;
	private String fqAnswer;
}
