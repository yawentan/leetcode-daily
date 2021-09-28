package yawen;

import java.util.*;

public class LC68H {
	@org.junit.Test
	public void test() {
		String[][] words = {{"What","must","be","acknowledgment","shall","be"},{"This", "is", "an", "example", "of", "text", "justification."},{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"},{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}};
		int[] nums = {16,16,20,16};
//		for(int i=0;i<words.length;i++) {
			List<String> ans = fullJustify(words[3],nums[3]);
			ans.forEach(System.out::println);			
//		}
	}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
    	int l=0,r=0;
    	int temp = 0;
    	List<String> ans = new LinkedList<>();
    	int i=0;
    	while(i<words.length) {
    		if(i<words.length) {
    			temp+=words[i].length();
    			r=i;    			
    		}
    		if(temp+(r-l)>maxWidth) {
    			int k = r-l-1;
    			int spaceNum = maxWidth-temp+(words[i].length());
    			String ss = "";
    			if(k==0) {
    				ss+=words[l];
    				while(spaceNum-->0) {
    					ss+=" ";
    				}
    			}else {
        			int left = spaceNum%k;
        			int mide = spaceNum/k;
        			for(int j=l;j<r;j++) {
        				ss += words[j];
        				if(j-l<left) {
        					ss+=" ";
        				}
        				if(j<r-1) {
        					for(int kk=0;kk<mide;kk++) {
        						ss+=" ";
        					}
        				}
        			}
    			}
    			ans.add(ss);
    			temp = words[r].length();
    			l = r;
    		}
    		if(i<words.length)
    			i++;
    	}
		if(temp+(r-l)>maxWidth) {
			int k = r-l-1;
			int spaceNum = maxWidth-temp+(words[r].length());
			String ss = "";
			if(k==0) {
				ss+=words[l];
				while(spaceNum-->0) {
					ss+=" ";
				}
			}else {
    			int left = spaceNum%k;
    			int mide = spaceNum/k;
    			for(int j=l;j<r;j++) {
    				ss += words[j];
    				if(j-l<left) {
    					ss+=" ";
    				}
    				if(j<r-1) {
    					for(int kk=0;kk<mide;kk++) {
    						ss+=" ";
    					}
    				}
    			}
			}
			ans.add(ss);
			temp = words[r].length();
			l = r;
		}
    	if(temp!=0) {
			int k = r-l;
			int spaceNum = maxWidth-temp;
			String ss = "";
			if(k==0) {
				ss+=words[l];
				while(spaceNum-->0) {
					ss+=" ";
				}
			}else {				
				for(int j=l;j<=r;j++) {
					ss += words[j];
					if(j<r) {
						ss+=" ";
					}
				}
				while(ss.length()<maxWidth)
					ss+=" ";
			}
			ans.add(ss);
			temp = words[r].length();
			l = r;
    	}
    	return ans;
    }
}
