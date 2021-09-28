package yawen;

public class LC233H {
	@org.junit.Test
	public void test() {
		System.out.println(this.countDigitOne(2000000000));
	}
	
    public int countDigitOne(int n) {
    	int[] dp = {0,1,20,300,4000,50000,600000,7000000,80000000,900000000,1000000000};
    	int ans=0;
    	String s = String.valueOf(n);
    	
    	int nn = s.length();
    	while(nn>0) {
    		char c = s.charAt(s.length()-nn);
    		if(c>'1') {
    			ans+=(c-'0')*dp[nn-1]+1*Math.pow(10, nn-1);
    		}else if(c=='1') {
    			ans+=dp[nn-1]+n%Math.pow(10, nn-1)+1;
    		}
    		nn--;
    	}
    	return ans;
    }
}
