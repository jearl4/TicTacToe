package tictactoe;

public class TicTacToe {

	protected char[] board;
	protected char userMarker;
	protected char aiMarker;
	protected char winner;
	protected char currentMarker;

	public TicTacToe(char playerToken, char aiMarker) {
		this.userMarker = playerToken;
		this.aiMarker = aiMarker;
		this.winner = '-';
		this.board = setBoard();
		this.currentMarker = userMarker;
	}

	public static char[] setBoard() {
		char[] board = new char[9];
		for (int i = 0; i < board.length; i++) {
			board[i] = '-';
		}
		return board;
	}

	public boolean playTurn(int spot) {
		boolean isValid = withinRange(spot) && !isSpotTaken(spot);
		if (isValid) {
			board[spot - 1] = currentMarker;
			currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
		}
		return isValid;
	}

	// check if spot is in range
	public boolean withinRange(int number) {
		return number > 0 && number < board.length + 1;
	}

	// check if spot is taken
	public boolean isSpotTaken(int number) {
		return board[number - 1] != '-';
	}

	public void printBoard() {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println("-------------");
			}
			System.out.println(" | " + board[i]);
		}
		System.out.println();
	}

	public static void printIndexBoard() {
		System.out.println();
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0 && i != 0) {
				System.out.println();
				System.out.println("-------------");
			}
			System.out.println(" | " + (i + 1));
		}
		System.out.println();
	}

	/**
	 * @return true if winner
	 */
	public boolean isThereAWinner() {
		boolean diagonalsAndMiddle = (rightDi() || leftDi() || middleRow() || secondCol()) && board[4] != '-';
		boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
		boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';
		if (diagonalsAndMiddle) {
			this.winner = board[4];
		} else if (topAndFirst) {
			this.winner = board[0];
		} else if (bottomAndThird) {
			this.winner = board[8];
		}
		return diagonalsAndMiddle || topAndFirst || bottomAndThird;
	}

	/**
	 * check if top row of board is same
	 * 
	 * @return true if top row of board matches
	 */
	public boolean topRow() {
		return board[0] == board[1] && board[1] == board[2];
	}

	/**
	 * check if middle row of board is same
	 * 
	 * @return true if row matches
	 */
	public boolean middleRow() {
		return board[3] == board[4] && board[4] == board[5];
	}

	/**
	 * check if bottom row of board is same
	 * 
	 * @return true if bottom row matches
	 */
	public boolean bottomRow() {
		return board[6] == board[7] && board[7] == board[8];
	}

	/**
	 * check if right diagonal matches
	 * 
	 * @return true if diagonal matches
	 */
	public boolean rightDi() {
		return board[2] == board[4] && board[4] == board[6];
	}

	/**
	 * check if left diagonal matches
	 * 
	 * @return true if left diagonal matches
	 */
	public boolean leftDi() {
		return board[0] == board[4] && board[4] == board[8];
	}

	/**
	 * check if far left column matches
	 * 
	 * @return true if match
	 */
	public boolean firstCol() {
		return board[0] == board[3] && board[3] == board[6];
	}

	/**
	 * check if middle column matches
	 * 
	 * @return true if match
	 */
	public boolean secondCol() {
		return board[1] == board[4] && board[4] == board[7];
	}

	/**
	 * check if right column matches
	 * 
	 * @return true if match
	 */
	public boolean thirdCol() {
		return board[2] == board[5] && board[5] == board[8];
	}

	/**
	 * check if board is filled
	 * 
	 * @return true if no - are found on board
	 */
	public boolean isTheBoardFilled() {
		for (int i = 0; i < board.length; i++) {
			if (board[i] == '-') {
				return false;
			}
		}
		return true;
	}

	public String gameOver() {
		boolean didSomeoneWin = isThereAWinner();
		if (didSomeoneWin) {
			return "We Have a winner! The winner is " + this.winner + "'s";
		} else if (isTheBoardFilled()) {
			return "Draw: Game Over";
		} else {
			return "not Over";
		}
	}
}
