package algorithm;

public class A01_Square {

	public static void main(String[] args) {

		int square = 5;
		
		int pow = square * square;
		
		for(int i=0; i<pow; i++) {
			
			if(i % square == 0 && i != 0) {
				System.out.println();
			}
			System.out.printf("%2d ", (i+1));
		}
	}

}
