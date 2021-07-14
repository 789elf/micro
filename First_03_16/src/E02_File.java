import java.io.File;

public class E02_File {

	/*
	 *	 # java.util.file
	 *	
	 *	  - ���� �ý����� ���� ������ ���� �� �ִ� Ŭ����
	 *	  - �ν��Ͻ��� ����ִ� ������ �������� ���ο� �����̳� ���丮�� ������ �� �ִ�
	 *	  - �̹� �����ϴ� ���� �Ǵ� ���丮�� ������ �ҷ����⵵ �Ѵ�
	 */
	public static void main(String[] args) {

		// �����ڷ� ��� ����
		File a = new File("E:\\kg-ac\\��\\a.txt");
//		File b = new File("b.txt");
		
		File dir = new File("E:/kg-ac/��");
		File dir2 = new File("E:/kg-ac/��/test_dir");
		
		// File�� �������� �޼ҵ�
		System.out.println("�б� ������ �ִ� �����ΰ��� ? " + a.canRead());
		System.out.println("���� ������ �ִ� �����ΰ��� ? " + a.canExecute());
		System.out.println("���� ������ �ִ� �����ΰ��� ? " + a.canWrite());
		
		// ���� ��� �˾ƿ���
		System.out.println(a.getAbsolutePath());
		
		// a�� ��� ��ΰ� ���� ����ΰ�?
		System.out.println(a.isAbsolute());
		
		// a�� ��� ���� �ν��Ͻ��� ���丮�ΰ�?
		System.out.println("Is a a directory ?" + a.isDirectory());
		
		System.out.println("a�� ���� �����ϴ°� ? " + a.exists());
		System.out.println("dir�� ���� �����ϴ°� ? " + dir.exists());
		System.out.println("dir2�� ���� �����ϴ°� ? " + dir2.exists());
		
		//�������� ������ ���丮 �����ϱ� mkdir() : ���丮 ���� �޼ҵ� 
		if(!dir2.exists()) {
			dir2.mkdir();
		}else {
			System.out.println("�̹� ����");
		}
		
	}

}
