package yawen;

import yawen.datastruct.*;

class Node{
	long max,min;
	boolean Flag;
    Node() {}
    Node(long max,long min) {
    	this.max = max;
    	this.min = min;
    	this.Flag = true;
    }
}

public class LC98M {
    public static Node isBST(TreeNode root) {
    	if(root == null) {
    		Node n = new Node(Long.MIN_VALUE,Long.MAX_VALUE);
    		return n;
    	}
//    	int Min,Max;
//    	if(root.left == null)
    	Node l = isBST(root.left);
    	Node r = isBST(root.right);
    	Node ans = new Node();
    	if(l.Flag&&r.Flag&&root.val>l.max&&root.val<r.min) {
    		ans.Flag = true;
    		ans.max = Math.max(root.val,r.max);
    		ans.min = Math.min(root.val,l.min);
    		return ans;
    	}
    	ans.Flag = false;
    	return ans;
    		
    }
    public static boolean isValidBST(TreeNode root) {
    	return isBST(root).Flag;
    }
    
    public static void main(String[] args) {
    	TreeNode T = new TreeNode();
    	int[] num = {2147483647};
    	T = T.NumpadToTree(num);
    	System.out.println(isValidBST(T));
    }
}
