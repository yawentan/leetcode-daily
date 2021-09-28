package yawen;

import java.util.LinkedList;
import java.util.List;

public class LC1239M {
	int ans = 0;
	public int dfs(List<String> arr,int idx,int[] Tab,boolean flg,int n) {
		if(idx==arr.size()) {
			this.ans = Math.max(this.ans, n);
			return n;
		}
		int[] TabCopy = new int[26];
		for(int i=0;i<26;i++) {
			TabCopy[i] = Tab[i];
		}
		if(flg) {
			for(int i=0;i<arr.get(idx).length();i++) {
				if(TabCopy[arr.get(idx).charAt(i)-'a']==1) {
					return 0;
				}else {
					TabCopy[arr.get(idx).charAt(i)-'a']=1;
				}
			}
			n+=arr.get(idx).length();
		}
		dfs(arr,idx+1,TabCopy,false,n);//idx+1不加入字段
		dfs(arr,idx+1,TabCopy,true,n);//idx+1加入字段
		return 0;
	}
	
    public int maxLength(List<String> arr) {
    	int[] Tab = new int[26];
		dfs(arr,0,Tab,false,0);
		dfs(arr,0,Tab,true,0);
		return this.ans;
    }
	
	public static void main(String[] args) {
		List<String> arr = new LinkedList<>();
		arr.add("a");
		arr.add("ab");
		arr.add("c");
		arr.add("cd");
		LC1239M lc = new LC1239M();
		System.out.println(lc.maxLength(arr));
	}
}
