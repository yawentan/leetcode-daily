package yawen;

import org.junit.Test;

//KMP忘了
/*
 * @author: yawen
 * @description:靠回忆打了份KMP，算法思路我是知道的
 * s:长字符串,t短字符串
 * 关键思想就是，在t中存在重复时，尽量减少回溯。通过构建Next数组
 * 其中存在几个要注意的点：1.Next第1，2个是确定的-1，0
 * 2.-1表示第一个字符也不匹配，强制进位
 * 时间复杂度O(n+m)
 */
public class LC28 {
	class Solution {
	    public int strStr(String haystack, String needle) {
	    	if(needle.length()==0)
	    		return 0;
	    	if(haystack.length()==0)
	    		return -1;
	    	//KMP
	    	int i=0,j=0;
	    	int[] Next = this.getNext(needle);
	    	while(i<haystack.length()&&j<needle.length()) {
	    		if(j==-1||haystack.charAt(i)==needle.charAt(j)) {
	    			i++;j++;
	    		}else {
	    			j=Next[j];
	    	    	//System.out.println("i,j:"+i+" "+j);
	    		}
	    	}
	    	return j==needle.length()?i-j:-1;
	    }
	    
	    int[] getNext(String n) {
	    	
	    	int[] Next = new int[n.length()];
	    	if(n.length()==0)
	    		return Next;
	    	Next[0] = -1;
	    	if(n.length()==1)
	    		return Next;
	    	Next[1] = 0;
	    	int j = 0;
	    	int i=2;
	    	while(i<n.length()) {
	    		if(j==-1||n.charAt(i-1)==n.charAt(j)) {
	    			Next[i] = j+1;
	    			i++;j++;
	    		}else {
	    			j=Next[j];
	    		}
	    	}
	    	/*
	    	for(int k=0;k<Next.length;k++) {
	    		System.out.println(Next[k]);
	    	}*/
	    	return Next;
	    }
	}
	public static void main(String[] args) {
		LC28 LC = new LC28();
		Solution st = LC.new Solution();
		String haystack = "aabaaabaaac", needle = "aabaaac";
		//st.getNext(needle);
		System.out.println(st.strStr(haystack,needle));
	}
}
