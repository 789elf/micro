
public class B09_Operator3 {

	public static void main(String[] args) {

		/*
		 * 	# ���� ������
		 * 		- ������ if���� �� �ٷ� ǥ���� �� �ִ�.
		 * 		- ���� ? �� : �ƴϿ�;
		 */
		
		//ex: �ʿ��� �ٱ��� ���� ���ϱ�
		int apple = 25;
		int size = 10;
		
		int needs = apple % size == 0 ? apple / size : apple / size + 1;

		boolean isEven = apple % 2 == 0;
		
//		System.out.println("�ʿ��� �ٱ��� ������ " + needs + "�� �Դϴ�.");
		
//		System.out.printf("����� ������ %s�Դϴ�.", isEven ? "¦��" : "Ȧ��");
		
		
		int a = 10;
		
		if(a % 2 == 0) {
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}
		
		System.out.println(a % 2 == 0 ? "¦��" : "Ȧ��");
		
		System.out.println(1 == 1 ? "��" : "����");
		System.out.println(1 == 2 ? "��" : "����"); 
	}

}
