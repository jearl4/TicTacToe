package tictactoe;

import java.util.Scanner;

public class TicTacToeApplication {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean doYouWantToPlay = true;
		
		while (doYouWantToPlay) {
			System.out.println("Welcome to Tic Tac Toe! You are about to go against the AI. Are you Ready?"
					+ "\n But first you must pick what character you want to be and which I will be");
			System.out.println();
			
			System.out.println("Eneter a single character that will represent you on the board");
			char playerToken = in.next().charAt(0);
			
			System.out.println("Enter a single character that will represent me");
			char aiToken = in.next().charAt(0);
			
			TicTacToe game = new TicTacToe(playerToken, aiToken);
			AI ai = new AI();
		}
	}
}
