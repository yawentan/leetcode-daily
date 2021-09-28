package yawen;

import java.util.Arrays;

import org.junit.Test;

public class LC650M {
	@Test
	public void test() {
		System.out.println(minSteps(50));
	}
	
	    public int minSteps(int n) {
	        int[][] dp = new int[n+1][n+1];
	        for(int i=1;i<=n;i++){
	            for(int j=1;j<=n;j++){
	            	dp[i][j]=10000;
	            }
	        }
	        dp[1][1]=1;
	        int ans = 0;
	        for(int i=2;i<=n;i++){
	        	ans = 10000;
	            for(int j=i-1;j>=1;j--){
	                dp[i][j] = 1+dp[i-j][j];
	                ans = Math.min(dp[i][i], ans);
	                ans = Math.min(dp[i][j], ans);
	            }
	            dp[i][i] = 1+ans;
	        }
	        return ans;
	    }
}
