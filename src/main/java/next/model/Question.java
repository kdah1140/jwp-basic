package next.model;

import java.util.Date;

public class Question {
	private long   questionId;
	private String writer;
	private String title;
	private String contents;
	private Date   createdDate;
	private int countOfAnswer;
	
	public Question(String writer, String title, String contents) {
		this(0, writer, title, contents, new Date(), 0);
	}

	public Question(long questionId, String writer,String title, String contents, Date createdDate, int countOfAnswer) {
		this.questionId = questionId;
		this.writer = writer;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.countOfAnswer = countOfAnswer;	
	}
	
	public long getQuestionId() {
		return questionId;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Object getContents() {
		return contents;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
		
	public int getCountOfAnswer() {
		return countOfAnswer;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + (int)(questionId^(questionId>>>32));
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Question other = (Question) obj;
		
		if(questionId != other.questionId)
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Question [questionId =" + questionId +
				", writer = " + writer + ", title = " +
				title + ", contents = " + contents +
				", createdDate = " + createdDate +
				", countOfAnswer =" + countOfAnswer + "]";
	}

}
		
	

