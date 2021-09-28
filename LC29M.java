package yawen;

public class LC29M {
    public static int divide(int dividend, int divisor) {
    	long l = 1,r = Math.abs((long)dividend);
    	long target = Math.abs((long)dividend);
    	long num = Math.abs((long)divisor);
    	while(l<=r) {
    		long m = l + ((r-l)>>2);
    		if(m*num==target) {
    			r = m;
    			break;
    		}
    		else if(m*num<target)
    			l = m+1;
    		else
    			r = m-1;
    	}
    	if((dividend<0&&divisor<0)||(dividend>0&&divisor>0)) {
    		long temp = Math.abs(r);
    		return temp>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)r;
    	}
    	else
    		return -1*(int)r;
    }
    public static int sum(int n) {
    	if(n==0)
    		return 0;
    	return n+sum(n-1);
    }
    public static void main(String[] args) {
    	int dividend = -2147483648, divisor = 1;
    	System.out.println(divide(dividend,divisor));
//    	System.out.println(sum(6));
    }
}
