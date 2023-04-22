public class PointsHandler{
	public void handlePoints(Player player, int choice, Referee referee){  // handles the points of the players
		
		// if the player has not pocketed any coin then the unpocketcount increases
		if(choice==5){  
			player.unPocketCount++; 
		}

		// if the player has pocketed the striker then he/she will loose a point
		else if(choice==4){
			if(player.points>0){
				player.points--;
				referee.addFoulToPlayer(player); // fouls will be checked only by the referee
				player.unPocketCount++;
			}
		}

		// if the player has pocketed one or more black coins or the red coin
		else{
			player.unPocketCount = 0;
			// player.points += choice;

			// if the player has pocketed one black coin
			if(choice==1){
				player.points = player.points + 1;
			}
			// if the player has multistriked black coins
			else if(choice==2){
				player.points = player.points + 2;
			}
			// if the player has striked the red coin
			else if(choice==3){
				player.points = player.points + 3;
			}
		}
	}
}