package yawen;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ListNode{
	int val;
	ListNode next = null;
	ListNode() {};
	ListNode(int val){
		this.val = val;
	}
	ListNode(int val,ListNode next){
		this.val = val;
		this.next = next;
	}
	void OutPrint() {
		ListNode temp = this;
		while(temp!=null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}

public class LC83 {
    public static ListNode deleteDuplicates(ListNode head) {
    	if(head == null ||head.next == null) {
    		return head;
    	}
    	ListNode last = head;
    	ListNode next = head.next;
    	while(next!=null) {
    		if(last.val == next.val) {
    			last.next = next.next;
    			next = next.next;
    		}else {
    			last = next;
    			next = next.next;
    		}
    	}
    	return head;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode();
		head = deleteDuplicates(head);
		head.OutPrint();
	}
}
