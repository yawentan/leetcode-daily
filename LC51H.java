package yawen;

import java.util.*;
/*
 * author:看了题解后做出来的，挺难的，被java的浅拷贝卡住了好久
 */
public class LC51H {
	private List<List<String>> out = new LinkedList<List<String>>();
	
	int[][] Update(int x,int y,int[][] visited){
		for(int i=x;i<visited.length;i++) {
			visited[i][y] = 1;
			if(y-i+x>=0)
				visited[i][y-i+x] = 1;
			if(y+i-x<visited.length)
				visited[i][y+i-x] = 1;
		}
		return visited;
	}
	
	//way是路径,visited[layer]是选择空间
	public void BackTrack(List<String> way,int[][] visited,int layer) {
		List<String> ls = new LinkedList<String>();
		if(way.size()==visited.length) {
			for(int i=0;i<way.size();i++) {
				String s = "";
				for(int j=0;j<way.size();j++) {
					s = s+way.get(i).charAt(j);
				}
				ls.add(s);
			}
			this.out.add(ls);
			return;
		}

		StringBuffer s = new StringBuffer();
		for(int i=1;i<visited.length;i++) {
			s.insert(0, '.');
		}
		for(int i=0;i<visited.length;i++) {
			if(visited[layer][i]==1)
				continue;
			//做决策选第i个位置
			s.insert(i,'Q');
			//更新选择列表
			int[][] temp = new int[visited.length][visited.length];// = visited.clone();//保留副本
			for(int ii=0;ii<visited.length;ii++) {
					temp[ii] = visited[ii].clone();
			}
			visited = Update(layer,i,visited);
			//添加路径
			way.add(s.toString());
			//回溯
			BackTrack(way,visited,layer+1);
			//更新选择列表
			visited = temp;
			//移除路径
			s.deleteCharAt(i);
			way.remove(layer);
		}
	}
	
    public List<List<String>> solveNQueens(int n) {
    	int[][] visited = new int[n][n];
    	int layer = 0;
    	List<String> way = new LinkedList<String>();
    	BackTrack(way,visited,layer);
    	return this.out;
    }
    
	public static void main(String[] args) {
		LC51H lc = new LC51H();
		List<List<String>> ans = lc.solveNQueens(8);
		System.out.println(ans);
		System.out.println(ans.size());
	}

}
