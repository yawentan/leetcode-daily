package yawen;

import java.util.*;

public class LC581M {
    public int findUnsortedSubarray(int[] nums) {
    	Stack<Integer> l = new Stack<>();
    	Stack<Integer> r = new Stack<>();
    	
    	l.push(0);
    	int i = 1;
    	while(i<nums.length&&nums[i]>=nums[l.peek()]) {
    		l.push(i);
    		i++;
    	}
    	while(!l.isEmpty()&&i<nums.length) {
    		while(!l.isEmpty()&&nums[i]<nums[l.peek()]) {
    			l.pop();
    		}
    		i++;
    	}
    	int lidx = l.isEmpty()?0:l.pop()+1;
    	r.push(nums.length-1);
    	i=nums.length-2;
    	while(i>=0&&nums[i]<=nums[r.peek()]) {
    		r.push(i);
    		i--;
    	}
    	while(!r.isEmpty()&&i>=0) {
    		while(!r.isEmpty()&&nums[i]>nums[r.peek()])
    			r.pop();
    		i--;
    	}
    	int ridx = r.isEmpty()?nums.length-1:r.pop()-1;
    	return (ridx-lidx+1)>0?(ridx-lidx+1):0;
    }
}
