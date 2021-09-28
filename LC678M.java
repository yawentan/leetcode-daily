package yawen;

import java.util.*;

public class LC678M {
	@org.junit.Test
	public void test() {
		//(((((*(((((*)*(**)))))))))))
		//((((*)))))
		//(*)
//		String s = "((*)*)*)((*";
		String s = "()";
//		System.out.println(s.length());
		System.out.println(checkValidString(s));
	}
	
    public boolean checkValidString(String s) {
    	int[][] dp = new int[s.length()+1][2];
    	for(int i=1;i<=s.length();i++) {
    		if(s.charAt(i-1)=='(') {
    			dp[i][0]=dp[i-1][0]+1;
    			dp[i][1]=dp[i-1][1]+1;
    		}else if(s.charAt(i-1)==')') {
    			dp[i][0]=dp[i-1][0]-1;
    			dp[i][1]=dp[i-1][1]-1;
    		}else {
    			dp[i][0]=dp[i-1][0]-1;
    			dp[i][1]=dp[i-1][1]+1;
    		}
    		dp[i][0] = Math.max(0, dp[i][0]);
    		if(dp[i][1]<0)
    			return false;
    	}
    	return dp[s.length()][0]==0;
//    	return dfs(0,0,s);
    }

	private boolean dfs(int leftCount, int i, String s) {
		if(i==s.length()) {
			return leftCount==0;
		}
		
		if(s.charAt(i)=='*') {
			return dfs(leftCount+1,i+1,s)||dfs(leftCount,i+1,s)||(leftCount>0?dfs(leftCount-1,i+1,s):false);
		}
		
		if(s.charAt(i)=='(') {
			leftCount++;
		}else if(s.charAt(i)==')') {
			if(leftCount==0) {
				return false;
			}
			leftCount--;
		}
		return dfs(leftCount,i+1,s);
	}

	private List<Character> copy(List<Character> temp) {
		List<Character> ans = new LinkedList<>();
		for(char k:temp) {
			ans.add(k);
		}
		return ans;
	}
}
