package yawen;

import java.util.*;

public class LC447M {
	@org.junit.Test
	public void test() {
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(points));
	}
	
    public int numberOfBoomerangs(int[][] points) {
    	Map<Integer,List<Integer>>[] map = new Map[points.length];
    	for(int i=0;i<points.length;i++) {
    		map[i] = new HashMap<>();
    	}
    	for(int i=0;i<points.length;i++) {
    		for(int j=0;j<points.length;j++) {
    			if(i!=j) {
    				int d = dist(points[i],points[j]);
    				List<Integer> l = map[i].getOrDefault(d, new LinkedList<>());
    				l.add(j);
    				map[i].put(d, l);
    			}
    		}
    	}
    	int ans = 0;
    	for(int i=0;i<points.length;i++) {
    		for(int k:map[i].keySet()) {
    			ans+=(map[i].get(k).size()*(map[i].get(k).size()-1));
    		}
    	}
    	return ans;
    }

	private int dist(int[] x, int[] y) {
		// TODO Auto-generated method stub
		return (x[0]-y[0])*(x[0]-y[0])+(x[1]-y[1])*(x[1]-y[1]);
	}
}
