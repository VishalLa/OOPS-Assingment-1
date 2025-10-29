public abstract class Question {
	private String questiontext;
	private int points;
	
	public String getQuestion() {
		return this.questiontext;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public Question(String questiontext, int points) {
		this.questiontext = questiontext;
		this.points = points;
	}
	
	public abstract String getAnswer();
	public abstract boolean isCorrect(String userAnswer);
	
	@Override
	public String toString() {
		return String.format("Question: %s", this.questiontext);
	}
}
