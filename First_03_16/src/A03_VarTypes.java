
public class A03_VarTypes {

	public static void main(String[] args) {
		/*
		 * 	# ���� Ÿ��  ( 1byte -> 8bit ) (1��Ʈ = 1����)
		 * 
		 * 		0000 0000 (0) ~ 1111 1111 (255)
		 * 		
		 * 		*ù ��° bit�� ��ȣ ��Ʈ�� ���ȴ�. (0�� ��� 1�� ����)
		 * 		byteŸ���� ��� ����  0000 0000 (0) ~ 0111 1111 (127)
		 * 		byteŸ���� ���� ����  1000 0000 (-128) ~ 1111 1111 (-1) ��� ���� �ݴ�� ����ؼ� 1000 0000 �� -128
		 * 
		 * 		1bit : 2 ^ 1 - 2����
		 * 		2bit : 2 ^ 2 - 4����
		 * 		3bit : 2 ^ 3 - 8����
		 * 		4bit : 2 ^ 4 - 16����
		 * 		5bit : 2 ^ 5 - 32����
		 * 		6bit : 2 ^ 6 - 64����
		 *		7bit : 2 ^ 7 - 128����
		 *		8bit : 2 ^ 8 - 256����
		 *   
		 * 		- byte (1byte) (2 ^ 8 : 256����, ��/�������� 0 ~ 255 / -256 ~ -1)
		 * 		- short(2byte) (2 ^ 16: 65536����, ��/�������� : 0 ~ 32767 / -32768 ~ -1)
		 * 		- char (2byte) (2 ^ 16: 65536����, ����� ��Ÿ��, ��ȣ�� ����(unsigned) ������ 0 ~ 65535�� ����� ������ �� �ִ� Ÿ�� �ַ� ���� �ڵ带 �����ϴµ��� ����Ѵ�(����Ÿ��))  
		 * 		- int  (4byte) (2 ^ 32: 43�ﰡ��)
		 * 		- long (8byte) (2 ^ 64)
		 * 
		 * */
		
		byte min_Byte = -128;
		byte max_Byte = 127;
		System.out.println(
				"byteŸ�Կ� ������ �� �ִ� ���� ū ����"+max_Byte+"�̰�,"
						+ "���� ���� ����"+min_Byte+"�Դϴ�.");
		
		short min_Short = -32768;
		short max_Short = 32767;
		System.out.println(
				"shortŸ�Կ� ������ �� �ִ� ���� ū ����"+max_Short+"�̰�,"
						+ "���� ���� ����"+min_Short+"�Դϴ�.");
		
		char max_Char = 65535;
		char min_Char = 0;
		
		char ch = 65;
		System.out.println("charŸ�Կ� ����� ���� �⺻������ ���ڷ� ��µȴ�."+ch);
		System.out.println("charŸ�Կ� ����� �ڵ尪�� Ȯ���ϰ� ������ �տ�(int)�� ������.");
		
		System.out.println(
				"charŸ�Կ� ������ �� �ִ� ���� ū ����"+(int)max_Char+"�̰�,"
						+ "���� ���� ����"+(int)min_Char+"�Դϴ�.");

		int max_Int = 2_147_483_647;
		int min_Int = -2_147_483_648;
		System.out.println(
				"intŸ�Կ� ������ �� �ִ� ���� ū ����"+max_Int+"�̰�,"
						+ "���� ���� ����"+min_Int+"�Դϴ�.");
		
		long _long = 2_147_483_648L; //int�� ������ �Ѿ�� ���ڸ� ����� ���� �ڿ� L�� �������Ѵ�.
		
		/*
		 *	# �Ǽ� Ÿ��
		 *
		 *		- flaot (4byte)
		 *		- double(8byte)
		 *
		 *		�Ǽ��� �ַ� �׷��� ��꿡 ���ȴ�.
		 *		�ε��Ҽ��� ����� ����Ѵ�.
		 */
		
		// �׳� �Ҽ��� ���°��� �⺻������ doubleŸ���̴�.
		// floatŸ���� �Ҽ��� �ڿ� F�� ������ �Ѵ�.
		float weight = 65.66F;  //�ڿ� F
		double height = 177.77;
		
		/*
		 *	# boolean Ÿ��
		 *
		 *		���� ������ ǥ���ϴµ��� ���Ǵ� Ÿ��
		 *		���� true/false�ۿ� ����
		 */
		//boolean
		boolean has_Food = true;
		boolean is_Child = true;
		
		/*
		 *	# ������ Ÿ�� ( Ŭ���� Ÿ�� )
		 *		������ Ÿ���� �⺻�� Ÿ�Ե���� �ٸ��� �빮�ڷ� �����Ѵ�.
		 *			- String : ���ڿ� ( �������߿��� ���� ���ϰ� ����ϴ� �� )
		 *			- �� �� ��� Ŭ������  
		 */
		//������ Ÿ��
		String hello_Message = "Hello, My name is John Doe.";
		String bye_Message = "Good bye. ";
		System.out.println(hello_Message);
		System.out.println("hello_Message");
		
		System.out.println(bye_Message + bye_Message + bye_Message);
		


	}
}
