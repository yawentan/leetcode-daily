package yawen;

class Solution {
    public int removeDuplicates(int[] nums) {
    	if(nums.length<=1)
    		return nums.length;
    	int idx = 1;
    	int value = nums[0];
    	for(int i=1;i<nums.length;i++) {
    		if(value!=nums[i]) {
    			value = nums[i];
    			nums[idx]=nums[i];
    			idx++;
    		}
    	}
    	return idx;
    }
}

public class LC26 {

	public static void main(String[] args) {
		Solution st = new Solution();
		int[] nums = {1,2,3,4,4,5,6,7,7,7};
		System.out.println(st.removeDuplicates(nums));
	}
}
