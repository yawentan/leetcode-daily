package yawen;

import java.util.*;

public class LC567M {
    public static boolean checkInclusion(String s1, String s2) {
    	int left = 0,right = 0;
    	int vaild = 0;
    	HashMap<Character,Integer> need=new HashMap<>(),window=new HashMap<>();
    	for(int i=0;i<s1.length();i++) {
    		char c = s1.charAt(i);
    		if(need.get(c)==null)
    			need.put(c, 1);
    		else {
    			need.put(c, need.get(c)+1);
    		}
    	}
    	
    	while(right<s2.length()) {
    		//c½ø´°¿Ú
    		char c = s2.charAt(right);
    		right++;
    		if(need.containsKey(c)) {
    			if(window.get(c)==null)
    				window.put(c, 1);
    			else {
    				window.put(c, window.get(c)+1);
    			}
    			int nc = need.get(c);
    			if(window.get(c)==nc)
    				vaild++;
    		}
    		while(right-left>s1.length()) {
        		char d = s2.charAt(left);
        		left++;
        		if(need.containsKey(d)) {
        			int nc = need.get(d);
        			if(window.get(d)==nc)
        				vaild--;
        			window.put(d, window.get(d)-1);
        		}
    		}
    		if(vaild==need.size()) 
    			return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	String s1= "a",s2 = "b";
    	System.out.println(checkInclusion(s1,s2));
    }
}
