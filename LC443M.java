package yawen;

public class LC443M {
	@org.junit.Test
	public void test() {
		char[] chars = {'a','a','a','a','a','b'};
		System.out.println(compress(chars));
	}
	
    public int compress(char[] chars) {
    	int last = 0;
    	int count=1;
    	int ans=0;
    	int idx = 0;
    	for(int i=1;i<chars.length;i++) {
    		if(chars[i]==chars[last]) {
    			count++;
    		}else {
				chars[idx]=chars[last];
    			if(count==1) {
    				ans+=1;
					idx++;
    			}else {
    				idx++;
    				String temp = String.valueOf(count);
    				for(int j=0;j<temp.length();j++) {
    					chars[idx]=temp.charAt(j);
    					idx++;
    				}
    				ans+=1+temp.length();
    			}
    			count=1;
    			last=i;
    		}
    	}
		chars[idx]=chars[last];
		if(count==1) {
			ans+=1;
			idx++;
		}else {
			chars[idx]=chars[last];
			idx++;
			String temp = String.valueOf(count);
			for(int j=0;j<temp.length();j++) {
				chars[idx]=temp.charAt(j);
				idx++;
			}
			ans+=temp.length();
		}
    	System.out.println(chars);
    	return idx;
    }
}
