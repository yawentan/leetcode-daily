package yawen;

import java.util.*;

public class LC787M {
	@org.junit.Test
	public void test() {
		int n = 11, src = 0, dst = 2, k = 4;
		int[][] edges = {{0,3,3},{3,4,3},{4,1,3},{0,5,1},{5,1,100},{0,6,2},{6,1,100},{0,7,1},{7,8,1},{8,9,1},{9,1,1},{1,10,1},{10,2,1},{1,2,100}};
		System.out.println(findCheapestPrice(n,edges,src,dst,k));
	}
	
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    	int[][] roads = new int[n][n];
    	for(int i=0;i<flights.length;i++) {
    		roads[flights[i][0]][flights[i][1]]=flights[i][2];
//    		roads[flights[i][1]][flights[i][0]]=flights[i][2];
    	}
    	int djistra = dynamicPro(src,dst,n,roads,k);
    	return djistra==Integer.MAX_VALUE?-1:djistra;
    }

    private int dynamicPro(int src,int target,int n,int[][] roads,int k) {
		int[][] dp = new int[k+2][n];
		for(int i=0;i<k+2;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		dp[0][src]=0;
		for(int i=1;i<k+2;i++) {
			for(int j=0;j<n;j++) {
				for(int kk=0;kk<n;kk++)
					if(roads[kk][j]!=0&&dp[i-1][kk]!=Integer.MAX_VALUE) {
						dp[i][j]=Math.min(dp[i-1][kk]+roads[kk][j],dp[i][j]);			
					}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<k+2;i++) {
			ans = Math.min(ans, dp[i][target]);
		}
		return ans;
    }
    
    private int bfs(int src,int target,int n,int[][] roads,int k) {
		int[][] dp = new int[k+4][n];
		int[] Max = new int[n];
		for(int i=0;i<k+3;i++) {
			for(int j=0;j<n;j++) {
				dp[i][j]=Integer.MAX_VALUE;
				Max[i] = Integer.MAX_VALUE;
			}
		}
		int step = 0;
    	Queue<Integer> q = new LinkedList<>();
    	q.add(src);
    	dp[0][src]=0;
		boolean[] visited = new boolean[n];
		visited[src] = true;
		while(!q.isEmpty()) {
			int sz = q.size();
			for(int i=0;i<sz;i++) {
				int poll = q.poll();
				//扩散
				for(int j=0;j<n;j++) {
					if(roads[poll][j]!=0) {
						if(visited[j]) {
							if(dp[step][poll]+roads[poll][j]<Max[j]) {
								q.add(j);
								Max[j] = dp[step][poll]+roads[poll][j];
								dp[step+1][j] = dp[step][poll]+roads[poll][j];	
							}
						}else {
							q.add(j);
							visited[j]=true;
							dp[step+1][j] = dp[step][poll]+roads[poll][j];	
							Max[j] = dp[step+1][j];		
						}
					}
				}
			}
			step++;
			if(step>k+2)
				break;
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<k+2;i++) {
			ans = Math.min(ans, dp[i][target]);
		}
		return ans;
    }
    
	private int djistra(int src,int target,int n,int[][] roads,int k) {
		int[][] dp = new int[n][k+2];
		for(int i=0;i<n;i++) {
			for(int j=0;j<k+2;j++) {
				dp[i][j]=Integer.MAX_VALUE;
			}
		}
		dp[src][0]=0;
		int[] shortest = new int[n];
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++) shortest[i] = Integer.MAX_VALUE;
		
		//起点置0
		shortest[src]=0;
		for(int i=0;i<n;i++) {
			int Min = Integer.MAX_VALUE;
			int idx = src;
			for(int j=0;j<n;j++) {
				if(!visited[j]&&Min>shortest[j]) {
					Min = shortest[j];
					idx = j;
				}
			}
			//加入最短
			visited[idx]=true;
			shortest[idx]=Min;
			//更新shortest表
			for(int j=0;j<n;j++) {
				//扩散
				if(roads[idx][j]!=0) {
					for(int ki=0;ki<k+1;ki++) {
						if(dp[idx][ki]!=Integer.MAX_VALUE) {
							dp[j][ki+1] = Math.min(dp[j][ki+1],dp[idx][ki]+roads[idx][j]);	
							if(j==2)
								System.out.println(dp[j][ki+1]);
						}			
					}
				}
				if(!visited[j]&&roads[idx][j]!=0&&1L*shortest[idx]+roads[idx][j]<1L*shortest[j]) {
					shortest[j] = shortest[idx]+roads[idx][j];
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<k+1;i++) {
			ans = Math.min(ans, dp[target][i]);
		}
		return ans;
	}
	
}

