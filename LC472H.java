package yawen;

import java.util.*;

/**
 * @�ⷨ hash��¼ÿ�����ʣ������α���ÿ���ַ���������dp[i]��ʾ�Ƿ�Ϊ���Ӵʣ�ʱ�临�Ӷ�С��n^2
 * 		�÷������Զ�ÿ�����ʳ��Ƚ������򣬴�С��ʼ����������ʱ�临�Ӷ�
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
