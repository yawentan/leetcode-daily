package yawen;


public class LC38 {
	class Solution {
		private String fuck(String s) {
	    	String out="";
	    	int cont=1;
	    	for(int i=0;i<s.length()-1;i++) {
	    		if(i<s.length()-2) {
		    		if(s.charAt(i)==s.charAt(i+1))
		    			cont=cont+1;
		    		else {
		    			out = out+String.valueOf(cont);
		    			out = out+s.charAt(i);
		    			cont = 1;
		    		}
	    		}else {
		    		if(s.charAt(i)==s.charAt(i+1)) {
		    			cont=cont+1;
		    			out = out+String.valueOf(cont);
		    			out = out+s.charAt(i);
		    		}
		    		else {
		    			out = out+String.valueOf(cont);
		    			out = out+s.charAt(i);
		    			cont = 1;
		    			out = out+String.valueOf(cont);
		    			out = out+s.charAt(i+1);
		    		}
	    		}
	    	}
	    	return out;
		}
		
		private String countAndSay(int n) {
	    	if(n==1)
	    		return "1";
	    	String out = "11";
	    	n=n-2;
	    	while(n>0) {
	    		out = fuck(out);
	    		n=n-1;
	    	}
	    	return out;
	    }
	}
	
	public static void main(String[] args) {
		LC38 lc = new LC38();
		Solution st =  lc.new Solution();
		int n = 5;
		System.out.println(st.countAndSay(n));
	}
}
