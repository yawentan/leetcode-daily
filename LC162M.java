package yawen;

public class LC162M {
	@org.junit.Test
	public void test() {
		int[] nums = {2};
		System.out.println(findPeakElement(nums));
				
	}
	
    public int findPeakElement(int[] nums) {
    	return div(nums,0,nums.length);
    }

	private int div(int[] nums, int l, int r) {
		if(r-l<2||r<=l) {
			return -1;
		}
		// TODO Auto-generated method stub
		int m = l + (r-l)/2;
		int left = div(nums,l,m);
		int right = div(nums,m,r);
		if(left==-1&&right==-1) {
			if(nums[m-1]<nums[m]) {
				if(m+1>=nums.length||nums[m]>nums[m+1]) {
					return m;
				}else
					return -1;
			}else {
				if(m-2<0||nums[m-1]>nums[m-2]) {
					return m-1;
				}else
					return -1;
			}
		}else
			return left==-1?right:left;
	}
}
