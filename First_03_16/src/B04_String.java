
public class B04_String {

	public static void main(String[] args) {
	/*
	 *  # 	문자열 (참조형 타입)은 ==으로 비교하면 안된다.
	 *  	참조형 타입의 값을 비교할 때는  해당 클래스에 정의되어 있는 equals()라는
	 *  	메서드를 이용해야 한다. 
	 *  	ex: System.out.println(str.equals("yes"));
	 *  	
	 *  	문자열끼리 비교할 때 == 을 사용하면 값비교가 아닌 주소값 비교를 한다.
	 *  
	 *  #	기본형 타입과 참조형 타입의 차이
	 *  	- 기본형 타입은 내부 데이터의 크기를 예측하기 쉽다.
	 *  	  (차곡차곡 쌓이는 메모리 사용 , Stack)
	 *  	- 참조형 타입은 내부 데이터의 크기를 예측하기 어렵다.
	 *  	  (여기저기 막 쓰이는 메모리 사용, Heap)
	 */
		
		String str1 = "yes";
		String str2 = new String("yes");
		String str3 = "yes";
				
		
		
	}
	
	/*
	 *  format = 문자열을 만들때 포맷을 정해두고 리턴을 할 수있다
	 */
	public String getTranscript(String name, int kor, int eng, int mat, int total, float avg) {
		return String.format("%s  %d  %d  %d %d  %.2f", name, kor, eng, mat, total, avg);
	}
	
	
	
	
}
