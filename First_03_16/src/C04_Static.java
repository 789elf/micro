import java.util.Collections;
import java.util.HashSet;

public class C04_Static {

	/*
	 *  # static (���� ����, Ŭ���� ���� <=> �ν��Ͻ� ����)
	 *  
	 *    - static�� ���� Ŭ������ ��� �ν��Ͻ��� �������� ����ϴ� ����.
	 *    - �տ� static�� ���� Ŭ������ �ڿ��� ��� �ν��Ͻ����� ���� ���� ���ϰ� �ȴ�.
	 *    - static ������ Ŭ������ �ϳ��ۿ� �������� �����Ƿ� �޸𸮰� ����ȴ�.
	 *    - static ������ Ŭ������ �ϳ��̱� ������ Ŭ������ . �� ��� �����ϴ� ���� ����.
	 *    - static ������ �ڿ��� �ν��Ͻ��� ����� ������ ȣ���� �� �ִ�.
	 *    - �ν��Ͻ��� �������� ���� ���� static�� ���� ���ɼ��� �ֱ� ������
	 *      static �޼ҵ忡���� �ν��Ͻ� �ڿ��� ����� �� ����.
	 */
	
	private static HashSet<Integer> month31;
	private static HashSet<Integer> month30;
	// static�� �����ڿ��� �ʱ�ȭ�ϸ� �����̹Ƿ� static ��Ͽ��� �ʱ�ȭ �Ѵ�.
	static {
		month31 = new HashSet<>();
		month30 = new HashSet<>();
		
		Collections.addAll(month31, 1, 3, 5, 7, 8, 10, 12);
		Collections.addAll(month30, 4, 6, 9, 11);
	}
	public static void main(String[] args) {

		// ���� ������ �ν��Ͻ��� ������ static �ڿ��� ����� �� �ִ�.
		// static�ڿ��� Ŭ������ .�� ��� ������ �� �ִ� ( �ν��Ͻ� ���� �� �ڿ� �ٴ� . �̾ƴ� Ŭ������ �ڿ� �ٴ� . )
		System.out.println(Lamp.width);
		System.out.println(Lamp.height);
		
//		Lamp[] lamps = new Lamp[12];
		Lamp lamp01 = new Lamp();
		Lamp lamp02 = new Lamp();
		Lamp lamp03 = new Lamp();
		
		// lamp03.width�� ���� 30���� �����ص� static���� �� ��� �ڿ��� �����ϱ� ������ �ٸ��͵� 30���� ����ȴ�.  
		lamp03.width = 30;
		System.out.println(lamp01.width);
		System.out.println(lamp02.width);
		System.out.println(lamp03.width);
	}
}
class Lamp{
	
	//������ ������ ��� �������� �ʺ�� ���̴� �����ϴ� ( ��ü ���� ���̴� static���� �ش� )
	static int width = 50;
	static int height = 200;
	
	int[] position;
	double brightness;
	boolean powerOn;
	
	// static �޼��忡�� static ������ �����ϴ� ���� ����
	public static void changeWidth(int width) {
		Lamp.width = width;
	}
	// static �������� instance �ڿ��� �����ϴ� ���� �Ұ���
//	static void turnOn() {
//		powerOn = true;
//	}
	
	/*
	 *  myobj ��Ű���� static ������ ������ Ŭ������ �ϳ� ���� �غ���. 
	 *  ���� �ǵ��� 
	 *  
	 */
}
