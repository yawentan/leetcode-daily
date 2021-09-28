package yawen;

import java.util.HashMap;

public class LC1711M {
    public int countPairs(int[] deliciousness) {
    	HashMap<Integer,Integer> Tab = new HashMap<>();
    	int ans = 0;
    	int Mod = 1000000000+7;
    	for(int i=0;i<deliciousness.length;i++) {
    		for(int k=0;k<=21;k++) {
    			int temp = (int) (Math.pow(2, k)-deliciousness[i]);
    			if(Tab.containsKey(temp)) {
    				ans=(ans+Tab.get(temp))%Mod;
    			}
    		}
			if(Tab.containsKey(deliciousness[i])) {
				Tab.put(deliciousness[i], Tab.get(deliciousness[i])+1);
			}else {
				Tab.put(deliciousness[i], 1);
			}
    	}
    	return ans%Mod;
    }
    
    public static void main(String[] args) {
		int[] deliciousness = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
		LC1711M lc = new LC1711M();
		System.out.println(lc.countPairs(deliciousness));
	}
}
