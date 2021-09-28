package yawen;

import java.util.*;

public class LC212H {
	@org.junit.Test
	public void test() {
		char[][] board = {{'a'},{'a'}};
		String[] words = {"aaa"};
		List<String> findWords = findWords(board,words);
		findWords.forEach(System.out::println);

	}
	
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> ans = new LinkedList<>();
    	
    	for(int i=0;i<words.length;i++) {
    		if(match(board,words[i])) {
    			ans.add(words[i]);
    		}
    	}
    	return ans;
    }

	private boolean match(char[][] board, String s) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				if(board[i][j]==s.charAt(0)&&dfs(board,s,i,j,0,new boolean[board.length][board[0].length])) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String s, int i, int j,int idx,boolean[][] v) {
		if(idx==s.length())
			return true;
		if(i<0||i>=board.length||j<0||j>=board[i].length||v[i][j]) {
			return false;
		}
		if(board[i][j]==s.charAt(idx)) {
			v[i][j]=true;
			if(dfs(board,s,i+1,j,idx+1,v))
				return true;
			if(dfs(board,s,i-1,j,idx+1,v))
				return true;
			if(dfs(board,s,i,j+1,idx+1,v))
				return true;
			if(dfs(board,s,i,j-1,idx+1,v))
				return true;
			v[i][j]=false;
		}
		return false;
	}
}
