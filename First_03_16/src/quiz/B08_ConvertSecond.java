package quiz;

import java.util.Scanner;

public class B08_ConvertSecond {

	public static void main(String[] args) {

		/*
		 * 	�ʸ� �Է� ������ ��/��/�ð�/��/�ʷ� ��ȯ�Ͽ� ���
		 * 	�ʿ� ���´����� ������� �� ��
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int sec,year,day,hour,min;
		
		System.out.println("�ʸ� �Է��ϼ���.(�����)");
		sec = sc.nextInt();
		
		if(sec > 0) {

			min = sec / 60;
			hour = min / 60;
			day = hour / 24;
			year = day / 365;
			
			sec = sec % 60;
			min = min % 60;
			hour = hour % 24;
			day = day % 365;
			
			boolean flag;
			flag = false;
			
			if(year >= 1) {
				
//				System.out.println(year+"��"+day+"��"+hour+"�ð�"+min+"��"+sec+"��");
				System.out.print(year+"��");
				flag = true;
			}
			if(flag || day >= 1) {
				
//				System.out.println(day+"��"+hour+"�ð�"+min+"��"+sec+"��");
				System.out.print(day+"��");
				flag = true;
			}
			if(flag || hour >= 1) {
				
//				System.out.println(hour+"�ð�"+min+"��"+sec+"��");
				System.out.print(hour+"�ð�");
				flag = true;
			
			}
			if(flag || min >= 1) {
				
//				System.out.println(min+"��"+sec+"��");
				System.out.print(min+"��");
				
			}else{
				
				System.out.println("�ʸ� ��Ȯ�ϰ� �Է����ּ���.");
				
			}
		}
	}
}
