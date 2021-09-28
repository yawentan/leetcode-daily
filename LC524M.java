package yawen;

import java.util.*;

public class LC524M {
	@org.junit.Test
	public void test() {
		String s = "abpcplea";
		
    	List<String> dictionary = new LinkedList<>();
    	String[] ss = {"a","b","c"};
    	for(int i=0;i<ss.length;i++) {
    		dictionary.add(ss[i]);
    	}
    	System.out.println(match(s,"abpcllllll"));
		System.out.println(findLongestWord(s,dictionary));
	}
	
    public String findLongestWord(String s, List<String> dictionary) {
    	int max = 0;
//    	StringBuffer
    	String ans = "";
    	for(int i=0;i<dictionary.size();i++) {
    		boolean t = match(s,dictionary.get(i));
    		if(t) {
    			if(dictionary.get(i).length()>=max) {
    				if(max==dictionary.get(i).length()) {
    					if(ans.compareTo(dictionary.get(i))>0) {
    						ans = dictionary.get(i);
    					}
    				}else {
    					max = dictionary.get(i).length();    
						ans = dictionary.get(i);					
    				}
    			}
    		}
    	}
    	return ans;
    }

	private boolean match(String s, String string) {
		int i=0;
		int j=0;
		while(i<s.length()&&j<string.length()) {
			if(s.charAt(i)!=string.charAt(j)) {
				i++;
				continue;
			}
			i++;
			j++;
		}
		return j==string.length();
	}
}
