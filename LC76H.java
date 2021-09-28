/*
 * 码就完事儿了:
 * Java 用Map记录字母出现个数的写法，
 * 最后一个测试用例通不过时，要明白一件事。
 * Integer是对象
 * Integer会缓存频繁使用的数值，
 * 数值范围为-128到127，在此范围内直接返回缓存值。
 * 超过该范围就会new 一个对象。
 * Toogle:
 * == 是值相等。对于Integer这样的数据类型而言，意义是两个Integer对象的内存地址相等。
 * 也就是说如果你有两个不同的Integer的对象，哪怕他们的值一样，用==判断也是不相等的。 
 * 如果是基本类型int，用equals也是可以的。因为编译器会自动把int装箱为Integer。
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
    		//增加c进入窗口
    		char c = s.charAt(right);
    		right++;
    		if(need.containsKey(c)) {
        		if(window.get(c)==null)
        			window.put(c, 1);
        		else
        			window.put(c, window.get(c)+1);
        		//这个地方直接判断相等，出bug了
    			if(window.get(c)==need.get(c))
    				vaild++;//表示一个字符满足了
    		}
    		//表示need所有字符window中都有对应
    		while(vaild==need.size()) {
    			if(right-left<Len) {
    				Flag = false;
    				start = left;
    				Len = right-left;
    			}
    			//d为要移除窗口的值
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
