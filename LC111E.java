package yawen;

import yawen.datastruct.*;
import java.util.*;

public class LC111E {
    public int minDepth(TreeNode root) {
    	int step = 1;
    	if(root == null)
    		return 0;
    	Queue<TreeNode> q = new LinkedList<>();//bfs����
    	q.add(root);
    	
    	while(!q.isEmpty()) {
    		int sz = q.size();
    		//��ͬһ��ȫ������
    		for(int i=0;i<sz;i++) {
        		TreeNode temp = q.poll();
        		//��ֹ����
        		if(temp.left == null&&temp.right == null)
        			return step;
        		//��ӵ�ǰ�ڵ�������ھӽڵ�
        		if(temp.left!=null)
        			q.add(temp.left);
        		if(temp.right!=null)
        			q.add(temp.right);
    		}
    		step++;
    	}
    	return step;
    }
    
    public static void main(String[] args) {
    	LC111E lc = new LC111E();
    	int[] root = {2,-1,3,-1,4,-1,5,-1,6};
    	TreeNode T = new TreeNode();
    	T = T.NumpadToTree(root);
    	System.out.println(lc.minDepth(T));
    }
}
