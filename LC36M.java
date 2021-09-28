package yawen;

public class LC36M {
    public boolean isValidSudoku(char[][] board) {
    	for(int i=0;i<board.length;i++) {
    		for(int j=0;j<board.length;j++) {
    			if(board[i][j]!='.') {
    				if(!isValid(i,j,board))
    					return false;
    			}
    		}
    	}
    	return true;
    }

	private boolean isValid(int i, int j, char[][] board) {
		//ÐÐ
		for(int k=0;k<9;k++) {
			if(j!=k&&board[i][k]==board[i][j])
				return false;
		}
		//ÁÐ
		for(int k=0;k<9;k++) {
			if(i!=k&&board[k][j]==board[i][j])
				return false;
		}
		int in=i/3;
		int jn=j/3;
		for(int ii=0;ii<3;ii++) {
			for(int jj=0;jj<3;jj++) {
				if((3*in+ii!=i&&3*jn+jj!=j)&&board[3*in+ii][3*jn+jj]==board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
