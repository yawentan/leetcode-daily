package yawen;


public class LC130M {
	@org.junit.Test
	public void test() {
		String s = "[['X','X','X','X'],['X','O','O','X'],['X','X','O','X'],['X','O','X','X']]";
		s = s.replace('[', '{');
		s = s.replace(']', '}');
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve1(board);
		System.out.println(s);
	}
	
	char[][] ans;
    public void solve(char[][] board) {
    	int m=board.length;
    	int n=board[0].length;
    	ans = new char[m][n];
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++) {
    			ans[i][j]='X';    			
    		}
    	}
    	for(int i=0;i<m;i++){
    		dfs(i,0,board);
    		dfs(i,n-1,board);
    	}
    	for(int i=0;i<n;i++){
    		dfs(0,i,board);
    		dfs(m-1,i,board);
    	}
    	for(int i=0;i<m;i++){
    		for(int j=0;j<n;j++) {
    			board[i][j]=ans[i][j];    			
    		}
    	}
    }
    
    private void dfs(int i,int j,char[][] board) {
    	if(i<0||i>=board.length||j<0||j>=board[i].length||ans[i][j]=='O'||board[i][j]=='X') {
    		return;
    	}
    	if(ans[i][j]=='X'&&board[i][j]=='O') {
    		ans[i][j]='O';
    		dfs(i+1,j,board);
    		dfs(i-1,j,board);
    		dfs(i,j+1,board);
    		dfs(i,j-1,board);
    	}
		return;
    }
    
    public void solve1(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        UFDS ufds = new UFDS(m*n+1); //多加一个用来区分是否和边界相连


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //找所有的O，通过判断来形成不同的连通分量
                if(i==0||i==m-1||j==0||j==n-1){
                    if(board[i][j]=='O'){
                        // System.out.println(i+"-"+j+"-"+m+"-"+n);
                        ufds.union(i*n+j,m*n);
                    }
                }else{
                    
                    if(board[i][j]=='O'){
                        if(board[i-1][j]=='O'){
                            ufds.union(i*n+j,(i-1)*n+j);
                        }
                        if(board[i+1][j]=='O'){
                            ufds.union(i*n+j,(i+1)*n+j);
                        }
                        if(board[i][j-1]=='O'){
                            ufds.union(i*n+j,i*n+j-1);
                        }
                        if(board[i][j+1]=='O'){
                            ufds.union(i*n+j,i*n+j+1);
                        }
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(ufds.find(i*n+j)!=ufds.find(m*n)){
                    board[i][j]='X';
                }
            }
    }
    }
}

//并查集数据结构
class UFDS{
	int[] fa;
	public UFDS(int n) {
		this.fa = new int[n];
		for(int i=0;i<n;i++) {
			this.fa[i]=i;
		}
	}
	
	int find(int x) {
		System.out.println(fa[x]);
		return x==this.fa[x]?x:find(this.fa[x]);
	}
	
	boolean union(int x,int y) {
		int a = find(x);
		int b = find(y);
		if(a==b)
			return false;
		else {
			this.fa[b]=a;
		}
		return true;
	}
}





