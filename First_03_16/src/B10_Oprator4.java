
public class B10_Oprator4 {

	public static void main(String[] args) {

		/*
		 * 	# 대입 연산
		 * 		= : 왼쪽의 변수에 오른쪽의 값을 대입
		 */
		
		int num = 10;
		num = num + 20;
		
		System.out.println(num);
		
		/*
		 * 	# 복합 대입 연산자
		 * 		- 변수에 결과를 누적시키는 연산자
		 */
		
		num = 10;
		System.out.println(num += 15);
		System.out.println(num -= 3);
		System.out.println(num *= 2);
		System.out.println(num /= 4);
		System.out.println(num %= 3);
		
		/*
		 * 	# 단항 연산자 (++, --)
		 *   변수나 값의 앞, 뒤에 붙냐에 따라 연산 순서가 달라진다.
		 */
		num = 10;
		num++;
		System.out.println(num);
		num--;
		System.out.println(num);
		
		num = 3;
		System.out.println("----");
		System.out.println(num--); //출력후 -1 계산
		System.out.println(--num); //출력전 -1 계산하고 출력
		System.out.println(num);
	}	

}
