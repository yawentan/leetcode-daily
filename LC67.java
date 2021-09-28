package yawen;
/*
 * @author:yawen
 * @description:暴力模拟了二进制相加的所有情况
 */
public class LC67 {
	class Solution {
	    public String addBinary(String a, String b) {
	    	int n = a.length()-1;
	    	int m = b.length()-1;
	    	int k = 0,flag = 0;;
	    	char[] out = new char[m+n+2];
	    	while(n>=0||m>=0) {
	    		if(n>=0&&m>=0) {
	    			if(a.charAt(n)=='1'&&b.charAt(m)=='1'){
	    				if(flag == 1)
	    					out[k] = '1';
	    				else
	    					out[k] = '0';
	    				flag = 1;
	    			}
	    			else if(a.charAt(n)=='0'&&b.charAt(m)=='0'){
	    				if(flag == 1)
	    					out[k] = '1';
	    				else
	    					out[k] = '0';
	    				flag = 0;
	    			}
	    			else {
	    				if(flag == 1) {
	    					out[k] = '0';
	    					flag = 1;
	    				}
	    				else {
	    					out[k] = '1';
	    					flag = 0;
	    				}
	    			}
	    		}else if(n>=0) {
    				if(flag == 1) {
    					if(a.charAt(n)=='1') {
	    					out[k] = '0';
	    					flag = 1;
    					}
    					else {
	    					out[k] = '1';
	    					flag = 0;
    					}	
    				}else
    					out[k] = a.charAt(n);
	    			
	    		}else if(m>=0){
    				if(flag == 1) {
    					if(b.charAt(m)=='1') {
	    					out[k] = '0';
	    					flag = 1;
    					}
    					else {
	    					out[k] = '1';
	    					flag = 0;
    					}	
    				}else
    					out[k] = b.charAt(m);
	    			
	    		}
	    		m--;
	    		n--;
	    		k++;
	    	}
	    	if(flag == 1)
	    		out[k++]='1';
	    	String Out = "";
	    	while(k-->0) {
	    		//System.out.println(out[k]);
	    		Out+=out[k];
	    	}
	    	return Out;
	    }
	}
	
	public static void main(String[] args) {
		LC67 lc = new LC67();
		Solution st = lc.new Solution();
		String a = "11", b = "1";
		System.out.println(st.addBinary(a, b));
	}
}
