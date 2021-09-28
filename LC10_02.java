package yawen;

import java.util.Arrays;
import java.util.*;

class Node10_02{
	int[] tab = new int[26];

	public Node10_02(int[] tab) {
		super();
		this.tab = tab;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node10_02 other = (Node10_02) obj;
		if (!Arrays.equals(tab, other.tab))
			return false;
		return true;
	}
}

public class LC10_02 {
    public static List<List<String>> groupAnagrams(String[] strs) {
    	
    	Map<Node10_02,List<String>> map = new HashMap<>();
    	
    	for(int i=0;i<strs.length;i++) {
        	int[] tab = new int[26];
        	//统计字符数量
    		for(int j=0;j<strs[i].length();j++) {
    			tab[strs[i].charAt(j)-'a']++;
    		}
        	Node10_02 n1 = new Node10_02(tab);
    		if(map.containsKey(n1)) {
    			List<String> ltemp = map.get(n1);
    			ltemp.add(strs[i]);
    			map.put(n1, ltemp);
    		}else {
    			List<String> ltemp = new LinkedList<>();
    			ltemp.add(strs[i]);
    			map.put(n1, ltemp);
    		}
    		
    	}
    	List<List<String>> res = new LinkedList<>();
    	for(Node10_02 t:map.keySet()) {
			List<String> ltemp = map.get(t);
			res.add(ltemp);
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(LC10_02.groupAnagrams(s));
//    	Map<Node10_02,Integer> map = new HashMap<>();
//    	int[] tab1 = new int[26];
//    	int[] tab2 = new int[26];
//    	Node10_02 n1 = new Node10_02(tab1);
//    	Node10_02 n2 = new Node10_02(tab2);
//    	map.put(n1, null);
//    	map.put(n2, null);
//    	System.out.println(map.size());
    	
	}
}
