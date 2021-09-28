package yawen;

import java.util.*;

class Node847{
	int n;
	int mask;
	int dis;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mask;
		result = prime * result + n;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node847 other = (Node847) obj;
		if (mask != other.mask)
			return false;
		if (n != other.n)
			return false;
		return true;
	}
	public Node847(int n, int mask) {
		super();
		this.n = n;
		this.mask = mask;
	}
	public Node847(int n, int mask, int dis) {
		super();
		this.n = n;
		this.mask = mask;
		this.dis = dis;
	}
}
/**
 * ×´Ì¬Ñ¹Ëõ+bfs
 * @author yawen
 *
 */
public class LC847H {
    public int shortestPathLength(int[][] graph) {
    	Queue<Node847> q = new LinkedList<>();
    	int n = graph.length;
    	Set<Node847> visited = new HashSet<>();
    	for(int i=0;i<graph.length;i++) {
    		int mask = (int) Math.pow(2, i);
    		Node847 temp = new Node847(i,mask);
    		q.add(temp);
    		visited.add(temp);
    	}
    	
    	while(!q.isEmpty()) {
    		int sz = q.size();
    		for(int i=0;i<sz;i++) {
    			Node847 temp = q.poll();
    			if(temp.mask==((int) Math.pow(2, n)-1))
    				return temp.dis;
    			for(int cur:graph[temp.n]) {
    				int mask = temp.mask|((int) Math.pow(2, cur));
    				int dist = temp.dis+1;
        			Node847 t = new Node847(cur,mask,dist);
        			if(!visited.contains(t)) {
        				q.add(t);
        				visited.add(t);
        			}
    			}
    		}
    	}
    	return -1;
    }
}
