package yawen;

import java.util.*;

public class LC413M {
    public int numberOfArithmeticSlices(int[] nums) {
    	int ans = 0;
    	if(nums.length<3){
    		return 0;
    	}
    	int[] dp = new int[nums.length];
    	dp[0]=0;dp[1]=0;
    	for(int i=2;i<nums.length;i++) {
    		int d = nums[i]-nums[i-1];
    		if(nums[i-1]-nums[i-2]==d)
    			dp[i]=dp[i-1]+1;
    		ans+=dp[i];
    	}
    	return ans;
    }
    public static void main(String[] args) {
    	LC413M lc = new LC413M();
    	int[] nums= {1,2,3,4,5,6,1,2,3,4};
    	System.out.println(lc.numberOfArithmeticSlices(nums));
	}
}
