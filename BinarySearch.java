package yawen;

public class BinarySearch {
	int LeftBoundSearch(int[] nums,int target) {
		int left = 0,right = nums.length-1;
		if(nums.length==0) return -1;
		
		while(left<=right) {
			int mid = left + (right-left)/2;
			
			if(nums[mid]<target) {
				left = mid + 1;
			}else if(nums[mid]>target) {
				right = mid - 1;
			}
			else if(nums[mid]==target) {
				right = mid - 1;
			}
		}
		
		if(left==nums.length||nums[left]!=target)
			return -1;
		
		return left;
	}
	
	
	int RightBoundSearch(int nums[],int target) {
		int left = 0,right = nums.length-1;
		
		while(left<=right) {
			int mid = left + (right-left)/2;
			
			if(nums[mid]<target) {
				left = mid + 1;
			}else if(nums[mid]>target) {
				right = mid - 1;
			}else if(nums[mid]==target) {
				left = mid + 1;
			}
		}
		if(right<0||nums[right]!=target) return -1;
		
		return right;
	}
	
	int Search(int[] nums,int target) {
		int left = 0;
		int right = nums.length;
		
		while(left<right) {
			int mid = left+((right-left)>>1);
			
			if(nums[mid]==target) {
				return mid;
			}else if(nums[mid]<target) {
				left = mid + 1;
			}else if(nums[mid]>target) {
				right = mid;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,1,1,1};
		
		BinarySearch BF = new BinarySearch();
		System.out.println(BF.RightBoundSearch(nums,2));
	}
}
