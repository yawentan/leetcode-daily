package yawen;

import java.util.*;

/**
 * @解法 hash记录每个单词，再依次遍历每个字符串，采用dp[i]表示是否为连接词，时间复杂度小于n^2
 * 		该方法可以对每个单词长度进行排序，从小开始遍历来降低时间复杂度
 * @author yawen
 *
 */
public class LC472H {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    	Set<String> set = new HashSet<String>();
    	for(String s:words) {
    		set.add(s);
    	}
    	List<String> ans = new ArrayList<>();
    	for(String s:words) {
    		if(s.length()==0)
    			continue;
    		boolean[] dp = new boolean[s.length()+1];
    		dp[0]=true;
    		for(int i=1;i<=s.length();i++) {
    			for(int j=0;j<i;j++) {
    				if(j==0&&i==s.length())
    					continue;
    				dp[i]=dp[j]&&set.contains(s.substring(j, i));
    				if(dp[i])
    					break;
    			}
    		}
    		if(dp[s.length()]) {
    			ans.add(s);
    		}
    	}
    	return ans;
    }
}
