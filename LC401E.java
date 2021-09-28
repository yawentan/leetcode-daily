package yawen;

import java.util.*;

public class LC401E {
    public static List<String> readBinaryWatch(int turnedOn) {
    	List<String> ans = new LinkedList<>();
    	
    	for(int i=0;i<Math.pow(2, 10);i++) {
    		int temp = 1;
    		int times = 0,timeh=0;
    		int cont = 0;//记录多少个1
    		for(int j=0;j<10;j++) {
    			if((i&temp)!=0) {
    				cont++;
    				if(j<6) {
    					times+=Math.pow(2, j);
    				}else {
    					timeh+=Math.pow(2, j-6);
    				}
    			}
    			temp<<=1;
    		}
    		if(cont==turnedOn&&times<60&&timeh<12) {
    			String s = String.valueOf(timeh)+":";
    			if(times<10) {
    				s+="0";
    			}
    			s+=String.valueOf(times);
    			ans.add(s);
    		}
    	}
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	System.out.println(readBinaryWatch(0));
	}
}
