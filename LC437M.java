package yawen;

import yawen.datastruct.TreeNode;

public class LC437M {
	@org.junit.Test
	public void test() {
		TreeNode r = new TreeNode(10);
		r.left = new TreeNode(5);
		r.left.left = new TreeNode(3);
		System.out.println(pathSum(r,8));
	}
	
	static int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
    	ans = 0;
    	dfs(root,targetSum);
    	return ans;
    }
    public void dfs(TreeNode r,int t){
        if(r==null) {
        	return;
        }
        dfs(r,t,0);
        dfs(r.left,t);
        dfs(r.right,t);
        return;
    }
    public void dfs(TreeNode r,int t,int sum){
    	if(r==null) {
    		return;
    	}
    	sum+=r.val;
    	if(sum==t) {
    		ans++;
    	}
        dfs(r.left,t,sum);
        dfs(r.right,t,sum);
    }
}
