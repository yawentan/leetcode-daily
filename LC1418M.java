package yawen;

import java.util.*;
class Node1418 implements Comparable<Node1418>{
	int table = 0;
	HashMap<String,Integer> hash;

	public Node1418() {
		super();
		this.hash = new HashMap<>();
	}

	public Node1418(int table, HashMap<String, Integer> hash) {
		super();
		this.table = table;
		this.hash = hash;
	}

	@Override
	public int compareTo(Node1418 o) {
		// TODO Auto-generated method stub
		return table-o.table;
	}
}

public class LC1418M {
    public List<List<String>> displayTable(List<List<String>> orders) {
    	HashMap<Integer,HashMap<String,Integer>> hash = new HashMap<>();
    	PriorityQueue<Node1418> q = new PriorityQueue<Node1418>();
    	HashMap<String,Integer> cai = new HashMap<>();
    	int idx = 0;
    	for(int i=0;i<orders.size();i++) {
    		List<String> l = orders.get(i);
    		int table = Integer.parseInt(l.get(1));
    		String s = l.get(2);
    		
    		if(!cai.containsKey(s)) {
    			cai.put(s, idx);
    			idx++;
    		}
    		
    		if(hash.containsKey(table)) {
    			HashMap<String,Integer> htemp = hash.get(table);
    			if(htemp.containsKey(s)) {
    				int n = htemp.get(s);
    				htemp.put(s, n+1);//存在该菜名+1
    			}else {
    				htemp.put(s, 1);//不存在该菜名+1
    			}
    		}else {
    			HashMap<String,Integer> htemp = new HashMap<>();
    			htemp.put(s, 1);
    			hash.put(table, htemp);//不存在该菜名置1
    		}
    	}
    	
    	for(int n:hash.keySet()) {
    		HashMap<String,Integer> thash = hash.get(n);
    		Node1418 node = new Node1418(n,thash);
    		q.add(node);
    	}
    	List<List<String>> ans = new Stack<List<String>>();
    	Set<String> cais = cai.keySet();
    	PriorityQueue<String> pc = new PriorityQueue<>();
    	for(String st:cai.keySet()) {
    		pc.add(new String(st));
    	}

    	List<String> l = new Stack<String>();
    	l.add("Table");
		while(!pc.isEmpty()) {
			l.add(pc.poll());
		}
    	ans.add(l);
    	//cai保存<菜名，idx>
    	while(!q.isEmpty()) {
        	l = new Stack<String>();
    		Node1418 node = q.poll();
    		l.add(String.valueOf(node.table));
			HashMap<String,Integer> htemp = node.hash;
			
			//遍历菜名
			for(String st:ans.get(0)) {
				if(st=="Table")
					continue;
				if(htemp.containsKey(st)) {
		    		l.add(String.valueOf(htemp.get(st)));
				}else
					l.add("0");
			}
			ans.add(l);
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	PriorityQueue<String> pc = new PriorityQueue<>();
    	pc.add("feHB");
    	pc.add("YVay");
    	pc.add("QGQ");
    	pc.add("QGQ");
    	pc.poll();
    	System.out.println(pc);
    	System.out.println("YVay".compareTo("QGQ"));
	}
}
