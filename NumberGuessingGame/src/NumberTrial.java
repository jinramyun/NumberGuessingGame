import java.util.Scanner;

public class NumberTrial {
	
	public static void main(String [] args) {
		boolean winGame = false;
		NumberGenerator answer = new NumberGenerator();
		AnswerCheck checker = new AnswerCheck();
		Scanner stdin = new Scanner(System.in);
		answer.changeAnswer();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter a guess between 1 to 20.");
			checker.setGuess(stdin.nextInt());
			if (checker.checkAnswer(answer.getAnswer())) {
				System.out.println("You are correct!");
				winGame = true;
				break;
			}
			else
				System.out.println("Wrong answer!");
		}
		
		stdin.close();
		
		if (!winGame) {
			System.out.println("You lose.  The answer was " + answer.getAnswer());
		}
	}

}
