
public class B07_charAt {

	public static void main(String[] args) {

		/*
		 * 	# "���ڿ�".charAt(index);
		 * 	- �ش� ���ڿ����� ���ϴ� ��°�� ���ڸ� charŸ������ ������ �Լ�
		 * 	- ù��° ���ڴ� 0
		 * 
		 * 	# "���ڿ�".length();
		 * 	- �Լ��� �����ϸ� �ش� ���ڿ��� ���̸� intŸ������ �˷��ش�.
		 * 
		 *  
		 */
		System.out.println("Hello, everyone!!!".charAt(0));
		System.out.println("Hello, everyone!!!".charAt(1));
		System.out.println("Hello, everyone!!!".charAt(10));
		
		String str = "Hello, everyone!!!!";
		
		System.out.println(str.charAt(7));
		System.out.println(str.length());
	}
}