/* 
 * @author Kevin Park
 * Neustar coding assignment
 * Number guessing game: user has five chances to guess a randomly generated number between 1 and 20
 */

package com.numberGuessingGame;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {
	// Randomly generate a number between 1 and 20 for the user to guess
	private int answer = (int)(Math.random() * 20) + 1;
	
	// Increments number of tries for the user; decreases by 1 after each guess
	private int numOfGuesses = 5;
	
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 * Allows servlet to interact with webpage
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String guessString;
		int guess = 0;
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<head>");
		resp.getWriter().println("<title>Result</title>");
		resp.getWriter().println("</head>");
		resp.getWriter().println("<body>");
			
		guessString = req.getParameter("userGuess");
		
		// Checks to make sure the number input is of type int to prevent NumberFormatException
		if (guessString.indexOf(".") == -1) {
			guess = Integer.parseInt(req.getParameter("userGuess"));
			
			// If user guess is correct, user is notified and game ends
			if (guess == answer) {
				resp.getWriter().println("You are correct!");
				resetGame();
			}	
			// If user guess is incorrect, number of tries for the user is decreased by one, stating how many tries remain and allowing the user to input a new guess
			else if(numOfGuesses > 1) {
				decreaseNumOfGuesses();
				resp.getWriter().println("Wrong answer! You have " + numOfGuesses + " remaining.");
				resp.getWriter().println("<form action=\"servlet1\" method=\"get\">");
				// HTML is set so that input must be between 1 and 20, and in increments of 1 to prevent values such as 1.1
				resp.getWriter().println("Enter a number from 1 to 20: <input type=\"number\" name=\"userGuess\" min=\"1\" max=\"20\" step=\"1\"> <br>");				
				resp.getWriter().println("<input type=\"submit\" value=\"Enter\">");
				resp.getWriter().println("</form>");
			}
			// Once user runs out of guesses, game is over and the correct answer is shown
			else {
				resp.getWriter().println("You lose.  The answer was " + answer);
				resetGame();
			}
		}
		
		// If input is a double, user is told to enter an integer
		else {
			resp.getWriter().println("Input your guess without decimal points.");
			resp.getWriter().println("<form action=\"servlet1\" method=\"get\">");
			resp.getWriter().println("Enter a number from 1 to 20: <input type=\"number\" name=\"userGuess\" min=\"1\" max=\"20\" step=\"1\"> <br>");				
			resp.getWriter().println("<input type=\"submit\" value=\"Enter\">");
			resp.getWriter().println("</form>");
		}
		
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
	
	/*
	 * Decreases the number of tries available; numOfGuesses could be decreased without this method
	 */
	public void decreaseNumOfGuesses() {
		numOfGuesses--;
	}
	
	/*
	 * Resets the game after it is over so that it can be replayed
	 */
	public void resetGame() {
		numOfGuesses = 5;
		answer = (int)(Math.random() * 20) + 1;	
	}
	
	/*
	 * Getter method to return numOfGuesses
	 */
	public int getNumOfGuesses() {
		return numOfGuesses;
	}
}
