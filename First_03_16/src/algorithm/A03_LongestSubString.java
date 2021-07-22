package algorithm;

/*
  	Given a string, find the length of the longest substring without repeating characters.
	주어진 문자열에서 알파벳이 중복되지 않고 가장 길게 연속되는 문자열 일부를 반환하라
 */
public class A03_LongestSubString {
	public static int lengthOfLongestSubstring(String s) {

		int temp = 0;
		int temp2 = 0;

		// s.length() - s.replace(String.valueOf(s.charAt(i)), "").length() < 2
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {

					
					if (i < j && (s.subSequence(i, j).length() - s.replace(String.valueOf(s.charAt(i)), "").length() < 2 
							&& s.subSequence(i, j).length() - s.replace(String.valueOf(s.charAt(i)), "").length() > 0)) {
						System.out.println(s.subSequence(i, j).length() - s.replace(String.valueOf(s.charAt(i)), "").length());
						
						temp = Math.max(j - i, temp);
//						System.out.println(
//								"문자가 몇개 ? " + (s.length() - s.replace(String.valueOf(s.charAt(i)), "").length()));
//						System.out.println("**********");
//						System.out.println("i : " + i);
//						System.out.println("s[i] : " + s.charAt(i));
//						System.out.println("j : " + j);
//						System.out.println("s[j] : " + s.charAt(j));
						System.out.println("temp : " + temp);
//						System.out.println("===========\n");
					}
				}
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
//		System.out.println(lengthOfLongestSubstring("bbbb"));
//		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
