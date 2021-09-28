package yawen;

public class LC1137E {
    public int tribonacci(int n) {
    	int[] T = new int[4];
    	T[0]=0;
    	T[1]=1;
    	T[2]=1;
    	if(n<3)
    		return T[n];
    	for(int i=3;i<=n;i++) {
    		T[3] = T[0]+T[1]+T[2];
    		T[0]=T[1];
    		T[1]=T[2];
    		T[2]=T[3];
    	}
    	return T[3];
    }
}
