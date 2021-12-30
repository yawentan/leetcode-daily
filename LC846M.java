package yawen;

import java.util.*;

public class LC846M {
	public static void main(String[] args) {
		int[] nums = {1,2,3,6,2,3,4,7,8};
		int gs = 3;
		System.out.println(isNStraightHand(nums,gs));
	}
	
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int k:hand) {
        	treeMap.put(k,treeMap.getOrDefault(k,0)+1);
        }
        while(treeMap.size()!=0) {
        	Integer lastKey = treeMap.firstKey();
        	for(int i=0;i<groupSize;i++) {
        		if(treeMap.getOrDefault(lastKey+i, 0)!=0) {
                	treeMap.put(lastKey+i,treeMap.get(lastKey+i)-1);
                	if(treeMap.get(lastKey+i)==0) {
                		treeMap.remove(lastKey+i);
                	}
        		}else
        			return false;
        	}
        }
        return true;
    }
}
