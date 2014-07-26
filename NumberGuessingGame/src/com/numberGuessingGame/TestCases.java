package com.numberGuessingGame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestCases {

	private GameServlet testServlet;
	
	@Before
	public void setUp() throws Exception {
		testServlet = new GameServlet();
	}
	
	@Test
	public void testDecreaseNumOfGuesses() {
		testServlet.decreaseNumOfGuesses();
		assertEquals(4, testServlet.getNumOfGuesses());
		for(int i = 0; i < 4; i++) {
			testServlet.decreaseNumOfGuesses();
		}
		assertEquals(0, testServlet.getNumOfGuesses());
	}
	
	@Test
	public void testResetGame() {
		testServlet.resetGame();
		assertEquals(5, testServlet.getNumOfGuesses());
	}

}
