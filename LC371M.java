package yawen;

import java.util.Scanner;

public class LC371M {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String X = sc.nextLine();
		String Y = sc.nextLine();
		System.out.println(first(X,Y));
		sc.close();
	}
	
	public static String first(String X,String Y) {
		String ans = "";
		for(int i=0;i<X.length();i++) {
			if(!Y.contains(""+X.charAt(i))) {
				ans+=X.charAt(i);
			}
		}
		return ans;
	}
}
