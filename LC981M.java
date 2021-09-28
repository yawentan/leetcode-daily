package yawen;

import java.util.*;

class TimeMap {
	private TreeSet<Node> element = new TreeSet<>();
	
	class Node implements Comparable<Node>{
		private String key;
		private String value;
		private int timestamp;

		public Node(int timestamp) {
			super();
			this.timestamp = timestamp;
		}

		public Node(String key, String value, int timestamp) {
			this.key = key;
			this.value = value;
			this.timestamp = timestamp;
		}

		@Override
		public int compareTo(Node o) {
			return -(this.timestamp-o.timestamp);
		}

	}
	
    /** Initialize your data structure here. */
    public TimeMap() {
    	
    }
    
    public void set(String key, String value, int timestamp) {
    	Node temp = new Node(key,value,timestamp);
    	element.add(temp);
    }
    
    public String get(String key, int timestamp) {
    	String ans = "";
    	Node l = new Node(1);
    	Node r = new Node(timestamp+1);
    	SortedSet<Node> subSet = element.subSet(l, r);
//    	subSet.last();
    	for(Node n:subSet) {
    		if(n.key.equals(key)){
    			ans = n.value;
    	        return ans;
            }
    	}
    	
    	return ans;
    }
}

public class LC981M {
	public static void main(String[] args) {
		TreeSet<Integer> e = new TreeSet<>();
		e.add(1);
		e.add(3);
		e.add(5);
		e.add(4);
		TimeMap t = new TimeMap();
		t.set("foo","bar", 1);
		System.out.println(e);
		System.out.println(e.subSet(0, 4));
		
	}
}
