package yawen;

import org.junit.Test;

//KMP����
/*
 * @author: yawen
 * @description:��������˷�KMP���㷨˼·����֪����
 * s:���ַ���,t���ַ���
 * �ؼ�˼����ǣ���t�д����ظ�ʱ���������ٻ��ݡ�ͨ������Next����
 * ���д��ڼ���Ҫע��ĵ㣺1.Next��1��2����ȷ����-1��0
 * 2.-1��ʾ��һ���ַ�Ҳ��ƥ�䣬ǿ�ƽ�λ
 * ʱ�临�Ӷ�O(n+m)
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
