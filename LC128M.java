package yawen;

import java.util.*;

public class LC128M {
	@org.junit.Test
	public void test() {
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));
	}
	
	int[] fa;
    public int longestConsecutive(int[] nums) {
    	TreeSet<Integer> set = new TreeSet<>();
    	for(int n:nums) {
    		set.add(n);
    	}
    	int r;
    	int ans = 0;
    	while(!set.isEmpty()) {
    		r=1;
    		int temp = set.first();
    		set.remove(temp);
    		while(set.contains(temp+r)) {
        		set.remove(temp+r);
        		r++;
    		}
    		ans=Math.max(r, ans);
    	}
    	return ans;
    }
    
    //Â·¾¶Ñ¹ËõÕÒ
    private int find(int i) {
    	if(fa[i]==i)
    		return i;
    	fa[i]=find(fa[i]);
    	return fa[i];
    }
}
