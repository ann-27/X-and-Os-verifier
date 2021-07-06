/**
 * Program name: Noughts and crosses game verifier
 *
 *
 * This java program verifys the winner of a noughts and crosses game.
 */
import java.util.*;
import java.util.Random;
class NoughtsAndCrosses{
	public static void main(String[] args) {
		//Creating an instance of the class and running the method.
		System.out.println();
		System.out.println("NOUGHTS AND CROSSES : ");
		String[][]g = new String[3][3];
		System.out.println();
		NoughtsAndCrosses n = new NoughtsAndCrosses(g);
		System.out.println(n.checkWinner());
	}

	private int rows = 3;
	private int columns = 3;
	private String[][] grid;	//2D array represending the board/grid
	private String player1 = "X";
	private String player2 = "O";
	private String[] players = {player1,player2};

	public NoughtsAndCrosses(String[][]gd){
		grid = gd;
		grid = new String[rows][columns];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				//choosing random pieces for the grid.
				Random r = new Random();
        		int randomPiece = r.nextInt(players.length);
				grid[i][j] = players[randomPiece];
				// printing the grid as a matrix.
				System.out.print(grid[i][j]+"   ");

			}
			System.out.println();
		}
		System.out.println();
	}

	public String checkWinner(){

		//Checking if the game is finished.
		for(String[] stringArray : grid){
			for (String s : stringArray ){
				if(s == null){
					return "The outcome of the game is yet to be decided as the game is not yet finished.";
				}	
			}
		}

		for(int i = 0; i < grid.length; i++){

			//Checking the rows of the grid for a winner.
			if(grid[i][0].equals(grid[i][1]) && grid[i][1].equals(grid[i][2])){
				return "Congragulations!!!! player "+ grid[i][0] +" has won the game (Horizondal)";
			}

			//checking the columns of the grid for a winner.
			else if(grid[0][i].equals(grid[1][i]) && grid[1][i].equals(grid[2][i])){
				return "Congragulations!!!! player "+ grid[0][i] +" has won the game (Vertical)";
			}
		}

		//checking diagonals of the grid for a winner.
		if(grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2]) || grid[2][0].equals(grid[1][1]) && grid[1][1].equals(grid[0][2])) {
			return "Congragulations!!!! player "+ grid[1][1] +" has won the game (Diagonal)";		
		}

		//There are no winners to this game.
		return "There are no winners to this game :(";
		}
}


