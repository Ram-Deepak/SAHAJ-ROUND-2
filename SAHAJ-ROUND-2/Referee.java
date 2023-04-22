import java.util.ArrayList;

class Referee extends PointHandler{

    String[] moves = {"Strike", "Multistrike", "Red Strike", "Striker strike", "None"};

    public void displayOptions(int turn){
        System.out.println("Player "+turn+": Choose an outcome from the list below");
        for(int i=0; i<5; i++){
            System.out.println((i+1)+" "+moves[i]);
        }
    }

    public void checkFoul(Player player){
        if(player.didNotPocket==3){
            foulCount(player);
            player.didNotPocket = 0;
        }
        if(player.fouls==3){
            updatePoints(player, -1);
            player.fouls = 0;
        }
    }

    public boolean check(Player player_1, Player player_2){
        int player_1_point = player_1.points-1;
        int player_2_point = player_2.points-1;
        boolean result = false;
        if(player_1_point>=5 && player_1_point >= player_2_point+3){
            player_1.won = true;
            result = true;
        }
        else if(player_2_point>=5 && player_2_point >= player_1_point + 3){
            player_2.won = true;
            result = true;
        }
        return result;
    }

    public void announceResults(boolean result, Player player_1, Player player_2){
        String finalResult = "draw";
        if(result==true){
            if(player_1.won == true){
                finalResult = "Player 1 won the game. Final score: "+(player_1.points-1)+":"+(player_2.points-1);
            }
            else if(player_2.won==true){
                finalResult = "Player 2 won the game. Final score: "+(player_1.points-1)+":"+(player_2.points-1);
            }
        }
        System.out.println(finalResult);
    }
}