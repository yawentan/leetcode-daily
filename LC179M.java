package yawen;

import java.util.*;

class Node179 implements Comparable<Node179>{
    String s;
    
    public int compareTo(Node179 o){
        int idx = 0;
        if(s.length()==o.s.length()){
            return s.compareTo(o.s);
        }
        while(idx<s.length()&&idx<o.s.length()){
            if(s.charAt(idx)!=o.s.charAt(idx)){
                return s.charAt(idx)-o.s.charAt(idx);
            }
            idx++;
        }
//        System.out.println(o.s);
        if(s.length()==idx){
            return o.s.charAt(idx-1)-o.s.charAt(idx);
        }else {
            return s.charAt(idx)-s.charAt(idx-1);
        }
    }
}

public class LC179M {
	public static void main(String[] args) {
		int[] nums = {30,34,3};
		System.out.println(LC179M.largestNumber(nums));
	}
	
    public static String largestNumber(int[] nums) {
    	Node179[] s = new Node179[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i] = new Node179();
            s[i].s = String.valueOf(nums[i]);
        }
        Arrays.sort(s);
        for(int i=0;i<nums.length;i++){
            System.out.println(s[i].s);
        }
        String ans= "";
        for(int i=s.length-1;i>=0;i--){
            ans+=s[i].s;
        }
        return ans;
    }
}
