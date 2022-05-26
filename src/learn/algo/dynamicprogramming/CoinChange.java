package learn.algo.dynamicprogramming;

public class CoinChange {
    
    int[] coins, memo;
    
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new int[amount + 1];
        return dp(amount);
    }
    
    public int dp(int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        
        if(memo[amount] != 0){
            return memo[amount];
        }
        
        int minCoins = Integer.MAX_VALUE;
        
        for(int coin : coins){
            int count = dp(amount - coin);
            if(count >= 0){
                minCoins = Math.min(minCoins, count + 1);
            }
        }
        
        if(minCoins == Integer.MAX_VALUE ){
            memo[amount] = -1;
        }else{
            memo[amount] = minCoins;
        }
        
        return memo[amount];
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        int coins[] = {1,2,5};
        int amount = 11;

        sol.coinChange(coins, amount);
    }
}
