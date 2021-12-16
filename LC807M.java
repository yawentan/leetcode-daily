package yawen;

public class LC807M {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
    	int[] col = new int[grid.length];
    	int[] row = new int[grid.length];
    	int ans=0;
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[i].length;j++) {
    			row[i] = Math.max(row[i], grid[i][j]);
    			col[i] = Math.max(col[i], grid[j][i]);
    		}
    	}
    	for(int i=0;i<grid.length;i++) {
    		for(int j=0;j<grid[i].length;j++) {
    			ans+=Math.min(row[i], col[j])-grid[i][j];
    		}
    	}
    	return ans;
    }
    
}
