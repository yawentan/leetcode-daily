package yawen;

import java.util.*;

public class LC881M {
	@org.junit.Test
	public void test() {
		int[] people = {1,2};
		int limit = 3;
		System.out.println(numRescueBoats(people,limit));
	}
	
    public int numRescueBoats(int[] people, int limit) {

    	Arrays.sort(people);
    	int count = 0;
    	int r = people.length;
    	int t = BinarySearch(people,1,r,limit-people[0]);
    	count=r-t-1;
    	for(int i=0;i<=r;i++) {
    		if(i==people.length-1||limit-people[i]<people[i]) {
        		count++;
        		continue;
    		}
    		int idx = BinarySearch(people,i+1,r,limit-people[i]);
    		
			if(idx==i+1&&people[i]+people[i+1]>limit){
	        		count++;
	        		continue;
	    	}
    		count++;
    		r=idx;
    	}
    	return count;
    }

	private int BinarySearch(int[] people, int l, int r, int t) {
		while(l<r) {
			int m = l+(r-l)/2;
			if(t>people[m]) {
				l=m+1;
			}else if(t<people[m]) {
				r=m;
			}else {
				return m;
			}
		}
		return l;
	}
}
