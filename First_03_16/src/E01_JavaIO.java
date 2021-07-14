import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E01_JavaIO {

	/*
	 *  # Java I/O (Input/Output)
	 *   
	 *   - �ڹٴ� ��Ʈ���̶�� ������ �̿��� ������� �ٷ��.
	 *   - ���α׷����� ������ ��� �����͵��� �Է��̶�� �θ��� (Input)
	 *   - ���α׷��� �����ؼ� �������� ��� �����͵��� ����̶�� �θ��� (Output)
	 *   
	 *  # Stream
	 *  
	 *   - �����͵��� ���� ���� ���
	 *   - �Է� ���� �� �����͵��� ���α׷����� ������ ��θ� InputStream�̶�� �Ѵ�.
	 *   - ��� �� �� �����͵��� ������ ��θ� OutputStream�̶�� �Ѵ�.
	 *   - �����Ͱ� Stream���� �̵��ϱ� ���ؼ��� �ش� �����͸� byte Ÿ������ ��ȯ�ؾ� �Ѵ�.
	 *   
	 *   write()�� ����Ͽ� ���Ͽ� �Է����Ҷ��� �⺻������ ������ �ٽ� ����� �ȴ�.
	 *   FileOutputStream()�����ڸ� ���� ������ ��ġ�� booleanŸ�� true ���� ���� �־��ְ� �Ǹ� ����� �ʰ� ������ �߰��� �ȴ�. 
	 *   
	 *            �� �ҽ��� ����� ���� ��ġ�� ������Ʈ�� root�̴� ./a.txt = ������Ʈ ���� �ٷ� ���� ������ a.txt
	 */
	public static void main(String[] args) {
		FileOutputStream fout = null;
		try {
			// �⺻ ����� ���
			// fout = new FileOutputStream("E:\\kg-ac\\��\\a.txt");
			
			// true�� �Ű������� �ָ� ������ �߰��� �ȴ�.
//			fout = new FileOutputStream("E:\\kg-ac\\��\\a.txt", true);
			
//			File b = new File("b.txt");
			fout = new FileOutputStream("./a.txt");
			
			File a = new File("./a.txt");			
			
			// ���� ��� �˾ƿ���
			for(int i=0; i<5; i++) {
				// fout.write("������ ���� ".getBytes());
				fout.write(String.format("������ ���� %d \n", i).getBytes());
			}
			
			// �� I/O Stream �������� close()�� ȣ������� �Ѵ�(�޸� ȸ��)
			fout.close();
		} catch (FileNotFoundException e) {
			System.out.println("���� ��ã��");
		} catch (IOException e) {
			System.out.println("�����͸� ���ٰ� ������ ����");
		} finally {
			
				try {
					if(fout != null) fout.close();
				} catch (IOException e) {}
		}
	}
}
