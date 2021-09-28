package yawen;

import java.util.*;

class Node1337 implements Comparable<Node1337>{
	int n;
	int idx;
	public Node1337(int cont, int i) {
		n = cont;
		idx = i;
	}
	@Override
	public int compareTo(Node1337 o) {
		// TODO Auto-generated method stub
		return o.n-n==0?o.idx-this.idx:o.n-n;
	}
}

public class LC1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
    	PriorityQueue<Node1337> pq = new PriorityQueue<Node1337>();
    	int[] ans = new int[k];
    	for(int i=0;i<mat.length;i++) {
    		int cont = 0;
    		for(int j=0;j<mat[i].length;j++) {
    			if(mat[i][j]==1)
    				cont++;
    			else
    				break;
    		}
    		if(pq.size()<k) {
    			pq.add(new Node1337(cont,i));
    		}
    		else if(pq.size()==k&&pq.peek().n>cont) {
				pq.poll();
				pq.add(new Node1337(cont,i));
			}
    	}
    	int i=1;
    	while(!pq.isEmpty()) {
    		ans[k-i] = pq.poll().idx;
    		i++;
    	}
		return ans;
    }
    
    public static void main(String[] args) {
    	LC1337 lc = new LC1337();
    	
	}
}
