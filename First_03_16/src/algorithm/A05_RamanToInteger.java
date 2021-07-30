package algorithm;

// 로마 문자를 입력하면 문자에 맞는 숫자 리턴
// 단 I, X, C의 뒤에 오는 문자는 I, X, C를 뺀 값을 반환한다. 
// EX >  III : 3,  IV : 4,  CD : 400

/*
  	I = 1
  	V = 5
  	X = 10
  	L = 50
  	C = 100
  	D = 500
  	M = 1000
 */
public class A05_RamanToInteger {

	public static void romanToInteger(String str) {
		
		int result = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if((str.charAt(i) == 'I' || str.charAt(i) == 'X' || str.charAt(i) == 'C') && (i != str.length()-1) && getNumber(str.charAt(i)) < getNumber(str.charAt(i+1))) {
					System.out.println(str.charAt(i));
					result += getNumber(str.charAt(i+1)) - getNumber(str.charAt(i));
					i++;
//				}
			}else {
				result += getNumber(str.charAt(i));
			}
		}
		System.out.println(result);
	}
	
	public static int getNumber(char ch) {
		switch (ch) {
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default : return 1;
		}
	}
	public static void main(String[] args) {
		romanToInteger("MCMXCIV");
	}

}
