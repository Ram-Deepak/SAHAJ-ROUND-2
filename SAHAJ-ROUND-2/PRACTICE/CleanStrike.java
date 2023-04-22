import java.util.Scanner;


public class CleanStrike{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// Entities of the board game
		Player player1 = new Player();  // First player
		Player player2 = new Player();  // Second player
		Board carromBoard = new Board(); // A carrom board
		Referee referee = new Referee(); // Match referee
		PointsHandler ph = new PointsHandler(); // An entity to handle the points of the players
		CoinsHandler ch = new CoinsHandler(); // An entity to handle the coins of the carrom board

		// list of options the players have
		String options = "1. Strike" + "\n" + "2. Multistrike" + "\n" + "3. Red strike" + "\n" + "4. Striker strike" + "\n" + "5. None";

		// initially the game is not over 
		boolean gameOver = false;
		int turn = 1;
		while(!gameOver){
			int player;

			// decides which player should play now
			if(turn==1){
				player = 1;
			}
			else{
				player = 2;
			}

			// options are displayed
			System.out.println("Player "+player+": Choose an outcome from the list below");
			System.out.println(options);

			// getting the choice from the current player
			int choice = sc.nextInt();

			if(turn==1){  // if the turn was taken by first player
				ph.handlePoints(player1, choice, referee);  // points will be allotted by the referee based on the choice of the player
			}
			else{  // if the turn was taken by second player
				ph.handlePoints(player2, choice, referee);
			}
			ch.handleCoins(carromBoard, choice);  // coins on the board will be handled after each attempt by a player
			turn = 0 - turn; // change of turn

			gameOver = referee.check(player1, player2, carromBoard);  // referee will check if the game has ended
		}

		if(player1.won){
			System.out.println("Player 1 won the game. Final Score: "+player1.points+"-"+player2.points);
		}
		else if(player2.won){
			System.out.println("Player 2 won the game. Final Scoe: "+player2.points+"-"+player1.points);
		}
		else{
			System.out.println("Game draw");
		}
	}
}