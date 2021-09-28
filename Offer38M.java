package yawen;

import java.util.*;
/**
 * »ØËÝ
 * @author yawen
 *
 */
public class Offer38M {
	HashMap<String,Boolean> ans = new HashMap<>();
	
    public String[] permutation(String s) {
    	int[] visited = new int[s.length()];
    	dfs(s,"",visited);
    	int k=0;
    	String[] out = new String[ans.size()];
    	Set<String> set = ans.keySet();
    	for(String c:set) {
    		out[k++]=c;
    	}
    	return out;
    }

	private void dfs(String s,String string, int[] visited) {
		if(string.length()==visited.length) {
			if(!ans.containsKey(string)) {
				ans.put(string,true);
			}
		}
		
		for(int i=0;i<s.length();i++) {
			if(visited[i]==0) {
				visited[i]=1;
				dfs(s,string+s.charAt(i),visited);
				visited[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		Offer38M lc = new Offer38M();
		String[] pt = lc.permutation("aa");
		for(String c:pt) {
			System.out.println(c);			
		}
	}
}
