import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class D11_Calendar {

	/*
	 *	# Date, Calendar, Time
	 *
	 *	 - 자바로 날짜와 시간을 다루는 클랫
	 */
	public static void main(String[] args) {

		/* 
		  	# System.currentTimeMillis()
		  	 - 시스템의 유닉스 타임을 가져오는 메서드    ※ 유닉스 타임 - 1970년 1월 1일 이후로 시간이 몇 밀리초나 흘렀는지 센 것
		  	 
		  	# Date
		  	 - Data 클래스 내부의 메소드들은 요즘 버전에서는 거의 업데이트가 중단되어 있다
		  	 - 시간을 계산 할 때는 다른 클래스를 사용할 것을 권장한다
		  	 - Data 클래스는 주로 시간 인스턴스를 보관하는 용도로만 사용한다
		  	 
		  	# Calendar
		  	 - 달력을 표현한 클래스
		  	 - 날짜를 쉽게 계산할 수 있는 기능들이 모여있다.
		  	 - 추상 메소드이기 때문에 인스턴스화 시킬수 없다.
		  	 - 시간을 가져올 때 생성자가 아닌 getInstance()라는 스태틱 메소드를 사용한다.   ex) Calendar Korea = Calendar.getInstance();
		  	 - getInstance() 메소드에 경도를 나타내는 TimeZone을 전달 할 수 있다.
		  	 - Calendar에 저장된 시간 중 필요한 값을 get() 메소드를 통해 사용할 수 있다.
		  	 
		  	# TimeZone
		  	 - 여러 지역의 시차를 보관하고 있는 클래스
		  	 - getAvailableIDs() 스태틱 메소드를 통해 사용할 수 있는 타임존들을 볼 수 있다.
		  	 
		
		*/
		System.out.println("1970/01/01 이후로 .. " + 
				System.currentTimeMillis() + "밀리초 흘렀습니다.");
		
		System.out.println("1970/01/01 이후로 .. " + 
				System.currentTimeMillis() / 1000 + "초 흘렀습니다.");
		
		System.out.println("1970/01/01 이후로 .. " + 
				System.currentTimeMillis() / 1000 / 60+ "분 흘렀습니다.");
		
		System.out.println("1970/01/01 이후로 .. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 + "시간 흘렀습니다.");
		
		System.out.println("1970/01/01 이후로 .. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 / 24+ "일 흘렀습니다.");
		
		System.out.println("1970/01/01 이후로 .. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365 + "년 흘렀습니다.");
		
		Date now = new Date();
		System.out.println(now);

		Calendar korea = Calendar.getInstance();
		
		// 각 나라별 코드를 볼 수 있다.
		for(String zoneId : TimeZone.getAvailableIDs()) {
			System.out.println(zoneId);
		}
		//Date 타입으로 변환하면 시차가 사라진다.
		Calendar new_york = Calendar.getInstance(TimeZone.getTimeZone("America/New_york"));
		
		System.out.println("한국 현재 시간 : " + korea.get(Calendar.HOUR));
		System.out.println("뉴욕 현재 시간 : " + new_york.get(Calendar.HOUR));
		
		// Calender에 저장된 시간중 필요한값 get()사용해서 꺼내기 
		int year = korea.get(Calendar.YEAR);
		int month = korea.get(Calendar.MONTH)+1;  // Calendar 클래스는 month만 0으로 시작한다 (+1 을 해줘야함)
		int date = korea.get(Calendar.DATE);
		
		// Calendar에 저장된 시간을 set() 메소드를 통해 수정할 수 있다
		korea.set(Calendar.HOUR_OF_DAY, 15);
		// hour = 12시간 기준, hourOfDay = 24시간
		int hour = korea.get(Calendar.HOUR);
		int hourOfDay = korea.get(Calendar.HOUR_OF_DAY);
		int minute = korea.get(Calendar.MINUTE);
		int second = korea.get(Calendar.SECOND);
		int millisec = korea.get(Calendar.MILLISECOND);
		
		System.out.printf("한국 : %d/%d/%d/\n", year,month,date);
		System.out.printf("hour(12H) : %d, hourOfDay(24H) : %d\n", hour,hourOfDay);
		System.out.printf("%d:%d.%03d\n",minute,second,millisec);
		
		// Calendar.ERA가 필드 상수이고, GregorianCalendar.AD와 BC가 상수이다
		int era = korea.get(Calendar.ERA);
		
		// Calendar.AM_PM이 필드 상수이고, Calendar.AM과 Calendar.PM은 상수이다
		int am = korea.get(Calendar.AM_PM);
		
		System.out.println(era == GregorianCalendar.AD ? "AD" : "BC");
		System.out.println(era != GregorianCalendar.BC ? "AD" : "BC");
		
		System.out.println(am == Calendar.AM ? "AM" : "PM");
		System.out.println(am != Calendar.PM ? "AM" : "PM");
		
		
		int doy = korea.get(Calendar.DAY_OF_YEAR);
		int dom = korea.get(Calendar.DAY_OF_MONTH);
		int dow = korea.get(Calendar.DAY_OF_WEEK);
		int dowim = korea.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		System.out.println("DOY(올해가 시작되고 지난 날짜 : " + doy);
		System.out.println("DOY(이번 달 시작되고 지난 날짜 : " + dom);
		System.out.println("DOW(이번주 시작되고 지난 날짜, 요일 : " + dow); // 1은 sunday 2,3,4,5,6,7 순서대로 
		System.out.println("DOWIM(이번 달의 몇 번째 해당 요일인가 : " + dowim); // 오늘이 이번달 시작하고 몇번째 요일인지 (ex: 금요일이 이번달 시작되고 몇번 째인지 )   
		
		System.out.println("Calendar.SUNDAY: " + Calendar.SUNDAY);
        System.out.println("Calendar.MONDAY: " + Calendar.MONDAY);
        System.out.println("Calendar.TUESDAY: " + Calendar.TUESDAY);
        System.out.println("Calendar.WEDNESDAY: " + Calendar.WEDNESDAY);
        System.out.println("Calendar.THURSDAY: " + Calendar.THURSDAY);
        System.out.println("Calendar.FRIDAY: " + Calendar.FRIDAY);
        System.out.println("Calendar.SATURDAY: " + Calendar.SATURDAY);
        
        System.out.printf("%s: %d/%d/%d\n", 
                        korea.getTimeZone().getID(), year, month + 1, date);
        System.out.printf("hour(12H): %d, hourOfDay(24H): %d\n", hour, hourOfDay);
        System.out.printf("%d:%d.%03d\n", minute, second, millisec);
	}

}
