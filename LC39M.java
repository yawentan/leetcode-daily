package yawen;

import java.util.*;

public class LC39M {
	List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	
    	dfs(0,candidates,0,new LinkedList<Integer>(),target);
    	return this.ans;
    }
	private void dfs(int lastIdx, int[] nums, int sum, List<Integer> res,int target) {
		if(sum>target)
			return;
		if(sum==target) {
			List<Integer> temp = new LinkedList<Integer>();
			temp.addAll(res);
//			Collections.copy(temp, res);
			this.ans.add(temp);
			return;
		}
		
		for(int i = lastIdx;i<nums.length;i++) {
			res.add(nums[i]);
			dfs(i,nums,sum+nums[i],res,target);
			res.remove(res.size()-1);
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		LC39M lc = new LC39M();
		lc.combinationSum(candidates, target);
	}
}
