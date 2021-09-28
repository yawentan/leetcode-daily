package yawen;

import java.util.*;

public class LC15M {
    public List<List<Integer>> threeSum(int[] nums) {
    	Set<List<Integer>> ans = new HashSet<List<Integer>>();
    	List<List<Integer>> ans2 = new LinkedList<List<Integer>>();
    	Arrays.sort(nums);
    	
    	for(int i=0;i<nums.length;i++) {
    		for(int j=i+1;j<nums.length;j++) {
    			int idx;
    			int target = -(nums[i]+nums[j]);
    			idx = BinarySearch(nums,j+1,nums.length,target);
    			if(idx!=-1) {
        			List<Integer> res = new LinkedList<>();
    				res.add(nums[i]);
    				res.add(nums[j]);
    				res.add(nums[idx]);
    				ans.add(res);
    			}
    		}
    	}
    	for(List<Integer> l:ans) {
    		ans2.add(l);
    	}
    	
    	return ans2;
    }

	private int BinarySearch(int[] nums, int i, int j, int target) {
		int l = i,r=j;
		while(l<r) {
			int m = l + (r-l)/2;
			if(nums[m]>target) {
				r = m;
			}else if(nums[m]<target) {
				l = m+1;
			}else
				return m;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		LC15M lc = new LC15M();
		int[] nums = {0};
		System.out.println(lc.threeSum(nums));
	}
}
