package Testing;

public class KnightsTour {

	public static void main(String args[]) {

		int N = 8;

		int board[][] = new int[N][N];


		for (int x = 0; x < N; x++)
			for (int y = 0; y < N; y++)
				board[x][y] = -1;


		for (int x = 0; x < N; x++)     // If starting pt not given then consider each pt as starting pt through loop else given no need of loop just put x y value
			for (int y = 0; y < N; y++)
				printKnightsTour(board , x , y , 0);
	}

	private static void printKnightsTour(int[][] board, int currRow, int currCol, int Move) {

		if(currRow<0 || currRow>=board.length || currCol < 0 || currCol>=board.length) {
			return;
		}

		if(Move == board.length*board.length -1) // last cell 0 based indexing
		{
			board[currRow][currCol] = Move;
			printBoard(board);
			board[currRow][currCol] = -1;
			return;
		}

		board[currRow][currCol] = Move;
		
//		 2, 1, -1, -2, -2, -1, 1 , 2 };
//	     1, 2, 2 , 1 , -1, -2, -2, -1 };
		
		printKnightsTour(board,  currRow+2,  currCol+1,  Move+1);
		printKnightsTour(board,  currRow+1,  currCol+2,  Move+1);
		printKnightsTour(board,  currRow-1,  currCol+2,  Move+1);
		printKnightsTour(board,  currRow-2,  currCol+1,  Move+1);
		printKnightsTour(board,  currRow-2,  currCol-1,  Move+1);
		printKnightsTour(board,  currRow-1,  currCol-2,  Move+1);
		printKnightsTour(board,  currRow+1,  currCol-2,  Move+1);
		printKnightsTour(board,  currRow+2,  currCol-1,  Move+1);
		
		board[currRow][currCol] = -1;
		
		return;
	}

	private static void printBoard(int[][] board) {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				System.out.print(board[x][y]);
			}
			System.out.println();
		}
	}
}
