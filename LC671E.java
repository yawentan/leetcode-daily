package yawen;

import java.util.LinkedList;
import java.util.Queue;

import yawen.datastruct.*;

public class LC671E {
	    public int findSecondMinimumValue(TreeNode root) {
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        boolean flag = false;
	        int Min = root.val;
	        int ans = Integer.MAX_VALUE;
	        while(!q.isEmpty()) {
	        	int sz = q.size();
	        	for(int i=0;i<sz;i++) {
	        		TreeNode temp = q.poll();
	        		if(temp==null)
	        			continue;
	        		if(temp.val>Min) {
	        			ans = Math.min(ans, temp.val);
	        			flag = true;
	        		}
	        		q.add(temp.left);
	        		q.add(temp.right);
	        	}
	        }

        	if(flag)
        		return ans;
	        return -1;
	    }
	    public static void main(String[] args) {
	    	LC671E lc = new LC671E();
	    	TreeNode root = new TreeNode(2);
	    	System.out.println(lc.findSecondMinimumValue(root));
		}
	    
}
