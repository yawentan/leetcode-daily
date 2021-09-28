package yawen;


public class LC27 {
	class Solution {
	    public int removeElement(int[] nums, int val) {
	    	if(nums.length<=0)
	    		return nums.length;
	    	int idx = 0;
	    	for(int i=0;i<nums.length;i++) {
	    		if(val!=nums[i]) {
	    			nums[idx]=nums[i];
	    			idx++;
	    		}
	    	}
	    	for(int i=0;i<idx;i++) {
	    		System.out.println(nums[i]);
	    	}
		    return idx;
	    }
	}
	public static void main(String[] args) {
		LC27 LC = new LC27();
		Solution st = LC.new Solution();
		int[] nums = {0,1,2,2,3,0,4,2};
		int value = 2;
		System.out.println(st.removeElement(nums,value));
	}
}
