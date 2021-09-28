package yawen;

public class LC275M {
    public static int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length;
        int n = citations.length;
        if(n==0)
        	return 0;
        if(n==1)
        	return Math.min(citations[l],n-l);
        while(l<r){
            int m = l + (r-l)/2;
            if(citations[m]>n-m)
                r=m;
            else if(citations[m]<n-m)
                l=m+1;
            else
                return n-m;
        }
        if(l==n)
        	return 0;
        return Math.min(citations[l],n-l);
    }
    
    public static void main(String[] args) {
    	int[] nums = {9,9,9};
    	System.out.println(LC275M.hIndex(nums));
	}
}
