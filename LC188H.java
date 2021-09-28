package yawen;

/*
 * @author:yawen
 * @description:思路来源于算法小抄，这种dp题目，主要是列出状态，和找到转移矩阵。
 * 
 */
public class LC188H {
    public static int maxProfit(int k, int[] prices) {
    	if(prices.length==0)
    		return 0;
    	int dp[][][] = new int[prices.length][k+1][2];
    	for(int i=0;i<prices.length;i++) dp[i][0][0]=0;
    	for(int kk=1;kk<k+1;kk++) {dp[0][kk][0]=0;dp[0][kk][1]=-prices[0];}
    	
    	for(int i=1;i<prices.length;i++) {
    		for(int kk=1;kk<k+1;kk++) {
    			dp[i][kk][0]=Math.max(dp[i-1][kk][0], dp[i-1][kk][1]+prices[i]);
    			dp[i][kk][1]=Math.max(dp[i-1][kk][1], dp[i-1][kk-1][0]-prices[i]);
    		}
    	}
    	return dp[prices.length-1][k][0];
    }
	
	public static void main(String[] args) {
		int k = 3, prices[] = {5,4,3,2,1};
		System.out.println(maxProfit(k,prices));
	}
}
