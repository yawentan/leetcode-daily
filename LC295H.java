package yawen;

import java.util.*;

class MedianFinder {
	PriorityQueue<Integer> s;
	PriorityQueue<Integer> b;
    /** initialize your data structure here. */
    public MedianFinder() {
    	s = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
    	});
    	b = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
    	});
    }
    
    public void addNum(int num) {
    	if(s.size()==0) {
    		s.add(num);
    	}else {
        	int peek = s.peek();
        	if(num>=peek) {
        		b.add(num);
        	}else {
        		s.add(num);
        	}
    	}
    	while(Math.abs(s.size()-b.size())>1) {
    		if(s.size()>b.size()) {
    			b.add(s.poll());
    		}else {
    			s.add(b.poll());
    		}
    	}
    }
    
    public double findMedian() {
    	if(s.size()==b.size()) {
    		return 1.0*(s.peek()+b.peek())/2;
    	}else {
    		if(s.size()>b.size())
    			return s.peek();
    		else
    			return b.peek();
    	}
    }
}
public class LC295H {
	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(-1);
		System.out.println(m.findMedian());
		m.addNum(-2);
		System.out.println(m.findMedian());
		m.addNum(-3);
		System.out.println(m.findMedian());
		m.addNum(-4);
		System.out.println(m.findMedian());
		m.addNum(-5);
		System.out.println(m.findMedian());
	}
}
