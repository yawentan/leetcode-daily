package yawen;

public class LC42H {
	@org.junit.Test
	public void test() {
		int[] height = {4,2,0,3,2,5};
		System.out.println(trap(height));
	}
	
    public int trap(int[] height) {
    	int left = 0;
    	int temp = 0;
    	int ans = 0;
    	for(int i=1;i<height.length;i++) {
    		if(height[left]<=height[i]) {
    			//挨着
    			if(i-left==1) {
    				left = i;    				
    			}else {//没挨着
    				ans+=temp;
    				temp = 0;
    				left = i;
    			}
    		}else {
    			temp+=height[left]-height[i];
    		}
    	}
    	temp = 0;
    	int right = height.length-1;
    	for(int i=height.length-2;i>=0;i--) {
    		if(height[right]<height[i]) {
    			//挨着
    			if(i-right==-1) {
    				right = i;    				
    			}else {//没挨着
    				ans+=temp;
    				temp = 0;
    				right = i;
    			}
    		}else {
    			temp+=height[right]-height[i];
    		}
    	}
    	return ans;
    }
}
