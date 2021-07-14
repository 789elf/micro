import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class D13_Time{

	/*
	 *	# java.time.Time
	 *
	 *	 - Calendar�� �ν��Ͻ��� set() ������ ��ȭ��Ų�ٴ� ������ ������ Ŭ����
	 *	 - java.time ��Ű���� Ŭ�������� �ð��� ����� �� ���ο� �ν��Ͻ��� ��ȯ�ϰ�
	 *     ���� �ν��Ͻ��� �״�� �����Ѵ�
	 *     
	 *  # Class
	 *   - LocalDate : ��¥�� �����ϱ� ���� Ŭ����
	 *   - LocalTime : �ð��� �����ϱ� ���� Ŭ����  
	 *	 - LocalDateTime : ��¥�� �ð��� ��� �����ϱ� ���� Ŭ����
	 *
	 *	# method()
	 *   - now() : ���� �ð��� �ν��Ͻ��� �����ϴ� �޼ҵ�
	 *   - of()	 : ���ϴ� ��¥/�ð��� �ν��Ͻ��� �����ϴ� �޼ҵ�
	 */
	public static void main(String[] args) {

		// 1. now() : ���� �ð��� �ν��Ͻ��� ����
		// LocalDate ��¥�� ����
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		// LocalTime �ð��� ����
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		// LocalDateTime ��¥�� �ð��� ��� �����ϱ� ���� Ŭ����
		LocalDateTime date_time = LocalDateTime.now();
		System.out.println(date_time);
		
		
		// 2. of() : ���ϴ� ��¥/�ð��� �ν��Ͻ��� ����
		LocalDate childrensDay = LocalDate.of(2021, 5, 5);
		System.out.println(childrensDay);
		
		LocalTime promise = LocalTime.of(17, 8);
		System.out.println(promise);
		
		LocalDateTime my_promise = LocalDateTime.of(childrensDay, promise);
		System.out.println(my_promise);
		
		// �ð� �����ϱ�
		// - Calendar�� ������ �Ѽ��ϴ� ���迴�� ������ �� �κп��� ���̰� ����. (Time�� ����ϴ� ����)
		System.out.println(promise.plusHours(3));
		System.out.println(promise);
		
		System.out.println(childrensDay.getMonth()); // MAY  : ���� �̸��� ��ȯ
		System.out.println(childrensDay.getMonthValue()); // 5  : ���� ���� ��ȯ 
		System.out.println(childrensDay.minusWeeks(1)); // 2021-04-28  : ������ ��¥���� -1 ��
		
		// �ð��� ���ڿ��� ��ȯ
		// - DateTimeFormatter Ŭ���� ���
		// - �پ��� static �޼ҵ�� ǥ�ص��� �̿��� ���ڿ� ������ ������ �� �ִ�
		
		// .ofPattern(str) : ���� ���� �����
		System.out.println(childrensDay.format(DateTimeFormatter.ofPattern("y�� M�� d��")));
		
		// .�پ��� ǥ�� �̸��� : ǥ�� ����ϱ�
		System.out.println(my_promise.format(DateTimeFormatter.ISO_WEEK_DATE));
		System.out.println(my_promise.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		// �ð� ��ü���� ��
		LocalDate christmas = LocalDate.of(2020, 12, 25);
		
		System.out.println("2021�� ��̳��� 2020�� ũ������������ ���ΰ��� ? "
				+ childrensDay.isAfter(christmas));
		
		System.out.println("2021�� ��̳��� 2021�� ũ������������ ���ΰ��� ? "
				+ childrensDay.isBefore(christmas.plusYears(1)));
		
		
	}
}
