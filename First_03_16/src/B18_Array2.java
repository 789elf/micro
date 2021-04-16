import java.util.Scanner;

public class B18_Array2 {

	public static void main(String[] args) {

		// 배열 내부에 배열을 넣을 수 있다
		
		int[] num1 = { 1, 2, 3, 4, 5, 6 };
		int[] num2 = new int[10];
		int[] num3 = new int[] { 100, 200, 300, 400 };
		
		int[][] arr2 = { num1, num2, num3 };
		
		System.out.println(arr2[0]);

		System.out.println("{ 1, 2, 3, 4, 5, 6, }이 저장되어 있는 메모리의 시작 주소: " + num1);
		System.out.println("num1[0] ( 실제 위치 : [I@15db9742 )"+ num1[0]);
		System.out.println("num1[1] ( 실제 위치 : [I@15db9746 )"+ num1[1]);
		System.out.println("num1[2] ( 실제 위치 : [I@15db974A )"+ num1[2]);
		
		//2차원 배열의 값 사용하기
		System.out.println("arr[0][5]" + arr2[0][5]);
		System.out.println("arr[1][8]" + arr2[1][8]);
		System.out.println("arr[2][3]" + arr2[2][3]);
		
		
		// n 차원 배열은 n중 반복문으로 모두 탐색할 수 있다
		for(int i=0; i<arr2.length; i++) {
			
			System.out.println("###" + i + "번째 배열의 길이 : " + arr2[i].length);
			
			for(int j=0; j<arr2[i].length; j++) {
				System.out.printf("arr2[%d][%d]: %d\n", i, j, arr2[i][j]);
			}
		}
		
		
		// 활용 예 1
		char[][] block = {
				{'□','□','■','■', },
				{'□','□','□','■', },
				{'□','□','□','■', },
				{'□','□','□','■', },
		};
		
		for(int i=0; i<block.length; i++) {
			for(int j=0; j<block[i].length;j++) {
				System.out.println(block[i][j]);
			}
			System.out.println();
		}
		
		// 활용 예 2
		int[][] omok = new int[15][15];
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("좌표 입력 > ");
			
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			
			omok[x1][14 - y1] = 1;
			
			for (int y = 0; y < omok.length; ++y) {
				
				for (int x = 0; x < omok[y].length; ++x) {
					
					switch(omok[x][y]) {
					case 0:
						System.out.print('□');
						break;
					case 1:
						System.out.print('●');
						break;
					case 2:
						System.out.print('○');
						break;
					}
					System.out.print(' ');
				}
				System.out.println();
			}
		}
	}
}
