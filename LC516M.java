package yawen;

import org.junit.Test;


public class LC516M {
	@Test
	public void test() {
		System.out.println(longestPalindromeSubseq("aabaaba"));
	}
	

    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int j=0;j<s.length();j++) {
        	dp[j][j]=1;
        }
        for(int j=1;j<s.length();j++) {
        	for(int i=j-1;i>=0;i--) {
        		dp[i][j]=Math.max(dp[i][j-1], (i+1<=j-1?dp[i+1][j-1]:0)+(s.charAt(i)==s.charAt(j)?2:0));
        		dp[i][j]=Math.max(dp[i+1][j], dp[i][j]);
        	}
        }
        return dp[0][s.length()-1];
    }
}
