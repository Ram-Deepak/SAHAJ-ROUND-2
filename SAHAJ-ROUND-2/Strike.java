class Strike extends PointHandler{
    public void perform(Player player, int move){
        if(move==5){
            unPocketCount(player);
            player.prev = true;
        }
        if(move!=5){
            if(player.prev == true){
                player.prev = false;
                player.didNotPocket = 0;
            }
            if(move==1){
                updatePoints(player, 1);
                reduceBlackCoins(player, 1);
            }
            if(move==2){
                updatePoints(player, 2);
                reduceBlackCoins(player, 2);
            }
            if(move==4){
                updatePoints(player, -1);
            }
            if(move==3){
                if(redCoin==1){
                    updatePoints(player, 3);
                    reduceRedCoin(player);
                }
            }
        }
    }
}