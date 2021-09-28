package yawen;

import java.util.Arrays;

public class LC31M {
    public void nextPermutation(int[] nums) {
    	for(int i=nums.length-2;i>=0;i--) {
    		for(int j=nums.length-1;j>i;j--) {
    			if(nums[j]>nums[i]) {
    				int temp = nums[i];
    				nums[i] = nums[j];
    				nums[j] = temp;
    				for(int ii=i+1;ii<nums.length;ii++) {
    					for(int jj=ii+1;jj<nums.length;jj++) {
    		    			if(nums[jj]<nums[ii]) {
    		    				int temp2 = nums[ii];
    		    				nums[ii] = nums[jj];
    		    				nums[jj] = temp2;
    		    			}
    					}    					
    				}
    				return;
    			}
    		}
    	}
    	int l=0,r=nums.length-1;
    	while(l<r) {
			int temp = nums[l];
			nums[l] = nums[r];
			nums[r] = temp;
			l++;
			r--;
    	}
    }
    
    public static void main(String[] args) {
    	LC31M lc = new LC31M();
    	int[] nums = {1,3,2};
    	lc.nextPermutation(nums);
    	System.out.println();
	}
}
