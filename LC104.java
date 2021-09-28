package yawen;

import yawen.datastruct.TreeNode;

public class LC104 {
    public static int maxDepth(TreeNode root) {
		if(root== null)
			return 0;
		return 1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public static void main(String[] args) {
    	TreeNode T = new TreeNode(3);
    	T.left = new TreeNode(9);
    	T.right = new TreeNode(20);
    	T.right.left = new TreeNode(15);
    	T.right.right = new TreeNode(7);
    	System.out.print(maxDepth(T));
    }
}
