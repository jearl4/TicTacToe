package tictactoe;

import java.util.Scanner;

public class TicTacToeApplication {
	public static void main(String[] args) {
		// get input
		Scanner in = new Scanner(System.in);
		boolean doYouWantToPlay = true;

		while (doYouWantToPlay) {
			// set up tokens and AI
			System.out.println("Welcome to Tic Tac Toe! You are about to go against the AI. Are you Ready?"
					+ "\nBut first you must pick what character you want to be and which I will be");
			System.out.println();

			System.out.println("Enter a single character that will represent you on the board");
			char playerToken = in.next().charAt(0);

			System.out.println("Enter a single character that will represent me");
			char aiToken = in.next().charAt(0);

			TicTacToe game = new TicTacToe(playerToken, aiToken);
			AI ai = new AI();

			// set up game
			System.out.println();
			System.out.println("Now we can start the game. Enter a number and the token will be put in its place."
					+ "\nThe numbers go from 1 to 9, left to right.");
			TicTacToe.printIndexBoard();
			System.out.println();

			// lets play
			while (game.gameOver().equals("not Over")) {
				if (game.currentMarker == game.userMarker) {
					// user turn
					System.out.println("It's your turn, enter spot number");
					int spot = in.nextInt();
					while (!game.playTurn(spot)) {
						System.out.println(
								"Try again. " + spot + " is invalid. This spot is already taken or is out of range.");
						spot = in.nextInt();
					}
					System.out.println("You picked " + spot);
				} else {
					// AI turn
					System.out.println("It's my turn.");
					// pick spot
					int aiSpot = ai.pickSpot(game);
					game.playTurn(aiSpot);
					System.out.println("I picked " + aiSpot);
				}
				// print out new board
				game.printBoard();
			}
			System.out.println(game.gameOver());
			System.out.println();

			// set up new game
			System.out.println("Do you want to play again? Y if you do, anything else if you dont.");
			char response = in.next().charAt(0);
			doYouWantToPlay = (response == 'Y');
			System.out.println();
			System.out.println();
		}
		in.close();
	}
}
