import java.util.Scanner;

class Game{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Player player_1 = new Player();
        Player player_2 = new Player();
        Strike strike = new Strike();
        Referee referee = new Referee();
        int turn = 1;
        boolean result = false;
        while(strike.totalCoins>0){
            referee.displayOptions(turn);
            int move = sc.nextInt();
            if(turn==1){
                strike.perform(player_1, move);
                referee.checkFoul(player_1);
                turn = 2;
            }
            else if(turn==2){
                strike.perform(player_2, move);
                referee.checkFoul(player_2);
                turn = 1;
            }
            result = referee.check(player_1, player_2);
            if(result==true){
                break;
            }
        }
        referee.announceResults(result, player_1, player_2);
    }
}