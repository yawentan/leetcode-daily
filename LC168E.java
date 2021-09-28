package yawen;

public class LC168E {
    public String convertToTitle(int columnNumber) {
    	StringBuffer ans = new StringBuffer();
    	while(columnNumber>0) {
    		ans.append((char)('A'+(columnNumber-1)%26));
    		columnNumber=(int) (Math.ceil(1.0*columnNumber/26)-1);
//    		System.out.println(Math.ceil(1.0*columnNumber/26)-1);
    	}
    	return ans.reverse().toString();
    }
    public static void main(String[] args) {
    	LC168E lc = new LC168E();
    	System.out.println(lc.convertToTitle(701));
	}
}
