package yawen;

import java.util.*;
/*
 * 双向bfs
 */
public class LC752M {
    public int openLock(String[] deadends, String target) {
    	Set<String> q1 = new HashSet<String>();
    	Set<String> q2 = new HashSet<String>();
    	q1.add("0000");
    	q2.add(target);
    	int step = 0;
    	int visited[] = new int[10000];
    	int dead[] = new int[10000];
    	
    	for(int i=0;i<deadends.length;i++) {
    		int idx = Integer.parseInt(deadends[i]);
    		dead[idx] = 1;
    	}
    	if(dead[0]==1)
    		return -1;
    	
    	while(!q1.isEmpty()&&!q2.isEmpty()) {
    		//遍历当前层所有节点
    		Set<String> temp_q = new HashSet<String>();
    		for(String temp:q1) {
    			int iidx = Integer.parseInt(temp.toString());
    			//是否到终点
	    		if(q2.contains(temp))
	    			return step;
				visited[iidx]=1;
	    		
    			//添加邻接节点
	        	for(int i=0;i<4;i++) {
	        		for(int k=-1;k<=1;k++) {
	        			if(k==0)
	        				continue;
	        			StringBuffer ss = new StringBuffer(temp);
	        			char c = ss.charAt(i);
	        			ss.deleteCharAt(i);
	        			if(c+k-'0'==-1)
	        				c='9';
	        			else if(c+k-'0'==10)
	        				c='0';
	        			else
	        				c=(char)(c+k);
	        			ss.insert(i, c);
	        			int idx = Integer.parseInt(ss.toString());
	        			if(visited[idx]==0&&dead[idx]==0)
	        				temp_q.add(ss.toString());
	        		}
	        	}
    		}
    		//增加步数
    		step++;
    		//交换q1,q2
    		q1 = q2;
    		q2 = temp_q;
    	}
		return -1;
    }
    
    public static void main(String[] args) {
    	LC752M lc = new LC752M();
    	String[] dead = {"0201","0101","0102","1212","2002"};
    	String target = "0202";
//    	StringBuffer s = new StringBuffer(target);
//    	for(int i=0;i<4;i++) {
//    		for(int k=-1;k<=1;k++) {
//    			StringBuffer ss = new StringBuffer(s);
//    			char c = ss.charAt(i);
//    			ss.deleteCharAt(i);
//    			if(c+k-'0'==-1)
//    				c='9';
//    			else if(c+k-'0'==10)
//    				c='0';
//    			else
//    				c=(char)(c+k);
//    			ss.insert(i, c);
//    			int idx = Integer.parseInt(ss.toString());
//    			System.out.println(idx);
//    		}
//    	}
    	System.out.println(lc.openLock(dead, target));
    }
}
