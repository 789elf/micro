package quiz;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/*
 *  차량 끝번호에 따라서 출입이 불가능한 요일을 지정하기
 *   
 *  월 : 1, 6    2 
 *  화 : 2, 7    3
 *  수 : 3, 8    4
 *  목 : 4, 9    5
 *  금 : 5, 0    6
 *  
 *  주말 : 모든 차량 가능
 *  
 *  제외차량 : 장애인,유아동승,경차 
 */
public class D13_CarPermit {
	
	static Car car = new Car();
	static Calendar cal = Calendar.getInstance();
	static SimpleDateFormat f1 = new SimpleDateFormat("EEEE");
	static String date = f1.format(Calendar.getInstance().getTime());
	
	public static String getCarType() {
		
		if(car.car_type.equals("일반차량")) 
			return "일반차량";
		if(car.car_type.equals("장애인탑승차량")) 
			return "장애인탑승차량";
		if(car.car_type.equals("유아동승차량")) 
			return "유아동승차량";
		else 
			return "경차";
	}
	
	public static boolean carPermit() {

		
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		int last_num = car.car_num.charAt(3) - 48;
		
		if(!getCarType().equals("일반차량")) {
			System.out.println(getCarType() + " 상시 출입 가능");
			return true;
		}
		
		if(dow == 1 || dow == 7) {
			System.out.println("주말은 모두 통과 가능");
			return true;
		}
		// 월 ~ 목
		for(int i=0; i<4; i++) {
			if(dow == (i+2) && (last_num == (i+1) || last_num == (i+6))) {
				System.out.println(date + "출입 불가 차량  ");
				return false;
			}
		}
		// 금
		if(dow == 6 && (last_num == 5 || last_num == 0)) {
			System.out.println(date + "출입 불가 차량  ");
			return false;
		}
		System.out.println("통과 가능 차량");
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println("자동차 종류 : " + car.car_type);
		System.out.println("자동차 번호 : " + car.car_num);
		System.out.println("요일 : " + date + "\n");
		
		System.out.println(carPermit());
	}
}

class Car{
	
	String[] numbers = {
			"0","1","2","3","4","5","6","7","8","9"
			};
	String[] types = {
			"일반차량", "장애인탑승차량", "유아동승차량", "경차"
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
