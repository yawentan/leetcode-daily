package yawen;

import java.util.Random;

public class LC528M {
	class Solution {
		int sum;
		int[] pre;
	    public Solution(int[] w) {
	    	sum=0;
	    	pre = new int[w.length];
	    	for(int i=0;i<w.length;i++) {
	    		if(i-1>=0)
	    			pre[i]=pre[i-1]+w[i];
	    		else
	    			pre[i]=w[i];
	    		sum+=w[i];
	    	}
	    }
	    
	    public int pickIndex() {
	    	Random rd = new Random();
	    	double temp = rd.nextDouble();
	    	temp*=sum;
	    	int idx = binarySearch(pre,temp);
	    	return idx;
	    }

		private int binarySearch(int[] nums, double t) {
			int l=0,r=nums.length;
			while(l<r) {
				int m = l+(r-l)/2;
				if(t>nums[m]) {
					l=m+1;
				}else if(t<nums[m]) {
					r = m;
				}else {
					return m;
				}
			}
			return l;
		}
	}
	@org.junit.Test
	public void test() {
		int[] w = {1,1,1,1,1};
		int[] tab = new int[w.length];
		Solution s =new Solution(w);
		for(int i=0;i<250000;i++) {
			int t = s.pickIndex();
			tab[t]++;
		}
		for(int i=0;i<tab.length;i++) {
			System.out.println(tab[i]);
		}
	}
}
