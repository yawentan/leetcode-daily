package yawen;

import java.util.Arrays;

public class LC16M {
    public int threeSumClosest(int[] nums, int target) {
    	int ans = Integer.MAX_VALUE;
    	int last = Integer.MAX_VALUE;
    	Arrays.sort(nums);
    	
    	for(int i=1;i<nums.length-1;i++) {
    		int l = i-1;
    		int r = i+1;
    		while(l>=0&&r<nums.length) {
	    		int sum = nums[l]+nums[i]+nums[r];
	    		if(sum>target) {
	    			l--;
	    		}else if(sum<target) {
	    			r++;
	    		}else
	    			return target;
	    		if(Math.abs(target-sum)<last) {
	    			last = Math.abs(target-sum);
	    			ans = sum;
	    		}
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = {1,89,21,2,5,519,81,56,123,198,5,12,16,51,23,1,6,5,2};
		int target = 510;
		LC16M lc = new LC16M();
		System.out.println(lc.threeSumClosest(nums, target));
	}
}
