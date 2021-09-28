package yawen;

import java.util.*;

public class LC673M {
	@org.junit.Test
	public void test() {
		int[] nums = {1,1,1,2,2,2,3,3,3};
		System.out.println(findNumberOfLIS(nums));
	}
	
    public int findNumberOfLIS(int[] nums) {
    	int[] dp = new int[nums.length];
    	int[] count = new int[nums.length];
    	for(int i=0;i<nums.length;i++) {
    		dp[i]=1;
    		count[i]=1;
    	}
    	for(int i=0;i<nums.length;i++) {
    		for(int j=0;j<i;j++) {
    			if(nums[i]>nums[j]) {
    				if(dp[i] == dp[j]+1) {
    					count[i]+=count[j];
    				}else if(dp[i]<dp[j]+1){
    					dp[i]=dp[j]+1;
    					count[i]=count[j];
    				}
    			}
    		}
    	}
    	int ans = 0;
    	int MaxLen = -1;
    	for(int i=0;i<nums.length;i++) {
    		if(dp[i]==MaxLen) {
    			ans+=count[i];
    		}else if(dp[i]>MaxLen) {
    			MaxLen=dp[i];
    			ans = count[i];
    		}
    	}
    	return ans;
    }


}
