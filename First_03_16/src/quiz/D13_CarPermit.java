package quiz;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/*
 *  ���� ����ȣ�� ���� ������ �Ұ����� ������ �����ϱ�
 *   
 *  �� : 1, 6    2 
 *  ȭ : 2, 7    3
 *  �� : 3, 8    4
 *  �� : 4, 9    5
 *  �� : 5, 0    6
 *  
 *  �ָ� : ��� ���� ����
 *  
 *  �������� : �����,���Ƶ���,���� 
 */
public class D13_CarPermit {
	
	static Car car = new Car();
	static Calendar cal = Calendar.getInstance();
	static SimpleDateFormat f1 = new SimpleDateFormat("EEEE");
	static String date = f1.format(Calendar.getInstance().getTime());
	
	public static String getCarType() {
		
		if(car.car_type.equals("�Ϲ�����")) 
			return "�Ϲ�����";
		if(car.car_type.equals("�����ž������")) 
			return "�����ž������";
		if(car.car_type.equals("���Ƶ�������")) 
			return "���Ƶ�������";
		else 
			return "����";
	}
	
	public static boolean carPermit() {

		
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		int last_num = car.car_num.charAt(3) - 48;
		
		if(!getCarType().equals("�Ϲ�����")) {
			System.out.println(getCarType() + " ��� ���� ����");
			return true;
		}
		
		if(dow == 1 || dow == 7) {
			System.out.println("�ָ��� ��� ��� ����");
			return true;
		}
		// �� ~ ��
		for(int i=0; i<4; i++) {
			if(dow == (i+2) && (last_num == (i+1) || last_num == (i+6))) {
				System.out.println(date + "���� �Ұ� ����  ");
				return false;
			}
		}
		// ��
		if(dow == 6 && (last_num == 5 || last_num == 0)) {
			System.out.println(date + "���� �Ұ� ����  ");
			return false;
		}
		System.out.println("��� ���� ����");
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("�ڵ��� ���� : " + car.car_type);
		System.out.println("�ڵ��� ��ȣ : " + car.car_num);
		System.out.println("���� : " + date + "\n");
		
		System.out.println(carPermit());
	}
}

class Car{
	
	String[] numbers = {
			"0","1","2","3","4","5","6","7","8","9"
			};
	String[] types = {
			"�Ϲ�����", "�����ž������", "���Ƶ�������", "����"
	};
	
 	String car_type = "";
	String car_num = "";
	
	Car(){
		car_type = types[(int)(Math.random() * 4 + 0)];
		
		for(int i=0; i<4; i++) {
			car_num += numbers[(int)(Math.random() * 10 + 0)];
		}
	}
}
