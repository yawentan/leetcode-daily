package yawen;

import java.util.HashMap; //ÒıÈëHashMap
import java.util.Stack;

public class LC20 {
	class Solution {
	    public boolean isValid(String s) {
	    	Stack<Character> stack = new Stack<>();
	    	HashMap<Character,Character> hash = new HashMap<>();
	    	hash.put(')', '(');
	    	hash.put(']', '[');
	    	hash.put('}', '{');
	    	for(int i=0;i<s.length();i++) {
	    		if(hash.containsKey(s.charAt(i)))
	    			if(stack.isEmpty()||stack.pop()!=hash.get(s.charAt(i))) {
	    	    		System.out.println(s.charAt(i));
	    				return false;
	    			}else
	    				continue;
	    		else
	    			stack.push(s.charAt(i));
	    		}
	    	return stack.isEmpty();
	    }
	}
	public static void main(String args[]) {
		LC20 LC = new LC20();
		Solution st = LC.new Solution();
		String s="()[]{}";
		System.out.println(st.isValid(s));
	}
}
