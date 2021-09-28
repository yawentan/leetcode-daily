package yawen;

import java.util.*;

class Node1713{
	int i;
	int j;
	public Node1713(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node1713 other = (Node1713) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
}

public class LC1713H {
//	int res=0;
//	HashMap<Integer,TreeSet<Integer>> map = new HashMap<Integer, TreeSet<Integer>>();
//	Map<Node1713,Integer> dp2 = new HashMap<>();
//	int[][] dp;
//    public int minOperations(int[] target, int[] arr) {
//
//    	//±£´ækey£¬idx
//    	for(int i=0;i<arr.length;i++) {
//    		if(map.containsKey(arr[i])) {
//    			TreeSet<Integer> temp = map.get(arr[i]);
//    			temp.add(i);
//    			map.put(arr[i], temp);
//    		}else {
//    			TreeSet<Integer> temp = new TreeSet<Integer>();
//    			temp.add(i);
//    			map.put(arr[i], temp);
//    		}
//    	}
//    	int[][] dp = new int[target.length][arr.length];
//    	dp[target.length-1][arr.length-1]=target[target.length-1]==arr[arr.length-1]?1:0;
//    	for(int i=target.length-2;i>=0;i--) {
//    		dp[i][arr.length-1] = arr[arr.length-1]==target[i]?1:dp[i+1][arr.length-1];
//    	}
//    	for(int i=arr.length-2;i>=0;i--) {
//    		dp[target.length-1][i] = target[target.length-1]==arr[i]?1:dp[target.length-1][i+1];
//    	}
//    	for(int i=target.length-2;i>=0;i--) {
//    		for(int j=arr.length-2;j>=0;j--) {
//    			if(target[i]!=arr[j]) {
//    				dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);		
//    			}else {
//    				dp[i][j] = dp[i+1][j+1]+1;
//    			}
//    		}
//    	}
//    	
//    	
//    	//dfs(0,-1,0,target);
//    	return target.length-dp[0][0];
//    }
//    
//    private int dfs(int i, int j, int ans,int[] target) {
//    	Node1713 nod1713 = new Node1713(i,j+1);
//    	if(ans+target.length-i<this.res)
//    		return -1;
//    	if(i==target.length) {
//    		this.res = Math.max(this.res, ans);
//    		return ans;
//    	}
//    
//    	
//    	if(dp2.containsKey(nod1713)&&dp2.get(nod1713)!=0) {
//    		this.res = Math.max(this.res, ans+dp2.get(nod1713));
//    		return ans+dp2.get(nod1713);
//    	}
////    	if(dp[i][j+1]!=0) {
////    		this.res = Math.max(this.res, ans+dp[i][j+1]);
////    		return ans+dp[i][j+1];
////    	}
//    	if(map.containsKey(target[i])==false) {
//    		return dfs(i+1,j,ans,target);
//    	}
//
//    	TreeSet<Integer> temp = map.get(target[i]);
//    	if(temp.higher(j)==null) {
//    		return dfs(i+1,j,ans,target);
//    	}
//    	int k1 = dfs(i+1,temp.higher(j),ans+1,target);
//    	int k2 = dfs(i+1,j,ans,target);
//    	if(i==610&&j==995)
//    		i=i;
//    	dp2.put(nod1713, Math.max(k1, k2)-ans);
////    	dp[i][j+1] = Math.max(k1, k2)-ans;
//		return Math.max(k1, k2);
//	}

    
    public int minOperations(int[] target, int[] arr) {
    	Map<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
    	for(int i=0;i<target.length;i++) {
    		hashMap.put(target[i], i);
    	}
    	Stack<Integer> ans = new Stack<>();
    	List<Integer> d = new ArrayList<>();
    	for(int n:arr) {
    		if(hashMap.containsKey(n)==false)
    			continue;
    		ans.add(hashMap.get(n));
    		if(d.size()==0||d.get(d.size()-1)<ans.peek()) {
    			d.add(ans.peek());
    		}else if(d.get(d.size()-1)>ans.peek()) {
    			int idx = BinarySearch(d,ans.peek());
    			if(d.get(idx)>ans.peek()) {
        			d.remove(idx);
        			d.add(idx,ans.peek());
    			}
    		}
    	}
    	return target.length-d.size();
    }
    
	private int BinarySearch(List<Integer> d, int n) {
		int l=0,r=d.size();
		
		while(l<r) {
			int m = l+(r-l)/2;
			if(d.get(m)>n) {
				r=m;
			}else if(d.get(m)<n) {
				l = m+1;
			}else {
				return m;
			}
		}
		
		return l;
	}
	public static void main(String[] args) {
    	LC1713H lc = new LC1713H();
    	int[] target = {6,4,8,1,3,2},arr = {4,7,6,2,3,8,6,1};
    	System.out.println(lc.minOperations(target, arr));
	}
}
