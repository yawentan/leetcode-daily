package yawen;

public class LC55 {
    public boolean canJump(int[] nums) {
    	int max = 0;
    	for(int i=0;i<nums.length;i++) {
    		max = nums[i]+i;
    	}
    	return max>nums.length?true:false;
    }
    
    public static void main(String[] args) {
		LC55 lc =  new LC55();
		int[] nums = {3,2,1,0,4};
		System.out.println(lc.canJump(nums));
	}
}
