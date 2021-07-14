import java.text.SimpleDateFormat;
import java.util.Calendar;

public class D12_SimpleDateFormat {

	/*
	 * 	# SimpleDateFormat Ŭ����
	 * 	
	 * 	 - �����ϰ� ��¥ �ν��Ͻ��� ���ڷ� ��ȯ�� �� �ִ� ���� Ŭ����
	 * 
	 *  # ��¥ ����
	 *  
	 *   y : ��
	 *   M : ��
	 *   d : �� 
	 *   D : �� ���� ���� �� (1 ~ 365)
	 *   
	 *   H : 24��
	 *   h : 12��
	 *   m : ��
	 *   s : ��
	 *   S : �и���
	 *   
	 *   E : ����
	 *   
	 *   w : day of week if year  // 1���� ���° n��������
	 *   W : day of week in month // �̹��� �� ����� n��������
	 */
	public static void main(String[] args) {

		SimpleDateFormat f1 = new SimpleDateFormat("yyyy/MM/dd (DDD) HH:mm:ss.SSS EEEE w W");
		
		String date = f1.format(Calendar.getInstance().getTime());
		
		System.out.println(date);
	}

}
