package yawen;

import java.util.*;

class Node451 implements Comparable<Node451>{
	char c;
	int cont;
	@Override
	public int compareTo(Node451 o) {
		return o.cont-this.cont;
	}
}

public class LC451M {
    public String frequencySort(String s) {
    	PriorityQueue<Node451> q = new PriorityQueue<>();
    	int[] Tab = new int[128];
    	for(int i=0;i<s.length();i++) {
    		Tab[s.charAt(i)]++;
    	}
    	for(int i=0;i<Tab.length;i++) {
    		if(Tab[i]!=0) {
    			Node451 temp = new Node451();
    			temp.c = (char) i;
    			temp.cont = Tab[i];
    			q.add(temp);
    		}
    	}
    	String ans = "";
    	int sz = q.size();
    	for(int i=0;i<sz;i++) {
        	Node451 temp = q.poll();
	    	while(temp.cont-->0) {
	    		ans+=temp.c;
	    	}
    	}
    	return ans;
    }
	
    public static void main(String[] args) {
    	LC451M lc = new LC451M();
    	System.out.println(lc.frequencySort("Aabb"));
	}
}
