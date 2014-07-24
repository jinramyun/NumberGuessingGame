
public class AnswerCheck {
	private int guess;
	
	public void setGuess(int userGuess) {
		guess = userGuess;
	}
	
	public boolean checkAnswer(int answer) {
		return guess == answer;
	}

}
