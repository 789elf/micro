
public class A02_Variable {

	public static void main(String[] args) {

		/*
		 *  # ���� (variable)
		 *  	- �����͸� ���� �� �ִ� ����
		 *  	- �ڹٿ����� ������ �ݵ�� ������ �ڿ� ����ؾ� �Ѵ�.
		 *  	- ���� ����ÿ��� �� ������ ����� �������� Ÿ���� ������� �Ѵ�.
		 *  	- ""�� ''�� ���� ��� ���ڿ� �Ǵ� ���ڴ� ������.
		 *  	- ���� �̸��� ������ �ٽ� ������ �� ����.
		 *  
		 *  # ������ ���� ( declare, declaration )
		 *  	Ÿ�� ������; -> int a, char b
		 *  # ������ Ÿ��
		 *  	- int : ������ ������ �� �ִ� ���� Ÿ��
		 *  
		 *  # = �ǹ� 
		 *  	���α׷��� ���� =�� �ǹ̴� ������ ������ �������� ���� �־�� 
		 *  
		 */
		
		int a = 10;
		int apple = a + 50;
		
		System.out.println(a);
		System.out.println(apple);
		
		a = 50;
		System.out.println(a);
		
		// �������� ���� ���� ���
		//������ ������ ���ʷ� ���� �����ϴ� ���� '�ʱ�ȭ(initialize, init)' ��� �Ѵ�.
		int b;
		//System.out.println(b); ���� �ѹ��� ���Ե����� ���� ������ ����� �� ����. ( �ʱ�ȭ ���� ���� ���� )
		int c,d;
		int e = 55;
		int f = 99, g = 999;
		System.out.println("f�� ����ִ� ��: " + f);
		System.out.println("g�� ����ִ� ��: " + g);
		
	}
}
