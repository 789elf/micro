
public class B10_Oprator4 {

	public static void main(String[] args) {

		/*
		 * 	# ���� ����
		 * 		= : ������ ������ �������� ���� ����
		 */
		
		int num = 10;
		num = num + 20;
		
		System.out.println(num);
		
		/*
		 * 	# ���� ���� ������
		 * 		- ������ ����� ������Ű�� ������
		 */
		
		num = 10;
		System.out.println(num += 15);
		System.out.println(num -= 3);
		System.out.println(num *= 2);
		System.out.println(num /= 4);
		System.out.println(num %= 3);
		
		/*
		 * 	# ���� ������ (++, --)
		 *   ������ ���� ��, �ڿ� �ٳĿ� ���� ���� ������ �޶�����.
		 */
		num = 10;
		num++;
		System.out.println(num);
		num--;
		System.out.println(num);
		
		num = 3;
		System.out.println("----");
		System.out.println(num--); //����� -1 ���
		System.out.println(--num); //����� -1 ����ϰ� ���
		System.out.println(num);
	}	

}
