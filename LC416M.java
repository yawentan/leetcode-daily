package yawen;

import java.util.Arrays;

public class LC416M {
    public boolean canPartition(int[] nums) {
    	Arrays.sort(nums);
    	int sum = 0;
    	int Max = nums[0];
    	for(int i=0;i<nums.length;i++) {
    		sum+=nums[i];
    		Max = Math.max(Max, nums[i]);
    	}
    	if(sum%2==1||Max>sum/2)
    		return false;
    	int t = sum/2;
    	boolean[][] dp = new boolean[nums.length][t+1];

    	for(int i=0;i<nums.length;i++) {
    		dp[i][0]=true;
    	}
		dp[0][nums[0]]=true;
    	for(int i=1;i<nums.length;i++) {
    		for(int j=1;j<=t;j++) {
    			dp[i][j] = dp[i-1][j]||(j>=nums[i]?dp[i-1][j-nums[i]]:false);
    		}
    	}
    	
    	return dp[nums.length-1][t];
    }

	private boolean dfs(int[] nums, int idx, int t, int s) {
		if(s==t) 
			return true;
		if(s>t)
			return false;
		int last=-1;
		for(int i=idx+1;i<nums.length;i++) {
			if(nums[i] == last)
				continue;
			if(dfs(nums, i, t, s+nums[i]))
				return true;
			last = nums[i];
		}
		return false;
	}
	public static void main(String[] args) {
		LC416M lc = new LC416M();
		int[] nums = {1,2,3,5};
		System.out.println(lc.canPartition(nums));
	}
}
