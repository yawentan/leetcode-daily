package yawen;

import java.util.*;

public class LC802M {
    public List<Integer> eventualSafeNodes(int[][] graph) {
    	List<Integer> ans = new ArrayList<>();
    	Set<Integer> memNo = new HashSet<>();
    	Set<Integer> memYes = new HashSet<>();
    	for(int i=0;i<graph.length;i++) {
    		Set<Integer> visited = new HashSet<>();
    		visited.add(i);
    		if(dfs(graph,i,visited,memNo,memYes)) {
    			ans.add(i);
    			memYes.addAll(visited);
    		}
    		visited.remove(i);
    	}
    	
    	return ans;
    }

	private boolean dfs(int[][] graph, int node,Set<Integer> visited, Set<Integer> memNo, Set<Integer> memYes) {
    	Set<Integer> temp = new HashSet<>();
		if(graph[node].length==0) {
			return true;
		}
		if(memNo.contains(node)) {
			return false;
		}
		if(memYes.contains(node)) {
			return true;
		}
		
		for(int i:graph[node]) {
			if(visited.contains(i)) {
    			memNo.addAll(visited);
				return false;
			}
			visited.add(i);
			if(!dfs(graph,i,visited,memNo,memYes)) {
    			memNo.addAll(visited);
				return false;
			}
			visited.remove(i);
			temp.add(i);
		}
		memYes.addAll(temp);
		return true;
	}



	public static void main(String[] args) {
		LC802M lc = new LC802M();
		int[][] graph = {{1,2},{2,3},{4},{0},{5},{},{}};
		System.out.println(lc.eventualSafeNodes(graph));
	}
}
