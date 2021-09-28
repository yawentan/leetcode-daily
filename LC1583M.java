package yawen;

import java.util.*;

public class LC1583M {
	@org.junit.Test
	public void test() {
		int n = 4;
		int[][] preferences = {{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}};
		int[][] pairs = {{0, 2}, {1, 3}};
		System.out.println(unhappyFriends(n,preferences,pairs));
	}
	
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    	Set<Integer> s = new HashSet<>();
    	HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
    	for(int i=0;i<pairs.length;i++) {
    		hash.put(pairs[i][0],pairs[i][1]);
    		hash.put(pairs[i][1],pairs[i][0]);
    	}
    	
    	for(int i=0;i<n;i++) {
    		if(s.contains(i))
    			continue;
    		int iy = hash.get(i);
    		for(int j=0;j<n;j++) {
    			if(preferences[i][j]==iy)
    				break;
    			int u = preferences[i][j];
        		for(int iv=0;iv<n;iv++) {
        			if(preferences[u][iv]==hash.get(u))
        				break;
        			if(preferences[u][iv]==i) {
        				s.add(i);
        				s.add(u);
        				break;
        			}
        		}
    		}
    	}
    	return s.size();
    }
}
