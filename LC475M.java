package yawen;

import java.util.*;

public class LC475M {
	public static void main(String[] args) {
		LC475M lc = new LC475M();
		int[] houses = {1,5}, heaters = {10};
		System.out.println(lc.findRadius(houses, heaters));
	}
    public int findRadius(int[] houses, int[] heaters) {
    	TreeSet<Integer> set = new TreeSet<>();
    	for(int heater:heaters) {
    		set.add(heater);
    	}
    	int ans = 0;
    	for(int house:houses) {
    		if(set.contains(house)) {
    			continue;
    		}
    		Integer lower = set.lower(house);
    		Integer higher = set.higher(house);
    		//都为null的情况不符合题意
    		if(lower==null) {
    			lower = Integer.MIN_VALUE+house+1;
    		}
    		if(higher==null) {
    			higher = Integer.MAX_VALUE;
    		}
			ans = Math.max(ans, Math.min(house-lower, higher-house));
    	}
    	return ans;
    }
}
