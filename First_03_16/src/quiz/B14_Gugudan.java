package quiz;

public class B14_Gugudan {

	public static void main(String[] args) {

		/*
		 *  1. �������� ������ ���� ���η� ����غ�����.
		 *  2��:	2x1=2 2x2=4 2x3=6
		 *  3��:	3x1=3 3x2=6 ....
		 *   
		 *  2. �������� ������ ���� ���η� ����غ�����
		 *  
		 * 		2��		3�� ..
		 * 		2x1=2	3x1=3
		 * 		2x2=4	3x2=6
		 */
		
		// 1.
		for(int i=2; i<=9; i++) {
			
			for(int j=1; j<=9; j++) {
				System.out.printf("%d x %d = %d\t", i, j, i*j);
			}
			System.out.println();
		}
		
		System.out.println("\n\n\n");
		
		// 2.
		for(int i=1; i<=9; i++) {
			
			for(int j=2; j<=9; j++) {
				
				System.out.printf("%d x %d = %d\t", j, i, j*i);
			}
			System.out.println();
		}
	}
}
