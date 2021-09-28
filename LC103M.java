package yawen;

import yawen.datastruct.TreeNode;
import java.util.*;

public class LC103M {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> ans = new LinkedList<>();
        if(root==null)
            return ans;
    	List<TreeNode> l = new LinkedList<>();
    	
    	l.add(root);
    	boolean Flag = true;
    	while(!l.isEmpty()) {
    		List<Integer> ll = new LinkedList<>();
    		int n = l.size();
    		for(int i=0;i<n;i++) {
        		TreeNode temp;
        		temp = l.remove(n-1-i);
    			if(temp!=null) {
    				ll.add(temp.val);
            		if(Flag) {
		    			l.add(temp.left);
		    			l.add(temp.right);
            		}else {
		    			l.add(temp.right);
		    			l.add(temp.left);
            		}
    			}
    		}
    		Flag = !Flag;
    		if(ll.size()!=0)
    			ans.add(ll);
    	}
    	return ans;
    }
    
    public static void main(String[] args) {
    	int[] nums= {3,9,20,-1,-1,15,7};
//        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(3));

        TreeNode p = new TreeNode(1);
        p = p.NumpadToTree(nums);
        p.PostOrderTraverse(p);
        System.out.println(zigzagLevelOrder(p));
    }
}
