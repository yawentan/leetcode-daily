package yawen;

import java.util.*;

public class LC457M {
    public boolean circularArrayLoop(int[] nums) {
    	int idx = 0;
    	for(int i=0;i<nums.length;i++) {
    		boolean flag;
    		int[] visited = new int[5001];
    		idx = i;
    		int count = 1;
    		visited[idx]=count;
			count++;
			if(nums[i]>0)
    			flag = true;
    		else
    			flag = false;
    		while(true) {
    			if(flag) {
        			idx = (idx+nums[idx])%nums.length;
    				if(nums[idx]<0)
    					break;
    			}else {
    				int temp = nums[idx];
    				while(idx+temp<0) {
    					idx+=nums.length;
    				}
        			idx = (idx+temp);
    				if(nums[idx]>0)
    					break;
    			}
    			if(visited[idx]!=0) {
    				if(count-visited[idx]>1)
        				return true;
    				else
    					break;
    			}
    			visited[idx]=count;
    			count++;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
    	int[] nums = {-1,2};
    	LC457M lc = new LC457M();
    	System.out.println(lc.circularArrayLoop(nums));
	}
}
