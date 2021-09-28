package yawen;

import java.util.*;
import yawen.datastruct.TreeNode;

/*
 * @author:yawen
 * @思路:BFS层序遍历，再反序
 */

public class LC107M {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> ans = new LinkedList<>();
    	Stack<List<Integer>> s = new Stack<>();
    	if(root==null) return ans;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		List<Integer> temp = new LinkedList<>();
    		int n = q.size();
    		for(int i=0;i<n;i++) {
        		TreeNode t = q.poll();
    			temp.add(t.val);
    			if(t.left!=null) q.add(t.left);
    			if(t.right!=null) q.add(t.right);
    		}
    		s.add(temp);
    	}
    	while(!s.isEmpty()) {
    		ans.add(s.pop());
    	}
    	return ans;
    }
    
	public static void main(String[] args) {
        int[] num = {3,9,20,-1,-1,15,7};
        TreeNode q = new TreeNode();
        q = q.NumpadToTree(num);
        levelOrderBottom(q);
	}
}
