package yawen;

public class LC518M {
	private int ans;
	
    public int change(int amount, int[] coins) {
    	int[] dp = new int[amount+1];
    	dp[0] = 1;
    	//coins������ѭ����������ѡ��˳�򲻳����ظ�
		for(int j=0;j<coins.length;j++) {
			for(int i=coins[j];i<=amount;i++) {
    			dp[i]+=dp[i-coins[j]];
    		}
    	}
    	return dp[amount];
    }
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,5};
		LC518M lc = new LC518M();
		System.out.println(lc);
	}
}
