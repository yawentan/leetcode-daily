package yawen;

import java.util.Arrays;

public class LC322M {
    public int coinChange(int[] coins, int amount) {
    	Arrays.sort(coins);
    	int[] dp = new int[amount+1];
    	for(int i=1;i<=amount;i++) {
    		dp[i]=-1;
    		for(int coin:coins) {
    			if(i-coin<0)
    				break;
    			if(dp[i-coin]!=-1) {
        			dp[i]=dp[i]==-1?dp[i-coin]+1:Math.min(dp[i-coin]+1,dp[i]);
    			}
    		}
    	}
    	return dp[amount];
    }
    
    public static void main(String[] args) {
		LC322M lc = new LC322M();
		int[] coins = {1};
		int amount = 2;
		System.out.println(lc.coinChange(coins, amount));
	}
}
