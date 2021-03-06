import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_Regex {

	/*
	 * 	# 정규표현식 (Regular Expression)
	 * 
	 * 	 - 문자열의 패턴을 표현하는 표현식
	 * 	 - 특정 프로그래밍 언어에 종속되지 않는다
	 * 	 - 프로그래머가 원하는 문자열 패턴과 일치하는지 검사한다
	 *   - 정규표현식에는 공백을 넣으면 안된다
	 * 
	 * 	# Pattern 클래스
	 *  
	 *   - 정규표현식을 다루는 클래스
	 *   
	 *  # Matcher 클래스
	 *   
	 *   - 패턴 인스턴스를 이용하여 문자열을 검사할 때 사용하는 클래스 
	 */
	
	public static void main(String[] args) {
		
		// Pattern.matches(regex, input) : input이 regex에 매치되는 문자열인지를 검사해주는 매소드
		System.out.println(Pattern.matches("sleep", "sleep"));
		
		// [] : 해당 위치의 한 글자에 어떤 문자들이 올 수 있는지 정의하는 표현식
		System.out.println(Pattern.matches("s[lh@]eep", "sleep"));	// true
		System.out.println(Pattern.matches("s[lh@]eep", "sheep"));	// true
		System.out.println(Pattern.matches("s[lh@]eep", "s@eep"));	// true
		
		/* 
		 *	[] 내부에 정의할 수 있는 것들
		 * 
		 * 	 1.abc  : 해당 자리에 a 또는 b 또는 c를 허용
		 * 	 2.^abc : 해당 자리에 abc를 제외한 모든것을 허용
		 *   3.a-z  : a 부터 z까지 모두 허용 ( 숫자도 가능 )
		 *   4.&&   : 교집합 
		 */
		System.out.println(Pattern.matches("s[^lh@]eep", "s2eep"));	// true		 ^붙은것 제외	
		System.out.println(Pattern.matches("s[0-9]eep", "s4eep"));	// true      ~ 부터 ~ 까지 가능 
		System.out.println(Pattern.matches("s[0-9a-z]eep", "s0eep"));	// true  ~ 부터 ~ 까지 가능
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sdeep"));	// true  교집합
		
		
		/*
		 * 	 여러 문자를 나타내는 것들
		 * \ 는 두개를 한번에 붙혀야 한다 ( escape )
		 * 
		 *  1. .  : 모든 문자  ※ [] 밖에 써야 모든 문자
		 *  2. \d : 모든 숫자
		 *  3. \D : 숫자를 제외한 모든 것
		 *  4. \s : 모든 공백 (\t\n .. 등의 모든 공백들)
		 *  5. \S : 공백을 제외한 모든 것
		 *  6. \w : 일반적인 문자들을 허용 [a-zA-Z0-9_]   ( 변수로 사용했을때 별 이상 없을 애들 (숫자 가능))
		 *  7. \W : \w의 반대
		 */
		
		System.out.println(Pattern.matches("s.eep", "sheep"));		// true 	모든 문자
		System.out.println(Pattern.matches("s[.]eep", "sheep"));	// false  	. 만허용
		System.out.println(Pattern.matches("s\\.eep", "sheep"));	// false  	. 만허용
		
		System.out.println(Pattern.matches("s\\deep", "s9eep"));	// true  	숫자만 허용			\d
		System.out.println(Pattern.matches("\\D\\D\\D", "Cat"));	// true  	숫자를 제외한 모든 것  	\D
		System.out.println(Pattern.matches("s\\seep", "s\teep"));	// true  	공백만 허용 			\s	
		System.out.println(Pattern.matches("s\\Seep", "s\teep"));	// false  	공백을 제외한 모든 것	\S
		
		
		/*
		 * 	해당 패턴이 적용될 문자의 갯수를 정의하는 방법
		 *  
		 *  1. [ex]{n}  : {}앞의 패턴이 n개 일치해야 한다.
		 *  2. [ex]{n,m}: {}앞의 패턴이 최소 n개 이상, 최대 m개(m포함) 일치해야 한다
		 *  3. [ex]{n,} : {} 앞의 패턴이 최소 n개 이상 일치해야 한다
		 *  4. [ex]?    : 0번 또는 한번
		 *  5. [ex]+ 	: 최소 한번 이상
		 *  6. [ex]* 	: 0번 또는 여러번
		 *  
		 */
		
		System.out.println(Pattern.matches("[\\D3-5]{5}","ca3t5"));		// {5}앞의 글자는 5개 이어야하고, 숫자를 제외 하고 , 3,4,5 는 포함할 수 있으면 true
		System.out.println(Pattern.matches("[\\D3-5]{5}\\.txt","ca3t5.txt"));		// ex) 파일명 검사할 때 파일명은 5글자, 3,4,5 를 제외한 숫자 X 확장자는 .txt
		System.out.println(Pattern.matches("[\\D3-5]{2,5}\\.txt","3!.txt"));		// 앞의 글자 {2글자에서 5글자까지 허용}
		System.out.println(Pattern.matches("[\\가-힣]{2,}","안녕하세힣"));		// 앞의 글자 {2글자 이상}
		System.out.println(Pattern.matches("[\\가-힣]?",""));			// ? 앞의 글자가 0또는 한글자

		// 전화번호 정규표현식
		// 앞에는 0으로 시작해서 숫자 두글자 더 
		// - 를 써도, 안써도 괜찮고 중간자리는 3~4자리 
		// 뒷자리는 위와 동일한 패턴
		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}","010-234-1344"));		
		
		
		// 연습 문제 : 자바에서 허용하는 변수명을 검사할 수 있는 정규표현식을 만들기
		System.out.println(Pattern.matches("[a-zA-Z가-힣_$]+[0-9a-zA-Z가-힣_]*", "힣0_"));
		
		
		/*
		 *	# Pattern.compile(regex)
		 *
		 *	 - 전달한 정규 표현식을 해석하여 Pattern 인스턴스를 생성하고 반환한다
		 *	 - Pattern 타입 인스턴스를 요구하는 곳에 사용할 수 있다.
		 *
		 *	# split() : 컴파일된 패턴 인스턴스로 split()을 진행한다
		 *
		 *	# matcher() : Matcher 인스턴스를 생성하여 반환한다
		 *
		 *	# find() : 다음 값이 있으면 true 없으면 false    (while이랑 같이 쓰기 편함)
		 *
		 *	# group
		 */
		
		String fruit_text = "apple/banana/orange/grape/pineapple/peach/mango/redapple";
		
		Pattern regex = Pattern.compile("/");
		// split 
		String[] fruits = regex.split(fruit_text);
		System.out.println(Arrays.toString(fruits));
		
		// matcher : 검색 느낌 
//		Pattern regex2 = Pattern.compile("apple");		// apple 검색
//		Pattern regex2 = Pattern.compile("a.{3}e");		// a로 시작해서 e로 끝나고 그 사이에 문자가 세개 있는것을 검색
		Pattern regex2 = Pattern.compile("[a-zA-Z]+");	// a~z 까지 잇는 것을 검색 (다른 문자가 있을때까지 ) 
		
		Matcher matcher = regex2.matcher(fruit_text);
		
		while(matcher.find()) {
			System.out.println("찾은 것: " + matcher.group());
			System.out.println("위치 : " + matcher.start() + " 부터 " + matcher.end() + "까지");
		}
		
		
		
		
		
		
		
	}
}
