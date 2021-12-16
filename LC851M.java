package yawen;

import java.util.*;

public class LC851M {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
    	Set<Integer>[] lower = new Set[quiet.length];
    	int[] q = new int[quiet.length];
    	for(int i=0;i<quiet.length;i++){
    		q[quiet[i]]=i;
    	}
    	for(int i=0;i<richer.length;i++) {
    		if(lower[richer[i][1]]==null) {
    			lower[richer[i][1]]=new HashSet<Integer>();
    		}
    		lower[richer[i][1]].add(richer[i][0]);    			
    	}
    	
    	int[] res = new int[quiet.length];
    	int[] ans = new int[quiet.length];
    	Arrays.fill(res, 501);
    	for(int i=0;i<quiet.length;i++) {
    		dfs(i,lower,res,quiet);    		
    	}
    	for(int i=0;i<ans.length;i++) {
    		ans[i]=q[res[i]];
    	}
    	return ans;
    	
//    	//bfs时间复杂度太高
//    	for(int i=0;i<ans.length;i++) {
//    		//BFS搜索所有比i小的
//    		Queue<Integer> q = new LinkedList<>();
//    		boolean[] v = new boolean[quiet.length+1];
//    		q.add(i);
//    		ans[i]= i;
//    		int minQuiet = quiet[i];
//    		v[i]=true;
//    		while(!q.isEmpty()) {
//    			int sz = q.size();
//    			for(int j=0;j<sz;j++) {
//    				int poll = q.poll();
//    				if(lower[poll]!=null) {
//    					for(int s:lower[poll]) {
//    						if(!v[s]) {
//    							q.add(s);
//    							if(minQuiet>=quiet[s]) {
//    								minQuiet = quiet[s];
//    								ans[i]=s;
//    							}
//    							v[s]=true;
//    						}
//    					}
//    				}
//    			}
//    		}
//    	}
//    	return ans;
    }

	private int dfs(int idx, Set<Integer>[] map, int[] dp, int[] quiet) {
		if(dp[idx]!=501) {
			return dp[idx];
		}
		
		if(map[idx]==null) {
			return dp[idx]=quiet[idx];
		}
		dp[idx] = quiet[idx];
		for(int node:map[idx]) {
			dp[idx]=Math.min(dfs(node,map,dp,quiet),dp[idx]);
		}
		return dp[idx];
	}
}
