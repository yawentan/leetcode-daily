package yawen;

public class LC1995E {
    public int countQuadruplets(int[] nums) {
    	int ans = 0;
    	for(int i=3;i<nums.length;i++) {
    		ans+=dfs(0,nums,0,0,i);
    	}
    	return ans;
    }
    
    private int dfs(int idx,int[] nums,int len,int sum,int target){
    	int ans = 0;
    	if(len==3&&sum==nums[target]) {
    		return 1;
    	}else if(len==3&&sum!=nums[target])
    		return 0;
    	if(idx==target||len>3) {
    		return 0;
    	}
    	if(len<3) {
    		ans+=dfs(idx+1,nums,len,sum,target);
    		ans+=dfs(idx+1,nums,len+1,sum+nums[idx],target);
    	}
    	return ans;
    }
}
