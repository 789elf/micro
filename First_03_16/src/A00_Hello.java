// public class�� �̸��� �ݵ�� ���Ѥ��� ���ƾ� �Ѵ�
public class A00_Hello {
// �������� ������ ������ �װ��� Ŀ���� �ΰ� F2�� ������
// ������ ���� ������ �ذ�å�� �� �� �ִ�.

	/*
	 *   # main() �Լ�
	 *   	
	 *   	- ���α׷��� ���� ����
	 *   	- ����ڰ� ���α׷��� �����ϸ� ���� ���� main() �Լ��� ã�Ƽ� �����Ų��.
	 *   	- main() �Լ��� ������ �߰�ȣ{}�� ���� �ȴ�.
	 *   
	 *   # �Լ���?
	 *   	- � �ܾ� �ڿ� ()�� �ִ� �Ͻ� ��� �Լ���� �θ���.
	 *   
	 *   # System.out.println() �Լ�
	 *   	- () �ȿ� ������ �����͸� �ֿܼ� ����ϴ� �Լ�
	 *   
	 *   # �ܼ�
	 *   	- ���ڸ� ������ ���� ȭ�� ( ���� ��ǻ�� ȭ�� )
	 *   	- Eclipse������ �׽�Ʈ������ �Ͼ� ������ �ܼ��� �����Ѵ�.
	 *   	- Ctrl + F11�� ������ �츮�� ���� ���α׷���
	 *   	    �׽�Ʈ�� �ܼ� �󿡼� ������ �� �� �ִ�.
	 *   	- �츮�� ���� �ҽ� �ڵ�(.java)�� �����(.class)�� bin������ ����Ǿ� �ִ�.
	 *    
	 */
		
	
	// Ctrl + F11
	public static void main(String[] args) {
		// ���α׷� ����
		System.out.println("Hello, world 1");
		System.out.println(12345);// ����
		System.out.println("12345" + 5 * 7); //����
		/*
		 * 	# �ڹ��� �����͵� ( ���ͷ� )
		 *  1. ""���̿� ���� �͵� : ���ڿ�(String), ���ڸ� ������ �� �� �ִ� ������ Ÿ��
		 *  2. ''���̿� ���� �͵� : ����(Character), ���� �� �ϳ��� �� �� �ִ� ������ Ÿ��
		 *  3. ����			: ����(Integer)
		 *  4. �Ǽ�			: (Float, Double)
		 *  5. true, false
		 *  
		 *  # ���ڵ��� �����δ� ���ڰ��� ������ �ִ�.
		 * 	    �츮 ���� ���϶��� ���ڷ� ���̴� ��
		 * 	  ���ڳ��� ��굵 ����, ���� ���� ���ε� ��� ����
		 */
		System.out.println("ABCDEFG ����"); 	// String
		System.out.println('��');			// Char
		System.out.println('��');
		System.out.println('��');
		
		System.out.println(1000 + 500);	 	// int
		System.out.println(123.456 + 10.5);	// float
		
		System.out.println(true);
		System.out.println(false);
		
		System.out.println((int)'A');		//������ �ƽ�Ű�ڵ尪
		System.out.println((int)'��');
		System.out.println((int)'��');
		System.out.println((char)54621);	//�ƽ�Ű�ڵ尪�� ���ڷ� ��ȯ
		System.out.println('A' + 1);		//66
		System.out.println((char)('A' + 1)); // B
		
		// # ���ڿ� Ÿ�԰� �ٸ� Ÿ���� ���ϸ� ����� �ϴ°��� �ƴ϶� �̾���δ�.
		System.out.println("'A'�� �������� ��� : " + 'A');
		System.out.println("1" + 5); 	//"15" 
		System.out.println('1' + 5);	// 54  (int)'1' = 49  : ���� 1�� �ڵ尪 49 + 5   
		System.out.println(1 + 5 ); 	// 6
		System.out.println((int)'1');
		
		// ���α׷� ��
	}
	

}
