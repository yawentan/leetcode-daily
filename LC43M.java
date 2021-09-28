package yawen;

import java.util.*;

public class LC43M {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";
		StringBuffer ans = new StringBuffer();
		StringBuffer space = new StringBuffer();
		int last = 0;
    	for(int i=num1.length()-1;i>=0;i--) {
    		StringBuffer sb = new StringBuffer(space);
    		for(int j=num2.length()-1;j>=0;j--) {
    			int tmep = (num1.charAt(i)-'0')*(num2.charAt(j)-'0') + last;
    			sb.append(tmep%10);
    			last = tmep/10;
    		}
    		if(last!=0) {
    			sb.append(last);
    			last = 0;
    		}
    		sb.reverse();
    		ans = StringSum(ans,sb);
    		space.append(0);
    	}
		return ans.toString();
    }

	private StringBuffer StringSum(StringBuffer a, StringBuffer b) {
		int i = a.length()-1;
		int j = b.length()-1;
		StringBuffer ans = new StringBuffer();
		int last = 0;
		while(i>=0&&j>=0) {
			int temp = (a.charAt(i)-'0')+(b.charAt(j)-'0') + last;
			ans.append(temp%10);
			i--;j--;
			last = temp/10;
		}
		while(i>=0) {
			int temp = a.charAt(i)-'0'+last;
			ans.append(temp%10);
			i--;
			last = temp/10;
		}
		while(j>=0) {
			int temp = b.charAt(j)-'0'+last;
			ans.append(temp%10);
			j--;
			last = temp/10;
		}
		if(last!=0) {
			ans.append(last);
			last = 0;
		}
		return ans.reverse();
	}
	
	public static void main(String[] args) {
		LC43M lc = new LC43M();
		System.out.println(lc.multiply("79362","217"));
	}
}
