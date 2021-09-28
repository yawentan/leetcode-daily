package yawen;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class LC40M {
	Set<List<Integer>> ans = new HashSet<>();
	List<List<Integer>> ans2 = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	
    	dfs(-1,candidates,0,new LinkedList<Integer>(),target);
    	for(List<Integer>l:ans) {
    		ans2.add(l);
    	}
    	return this.ans2;
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
		int temp = -1;
		for(int i = lastIdx+1;i<nums.length;i++) {
			if(nums[i]==temp)
				continue;
			res.add(nums[i]);
			dfs(i,nums,sum+nums[i],res,target);
			temp = res.remove(res.size()-1);
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] candidates = {2,5,2,1,2};
		int target = 5;
		LC40M lc = new LC40M();
		lc.combinationSum2(candidates, target);
	}
}
