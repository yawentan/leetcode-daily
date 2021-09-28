package yawen;

import java.util.LinkedList;
import java.util.Queue;

//Definition for a Node.
//class Node {
// public int val;
// public Node left;
// public Node right;
// public Node next;
//
// public Node() {}
// 
// public Node(int _val) {
//     val = _val;
// }

// public Node(int _val, Node _left, Node _right, Node _next) {
//     val = _val;
//     left = _left;
//     right = _right;
//     next = _next;
// }
//};


public class LC116M {
    public Node connect(Node root) {
    	//bfs»ù´¡ÌâÄ¿
//    	Queue<Node> q = new LinkedList<>();
//    	q.add(root);
//    	while(!q.isEmpty()) {
//    		int sz = q.size();
//    		for(int i=0;i<sz;i++) {
//    			Node temp = q.poll();
//    			if(temp==null)
//    				continue;
//    			temp.next = i==sz-1?null:q.peek();
//    			q.add(temp.left);
//    			q.add(temp.right);
//    		}
//    	}
//    	return root;
    }
}
