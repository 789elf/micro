import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class D11_Calendar {

	/*
	 *	# Date, Calendar, Time
	 *
	 *	 - �ڹٷ� ��¥�� �ð��� �ٷ�� Ŭ��
	 */
	public static void main(String[] args) {

		/* 
		  	# System.currentTimeMillis()
		  	 - �ý����� ���н� Ÿ���� �������� �޼���    �� ���н� Ÿ�� - 1970�� 1�� 1�� ���ķ� �ð��� �� �и��ʳ� �귶���� �� ��
		  	 
		  	# Date
		  	 - Data Ŭ���� ������ �޼ҵ���� ���� ���������� ���� ������Ʈ�� �ߴܵǾ� �ִ�
		  	 - �ð��� ��� �� ���� �ٸ� Ŭ������ ����� ���� �����Ѵ�
		  	 - Data Ŭ������ �ַ� �ð� �ν��Ͻ��� �����ϴ� �뵵�θ� ����Ѵ�
		  	 
		  	# Calendar
		  	 - �޷��� ǥ���� Ŭ����
		  	 - ��¥�� ���� ����� �� �ִ� ��ɵ��� ���ִ�.
		  	 - �߻� �޼ҵ��̱� ������ �ν��Ͻ�ȭ ��ų�� ����.
		  	 - �ð��� ������ �� �����ڰ� �ƴ� getInstance()��� ����ƽ �޼ҵ带 ����Ѵ�.   ex) Calendar Korea = Calendar.getInstance();
		  	 - getInstance() �޼ҵ忡 �浵�� ��Ÿ���� TimeZone�� ���� �� �� �ִ�.
		  	 - Calendar�� ����� �ð� �� �ʿ��� ���� get() �޼ҵ带 ���� ����� �� �ִ�.
		  	 
		  	# TimeZone
		  	 - ���� ������ ������ �����ϰ� �ִ� Ŭ����
		  	 - getAvailableIDs() ����ƽ �޼ҵ带 ���� ����� �� �ִ� Ÿ�������� �� �� �ִ�.
		  	 
		
		*/
		System.out.println("1970/01/01 ���ķ� .. " + 
				System.currentTimeMillis() + "�и��� �귶���ϴ�.");
		
		System.out.println("1970/01/01 ���ķ� .. " + 
				System.currentTimeMillis() / 1000 + "�� �귶���ϴ�.");
		
		System.out.println("1970/01/01 ���ķ� .. " + 
				System.currentTimeMillis() / 1000 / 60+ "�� �귶���ϴ�.");
		
		System.out.println("1970/01/01 ���ķ� .. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 + "�ð� �귶���ϴ�.");
		
		System.out.println("1970/01/01 ���ķ� .. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 / 24+ "�� �귶���ϴ�.");
		
		System.out.println("1970/01/01 ���ķ� .. " + 
				System.currentTimeMillis() / 1000 / 60 / 60 / 24 / 365 + "�� �귶���ϴ�.");
		
		Date now = new Date();
		System.out.println(now);

		Calendar korea = Calendar.getInstance();
		
		// �� ���� �ڵ带 �� �� �ִ�.
		for(String zoneId : TimeZone.getAvailableIDs()) {
			System.out.println(zoneId);
		}
		//Date Ÿ������ ��ȯ�ϸ� ������ �������.
		Calendar new_york = Calendar.getInstance(TimeZone.getTimeZone("America/New_york"));
		
		System.out.println("�ѱ� ���� �ð� : " + korea.get(Calendar.HOUR));
		System.out.println("���� ���� �ð� : " + new_york.get(Calendar.HOUR));
		
		// Calender�� ����� �ð��� �ʿ��Ѱ� get()����ؼ� ������ 
		int year = korea.get(Calendar.YEAR);
		int month = korea.get(Calendar.MONTH)+1;  // Calendar Ŭ������ month�� 0���� �����Ѵ� (+1 �� �������)
		int date = korea.get(Calendar.DATE);
		
		// Calendar�� ����� �ð��� set() �޼ҵ带 ���� ������ �� �ִ�
		korea.set(Calendar.HOUR_OF_DAY, 15);
		// hour = 12�ð� ����, hourOfDay = 24�ð�
		int hour = korea.get(Calendar.HOUR);
		int hourOfDay = korea.get(Calendar.HOUR_OF_DAY);
		int minute = korea.get(Calendar.MINUTE);
		int second = korea.get(Calendar.SECOND);
		int millisec = korea.get(Calendar.MILLISECOND);
		
		System.out.printf("�ѱ� : %d/%d/%d/\n", year,month,date);
		System.out.printf("hour(12H) : %d, hourOfDay(24H) : %d\n", hour,hourOfDay);
		System.out.printf("%d:%d.%03d\n",minute,second,millisec);
		
		// Calendar.ERA�� �ʵ� ����̰�, GregorianCalendar.AD�� BC�� ����̴�
		int era = korea.get(Calendar.ERA);
		
		// Calendar.AM_PM�� �ʵ� ����̰�, Calendar.AM�� Calendar.PM�� ����̴�
		int am = korea.get(Calendar.AM_PM);
		
		System.out.println(era == GregorianCalendar.AD ? "AD" : "BC");
		System.out.println(era != GregorianCalendar.BC ? "AD" : "BC");
		
		System.out.println(am == Calendar.AM ? "AM" : "PM");
		System.out.println(am != Calendar.PM ? "AM" : "PM");
		
		
		int doy = korea.get(Calendar.DAY_OF_YEAR);
		int dom = korea.get(Calendar.DAY_OF_MONTH);
		int dow = korea.get(Calendar.DAY_OF_WEEK);
		int dowim = korea.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		
		System.out.println("DOY(���ذ� ���۵ǰ� ���� ��¥ : " + doy);
		System.out.println("DOY(�̹� �� ���۵ǰ� ���� ��¥ : " + dom);
		System.out.println("DOW(�̹��� ���۵ǰ� ���� ��¥, ���� : " + dow); // 1�� sunday 2,3,4,5,6,7 ������� 
		System.out.println("DOWIM(�̹� ���� �� ��° �ش� �����ΰ� : " + dowim); // ������ �̹��� �����ϰ� ���° �������� (ex: �ݿ����� �̹��� ���۵ǰ� ��� °���� )   
		
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
