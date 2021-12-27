package yawen;

import java.util.Arrays;

public class LC825M {
	public static void main(String[] args) {
		int[] nums = {108,115,5,24,82};
		System.out.println(numFriendRequests(nums));
	}
	
    public static int numFriendRequests(int[] ages) {
    	int[] tab = new int[121];
    	for(int k:ages) {
    		tab[k]++;
    	}
    	for(int i=1;i<121;i++) {
    		tab[i]+=tab[i-1];
    	}
    	int ans = 0;
    	for(int k:ages) {
    		int	left = k/2+7;
    		int right = k;
    		if(left<right) {
    			ans += tab[right]-tab[left];   
    			ans--;
    		}
    	}
    	return ans;
    }
}
