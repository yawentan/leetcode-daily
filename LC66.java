package yawen;

public class LC66 {
	class Solution {
		public int[] plusOne(int[] digits) {
			for(int i=digits.length-1;i>=0;i--) {
				if(digits[i]==9) {
					if(i==0) {
						int[] out = new int[digits.length+1];
						out[0] = 1;
						return out;
					}
					digits[i] = 0;
					continue;
				}
				else {
					digits[i]++;
					return digits;
				}
			}
			return digits;
		}
	}
	
	
	public static void main(String[] args) {
		LC66 lc = new LC66();
		Solution st = lc.new Solution();
		int[] d = {8,9,9};
		int[] out = st.plusOne(d);
		for(int i=0;i<out.length;i++) {
			System.out.println(out[i]);
		}
	}
}
