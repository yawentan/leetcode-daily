package yawen;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC630H {
	public static void main(String[] args) {
		int[][] courses = {{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}};
		System.out.println(scheduleCourse(courses));
	}
	
    public static int scheduleCourse(int[][] courses) {
    	Arrays.sort(courses,(int[] a,int[] b)->{
    		return a[1]!=b[1]?a[1]-b[1]:a[0]-b[0];
    	});
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
    	int time=0;
    	for(int[] course:courses) {
    		if(time+course[0]<=course[1]) {
    			pq.add(course[0]);
    			time+=course[0];
    		}else if(!pq.isEmpty()&&pq.peek()>course[0]){
    			time-=pq.poll()-course[0];
    			pq.add(course[0]);
    		}
    	}
    	return pq.size();
    }
}
