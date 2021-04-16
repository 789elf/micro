
public class B05_TypeCasting {

	public static void main(String[] args) {

		/*
		 * 	# 타입 캐스팅
		 * 	- 타입이 자연스럽게 변하는 경우 (타입이 변하더라도 문제가 없을 때)
		 * 	- 타입을 강제로 변환시키는 경우 (타입이 변하면 위험할 때)
		 * 
		 * 	# 타입의 크기
		 * 	- 정수 타입: byte(1) < char,short(2) < int(4) < long(8)
		 * 	- 실수 타입: float(4) < double(8)
		 * 
		 * 	# 정수 타입은 무조건 실수 타입보다 표현 범위가 작다.
		 */
		
		// 1. 자연스러운 타입 캐스팅
		byte _byte = 127;
		int _int;
		long _long;
		float _float;
		short _short;
		_int = _byte;
		_int = 2100000000;
		_long = _int;
		_float = _long;
	
		// 2. 값이 손상될 위험이 있는 타입 캐스팅
		_int = 1000;
		_short = (short)_int;	// 값이 손상될 수 있을때 경고를 해주고 강제 캐스팅을 해야한다.
		
		// 3. 같은 값이더라도 다르게 해석될 수 있는 타입의 경우 타입 캐스팅이 필요하다.
		int a = 80;
		char ch = 'z';
		
		System.out.println((char) a);
		System.out.println(a);
		
		System.out.println((int) ch);
		System.out.println(ch);
		
		
		
		
	}

}
