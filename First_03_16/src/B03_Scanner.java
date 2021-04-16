import java.util.Scanner;

public class B03_Scanner {
	/*
	 * 	# ������ java�� �����ϴ� Ŭ����
	 *	
	 *	- Math Ŭ����
	 *		- ���а� ���õ� ��ɵ��� ���ִ� Ŭ���� 
	 *			ex: abs(), round(), ceil() ... 	
	 * 
	 * 	# java.util.Scanner Ŭ����
	 * 	- ���α׷��� �ܺηκ��� �Է��� ���� �� �ִ� ��ɵ��� ���ִ� Ŭ����
	 * 	- ��𿡼� �Է��� ������ ������ �ڿ� �پ��� ������ �Է¹��� �� �ִ�.
	 * 	- �ܼ� �κ��� �Է¹ް� ���� ���� System.in �� ����Ѵ�.
	 * 
	 * 	#	 next(): ���� �ܾ stringŸ������ �޾ƿ��� (�������)
	 * 		 nextLine(): ���� �� ���� StringŸ������ �޾ƿ��� \n����
	 */
	
	public static void main(String[] args) {

		//System.in ���κ��� �Է¹޴� ��ĳ�ʸ� �ϳ� ����
		Scanner sc = new Scanner(System.in);
		
		//Scanner�� nextInt()
		//	- �������� ������ ������ �ϳ� ������.
		//	- �������� ���� ���� �ƹ��͵� ���� ���� �Է��� ��� ��ٸ���.
		System.out.print("�� ������ �Է����ּ���(21������) > ");
		int a = sc.nextInt();
		
		System.out.println("�Է��Ͻ� ���� " + a + "�Դϴ�.");
		System.out.println("�Է��Ͻ� ���� 3�� ���ϸ� "+ a * 3 + "�Դϴ�.");
		System.out.println("1000�� �Է��Ͻ� ���� ���̴� "+ (1000-a) + "�Դϴ�.");
		
		
		//Scanner�� NextDouble()
		//	-�������� ������ �Ǽ��� �ϳ� ������.
		System.out.print("�Ǽ��� �Է����ּ���. (������ ����) > ");
		double b = sc.nextDouble();
		
		System.out.println("�ι�°�� �Է��Ͻ� ���� " + b + "�Դϴ�.");
		System.out.println("ù ��° ���� �� ��° ���� ���ϸ�" + a * b + "�Դϴ�.");
		
		
	}

}
