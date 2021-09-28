package yawen;

import java.util.HashSet;
import java.util.Set;

public class LC345E {
	@org.junit.Test
	public void test() {
		System.out.println(reverseVowels("aA"));
	}
	
    public String reverseVowels(String s) {
    	int l=0,r=s.length();
    	Set<Character> set = new HashSet<>();
    	StringBuffer h = new StringBuffer();
    	StringBuffer w = new StringBuffer();
    	set.add('a');
    	set.add('e');
    	set.add('i');
    	set.add('o');
    	set.add('u');
    	set.add('A');
    	set.add('E');
    	set.add('I');
    	set.add('O');
    	set.add('U');
    	boolean flag = true;
    	int count = 0;
    	while(l<r) {
    		int idx = flag?l:r;
    		char c = s.charAt(idx);
    		if(set.contains(c)) {
    			count++;
				flag = false;
    			if(count==2) {
    				count = 0;
    				h.append(s.charAt(r));
    				w.append(s.charAt(l));
    				flag = true;
    			}
    		}else {
    			if(count==0)
    				h.append(c);
    			else
    				w.append(c);
    		}
    		idx = flag?l++:r--;
    		
    	}
    	if(count==1)
			h.append(s.charAt(l));
    		
    	return h.toString()+w.reverse().toString();
    }
}
