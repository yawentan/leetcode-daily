package yawen;

import java.util.*;

public class LC200M {
	@org.junit.Test
	public void test() {
		String s = "[['1','0','1','1','1'],['1','0','1','0','1'],['1','1','1','0','1']]";
		s = s.replace('[', '{');
		s = s.replace(']', '}');
		System.out.println(s);
		char[][] grid = {{'1','0','1','1','1'},{'1','0','1','0','1'},{'1','1','1','0','1'}};
		System.out.println(numIslands(grid));
	}
	
	class UFDS{
		int[] fa;

		public UFDS(int n) {
			this.fa = new int[n];
			for(int i=0;i<n;i++) {
				this.fa[i]=i;
			}
		}
		
		public int find(int x){
			return x==this.fa[x]?x:find(this.fa[x]);
		}
		
		public boolean union(int x,int y) {
			int a = find(x);
			int b = find(y);
			if(a==b)
				return false;
			else
				this.fa[a]=b;
			return true;
		}
		
		public int countNum() {
			Set<Integer> s = new TreeSet<>();
			for(int n:this.fa) {
				s.add(find(n));
			}
			return s.size();
		}
	}
	
    public int numIslands(char[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	UFDS ufds = new UFDS(m*n+1);
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(grid[i][j]=='1') {
    				if(i+1<m&&grid[i+1][j]=='1') {
    					ufds.union(i*n+j, (i+1)*n+j);
    				}
    				if(i-1>=0&&grid[i-1][j]=='1') {
    					ufds.union(i*n+j, (i-1)*n+j);
    				}
    				if(j+1<n&&grid[i][j+1]=='1') {
    					ufds.union(i*n+j, (i)*n+j+1);
    				}
    				if(j-1>=0&&grid[i][j-1]=='1') {
    					ufds.union(i*n+j, (i)*n+j-1);
    				}
    			}else {
					ufds.union(i*n+j, m*n);
    			}
    		}
    	}
    	return ufds.countNum()-1;
    }
}

