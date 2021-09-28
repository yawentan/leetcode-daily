package yawen;

import java.util.*;

public class LC797M {
	@org.junit.Test
	public void test() {
		String s = "[[1,2,3],[2],[3],[]]";
		s = s.replace('[', '{');
		s = s.replace(']', '}');
		System.out.println(s);
		int[][] graph =  {{1,2,3},{2},{3},{}};
		List<List<Integer>> allPath = allPathsSourceTarget(graph);
		allPath.forEach(System.out::println);
	}
	
	List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	LinkedList<Integer> ans = new LinkedList<>();
    	ans.add(0);
    	dfs(0,graph,graph.length,ans);
    	return this.res;
    }
    private void dfs(int node,int[][] graph,int n,List<Integer> ans) {
    	if(node == n-1) {
    		List<Integer> temp = new LinkedList<>(ans);
    		res.add(temp);
    	}
    	for(int i=0;i<graph[node].length;i++) {
    		ans.add(graph[node][i]);
    		dfs(graph[node][i],graph,n,ans);
    		ans.remove(ans.size()-1);
    	}
    }
}
