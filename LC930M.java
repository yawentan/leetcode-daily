package yawen;

public class LC930M {
	/**
	 * 滑动窗口,错误；
	 * 正确解法是前缀和
	 * @param nums
	 * @param goal
	 * @return
	 */
    public int numSubarraysWithSum(int[] nums, int goal) {
    	int ans = 0;
    	int[] Tab = new int[nums.length+1];
    	int[] pre = new int[nums.length];
    	Tab[0]++;
    	for(int i=0;i<nums.length;i++) {
    		if(i!=0) {
    			pre[i]=pre[i-1]+nums[i];
    		}else
    	    	pre[0]=nums[0];
    		if(pre[i]>=goal)
    			ans+=Tab[pre[i]-goal];
			Tab[pre[i]]++;
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
		int[] nums = {1};
		int goal =1;
		LC930M lc = new LC930M();
		System.out.println(lc.numSubarraysWithSum(nums, goal));
	}
}
