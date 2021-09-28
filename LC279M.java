package yawen;

import java.util.Scanner;

public class LC279M {
    public static int numSquares(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		for(int k=1;k<=n;k++) {
			dp[k]=Integer.MAX_VALUE;
			for(int i=1;i<=Math.sqrt(n);i++) {
				if(k-i*i<0)
					break;
				dp[k] = Math.min(dp[k],dp[k-i*i]+1);
			}
		}
		return dp[n];
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			int n = s.nextInt();
			System.out.println(LC279M.numSquares(n));
		}			
	}
}
