package yawen;



public class Test {
	
	public static void main(String[] args) {
		int[] array= {1,5,8,3,7,4};
		SecectionSorting(array);
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}
	
	public static int[] SecectionSorting(int[] array) {
		for(int i=0;i<array.length;i++) {
			int mixIndix=i;
			for(int j=i;j<array.length;j++) {
				if(array[i]>array[j]) {
					mixIndix=j;
				
				int temp=array[mixIndix];
				array[mixIndix]=array[i];
				array[i]=temp;
				}
			}
		}
		return array;
	}

}