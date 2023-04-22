class CoinHandler extends CarromBoard{
    public void reduceBlackCoins(Player player, int count){
        if(totalCoins>=count && blackCoins>=count){
            blackCoins = blackCoins - count;
            totalCoins = totalCoins - count;
        }
    }

    public void reduceRedCoin(Player player){
        redCoin = redCoin - 1;
        totalCoins = totalCoins - 1;
    }
}