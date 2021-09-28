package yawen.datastruct;

import java.util.*;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode() {}
	public TreeNode(int val){
		this.val = val;
	}
	public TreeNode(int val,TreeNode l,TreeNode r){
		this.right = r;
		this.left = l;
		this.val = val;
	}
	public TreeNode(int val,TreeNode l){
		this.left = l;
		this.val = val;
	}
	//前序遍历
	public void PreOrderTraverse(TreeNode T) {
		if(T == null) 
			return;
		System.out.print(T.val);
		PreOrderTraverse(T.left);
		PreOrderTraverse(T.right);
	}
	//中序遍历
	public void InOrderTraverse(TreeNode T) {
		if(T==null)
			return;
		InOrderTraverse(T.left);
		System.out.print(T.val);
		InOrderTraverse(T.right);
	}
	//后序遍历
	public void PostOrderTraverse(TreeNode T) {
		if(T==null)
			return;
		PostOrderTraverse(T.left);
		PostOrderTraverse(T.right);
		System.out.print(T.val);
	}
	
	//数组转化为树
	public TreeNode NumpadToTree(int[] Nums) {
		int n = Nums.length;
		if(n==0) {
			return null;
		}
		TreeNode T = new TreeNode(Nums[0]);
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(T);
		//int l = (int)(Math.log(n+1)/Math.log(2));
		//while(i<l)
		int k = 1;
		while(k<n) {
			TreeNode temp = q.poll();
			if(Nums[k]!=-1) {
				temp.left = new TreeNode(Nums[k++]);
				q.add(temp.left);
				
			}else
				k++;
			if(Nums[k]!=-1) {
				temp.right = new TreeNode(Nums[k++]);
				q.add(temp.right);
			}else
				k++;
		}
		//System.out.println(l);
		//q.add(Nums[])
		return T;
	}
	
    public static void main(String[] args) {
    	//p = [1,2,3], q = [1,2,3]
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode q;// = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        //isSameTree(p,q);
        int[] num = {1,2,3,4,5,6,7};
        q = p.NumpadToTree(num);
        q.PostOrderTraverse(q);
    }
}
