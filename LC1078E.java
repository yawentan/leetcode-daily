package yawen;

import java.util.*;

public class LC1078E {
	public static void main(String[] args) {
		
	}
	
    public String[] findOcurrences(String text, String first, String second) {
    	String[] split = text.split(" ");
    	List<String> ans = new ArrayList<>();
    	for(int i=0;i<split.length-2;i++) {
    		if(first.equals(split[i])&&second.equals(split[i+1])) {
    			ans.add(split[i+2]);
    		}
    	}
    	return ans.toArray(new String[ans.size()]);
    }
}
