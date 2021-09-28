package yawen;

import java.util.*;
import yawen.datastruct.*;

/*
 * author:yawen
 * description: 本来是沿用上一题的动态规划，但是卡在拷贝内存的位置上
 * 后来看了题解后写得递归
 * 总结：递归终止条件在所有子树中添加null有利于防止无解的情况
 */


public class LC95M {
	List<TreeNode> out = new LinkedList<>();
	//从i-j建树保存所有可能的子树
	public List<TreeNode> Back(int i,int j){
		List<TreeNode> ans = new LinkedList<>();
		List<TreeNode> l = new LinkedList<>();
		List<TreeNode> r = new LinkedList<>();
		TreeNode T;
		//这个处理方式解决了返回null的情况
		if(i>j) {
			ans.add(null);
			return ans;
		}
		for(int k=i;k<=j;k++) {
			l = Back(i,k-1);
			r = Back(k+1,j);
			//以k为节点时，结合所有可能的子树
			for(TreeNode left:l) {
				for(TreeNode right:r) {
					T = new TreeNode(k);
					T.left = left;
					T.right = right;
					ans.add(T);
				}
			}
		}
		return ans;
	}
	
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new LinkedList<TreeNode>();
    	return Back(1,n);
    }
    
    public static void main(String[] args) {
    	LC95M lc = new LC95M();
    	lc.generateTrees(0);
    }
}
