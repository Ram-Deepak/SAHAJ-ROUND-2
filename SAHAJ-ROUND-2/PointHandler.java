class PointHandler extends CoinHandler{
    public void updatePoints(Player player, int point){
        if(player.points>0){
            player.points = player.points + point; 
        }
    }

    public void unPocketCount(Player player){
        player.didNotPocket = player.didNotPocket + 1;
    }

    public void foulCount(Player player){
        player.fouls = player.fouls + 1;
    }
}