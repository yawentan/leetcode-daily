package yawen;

import java.util.*;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
    	List<Integer> d =new ArrayList<>();
    	
    	for(int n:nums) {
    		if(d.size()==0||n>d.get(d.size()-1)) {
    			d.add(n);
    		}else if(n<d.get(d.size()-1)){
    			int idx = BinarySearch(d, n);
//    			System.out.println(idx);
    			if(d.get(idx)>n) {
    				d.remove(idx);
    				d.add(idx, n);
    			}
    		}
    	}
    	return d.size();
    }
    
    private int BinarySearch(List<Integer> d, int n) {
		int l=0,r=d.size();
		while(l<r) {
			int m = l+(r-l)/2;
			if(d.get(m)>n) {
				r=m;
			}else if(d.get(m)<n) {
				l=m+1;
			}else {
				return m;
			}
		}
		return l;
	}

	public static void main(String[] args) {
    	LC300 lc = new LC300();
    	int[] nums = {10,9,2,5,3,7,101,18};
    	System.out.println(lc.lengthOfLIS(nums));
	}
}
