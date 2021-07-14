package quiz;

import java.util.ArrayList;
import java.util.Calendar;

public class D11_DiscountDay {

	/*
	 *  어떤 카페에서 짝수번째 목요일마다 할인행사를 진행한다고 가정 할 때
	 *  
	 *  년도를 입력하면 해당 년도의 모든 할인 날짜를 출력해 보세요  
	 *    
	 *   목요일 5
	 */
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int input = 2021;
		cal.set(Calendar.YEAR, input);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DATE, 1);
		
		int dom, dowim, dow;
		ArrayList<String> date_list = new ArrayList<String>();
		cal.set(Calendar.DATE, 2);
		
		String date;
//		System.out.println(Calendar.JANUARY);
//		System.out.println(Calendar.FEBRUARY);

		int month_cnt = 0;
		
//		int month = cal.get( Calendar.MONTH );
//		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
//		if( cal.get( month ) > month + 1 ) {
//		    cal.set( Calendar.MONTH, month + 1 );
//		}
		
		
		while(month_cnt < 12) {
			
			int month = cal.get( Calendar.MONTH );
//			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
			if( cal.get( month ) > month + 1 ) {
			    cal.set( Calendar.MONTH, month + 1 );
			}
			
			dom = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			dowim = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
			
			System.out.println("month: " + month);
			System.out.println("dom : " + dom);
			for(int i=1; i<=dom; i++) {
				
				if(i == dom) {
					cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
					month_cnt++;
					break;
				}
				cal.set(Calendar.DATE, i);
				dowim = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
				dow = cal.get(Calendar.DAY_OF_WEEK);

//				System.out.println("dow : " + dow + "   dowim : " + dowim);
				if(dow == 5 && dowim % 2 == 0) {
					date = input + "/" + (month_cnt+1) + "/" + i + "\n";
					date_list.add(date);
				}
			}
		}
		System.out.println(date_list);
	}
}
