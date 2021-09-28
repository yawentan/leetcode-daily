package yawen;

public class LC600H {
	@org.junit.Test
	public void test() {
		System.out.println(findIntegers(2));
	}
    public int findIntegers(int n) {
    	String s = Integer.toBinaryString(n);
    	int ans = 0;
    	int[][] dp = new int[s.length()+1][2];
    	dp[1][0]=1;
    	dp[1][1]=1;
    	for(int i=2;i<=s.length();i++) {
    		dp[i][0]=dp[i-1][0]+dp[i-1][1];
    		dp[i][1]=dp[i-1][0];
    	}
    	int len = s.length();
    	int i=0;
    	boolean last = false;
    	while(i<s.length()) {
    		if(!last&&s.charAt(i)=='1') {
        		if(i==len-1) {
        			ans+=dp[len-i][1];
        		}
    			ans+=dp[len-i][0];
    			last = true;
    		}else if(last&&s.charAt(i)=='1') {
    			ans+=dp[len-i][0];
    			return ans;
    		}
    		if(s.charAt(i)=='0') {
        		if(i==len-1) {
        			ans+=dp[len-i][0];
        		}
    			last = false;
    		}
    		i++;
    	}
    	return ans;
    }
}
