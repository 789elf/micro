import java.text.SimpleDateFormat;
import java.util.Calendar;

public class D12_SimpleDateFormat {

	/*
	 * 	# SimpleDateFormat 클래스
	 * 	
	 * 	 - 간편하게 날짜 인스턴스를 문자로 변환할 수 있는 서식 클래스
	 * 
	 *  # 날짜 서식
	 *  
	 *   y : 년
	 *   M : 월
	 *   d : 일 
	 *   D : 월 구분 없는 일 (1 ~ 365)
	 *   
	 *   H : 24시
	 *   h : 12시
	 *   m : 분
	 *   s : 초
	 *   S : 밀리초
	 *   
	 *   E : 요일
	 *   
	 *   w : day of week if year  // 1년중 몇번째 n요일인지
	 *   W : day of week in month // 이번달 중 몇번쨰 n요일인지
	 */
	public static void main(String[] args) {

		SimpleDateFormat f1 = new SimpleDateFormat("yyyy/MM/dd (DDD) HH:mm:ss.SSS EEEE w W");
		
		String date = f1.format(Calendar.getInstance().getTime());
		
		System.out.println(date);
	}

}
