package yawen;

import java.util.*;

public class LC313M {
//    public int nthSuperUglyNumber(int n, int[] primes) {
//    	TreeSet<Integer> q = new TreeSet<Integer>();
//    	q.add(1);
//    	Set<Integer> set = new TreeSet<Integer>();
//    	int temp = 1;
//    	while(set.size()<n) {
//    		temp = q.pollFirst();
//    		for(int i:primes) {
//    			long tt = ((long) i)*temp;
//    			if(tt<Integer.MAX_VALUE)
//    				q.add(i*temp);
//    		}
//    		set.add(temp);
//    	}
//    	return temp;
//    }
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] dp = new int[n+1];
		dp[1]=1;
		int[] pointer = new int[primes.length];
		for(int i=0;i<primes.length;i++)
			pointer[i] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=0;j<primes.length;j++) {
				dp[i] = Math.min(dp[i], dp[pointer[j]]*primes[j]);
			}
			for(int j=0;j<primes.length;j++) {
				if(dp[pointer[j]]*primes[j]==dp[i])
					pointer[j]++;
			}
		}
		return dp[n];
	}
    
    public static void main(String[] args) {
    	int n = 100000;
    	int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
    	LC313M lc = new LC313M();
    	System.out.println(lc.nthSuperUglyNumber(n, primes));
	}
}
