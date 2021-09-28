package yawen;

import java.util.*;

public class LC1714M {
	@org.junit.Test
	public void test() {
		int[] nums = {1,3,5,7,2,4,6,8};
		int t = 4;
		smallestK(nums,t);
	}
	
    public int[] smallestK(int[] arr, int k) {
    	if(k==0) {
    		return new int[0];
    	}
        int[] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
        });
        for(int i=0;i<arr.length;i++) {
        	if(pq.size()<k) {
        		pq.add(arr[i]);
        	}else {
        		if(arr[i]<pq.peek()) {
        			pq.poll();
        			pq.add(arr[i]);
        		}
        	}
        }
        int idx = 0;
        while(!pq.isEmpty()) {
        	ans[idx++]=pq.poll();
        }
        return ans;
    }
}
