package yawen;

import java.util.*;

public class LC22M {
    public List<String> generateParenthesis(int n) {
    	ArrayList<Set<String>> dp = new ArrayList<>();
    	Set<String> temp = new HashSet<>();
    	dp.add(temp);
    	temp.add("()");
    	dp.add(temp);
//    	System.out.println(dp.get(1));
    	for(int i =2;i<=n;i++) {
    		Set<String> set = new HashSet<>();
			Set<String>dpk = dp.get(i-1);
			for(String s1:dpk)
    			set.add("("+s1+")");
    		for(int j=1;j<i;j++) {
    			Set<String>dpi = dp.get(j);
    			Set<String>dpj = dp.get(i-j);
    			for(String s1:dpi) {
    				for(String s2:dpj) {
    					set.add(s1+s2);
    				}
    			}
    		}
    		dp.add(set);
    	}
    	List<String> ans = new ArrayList<String>();
    	for(String s:dp.get(n)) {
    		ans.add(s);
    	}
    	return ans;
    }
    public static void main(String[] args) {
		LC22M lc = new LC22M();
		System.out.println(lc.generateParenthesis(8));
	}
}
