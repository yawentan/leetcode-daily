package yawen;


/**
 * ���仯 + dfs//��ʱ
 * ��dp��д
 * @author yawen
 *
 */
public class LC879H {
	private long Mod = 1000000000+7;
	private long dfs(int n,int i,long value, int minProfit, int[] group, int[] profit,long[][][] dp) {
		int j = (int) Math.min(value, minProfit);
		//���仯����
		if(dp[j][n][i]!=0) {
			return dp[j][n][i]%Mod;
		}
		//��ֹ��������Ҷ�ӽڵ�
		if(i==group.length) {
			if(value>=minProfit) {
				dp[j][n][i] = 1;
				return 1;
			}
			dp[j][n][i] = 0;
			return 0;
		}
		
		if(n>=group[i]) {
			dp[j][n][i]+=dfs(n-group[i],i+1,value+profit[i],minProfit,group,profit,dp);//do
		}
		dp[j][n][i]+=dfs(n,i+1,value,minProfit,group,profit,dp);//not do
		return dp[j][n][i]%Mod;
	}
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    	long[][][] dp = new long[101][n+1][group.length+1];
    	for(int v=0;v<=100;v++) {
    		for(int nn=0;nn<=n;nn++) {
    			if(v>=minProfit)
    				dp[v][nn][group.length]=1;
    			else
    				dp[v][nn][group.length]=0;
    		}
    	}
    	for(int i=group.length-1;i>=0;i--) {
	    	for(int v=0;v<=100;v++) {
	    		for(int nn=0;nn<=n;nn++) {
    				long temp1;
    				long temp2;
    				if(nn-group[i]<0)
    					temp1 = 0;
    				else if(v+profit[i]>=100) {
    					temp1 = dp[100][nn-group[i]][i+1];
    				}else {
    					temp1 = dp[v+profit[i]][nn-group[i]][i+1];
    				}
    				temp2 = dp[v][nn][i+1];
    				
    				dp[v][nn][i] = (temp1+temp2)%this.Mod;
    			}
    		}
    	}
    	return (int) (dp[0][n][0]%Mod);
    	//return (int) dfs(n,0,0,minProfit,group,profit,dp);
    }
    
    public static void main(String[] args) {
    	LC879H lc879h = new LC879H();
 
//    	int n = 100, minProfit = 100;
//    	int[] group = {2,5,36,2,5,5,14,1,12,1,14,15,1,1,27,13,6,59,6,1,7,1,2,7,6,1,6,1,3,1,2,11,3,39,21,20,1,27,26,22,11,17,3,2,4,5,6,18,4,14,1,1,1,3,12,9,7,3,16,5,1,19,4,8,6,3,2,7,3,5,12,6,15,2,11,12,12,21,5,1,13,2,29,38,10,17,1,14,1,62,7,1,14,6,4,16,6,4,32,48};
//    	int[] profit = {21,4,9,12,5,8,8,5,14,18,43,24,3,0,20,9,0,24,4,0,0,7,3,13,6,5,19,6,3,14,9,5,5,6,4,7,20,2,13,0,1,19,4,0,11,9,6,15,15,7,1,25,17,4,4,3,43,46,82,15,12,4,1,8,24,3,15,3,6,3,0,8,10,8,10,1,21,13,10,28,11,27,17,1,13,10,11,4,36,26,4,2,2,2,10,0,11,5,22,6};
//    	int n = 100, minProfit = 10;
//    	int[] group = {66,24,53,49,86,37,4,70,99,68,14,91,70,71,70,98,48,26,13,86,4,82,1,7,51,37,27,87,2,65,93,66,99,28,17,93,83,91,45,3,59,87,92,62,77,21,9,37,11,4,69,46,70,47,28,40,74,47,12,3,85,16,91,100,39,24,52,50,40,23,64,22,2,15,18,62,26,76,3,60,64,34,45,40,49,11,5,8,40,71,12,60,3,51,31,5,42,52,15,36};
//    	int[] profit = {8,4,8,8,9,3,1,6,7,10,1,10,4,9,7,11,5,1,7,4,11,1,5,9,9,5,1,10,0,10,4,1,1,1,6,9,3,6,2,5,4,7,8,5,2,3,0,6,4,5,9,9,10,7,1,8,9,6,0,2,9,2,2,8,6,10,3,4,6,1,10,7,5,4,8,1,8,5,5,4,1,1,10,0,8,0,1,11,5,4,7,9,1,11,1,0,1,6,8,3};
//    	
    	int n = 10, minProfit = 5;
    	int[] group = {2,3,5};
    	int[] profit = {6,7,8};
    	System.out.println(lc879h.profitableSchemes(n, minProfit,group,profit));
	}
}
