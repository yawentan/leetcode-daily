package yawen;

public class LC33M {
    public int search(int[] nums, int target) {
        int k = -1;
        for(int i=1;i<nums.length;i++) {
        	if(nums[i]<nums[i-1]) {
        		k = i;
        		break;
        	}
        }
        
        int idx1 = BinarySearch(nums,0,k,target);
        int idx2 = BinarySearch(nums,k,nums.length,target);
        return idx1==-1?idx2==-1?-1:idx2:idx1;
    }

	private int BinarySearch(int[] nums, int i, int k, int target) {
		int l = i;
		int r = k;
		while(l<r) {
			int m = l + (r-l)/2;
			if(nums[m]>target) {
				r=m;
			}else if(nums[m]<target) {
				l = m+1;
			}else
				return m;
		}
		return -1;
	}
}
