import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class E03_FileIO {

	/*
	 * 	# Stream
	 * 	 - �����͵��� ������ ���
	 * 	 - ���α׷����� ���� �� ����ϴ� ��θ� InputStream�̶�� �Ѵ�.
	 * 	 - ���α׷����� ó���� �� ���� �� ����ϴ� ��θ� OutputStream�̶�� �Ѵ�.
	 * 
	 * 	# InputStream�� ���� �޼ҵ�
	 * 	 - read() : ��Ʈ������ ���� ������ �� ����Ʈ�� �о�´�. EOF�� �����ϸ� -1�� ��ȯ
	 * 	 - read(byte[]) : byte[] �� ���� �����ϸ� �ű⿡ ����ش�.
	 * 	 - read(byte[], off, len) : byte[]�� ���� �����ϵ� ���ϴ� ��ŭ ���ϴ� ��ġ�� �д´�.
	 *   - close() : �� ����� ��Ʈ���� �ݴ´�.���� ������ ��� �޸𸮸� �����ϰ� �ְ� �ȴ�.
	 * 
	 * 	# OutputStream�� ���� �޼ҵ�
	 * 	 - write(int) : �� ���ھ� ����
	 *   - write(byte[]) : byte[]�� ��� ������ �ѹ��� ����
	 *   - flush() : write�� ��Ƴ��� ������� ��� ��������
	 *   - close() : �� ����� ��Ʈ���� �ݴ´�.���� ������ ��� �޸𸮸� �����ϰ� �ְ� �ȴ�.
	 *   			 close() �� �� ���� �����Ͱ� �ִٸ� flush()�� �Ѵ�
	 */
	public static void main(String[] args) {

		File git = new File("./note/01_Git.txt");
		
		System.out.println(git.exists());
		System.out.println(git.isDirectory());
		System.out.println(git.isFile());
		
		try {
			FileInputStream fin = new FileInputStream(git);
			
			byte[] buffer = new byte[2000];
		
			// �ѱ� �ȱ����� �о� ���̴� ��(���ϴ� ����Ʈ ũ�⸸ŭ �б�
			int len;
			while((len = fin.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, len));
			}
			
			// ������ ������ �о� ���̴� �� (1����Ʈ�� �б�)( �ѱ� ���� ) 
//			int _byt
//			while((_byte = fin.read()) != -1) {
//				System.out.print((char)_byte);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���Ͽ� ��������
		File newFile = new File("./note/my first file output.txt");
		try {
			FileOutputStream fout = new FileOutputStream(newFile);
			
			// 1. int�� ����ϴ� ���
			fout.write(65);
			fout.write(66);
			fout.write(67);
			fout.write(68);
			fout.write('\n');
			
			// 2. byte[] �� �̿��ϴ� ���
			fout.write("�ȳ��ϼ���!\n".getBytes());
			
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}