package yawen;

import java.util.Stack;

public class LC32H {
    public int longestValidParentheses(String s) {
    	Stack<Character> st = new Stack<Character>();
    	int[] dp = new int[s.length()];
    	int ans = 0;
    	for(int i=0;i<s.length();i++) {
    		if(s.charAt(i)=='(') {
    			st.add('(');
    		}else {
    			if(!st.isEmpty()) {
    				st.pop();
    				dp[st.size()] = dp[st.size()]+dp[st.size()+1]+2;
    				dp[st.size()+1] = 0;
    				ans = Math.max(ans, dp[st.size()]);
    			}else {
    				dp = new int[s.length()];
    			}
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	LC32H lc = new LC32H();
    	String[] s = {"((()))())","((())))(((())))","((()(()())((()","(()",")()())",""};
    	for(String ss:s) {
    		System.out.println(lc.longestValidParentheses(ss));
    	}
	}
}
