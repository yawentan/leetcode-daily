package yawen;

import java.util.*;

public class LCP07E {
    public int numWays(int n, int[][] relation, int k) {
    	int ans = 0;
    	int step = 0;
    	HashMap<Integer,List<Integer>> hash = new HashMap<>();
    	for(int i=0;i<relation.length;i++) {
    		if(hash.containsKey(relation[i][0])) {
    			hash.get(relation[i][0]).add(relation[i][1]);
    		}else {
    			List<Integer> l = new LinkedList<>();
    			l.add(relation[i][1]);
    			hash.put(relation[i][0], l);
    		}
    	}
    	//BFS
    	Queue<Integer> q = new LinkedList<>();
    	q.add(0);
    	while(!q.isEmpty()) {
    		int sz = q.size();
    		for(int i=0;i<sz;i++) {
    			if(step>k)
    				return ans;
    			int temp = q.poll();
    			if(temp==n-1&&step==k) {
    				ans++;
    				continue;
    			}
    			List<Integer> l = hash.get(temp);
    			if(l==null)
    				continue;
    			for(int k1:l) {
    				q.add(k1);
    			}
    		}
    		step++;
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
		int n = 5, k = 3;
		int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
		LCP07E lc = new LCP07E();
		System.out.println(lc.numWays(n, relation, k));
	}
}
