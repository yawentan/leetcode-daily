package yawen;

import java.util.*;

public class LC695M {
	@org.junit.Test
	public void test() {
		String s = "[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]";
		s = s.replace('[', '{');
		s = s.replace(']', '}');
		System.out.println(s);
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		System.out.println(maxAreaOfIsland(grid));
	}
	
	class UFDS{
		int[] fa;
		int[] rank;
		public UFDS(int n) {
            fa = new int[n];
            rank = new int[n];
			for(int i=0;i<n;i++) {
				fa[i]=i;
				rank[i]=1;
			}
		}
		
		public int find(int x) {
			//路径压缩
			return x==fa[x]?x:(fa[x]=find(fa[x]));
		}
		
		//按照秩合并
		public void union(int x,int y) {
			fa[find(x)]=find(y);
//			int a = find(x);
//			int b = find(y);
//			if(rank[a]<=rank[b]) {
//				fa[a]=b;
//			}else
//				fa[b]=a;
//			//相同深度时才需要增加深度
//			if(rank[a]==rank[b]&&a!=b) {
//				rank[b]++;
//			}
		}
		
		public int findMax() {
			int Max = 0;
			Map<Integer,Integer> hash = new HashMap<>();
			for(int i=0;i<fa.length;i++) {
				int temp = hash.getOrDefault(find(i), 0);
				hash.put(find(i), temp+1);
			}
			for(int k:hash.keySet()) {
				if(k!=fa.length-1)
					Max = Math.max(Max, hash.get(k));
			}
			return Max;
		}
	}
	
    public int maxAreaOfIsland(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	UFDS ufds = new UFDS(m*n+1);
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(grid[i][j]==1) {
    				//上
    				if(i-1>=0&&grid[i-1][j]==1) {
    					ufds.union(i*n+j, (i-1)*n+j);
    				}
    				if(j-1>=0&&grid[i][j-1]==1) {//左
    					ufds.union(i*n+j, (i)*n+j-1);
    				}
    				if(i+1<m&&grid[i+1][j]==1) {
    					ufds.union(i*n+j, (i+1)*n+j);
    				}
    				if(j+1<n&&grid[i][j+1]==1) {//左
    					ufds.union(i*n+j, (i)*n+j+1);
    				}
    			}else {
    				ufds.union(i*n+j, m*n);
    			}
    		}
    	}
    	return ufds.findMax();
    }
}
