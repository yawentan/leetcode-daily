package yawen;

import org.junit.Test;

public class LC526M {
	@Test
	public void test() {
		System.out.println(countArrangement(1));
	}
	
    public int countArrangement(int n) {
    	int Max = (int) Math.pow(2, n);
    	int[] dp = new int[Max];
    	for(int i=0;i<Max;i++) dp[i]=-1;
    	int res = dfs(0,0,dp,n);
    	return res;
    }
    private int dfs(int visited,int i,int[] dp,int n) {
    	if(i==n) {
    		return 1;
    	}
    	int temp = visited;
    	if(dp[visited]!=-1)
    		return dp[visited];
    	dp[temp] = 0;
    	for(int k=0;k<n;k++) {
    		if((visited&1<<k)==0) {
    			if((k+1)%(i+1)==0||(i+1)%(k+1)==0) {
    				visited|=1<<k;
    				dp[temp] += dfs(visited,i+1,dp,n);
    				visited=temp;
    			}
    		}
    	}
    	return dp[visited];
    }
}
