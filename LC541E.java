package yawen;

import org.junit.Test;

public class LC541E {
	@Test
	public void test() {
		System.out.println(reverseStr("abcd",2));
	}
	
    public String reverseStr(String s, int k) {
        String ans = "";
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(i!=0&&i%k==0){
            	if(flag) {
            		sb.reverse();            		
            	}
                ans+=sb.toString();
                sb = new StringBuffer();
            }
            if(i!=0&&i%k==0) {
            	flag = !flag;
            }
            sb.append(s.charAt(i));
        }
    	if(flag) {
    		sb.reverse();            		
    	}
        ans+=sb.toString();
        return ans;
    }
}
