package yawen;

import yawen.datastruct.TreeNode;

public class LC100 {
	/*
	static boolean PreOrderTraverse(TreeNode T1,TreeNode T2) {
		boolean out;
		if(T1==null&&T2==null)
			return true;
		if(T1 == null||T2 == null)
			return false;
		if(T1.val!=T2.val)
			return false;
		out = PreOrderTraverse(T1.l,T2.l);
		if(out == false)
			return out;
		out = PreOrderTraverse(T1.r,T2.r);
		if(out == false)
			return out;
		return out;
	}
	*/
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	//Ç°Ðò±éÀú
		boolean out;
		if(p==null&&q==null)
			return true;
		if(p == null||q == null)
			return false;
		if(p.val!=q.val)
			return false;
		out = isSameTree(p.left,q.left);
		if(out == false)
			return out;
		out = isSameTree(p.right,q.right);
		if(out == false)
			return out;
		return out;
    }
    
    public static void main(String[] args) {
    	//p = [1,2,3], q = [1,2,3]
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode q = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        q.left.left = new TreeNode(5);
        System.out.print(isSameTree(p,q));
    }
}
