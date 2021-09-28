package yawen;

public class LC17_10E {
    public int majorityElement(int[] nums) {
    	int candi = -1;
    	int count = 0;
    	for(int i=0;i<nums.length;i++) {
        	if(count==0) {
        		candi=nums[i];
        		count++;
        	}else{
        		if(nums[i]==candi){
        			count++;
            	}else {
            		count--;
            	}
        	}
    	}
    	int cont=0;
    	for(int n:nums) {
    		if(n==candi)
    			cont++;
    	}
    	return cont>(nums.length+1)>>2?candi:-1;
    }
}
