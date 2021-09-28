package yawen;

import java.util.*;

public class LC18M {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	Set<List<Integer>> ans = new HashSet<>();
    	Arrays.sort(nums);
    	
    	for(int i=0;i<nums.length;i++) {
    		for(int j=i+1;j<nums.length;j++) {
    			for(int k=j+1;k<nums.length;k++) {
    				int t = target-(nums[i]+nums[j]+nums[k]);
    				int idx = BinarySearch(nums,k+1,nums.length,t);
    				if(idx!=-1) {
    					List<Integer> l = new LinkedList<>();
    					l.add(nums[i]);
    					l.add(nums[j]);
    					l.add(nums[k]);
    					l.add(nums[idx]);
    					ans.add(l);
    				}
    			}
    		}
    	}
    	List<List<Integer>> res = new LinkedList<>();
    	
    	for(List<Integer>l:ans) {
    		res.add(l);
    	}
    	return res;
    }

	private int BinarySearch(int[] nums, int i, int j, int t) {
		int l = i,r = j;
		while(l<r) {
			int m = l + (r-l)/2;
			if(nums[m]>t) {
				r=m;
			}else if(nums[m]<t) {
				l = m + 1;
			}else
				return m;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		LC18M lc = new LC18M();
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		System.out.println(lc.fourSum(nums, target));
	}
}
