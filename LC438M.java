package yawen;

import java.util.*;

public class LC438M {
    public static List<Integer> findAnagrams(String s, String p) {
    	List<Integer> ans = new LinkedList<>();
    	HashMap<Character,Integer> need=new HashMap<>(),window=new HashMap<>();
    	for(int i=0;i<p.length();i++) {
    		if(need.get(p.charAt(i))==null)
    			need.put(p.charAt(i), 1);
    		else
    			need.put(p.charAt(i), need.get(p.charAt(i))+1);
    	}
    	int vaild=0;
    	
    	int left=0,right=0;
    	while(right<s.length()) {
    		char c = s.charAt(right);
    		right++;
    		//窗口更新
    		if(need.containsKey(c)) {
        		if(window.get(c)==null)
        			window.put(c, 1);
        		else 
        			window.put(c,window.get(c)+1);
        		if(window.get(c).equals(need.get(c))) {
        			vaild++;
        		}
    		}
    		
    		while(right-left>p.length()) {
    			char d = s.charAt(left);
    			left++;
    			//窗口更新
    			if(need.containsKey(d)) {
    				if(window.get(d).equals(need.get(d)))
    					vaild--;
    				window.put(d, window.get(d)-1);
    			}
    		}
    		if(vaild==need.size())
    			ans.add(left);
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	String  s="",p="ab";
    	System.out.println(findAnagrams(s,p));
    }
}
