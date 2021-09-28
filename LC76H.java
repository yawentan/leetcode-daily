/*
 * ������¶���:
 * Java ��Map��¼��ĸ���ָ�����д����
 * ���һ����������ͨ����ʱ��Ҫ����һ���¡�
 * Integer�Ƕ���
 * Integer�Ỻ��Ƶ��ʹ�õ���ֵ��
 * ��ֵ��ΧΪ-128��127���ڴ˷�Χ��ֱ�ӷ��ػ���ֵ��
 * �����÷�Χ�ͻ�new һ������
 * Toogle:
 * == ��ֵ��ȡ�����Integer�������������Ͷ��ԣ�����������Integer������ڴ��ַ��ȡ�
 * Ҳ����˵�������������ͬ��Integer�Ķ����������ǵ�ֵһ������==�ж�Ҳ�ǲ���ȵġ� 
 * ����ǻ�������int����equalsҲ�ǿ��Եġ���Ϊ���������Զ���intװ��ΪInteger��
 */

package yawen;

import java.util.*;

public class LC76H {
    public static String minWindow(String s, String t) {
    	HashMap<Character,Integer> need = new HashMap<>(),window = new HashMap<>();
    	int left = 0,right = 0;
    	int start = 0,Len = Integer.MAX_VALUE;
    	int vaild = 0;
    	boolean Flag = true;
    	for(int i=0;i<t.length();i++) {
    		char c = t.charAt(i);
    		if(need.get(c)==null)
    			need.put(c,1);
			else
    			need.put(c,need.get(c)+1);
    	}
    	
    	while(right<s.length()) {
    		//����c���봰��
    		char c = s.charAt(right);
    		right++;
    		if(need.containsKey(c)) {
        		if(window.get(c)==null)
        			window.put(c, 1);
        		else
        			window.put(c, window.get(c)+1);
        		//����ط�ֱ���ж���ȣ���bug��
    			if(window.get(c)==need.get(c))
    				vaild++;//��ʾһ���ַ�������
    		}
    		//��ʾneed�����ַ�window�ж��ж�Ӧ
    		while(vaild==need.size()) {
    			if(right-left<Len) {
    				Flag = false;
    				start = left;
    				Len = right-left;
    			}
    			//dΪҪ�Ƴ����ڵ�ֵ
    			char d = s.charAt(left);
    			left++;
    			if(need.containsKey(d)) {
    				if(window.get(d)==need.get(d))
    					vaild--;
        			window.put(d, window.get(d)-1);
    			}
    		}
    	}
    	if(Flag)
    		return "";
    	return s.substring(start,start+Len);
    }
    
    public static void main(String[] args) {
    	String s = "ADOBECODEBANC",t = "ABC";
    	System.out.println(minWindow(s,t));
    }
}
