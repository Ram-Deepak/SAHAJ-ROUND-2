public class CoinsHandler{
	public void handleCoins(Board board, int choice){ // handles the coins on the carrom board
		// if(choice==1 || choice==2){
		// 	board.totalCoins -= choice;
		// 	board.black -= choice;
		// }

		// if one coin is pocketed
		if(choice==1){
			board.totalCoins = board.totalCoins - 1;
			board.black = board.black - 1;
		}

		// if two coins are multistriked
		else if(choice==2){
			board.totalCoins = board.totalCoins - 2;
			board.black = board.black - 2;
		}

		// if the red coin is pocketed
		else if(choice==3){
			if(board.red==1){
				board.red -= 1;
				board.totalCoins -= 1;
			}
		}
	}
}