package yawen;

public class LC58 {
	//class Solution {
	    public int lengthOfLastWord(String s) {
	    	int out = 0;
	    	int Flag = 0;
	    	for(int i=0;i<s.length();i++) {
	    		if(s.charAt(i)==' ')
	    			Flag = 1;
	    		else {
	    			if(Flag == 1)
	    				{
	    					out = 1;
	    					Flag = 0;
	    				}
	    			else
	    				out = out+1;
	    		}
	    	}
	    	return out;
	    }
	//}
	
	public static void main(String[] args) {
		LC58 lc = new LC58();
		//Solution st = lc.new Solution();
		String s = "Hello World";
		System.out.println(lc.lengthOfLastWord(s));
	}
}
