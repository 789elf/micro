
public class D03_WrapperClass {

	/*
	 *   # Wrapper Class
	 *   
	 *     - �⺻ Ÿ�Ե��� ������ Ÿ������ ����ϱ� ���� Ŭ����
	 *     - �� Ÿ�Ե鿡 ���� ������ ��ɵ��� ���ִ�
	 *     
	 *   # �⺻�� �̸�
	 *     
	 *     - byte, short, char, int, long, ...
	 *   
	 *   # ������ �̸�
	 *     - Byte, Short, Character
	 */
	public static void main(String[] args) {

		/*
		 *   # parse �ø���
		 *     
		 *     - ���ڿ��� ���ϴ� Ÿ������ ��ȯ��Ű�� ���
		 *     - �� Ÿ�Կ� ����ƽ �޼ҵ�� �����Ѵ�
		 *     - �����͸� �ְ� �������� ��� ���ڿ��� ��ȯ�Ͽ� ���۵Ǵ� ��찡 ����
		 *     - �ٽ� ����ϱ� ���ؼ��� ���� �����͸� ������ Ÿ������ �ǵ����� �Ѵ�
		 *     - radix�� �����ִ� �����ε��� ������ �ǹ��Ѵ�
		 */
		try {
			int a1 = Integer.parseInt("1234ABC",16);   // 16������ ��ȯ
			System.out.println(a1);
		}catch(NumberFormatException e) {
			System.out.println("int�� ��ȯ�� �� ���� ���ڿ��̾����ϴ�.");
		}
		
		String a = "10";
		int a2 = Integer.parseInt(a);
		System.out.println(a);
		
		System.out.printf("%f \n", Double.parseDouble("123.123456"));
		
		/*
		 *  # toString()
		 *  
		 *    - �ش� Ÿ���� ���� �ս��� ���ڿ��� ��ȯ�� �� �ִ�
		 *    - toString()�� Object�� �޼����̱� ������ ��� Ŭ������ �����Ѵ�
		 *    - �ν��Ͻ� �޼��� toString()�� �ش� �ν��Ͻ��� ���ڿ��� ��ȯ�Ѵ�
		 *    - ����ƽ �޼��� toString()�� ������ ���� ���ڿ��� ��ȯ�Ѵ�
		 */
		
		System.out.println(Integer.toString(123456, 2));
		System.out.println(Integer.toString(123456, 8));
		System.out.println(Integer.toString(123456));  //radix default 10

		/*
		 *   # typeValue()
		 *   
		 *     - �ش� �ν��Ͻ� ���� ���ϴ� Ÿ���� ������ �ս��� �����ϴ� �޼ҵ�
		 *     - Ÿ��ĳ������ ������ ����
		 */
		
		Integer num = 1000000;
		
		num.byteValue();
		num.shortValue();
		num.doubleValue();
		
		
		
		
	}

}
