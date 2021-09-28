package yawen;

import yawen.datastruct.*;

public class LC96M {
    public static int numTrees(int n) {
    	int[] dp = new int[n+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	for(int k = 2;k<=n;k++) {
	    	for(int i=1;i<=k;i++) {
	    		dp[k] += dp[k-i]*dp[i-1]; 
	    	}
    	}
    	for(int k = 2;k<=n;k++) {
    		System.out.println(dp[k]);
    	}
    	return dp[n];
    }
    public static void main(String[] args) {
    	System.out.println(numTrees(8));
    }
}
