package yawen;

import java.util.List;
import java.util.LinkedList;
import yawen.datastruct.TreeNode;

public class LC144E {
	public static void preorder(TreeNode root,List<Integer> ans) {
		if(root==null) return;
		//ǰ
		ans.add(root.val);
		preorder(root.left,ans);
		//��
		preorder(root.right,ans);
		//��
	}
	
    public static List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> ans = new LinkedList<>();
    	
    	preorder(root,ans);
    	
    	return ans;
    }
}
