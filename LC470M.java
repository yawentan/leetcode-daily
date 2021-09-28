package yawen;

import java.util.Random;

import org.junit.Test;

public class LC470M {
	@Test
	public void test() {
		int[] tab = new int[11];
		for(int i=0;i<10000;i++) {
			tab[rand10()]++;
		}
		for(int i=1;i<11;i++) {		
			System.out.println(tab[i]);
		}
	}
    public int rand7() {
        Random r = new Random();
        return r.nextInt(7)+1;
    }
    public int rand10() {
    	int[][] tab = new int[5][6];
    	for(int i=1;i<=2;i++) {
    		for(int j=1;j<=5;j++) {
    			tab[i][j]=j+(i-1)*5;
    		}
    	}
    	for(int i=3;i<=4;i++) {
    		for(int j=1;j<=5;j++) {
    			tab[i][j]=j+(i-3)*5;
    		}
    	}
        int a=0;
        int b=0;
        while((b=rand7())>5);
        while((a=rand7())>4);
    	return tab[a][b];
    }
}
