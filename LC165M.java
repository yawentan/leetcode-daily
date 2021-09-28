package yawen;

public class LC165M {
	@org.junit.Test
	public void test() {
		System.out.println(compareVersion("1.0.0","1.0"));
	}
	
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int idx=0;
        while(idx<Math.max(split1.length,split2.length)){
            int a = idx<split1.length?Integer.parseInt(split1[idx]):0;
            int b = idx<split2.length?Integer.parseInt(split2[idx]):0;
            if(a==b){
                idx++;
                continue;
            }else{
                return a-b>0?1:-1;
            }
        }
        return 0;
    }
}
