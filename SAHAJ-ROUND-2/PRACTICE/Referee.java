public class Referee{
	public boolean check(Player p1, Player p2, Board board){  // referee checks if the game has reached the end
		if(p1.fouls==3){  // checks if player 1 has made 3 fouls
			if(p1.points>0)  // if so he/she looses a point
				p1.points -= 1;
			p1.fouls = 0;
		}
		if(p2.fouls==3){  // checks if player 2 has made 3 fouls
			if(p2.points>0) // if so he/she looses a point
				p2.points -= 1;
			p2.fouls = 0;
		}


		// if the player has not pocketed a coin for three consecutive times, then he/she looses a point
		if(p1.unPocketCount==3){
			p1.unPocketCount = 0;
			if(p1.points>0)
				p1.points -= 1;
			p1.fouls++;
		}
		if(p2.unPocketCount==3){
			p2.unPocketCount = 0;
			if(p2.points>0)
				p2.points -= 1;
			p2.fouls++;
		}

		// checks if coins are exhausted or not
		if(board.totalCoins==0){
			if(isDraw(p1, p2))
				return true;
		}

		// checks who has won the match
		if(won(p1, p2)){
			return p1.won=true;
		}
		if(won(p2, p1)){
			return p2.won=true;
		}
		return false;
	} 

	// function to add a foul to a player
	public void addFoulToPlayer(Player player){
		player.fouls = player.fouls + 1; 
	}

	// checks if p1 has won p2 in this context
	private static boolean won(Player p1, Player p2){
		if((p1.points - p2.points)>=3 && p1.points>=5)
			return true;
		return false;
	}

	// checks if the match is draw
	private static boolean isDraw(Player p1, Player p2){
		if(Math.abs(p1.points-p2.points)<3)
			return true;
		else if(p1.points<5 && p2.points<5)
			return true;
		return false;
	}
}