package yawen;

public class LC552H {
	@org.junit.Test
	public void test() {
		System.out.println(checkRecord(10101));
	}
	
    public int checkRecord(int n) {
    	long Mod = 1000000000 + 7;
    	long[][][] dp = new long[n][3][2];
    	dp[0][0][0] = 1;
    	dp[0][0][1] = 1;
    	dp[0][1][0] = 1;
    	dp[0][1][1] = 0;
    	dp[0][2][0] = 0;
    	dp[0][2][1] = 0;
    	for(int i=1;i<n;i++) {
    		dp[i][0][0] = (dp[i-1][0][0]+dp[i-1][1][0]+dp[i-1][2][0])%Mod;
    		dp[i][0][1] = (dp[i-1][0][0]+dp[i-1][1][0]+dp[i-1][2][0]+dp[i-1][0][1]+dp[i-1][1][1]+dp[i-1][2][1])%Mod;
    		dp[i][1][0] = (dp[i-1][0][0])%Mod;
    		dp[i][1][1] = (dp[i-1][0][1])%Mod;
    		dp[i][2][0] = (dp[i-1][1][0])%Mod;
    		dp[i][2][1] = (dp[i-1][1][1])%Mod;
    	}
    	return (int) ((dp[n-1][0][0]+dp[n-1][0][1]+dp[n-1][1][0]+dp[n-1][1][1]+dp[n-1][2][0]+dp[n-1][2][1])%Mod);
    }
}
