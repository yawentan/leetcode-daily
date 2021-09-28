package yawen;

public class LC34M {
    public static int[] searchRange(int[] nums, int target) {
    	int[] ans = new int[2];
    	ans[0] = -1;
    	ans[1] = -1;
    	if(nums.length==0) return ans;
    	int l = 0,r = nums.length-1;
    	//ср╠ъ╫Г
    	while(l<=r) {
    		int m = l + (r-l)/2;
    		
    		if(nums[m]<=target)
    			l = m + 1;
    		else if(nums[m]>target)
    			r = m - 1;
    	}
    	int outr,outl;
    	if(r<0||nums[r]!=target)	outr = -1;
    	else
    		outr = r;
    	l = 0;
    	r = nums.length-1;
    	while(l<=r) {
    		int m = l+(r-l)/2;
    		if(nums[m]<target)
    			l = m + 1;
    		else if(nums[m]>=target)
    			r = m - 1;
    	}
    	if(l==nums.length||nums[l]!=target) outl = -1;
    	else
    		outl = l;
    	
    	ans[0] = outl;
    	ans[1] = outr;
    	
    	return ans;
    }
    
    public static void main(String[] args) {
    	int[] nums = {};
    	int target = 6;
    	System.out.println(searchRange(nums,target)[0]);
    	System.out.println(searchRange(nums,target)[1]);
    }
}
