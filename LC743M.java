package yawen;

import java.util.*;

public class LC743M {
    public int networkDelayTime(int[][] times, int n, int k) {
    	int[][] map = new int[n+1][n+1];
    	int[] dp = new int[n+1];
    	for(int i=0;i<=n;i++) {
        	for(int j=0;j<=n;j++) {
        		map[i][j]=-1;
        	}
    	}
    	for(int i=0;i<times.length;i++) {
    		map[times[i][0]][times[i][1]]=times[i][2];
    	}
    	for(int i=0;i<=n;i++) {
    		dp[i]=-1;
    	}
    	int ans = 0;
    	dp[k]=0;
    	Queue<Integer> q = new LinkedList<>();
    	q.add(k);
    	while(!q.isEmpty()) {
    		int sz = q.size();
    		for(int i=0;i<sz;i++) {
    			int idx = q.poll();
    			for(int j=1;j<=n;j++) {
    				if(map[idx][j]!=-1) {
    					if(dp[j]==-1||dp[j]>dp[idx]+map[idx][j]) {
    						q.add(j);
    						dp[j] = dp[idx]+map[idx][j];
    					}
    				}
    			}
    		}
    	}
    	for(int i=1;i<=n;i++) {
    		if(dp[i]==-1)
    			return -1;
    		ans = Math.max(ans, dp[i]);
    	}
    	return ans==0?-1:ans;
    }
    
    public static void main(String[] args) {
    	int[][] nums = {{3,5,78},{2,1,1},{1,3,0},{4,3,59},{5,3,85},{5,2,22},{2,4,23},{1,4,43},{4,5,75},{5,1,15},{1,5,91},{4,1,16},{3,2,98},{3,4,22},{5,4,31},{1,2,0},{2,5,4},{4,2,51},{3,1,36},{2,3,59}};
    	int n = 5;
    	int k = 5;
    	LC743M lc = new LC743M();
    	System.out.println(lc.networkDelayTime(nums, n, k));
	}
}
