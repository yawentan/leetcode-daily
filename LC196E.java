package yawen;

import java.util.*;

public class LC196E {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        int[] res = new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--) {
        	while(!s.isEmpty()&&nums2[i]>s.peek()) {
        		s.pop();
        	}
        	if(s.isEmpty()) {
        		ans.add(-1);
        	}else {
        		ans.add(s.peek());
        	}
        	s.add(nums2[i]);
        }
        
        for(int i=0;i<nums1.length;i++) {
            for(int idx=0;idx<nums2.length;idx++) {
            	if(nums1[i]==nums2[idx]) {
            		res[i]=ans.get(nums2.length-idx-1);
            	}
            }
        }
        return res;
    }
}
