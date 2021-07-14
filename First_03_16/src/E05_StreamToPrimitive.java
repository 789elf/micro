import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class E05_StreamToPrimitive {

	/*
	 *  # DataInputStream/DataOutputStream
	 *  
	 *   - Reader/Writer�� Stream�� ���ڷ� �ս��� �ٷ�� ���� Ŭ����
	 *     DataInputStream/DataOutputStream�� �⺻�� Ÿ������ �ս��� �ٷ�� ���� Ŭ������
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		File file = new File("./data/myData.data");
		try {
			FileOutputStream fout = new FileOutputStream(new File("./data/myData.data"));
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeInt(9990);
			dout.writeInt(3000);
			dout.writeInt(850);
			dout.writeFloat(123.123F);
			dout.writeUTF("UTF-8");
			dout.writeBoolean(true);
			
			// ����� ��Ʈ���� ���� �ֱٿ� ���� �� ���� ���ʴ�� �ݾƾ� �Ѵ�
			dout.close();
//			OutputStreamWriter writer = 
//					new OutputStreamWriter(fout, Charset.forName("euc-kr"));
//			writer.append("�ȳ��ϼ���");
//			writer.close();
			fout.close();
			
		}catch (FileNotFoundException e) {}
		 catch (IOException e) {}
		
		FileInputStream fin;
		DataInputStream din;
		try {
			fin = new FileInputStream(file);
			din = new DataInputStream(fin);
			
			// �� writeInt�� ���� ���� readInt�� �о�� �Ѵ�
			// ���Ͽ� ���� ������� ������ �����͸� �ٽ� ������ �� �ִ�.
			System.out.println("�Ʊ� �����ߴ� ù��° int : " + din.readInt());
			System.out.println("�Ʊ� �����ߴ� �ι�° int : " + din.readInt());
			System.out.println("�Ʊ� �����ߴ� ����° int : " + din.readInt());
			System.out.println("float : " + din.readFloat());
			System.out.println("UTF : " + din.readUTF());
			System.out.println("boolean : " + din.readBoolean());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
