package yawen;

import java.util.HashMap;

public class LC446 {
    public int numberOfArithmeticSlices(int[] nums) {
    	int ans=0;
    	HashMap<Long,Integer>[] map = new HashMap[nums.length];
    	for(int i=0;i<nums.length;i++) {
    		map[i] = new HashMap<>();
    	}
    	for(int i=0;i<nums.length;i++) {
    		for(int j=0;j<i;j++) {
    			long d=1L*nums[i]-nums[j];
    			int temp = map[i].getOrDefault(d, 0)+map[j].getOrDefault(d,0)+1;
    			map[i].put(d, temp);
    			ans+=map[j].getOrDefault(d,0);
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	int[] nums = {2,4,6,8,10};
    	LC446 lc = new LC446();
    	System.out.println(lc.numberOfArithmeticSlices(nums));
	}
}
