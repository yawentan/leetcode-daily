package yawen;

/*
 * @author: yawen
 * @describe: ����
 * @remark: m����һ�����Ե����������ܰ�����l�в�Ȼ�ᵼ����ѭ����
 */

public class LC35 {
	class Solution {
	    public int searchInsert(int[] nums, int target) {
	    	int l = 0,r=nums.length-1;
	    	int m;
	    	if(target>nums[r])
	    		return r+1;
	    	while(l<r) {
	    		//m = (l+r)/2;
	    		m=l+((r-l)>>1);//��ֹr+l�����λ�����ӿ��ٶ�
	    		if(nums[m]<target) {
	    			l=m+1;
	    		}else
	    			r=m;
	    	}
	    	return l;
	    }
	}
	
	public static void main(String arg[]) {
		LC35 lc = new LC35();
		Solution st = lc.new Solution();
		int[] nums = {1,3,5,6};
		int t = 4;
		//System.out.println(t>>1);
		System.out.println(st.searchInsert(nums, t));
	}
}
