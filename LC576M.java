package yawen;

public class LC576M {
	@org.junit.Test
	public void test() {
//		m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1

		System.out.println(findPaths(50,50,50,5,26));
	}

	int Mod = 1000000007;
	int ans = 0;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    	int[][][] dp = new int[m][n][maxMove+1];
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			for(int k=0;k<maxMove+1;k++) {
    				dp[i][j][k]=-1;
    			}
    		}
    	}
    	dfs(startRow,startColumn,0,maxMove,m,n,dp);
    	return dp[startRow][startColumn][0]%Mod;
    }
    
    private int dfs(int i,int j,int moveNum,int maxMove,int m,int n,int[][][] dp) {
    	if(moveNum>maxMove)
    		return 0;
    	if(isOut(i,j,m,n)) {
    		ans++;
    		return 1;
    	}
    	if(dp[i][j][moveNum]!=-1)
    		return dp[i][j][moveNum];
    	dp[i][j][moveNum]=0;
    	dp[i][j][moveNum]=(dp[i][j][moveNum]+dfs(i+1,j,moveNum+1,maxMove,m,n,dp))%Mod;
    	dp[i][j][moveNum]=(dp[i][j][moveNum]+dfs(i-1,j,moveNum+1,maxMove,m,n,dp))%Mod;
    	dp[i][j][moveNum]=(dp[i][j][moveNum]+dfs(i,j+1,moveNum+1,maxMove,m,n,dp))%Mod;
    	dp[i][j][moveNum]=(dp[i][j][moveNum]+dfs(i,j-1,moveNum+1,maxMove,m,n,dp))%Mod;
    	return dp[i][j][moveNum]%Mod;
    }

	private boolean isOut(int i, int j, int m, int n) {
		if(i>=m||i<0||j>=n||j<0)
			return true;
		return false;
	}
}
