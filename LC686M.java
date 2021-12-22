package yawen;

public class LC686M {
    public int repeatedStringMatch(String a, String b) {
    	int k = 0;
    	while(true) {
    		String repeat = a.repeat(k);
    		if(repeat.contains(b))
    			return k;
    		
    		if(repeat.length()>b.length()+a.length())
    			return -1;
    		k++;
    	}
    }
}
