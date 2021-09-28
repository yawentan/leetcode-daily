package yawen;

public class LC24M {
    public ListNode swapPairs(ListNode head) {
    	if(head==null) {
    		return head;
    	}
    	if(head.next==null) {
    		return head;
    	}
    	ListNode ans = head.next;
    	ListNode p=null;
    	while(head!=null) {
        	ListNode i = head;
        	ListNode j = head.next;
        	if(j==null)
        		return ans;
        	i.next = j.next;
        	j.next = i;
        	if(p!=null)
        		p.next = j;
        	head = i.next;
        	p = i;
    	}
        return ans;
    }
    
    public static void main(String[] args) {
		LC24M lc = new LC24M();
		ListNode t = new ListNode(1);
		t.next = new ListNode(2);
		t.next.next = new ListNode(3);
		t.next.next.next = new ListNode(4);
		lc.swapPairs(t).OutPrint();
	}
    
}
