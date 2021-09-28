package yawen;

public class JForTest2{
	public static void main(String[] args) {
		for(int i=2;i<=100;i++) {
			int isSushu=1;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					isSushu=0;
					break;
				}
			}
			if(isSushu==1) {
				System.out.print(i+" ");
			}
		}
		
	}
}
