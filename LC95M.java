package yawen;

import java.util.*;
import yawen.datastruct.*;

/*
 * author:yawen
 * description: ������������һ��Ķ�̬�滮�����ǿ��ڿ����ڴ��λ����
 * ������������д�õݹ�
 * �ܽ᣺�ݹ���ֹ�������������������null�����ڷ�ֹ�޽�����
 */


public class LC95M {
	List<TreeNode> out = new LinkedList<>();
	//��i-j�����������п��ܵ�����
	public List<TreeNode> Back(int i,int j){
		List<TreeNode> ans = new LinkedList<>();
		List<TreeNode> l = new LinkedList<>();
		List<TreeNode> r = new LinkedList<>();
		TreeNode T;
		//�������ʽ����˷���null�����
		if(i>j) {
			ans.add(null);
			return ans;
		}
		for(int k=i;k<=j;k++) {
			l = Back(i,k-1);
			r = Back(k+1,j);
			//��kΪ�ڵ�ʱ��������п��ܵ�����
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
