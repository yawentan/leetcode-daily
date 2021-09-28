package yawen;

public class LC725M {
	@org.junit.Test
	public void test() {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
		splitListToParts(root,3);
	}
	
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n=0;
        ListNode temp = head;
        ListNode ans[] = new ListNode[k];
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        int Len = n/k;
        int num = n%k;
        temp = head;
        int count = 0;
        int flag = 1;
        int kk=0;
        ans[0]=head;
        while(temp!=null){
            if(kk==num) {
            	flag = 0;
            }
            count++;
            if(count==Len+flag){
            	if(kk+1<k)
            		ans[++kk]=temp.next;
                ListNode temp2 = temp;
                temp=temp.next;
                temp2.next = null;
                count = 0;
            }else {
                temp=temp.next;
            }
        }
        return ans;
    }
}
