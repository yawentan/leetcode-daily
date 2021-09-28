package yawen;

import java.util.*;

public class LC1109M {
	@org.junit.Test
	public void test() {
		System.out.println(1);
	}
	
    public int[] corpFlightBookings1(int[][] bookings, int n) {
		int[] res = new int[n];
		Map<Integer,List<Integer>> s = new HashMap<>();
		Map<Integer,List<Integer>> e = new HashMap<>();
		for(int[] book:bookings) {
			List<Integer> list = s.getOrDefault(book[0], new LinkedList<>());
			list.add(book[2]);
			s.put(book[0], list);
			list = e.getOrDefault(book[1], new LinkedList<>());
			list.add(book[2]);
			e.put(book[1], list);
		}
		int ans = 0;
    	for(int i=1;i<=n;i++) {
			//½ø
    		List<Integer> list = s.getOrDefault(i,new LinkedList<>());
    		
    		for(int k:list) {
    			ans+=k;
    		}
    		res[i-1]=ans;
    		//³ö
    		list = e.getOrDefault(i, new LinkedList<>());
    		for(int k:list) {
    			ans-=k;
    		}
    	}
    	return res;
    }
    public int[] corpFlightBookings(int[][] bookings, int n) {
    	int[] dec = new int[n];
    	for(int[] book:bookings) {
    		dec[book[0]-1]+=book[2];
    		dec[book[1]]-=book[2];
    	}
    	int[] pre = new int[n];
    	pre[0]=dec[0];
    	for(int i=1;i<n;i++) {
    		pre[i]=pre[i-1]+dec[i];
    	}
    	return pre;
    }
}
