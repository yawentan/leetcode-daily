package yawen;

import java.util.Arrays;

public class LC611M {
    public int triangleNumber(int[] nums) {
    	int ans = 0;
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length;i++) {
    		for(int j=i+1;j<nums.length;j++) {
    			int idxl = Math.max(j,BinarySearch(nums,j+1,nums.length,nums[j]-nums[i],false));
    			int idxr = BinarySearch(nums,j+1,nums.length,nums[j]+nums[i]-1,true);
    			ans+=(idxr-idxl);
    		}
    	}
    	return ans;
    }
    
    /**
     * ¶ş·ÖÕÒ±ß½ç
     * @param nums
     * @param l
     * @param r
     * @param t
     * @param flag
     * @return
     */
    public int BinarySearch(int[] nums,int l,int r,int t,boolean flag) {
    	while(l<r) {
    		int m = l+(r-l)/2;
    		if(t>nums[m]) {
    			l = m+1;
    		}else if(t<nums[m]) {
    			r = m;
    		}else {
    			if(flag){
    				l=m+1;
    			}else {
    				r=m;
    			}
    		}
    	}
		return l;
    }
    
    public static void main(String[] args) {
		int[] nums = {0,2,2,1};
		int[] s = {2,2,2,2};
		LC611M lc = new LC611M();
		System.out.println(lc.BinarySearch(s, 0, s.length, 2,true));
		System.out.println(lc.triangleNumber(nums));
	}
}
