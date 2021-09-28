package yawen;

public class LC14LongestCommonPrefix {

	class Solution {
	    public String longestCommonPrefix(String[] strs) {
	    	String out = "";
	    	char temp;
	    	if(strs.length==0)
	    		return out;
	    	for(int i = 0;i<=200;i++) {
	    		if(i<strs[0].length())
	    			temp = strs[0].charAt(i);
	    		else
	    			return out;
	    		for(int j=1;j<strs.length;j++) {
	    			if(i>=strs[j].length()||temp!=strs[j].charAt(i))
	    				return out;
	    		}
	    		out += temp;
	    	}
	    	return out;
	    }
	}

	public static void main(String arg[]) {
		LC14LongestCommonPrefix LC = new LC14LongestCommonPrefix();
		Solution st = LC.new Solution();
		String[] strs = {"ab", "a"};
		System.out.println(st.longestCommonPrefix(strs));
	}
}
