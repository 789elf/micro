package quiz;

import java.util.Scanner;

public class B08_ConvertSecond {

	public static void main(String[] args) {

		/*
		 * 	초를 입력 받으면 년/일/시간/분/초로 변환하여 출력
		 * 	필요 없는단위는 출력하지 말 것
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int sec,year,day,hour,min;
		
		System.out.println("초를 입력하세요.(양수만)");
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
				
//				System.out.println(year+"년"+day+"일"+hour+"시간"+min+"분"+sec+"초");
				System.out.print(year+"년");
				flag = true;
			}
			if(flag || day >= 1) {
				
//				System.out.println(day+"일"+hour+"시간"+min+"분"+sec+"초");
				System.out.print(day+"일");
				flag = true;
			}
			if(flag || hour >= 1) {
				
//				System.out.println(hour+"시간"+min+"분"+sec+"초");
				System.out.print(hour+"시간");
				flag = true;
			
			}
			if(flag || min >= 1) {
				
//				System.out.println(min+"분"+sec+"초");
				System.out.print(min+"분");
				
			}else{
				
				System.out.println("초를 정확하게 입력해주세요.");
				
			}
		}
	}
}
