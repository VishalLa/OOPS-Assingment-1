public class QuestionSA extends Question{
	private String answer;
	
	public QuestionSA(String questiontext, int points, String answer) {
		super(questiontext, points);
		this.answer = answer;
	}

	@Override
	public String getAnswer() {
		return this.answer;
	}

	@Override
	public boolean isCorrect(String userAnswer) {
		return userAnswer.equalsIgnoreCase(answer);
	}
}
