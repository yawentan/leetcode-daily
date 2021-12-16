package yawen;

public class LC456H {
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    	int count = (minutesToTest-1)/minutesToDie+1;
    	int[][] dp = new int[1001][count+1];
    	dp[1][1]=1;
    	for(int i=2;i<1001;i++) {
    		dp[i][1] = (int) (Math.log(i-1)/Math.log(2))+1;
    	}
    	for(int i=2;i<buckets+1;i++) {
	    	for(int j=2;j<=count;j++) {
	    		dp[i][j]=Integer.MAX_VALUE;
	    		for(int k=2;k<=i;k++) {
	    			dp[i][j] = Math.min(dp[(i-1)/k+1][j-1]+ dp[k-1][1],dp[i][j]);
	    		}
	    	}
    	}
		return dp[buckets][1]-count+1<0?dp[buckets][1]:dp[buckets][1]-count+1;
    }
    public static void main(String[] args) {
    	System.out.println(LC456H.poorPigs(256,15,45));
	}
}
