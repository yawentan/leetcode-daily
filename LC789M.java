package yawen;

public class LC789M {
	@org.junit.Test
	public void test() {
		int[][] ghosts =  {{5,0},{-10,-2},{0,-5},{-2,-2},{-7,1}};
		int[] target = {7,7};
		System.out.println(escapeGhosts(ghosts,target));
	}
	
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
    	for(int i=0;i<ghosts.length;i++) {
    		if(ghosts[i][0]<=target[0]&&ghosts[i][0]>=0&&ghosts[i][1]<=target[1]&&ghosts[i][1]>=0)
    			return false;
    		int x = Math.abs(ghosts[i][0]-target[0]);
    		int y = Math.abs(ghosts[i][1]-target[1]);
    		if(x+y<=Math.abs(target[0])+Math.abs(target[1]))
    			return false;
    	}
    	return true;
    }
}
