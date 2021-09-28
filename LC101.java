package yawen;

import java.util.*;
import yawen.datastruct.TreeNode;
/*
 * author:yawen
 * description:我的思路方法都显得那么幼稚臃肿,太蠢了
 */
public class LC101 {
	public static boolean isSymmetric(TreeNode root) {
		return check(root,root);
	}
	public static boolean check(TreeNode p,TreeNode q) {
		if(p==null&&q==null)
			return true;
		if(p==null||q==null)
			return false;
		if(p.val!=q.val)
			return false;
		return check(p.left,q.right)&&check(p.right,q.left);
	}
	
    public static boolean isSymmetric2(TreeNode root) {
    	Queue<TreeNode> l = new LinkedList<>();//bfs
    	Queue<TreeNode> r = new LinkedList<>();//bfs
    	if(root.left==null&&root.right!=null)
    		return false;
    	if(root.left!=null&&root.right==null)
    		return false;
    	if(root.left==null&&root.right==null)
    		return true;
    	if(root.left.val==root.right.val) {
        	l.add(root.left);
        	r.add(root.right);
    	}else
    		return false;
    	while(!l.isEmpty()&&!r.isEmpty()) {
    		TreeNode templ,tempr;
    		templ = l.poll();
    		tempr = r.poll();
    		/*
    		if(templ.left!=null&&templ.right!=null&&tempr.left!=null&&tempr.right!=null) {
	    		if(templ.left.val!=tempr.right.val||templ.right.val!=tempr.left.val)
	    			return false;
    		}else {
    			*/
    			if(templ.left==null&&tempr.right!=null)
    				return false;
    			if(templ.left!=null&&tempr.right==null)
    				return false;
    			if(templ.right==null&&tempr.left!=null)
    				return false;
    			if(templ.right!=null&&tempr.left==null)
    				return false;
    		//}
			if(templ.left!=null&&tempr.right!=null) {
				if(templ.left.val!=tempr.right.val)
	    			return false;
    			l.add(templ.left);
    			r.add(tempr.right);
			}
			if(templ.right!=null&&tempr.left!=null) {
				if(templ.right.val!=tempr.left.val)
	    			return false; 
    			l.add(templ.right);
    			r.add(tempr.left);
			}
    	}
    	if(!l.isEmpty()||!r.isEmpty())
    		return false;
    	return true;
    }
    
    
    public static void main(String[] args) {
    	TreeNode T = new TreeNode(9);
//    	T.left = new TreeNode(25);
//    	T.right = new TreeNode(25);
//    	T.left.right = new TreeNode(-95);
//    	T.right.left = new TreeNode(-95);
//    	T.left.right.left = new TreeNode(-100);
//    	T.right.left.right = new TreeNode(-15);
    	int[] nums = {9,25,25,-1,-95,-95,-1,-1,-1,-100,-1,-1,-15,-1,-1};
    	T = T.NumpadToTree(nums);
    	T.PreOrderTraverse(T);
    	//System.out.println(isSymmetric(T));
    }
}
