package yawen;

import yawen.datastruct.TreeNode;
/*
 * author: yawen
 * description: 算法小抄上的题，该题关键是理解题意，后序遍历并且保存最大子树路径和。
 */
public class LC124 {
	int out = -1001;
    public int onePathSum(TreeNode root) {
    	if(root==null)
    		return 0;
    	int l = Math.max(0,onePathSum(root.left));
    	int r = Math.max(0,onePathSum(root.right));
    	this.out = Math.max(l+r+root.val,out);//全局变量寻找维护路径和最大
    	return (Math.max(l,r)+root.val);//返回值维护子树最大和
    }
    public int maxPathSum(TreeNode root) {
    	onePathSum(root);
    	return this.out;
    }
    
    public static void main(String[] args) {
    	TreeNode T = new TreeNode(1);
    	int[] num = {-10,9,20,-1,-1,15,7};
    	T = T.NumpadToTree(num);
    	LC124 lc = new LC124();
    	System.out.print(lc.maxPathSum(T));
    }
}
