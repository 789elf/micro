

public class C01_Function {

	public static void main(String[] args) {

		/*
		 *  # �Լ� (Function)
		 *  
		 *  - ����� �̸� �����صΰ� ���߿� ������ ���� ��
		 *  - �ڹٿ��� �Լ�(�޼���)�� �ݵν� Ŭ���� ���ο� �����ؾ� �Ѵ�.
		 *  - �����ص� �Լ� �̸� �ڿ� ()�� ������ �Լ��� ȣ���ϸ�
		 *    ȣ���� �ڸ��� �Լ��� ���� ����� ��ȯ�ȴ�.
		 *  - �Լ��� ������ �� �ش� �Լ��� ��ȯ�� ���� Ÿ���� �տ� ����д�
		 *  - ���߿� ���� �� ���ɼ��� �ִ� ��ɵ��� �̸� ���������ν�
		 *    �۾��� �ݺ��� ���� �� �ִ�.
		 *  - �Ű������� Ÿ��, ������ �ٸ��� ���� �̸��� �Լ��� ������ ���� �� �ִ�. ( �����ε� )
		 */
		
		for (int i=0; i<10; i++) {
			print_rabbit();
		}
		
//		int basket = apple_basket(123, 10);
//		System.out.println("�ʿ��� �ٱ����� ������ " + basket);
		
		System.out.println(apple_basket(123, 10));
	}
	
	public static void print_rabbit() {
		System.out.println(" /)/)");
		System.out.println("(  ..)");
		System.out.println("(  >$)");
	}
	
	// ex: ����� ������ �ٱ����� ũ�⸦ �����ϸ� �ʿ��� �ٱ����� ������ �˷��ش� �Լ�
	/*
	 *  public static : ���߿� ����
	 *  int : �� �Լ��� ���� ����� Ÿ�� ( ���� Ÿ���̶�� �Ѵ� )
	 *  apple_basket : Ÿ�� �ڿ� �Լ����� ������ �� �ִ�.
	 *  apple_basket(int apple, int size)
	 *  	: �� �Լ��� ������ �� int Ÿ�� ���� �� �� ���� �޵��� ���� (�Ű� ���� (arguments)
	 */
	public static String apple_basket(int apple, int size) {
		int result;
		
		if(apple % size == 0) {
			result = apple / size;
		} else {
			result = apple / size + 1;
		}
		
		return "�ʿ��� �ٱ����� ������" + result + " �� �Դϴ�.";
		
	}
}
