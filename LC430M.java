package yawen;

//Definition for a Node.


public class LC430M {
	class Node {
		 public int val;
		 public Node prev;
		 public Node next;
		 public Node child;
	}
	@org.junit.Test
	public void test() {
		Node
		flatten
	}
	 public Node flatten(Node head) {
	     Node res = head;
	     dfs(head);
	     return res;
	 }
	 public void dfs(Node head) {
	     while(head!=null){
	         if(head.child!=null){
	             Node hnext = head.next;
	             Node hchild = head.child;
	             head.next = hchild;
	             hchild.prev = head;
	             head.child = null;
	             dfs(head.next);
	             head.next=hnext;
	             hnext.prev=head;
	         }else{
	             head = head.next;
	         }
	     }
	 }
}
