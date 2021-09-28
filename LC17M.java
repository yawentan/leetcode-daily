package yawen;

import java.util.*;

public class LC17M {
	List<String> ans = new LinkedList<String>();
    public List<String> letterCombinations(String digits) {
    	dfs(0,new StringBuffer(),digits);
    	return this.ans;
    }
    
    private void dfs(int i, StringBuffer s, String digits) {
    	if(i==digits.length()) {
    		ans.add(s.toString());
    		return;
    	}
    	if(digits.charAt(i)=='2') {
    		dfs(i+1,s.append('a'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('b'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('c'),digits);
    		s.deleteCharAt(i);
    	}else if(digits.charAt(i)=='3') {
    		dfs(i+1,s.append('d'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('e'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('f'),digits);
    		s.deleteCharAt(i);
    	}else if(digits.charAt(i)=='4') {
    		dfs(i+1,s.append('g'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('h'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('i'),digits);
    		s.deleteCharAt(i);
    	}else if(digits.charAt(i)=='5') {
    		dfs(i+1,s.append('j'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('k'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('l'),digits);
    		s.deleteCharAt(i);
    	}else if(digits.charAt(i)=='6') {
    		dfs(i+1,s.append('m'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('n'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('o'),digits);
    		s.deleteCharAt(i);
    	}else if(digits.charAt(i)=='7') {
    		dfs(i+1,s.append('p'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('q'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('r'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('s'),digits);
    		s.deleteCharAt(i);
    	}else if(digits.charAt(i)=='8') {
    		dfs(i+1,s.append('t'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('u'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('v'),digits);
    		s.deleteCharAt(i);
    	}else if(digits.charAt(i)=='9') {
    		dfs(i+1,s.append('w'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('x'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('y'),digits);
    		s.deleteCharAt(i);
    		dfs(i+1,s.append('z'),digits);
    		s.deleteCharAt(i);
    	}
	}

	public static void main(String[] args) {
    	LC17M lc = new LC17M();
    	String s = "23";
    	System.out.println(lc.letterCombinations(s));
	}
}
