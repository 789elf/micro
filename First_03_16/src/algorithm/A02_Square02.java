package algorithm;

public class A02_Square02 {

	public static void main(String[] args) {

		/*
		 * ������ �׸� �ƴ� �� �� ���·� ���
		 */
		
		int num = 5;		// �簢�� ũ��
		int reverse = 0;	// �ݴ�� ��µ� �� ���� ����
		
		int square;			// �ݴ�� ��µ� �� ���� ���� 2
		int cnt = 1;		// ���� ��µ� �� ���� ����

		// num ũ�� ��ŭ �ݺ� ( 2�� for�� �� num * num ��ŭ �ݺ� )
		for (int i = 0; i < num; i++) {
			
			//square num ������ �ʱ�ȭ
			square = num;	
			
			for (int j = 0; j < num; j++) {
				
				// reverse�� ¦����� ���������� ��� 
				if (reverse % 2 == 0) {		

					System.out.printf("%3d ", cnt);  
					
				// reverse�� Ȧ����� �������� ���
				} else if (reverse % 2 != 0) {
					
					// �Ʒ� �� ��� ����� square -2 �� ���ָ� ���������� �������� ���
					// cnt�� 1�� ���� , ��µǾ���� ���� 1�� ���� �� 2�� ���̳ʽ��� ���ְ�,  
					// ���� ��(cnt)���� (square -1)���� ������ָ� ���������� �������� ��µȴ�.
					
					System.out.printf("%3d ", cnt + (square - 1));
					square = square - 2;
					
				}
				//�ݺ��� �ѹ� ���������� �� + 1
				cnt++;
			}
			//2��° for�� ���������� ���� ��� ���� �� + 1 (¦,Ȧ�� �����ư��� ���� ����), �� �ٲ�
			reverse++;
			System.out.println("\n");
		}
	}
}
