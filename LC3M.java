package yawen;

import java.util.*;

public class LC3M {
    public static int lengthOfLongestSubstring(String s) {
    	HashMap<Character,Integer> window = new HashMap<>();
    	int left = 0,right = 0;
    	int Max = 0;
    	while(right<s.length()) {
    		char c = s.charAt(right);
    		right++;
    		if(window.get(c)==null||window.get(c)==0)
        		window.put(c, 1);
    		else
        		window.put(c, 2);
    		
    		while(window.get(c)==2) {
    			char d = s.charAt(left);
    			left++;
    			window.put(d, window.get(d)-1);
    		}
    		Max = Max>(right-left)?Max:(right-left);
    	}
    	return Max;
    }
    
    public static void main(String[] args) {
    	String s = "tmmzuxt";
    	System.out.println(lengthOfLongestSubstring(s));
    }
}
