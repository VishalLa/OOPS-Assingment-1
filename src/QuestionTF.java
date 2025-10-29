public class QuestionTF extends Question {
	public boolean answer;
	
	public QuestionTF(String questiontext, int points, boolean answer) {
		super(questiontext, points);
		this.answer = answer;
	}

	@Override
	public String getAnswer() {
		return String.valueOf(answer);
	}

	@Override
	public boolean isCorrect(String userAnswer) {
		return userAnswer.equalsIgnoreCase(this.getAnswer());
	}
}
