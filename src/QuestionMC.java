public class QuestionMC extends Question{
	public String[] choices;
	public String answerLetter;
	
	public QuestionMC(String questiontext, int points, String answerLetter, String[] choices) {
		super(questiontext, points);
		this.choices = choices;
		this.answerLetter = answerLetter;
	}

	@Override
	public String getAnswer() {
        int correctIndex = answerLetter.toUpperCase().charAt(0) - 'A';
        if (correctIndex >= 0 && correctIndex < choices.length) {
            return choices[correctIndex];
        }
        return "Error: Invalid answer key.";
	}

	@Override
	public boolean isCorrect(String userAnswer) {
		return userAnswer.equalsIgnoreCase(answerLetter);
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\n");
        char choiceLetter = 'A';
        for (String choice : choices) {
            sb.append(choiceLetter).append(") ").append(choice).append("\n");
            choiceLetter++;
        }
        return sb.toString().trim();
    }
}
