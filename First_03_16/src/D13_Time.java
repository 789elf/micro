import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class D13_Time{

	/*
	 *	# java.time.Time
	 *
	 *	 - Calendar의 인스턴스를 set() 을통해 변화시킨다는 단점을 보완한 클래스
	 *	 - java.time 패키지의 클래스들은 시간을 계산한 뒤 새로운 인스턴스를 반환하고
	 *     원본 인스턴스는 그대로 유지한다
	 *     
	 *  # Class
	 *   - LocalDate : 날짜만 저장하기 위한 클래스
	 *   - LocalTime : 시간만 저장하기 위한 클래스  
	 *	 - LocalDateTime : 날짜와 시간을 모두 저장하기 위한 클래스
	 *
	 *	# method()
	 *   - now() : 지금 시간의 인스턴스를 생성하는 메소드
	 *   - of()	 : 원하는 날짜/시간의 인스턴스를 생성하는 메소드
	 */
	public static void main(String[] args) {

		// 1. now() : 지금 시간의 인스턴스를 생성
		// LocalDate 날짜만 저장
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		// LocalTime 시간만 저장
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		// LocalDateTime 날짜와 시간을 모두 저장하기 위한 클래스
		LocalDateTime date_time = LocalDateTime.now();
		System.out.println(date_time);
		
		
		// 2. of() : 원하는 날짜/시간의 인스턴스를 생성
		LocalDate childrensDay = LocalDate.of(2021, 5, 5);
		System.out.println(childrensDay);
		
		LocalTime promise = LocalTime.of(17, 8);
		System.out.println(promise);
		
		LocalDateTime my_promise = LocalDateTime.of(childrensDay, promise);
		System.out.println(my_promise);
		
		// 시간 변경하기
		// - Calendar는 원본을 훼손하는 설계였기 때문에 이 부분에서 차이가 난다. (Time을 사용하는 이유)
		System.out.println(promise.plusHours(3));
		System.out.println(promise);
		
		System.out.println(childrensDay.getMonth()); // MAY  : 달의 이름을 반환
		System.out.println(childrensDay.getMonthValue()); // 5  : 달의 값을 반환 
		System.out.println(childrensDay.minusWeeks(1)); // 2021-04-28  : 전달한 날짜기준 -1 주
		
		// 시간을 문자열로 변환
		// - DateTimeFormatter 클래스 사용
		// - 다양한 static 메소드와 표준들을 이용해 문자열 형식을 지정할 수 있다
		
		// .ofPattern(str) : 포맷 직접 만들기
		System.out.println(childrensDay.format(DateTimeFormatter.ofPattern("y년 M월 d일")));
		
		// .다양한 표준 이름들 : 표준 사용하기
		System.out.println(my_promise.format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println(my_promise.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		// 시간 객체끼리 비교
		LocalDate christmas = LocalDate.of(2020, 12, 25);
		
		System.out.println("2021년 어린이날이 2020년 크리스마스보다 뒤인가요 ? "
				+ childrensDay.isAfter(christmas));
		
		System.out.println("2021년 어린이날이 2021년 크리스마스보다 앞인가요 ? "
				+ childrensDay.isBefore(christmas.plusYears(1)));
		
		
	}
}
