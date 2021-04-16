import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_Regex {

	/*
	 * 	# ����ǥ���� (Regular Expression)
	 * 
	 * 	 - ���ڿ��� ������ ǥ���ϴ� ǥ����
	 * 	 - Ư�� ���α׷��� �� ���ӵ��� �ʴ´�
	 * 	 - ���α׷��Ӱ� ���ϴ� ���ڿ� ���ϰ� ��ġ�ϴ��� �˻��Ѵ�
	 *   - ����ǥ���Ŀ��� ������ ������ �ȵȴ�
	 * 
	 * 	# Pattern Ŭ����
	 *  
	 *   - ����ǥ������ �ٷ�� Ŭ����
	 *   
	 *  # Matcher Ŭ����
	 *   
	 *   - ���� �ν��Ͻ��� �̿��Ͽ� ���ڿ��� �˻��� �� ����ϴ� Ŭ���� 
	 */
	
	public static void main(String[] args) {
		
		// Pattern.matches(regex, input) : input�� regex�� ��ġ�Ǵ� ���ڿ������� �˻����ִ� �żҵ�
		System.out.println(Pattern.matches("sleep", "sleep"));
		
		// [] : �ش� ��ġ�� �� ���ڿ� � ���ڵ��� �� �� �ִ��� �����ϴ� ǥ����
		System.out.println(Pattern.matches("s[lh@]eep", "sleep"));	// true
		System.out.println(Pattern.matches("s[lh@]eep", "sheep"));	// true
		System.out.println(Pattern.matches("s[lh@]eep", "s@eep"));	// true
		
		/* 
		 *	[] ���ο� ������ �� �ִ� �͵�
		 * 
		 * 	 1.abc  : �ش� �ڸ��� a �Ǵ� b �Ǵ� c�� ���
		 * 	 2.^abc : �ش� �ڸ��� abc�� ������ ������ ���
		 *   3.a-z  : a ���� z���� ��� ��� ( ���ڵ� ���� )
		 *   4.&&   : ������ 
		 */
		System.out.println(Pattern.matches("s[^lh@]eep", "s2eep"));	// true		 ^������ ����	
		System.out.println(Pattern.matches("s[0-9]eep", "s4eep"));	// true      ~ ���� ~ ���� ���� 
		System.out.println(Pattern.matches("s[0-9a-z]eep", "s0eep"));	// true  ~ ���� ~ ���� ����
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sdeep"));	// true  ������
		
		
		/*
		 * 	 ���� ���ڸ� ��Ÿ���� �͵�
		 * \ �� �ΰ��� �ѹ��� ������ �Ѵ� ( escape )
		 * 
		 *  1. .  : ��� ����  �� [] �ۿ� ��� ��� ����
		 *  2. \d : ��� ����
		 *  3. \D : ���ڸ� ������ ��� ��
		 *  4. \s : ��� ���� (\t\n .. ���� ��� �����)
		 *  5. \S : ������ ������ ��� ��
		 *  6. \w : �Ϲ����� ���ڵ��� ��� [a-zA-Z0-9_]   ( ������ ��������� �� �̻� ���� �ֵ� (���� ����))
		 *  7. \W : \w�� �ݴ�
		 */
		
		System.out.println(Pattern.matches("s.eep", "sheep"));		// true 	��� ����
		System.out.println(Pattern.matches("s[.]eep", "sheep"));	// false  	. �����
		System.out.println(Pattern.matches("s\\.eep", "sheep"));	// false  	. �����
		
		System.out.println(Pattern.matches("s\\deep", "s9eep"));	// true  	���ڸ� ���			\d
		System.out.println(Pattern.matches("\\D\\D\\D", "Cat"));	// true  	���ڸ� ������ ��� ��  	\D
		System.out.println(Pattern.matches("s\\seep", "s\teep"));	// true  	���鸸 ��� 			\s	
		System.out.println(Pattern.matches("s\\Seep", "s\teep"));	// false  	������ ������ ��� ��	\S
		
		
		/*
		 * 	�ش� ������ ����� ������ ������ �����ϴ� ���
		 *  
		 *  1. [ex]{n}  : {}���� ������ n�� ��ġ�ؾ� �Ѵ�.
		 *  2. [ex]{n,m}: {}���� ������ �ּ� n�� �̻�, �ִ� m��(m����) ��ġ�ؾ� �Ѵ�
		 *  3. [ex]{n,} : {} ���� ������ �ּ� n�� �̻� ��ġ�ؾ� �Ѵ�
		 *  4. [ex]?    : 0�� �Ǵ� �ѹ�
		 *  5. [ex]+ 	: �ּ� �ѹ� �̻�
		 *  6. [ex]* 	: 0�� �Ǵ� ������
		 *  
		 */
		
		System.out.println(Pattern.matches("[\\D3-5]{5}","ca3t5"));		// {5}���� ���ڴ� 5�� �̾���ϰ�, ���ڸ� ���� �ϰ� , 3,4,5 �� ������ �� ������ true
		System.out.println(Pattern.matches("[\\D3-5]{5}\\.txt","ca3t5.txt"));		// ex) ���ϸ� �˻��� �� ���ϸ��� 5����, 3,4,5 �� ������ ���� X Ȯ���ڴ� .txt
		System.out.println(Pattern.matches("[\\D3-5]{2,5}\\.txt","3!.txt"));		// ���� ���� {2���ڿ��� 5���ڱ��� ���}
		System.out.println(Pattern.matches("[\\��-�R]{2,}","�ȳ��ϼ��R"));		// ���� ���� {2���� �̻�}
		System.out.println(Pattern.matches("[\\��-�R]?",""));			// ? ���� ���ڰ� 0�Ǵ� �ѱ���

		// ��ȭ��ȣ ����ǥ����
		// �տ��� 0���� �����ؼ� ���� �α��� �� 
		// - �� �ᵵ, �Ƚᵵ ������ �߰��ڸ��� 3~4�ڸ� 
		// ���ڸ��� ���� ������ ����
		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}","010-234-1344"));		
		
		
		// ���� ���� : �ڹٿ��� ����ϴ� �������� �˻��� �� �ִ� ����ǥ������ �����
		System.out.println(Pattern.matches("[a-zA-Z��-�R_$]+[0-9a-zA-Z��-�R_]*", "�R0_"));
		
		
		/*
		 *	# Pattern.compile(regex)
		 *
		 *	 - ������ ���� ǥ������ �ؼ��Ͽ� Pattern �ν��Ͻ��� �����ϰ� ��ȯ�Ѵ�
		 *	 - Pattern Ÿ�� �ν��Ͻ��� �䱸�ϴ� ���� ����� �� �ִ�.
		 *
		 *	# split() : �����ϵ� ���� �ν��Ͻ��� split()�� �����Ѵ�
		 *
		 *	# matcher() : Matcher �ν��Ͻ��� �����Ͽ� ��ȯ�Ѵ�
		 *
		 *	# find() : ���� ���� ������ true ������ false    (while�̶� ���� ���� ����)
		 *
		 *	# group
		 */
		
		String fruit_text = "apple/banana/orange/grape/pineapple/peach/mango/redapple";
		
		Pattern regex = Pattern.compile("/");
		// split 
		String[] fruits = regex.split(fruit_text);
		System.out.println(Arrays.toString(fruits));
		
		// matcher : �˻� ���� 
//		Pattern regex2 = Pattern.compile("apple");		// apple �˻�
//		Pattern regex2 = Pattern.compile("a.{3}e");		// a�� �����ؼ� e�� ������ �� ���̿� ���ڰ� ���� �ִ°��� �˻�
		Pattern regex2 = Pattern.compile("[a-zA-Z]+");	// a~z ���� �մ� ���� �˻� (�ٸ� ���ڰ� ���������� ) 
		
		Matcher matcher = regex2.matcher(fruit_text);
		
		while(matcher.find()) {
			System.out.println("ã�� ��: " + matcher.group());
			System.out.println("��ġ : " + matcher.start() + " ���� " + matcher.end() + "����");
		}
		
		
		
		
		
		
		
	}
}
