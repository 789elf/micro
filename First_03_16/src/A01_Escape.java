
public class A01_Escape {
	public static void main(String[] args) {
		
		/*
		 * 	# Escape ����
		 * 		- Ư���� ����� ���� ���ڵ�
		 * 		- �׳� ����Ϸ��� �ϸ� ������ �߻��ϴ� Ư���� ���ڵ�
		 * 		- �տ� \�� ���� ���ڴ� Escape���ڷ� �����Ѵ�.
		 * 		- �տ� ���� \�� ���� ���ڰ� �������� �ϳ��� ���ڷ� �νĵȴ�.
		 */
		System.out.println("�ȳ��ϼ���, �ݰ����ϴ�.");
		
		// \n : �� �ٲ��� ����� ���� Ư�� ���� (linefeed, breakline, newline, .. )
		System.out.println("�ȳ��ϼ���, \n��\n��\n��\n��\n��.");

		// \t : TabŰ�� ����� ���� Ư�� ����
		System.out.println("�ȳ��ϼ���, ��\t��\t��\t��\t��.");
		
		// \\ : Escape������ ����� �̿����� �ʰ� �׳� ����ϰ� ���� ��
		System.out.println("�ȳ��ϼ���, ��\\t��\\t��\\t��\\t��.");
		// ex > JDK�� ��θ� ����ϰ� ���� ��
		// System.out.println("C:\Program Files\JAVA\JDK"); 
		System.out.println("C:\\Program Files\\JAVA\\JDK");

		/*
		 *  \" : ū ����ǥ�� ����ϰ� ���� �� ����Ѵ�
		 *  \' : ���� ����ǥ�� ����ϰ� ���� �� ����Ѵ�.
		 */
		
		System.out.println("������ �������� \"�Ŷ��\"�� �Ծ�߰ڴ�.");
		
	}

}
