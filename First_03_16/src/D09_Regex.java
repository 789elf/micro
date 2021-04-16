import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D09_Regex {

	/*
	 * 	# Á¤±ÔÇ¥Çö½Ä (Regular Expression)
	 * 
	 * 	 - ¹®ÀÚ¿­ÀÇ ÆĞÅÏÀ» Ç¥ÇöÇÏ´Â Ç¥Çö½Ä
	 * 	 - Æ¯Á¤ ÇÁ·Î±×·¡¹Ö ¾ğ¾î¿¡ Á¾¼ÓµÇÁö ¾Ê´Â´Ù
	 * 	 - ÇÁ·Î±×·¡¸Ó°¡ ¿øÇÏ´Â ¹®ÀÚ¿­ ÆĞÅÏ°ú ÀÏÄ¡ÇÏ´ÂÁö °Ë»çÇÑ´Ù
	 *   - Á¤±ÔÇ¥Çö½Ä¿¡´Â °ø¹éÀ» ³ÖÀ¸¸é ¾ÈµÈ´Ù
	 * 
	 * 	# Pattern Å¬·¡½º
	 *  
	 *   - Á¤±ÔÇ¥Çö½ÄÀ» ´Ù·ç´Â Å¬·¡½º
	 *   
	 *  # Matcher Å¬·¡½º
	 *   
	 *   - ÆĞÅÏ ÀÎ½ºÅÏ½º¸¦ ÀÌ¿ëÇÏ¿© ¹®ÀÚ¿­À» °Ë»çÇÒ ¶§ »ç¿ëÇÏ´Â Å¬·¡½º 
	 */
	
	public static void main(String[] args) {
		
		// Pattern.matches(regex, input) : inputÀÌ regex¿¡ ¸ÅÄ¡µÇ´Â ¹®ÀÚ¿­ÀÎÁö¸¦ °Ë»çÇØÁÖ´Â ¸Å¼Òµå
		System.out.println(Pattern.matches("sleep", "sleep"));
		
		// [] : ÇØ´ç À§Ä¡ÀÇ ÇÑ ±ÛÀÚ¿¡ ¾î¶² ¹®ÀÚµéÀÌ ¿Ã ¼ö ÀÖ´ÂÁö Á¤ÀÇÇÏ´Â Ç¥Çö½Ä
		System.out.println(Pattern.matches("s[lh@]eep", "sleep"));	// true
		System.out.println(Pattern.matches("s[lh@]eep", "sheep"));	// true
		System.out.println(Pattern.matches("s[lh@]eep", "s@eep"));	// true
		
		/* 
		 *	[] ³»ºÎ¿¡ Á¤ÀÇÇÒ ¼ö ÀÖ´Â °Íµé
		 * 
		 * 	 1.abc  : ÇØ´ç ÀÚ¸®¿¡ a ¶Ç´Â b ¶Ç´Â c¸¦ Çã¿ë
		 * 	 2.^abc : ÇØ´ç ÀÚ¸®¿¡ abc¸¦ Á¦¿ÜÇÑ ¸ğµç°ÍÀ» Çã¿ë
		 *   3.a-z  : a ºÎÅÍ z±îÁö ¸ğµÎ Çã¿ë ( ¼ıÀÚµµ °¡´É )
		 *   4.&&   : ±³ÁıÇÕ 
		 */
		System.out.println(Pattern.matches("s[^lh@]eep", "s2eep"));	// true		 ^ºÙÀº°Í Á¦¿Ü	
		System.out.println(Pattern.matches("s[0-9]eep", "s4eep"));	// true      ~ ºÎÅÍ ~ ±îÁö °¡´É 
		System.out.println(Pattern.matches("s[0-9a-z]eep", "s0eep"));	// true  ~ ºÎÅÍ ~ ±îÁö °¡´É
		System.out.println(Pattern.matches("s[a-d&&c-f]eep", "sdeep"));	// true  ±³ÁıÇÕ
		
		
		/*
		 * 	 ¿©·¯ ¹®ÀÚ¸¦ ³ªÅ¸³»´Â °Íµé
		 * \ ´Â µÎ°³¸¦ ÇÑ¹ø¿¡ ºÙÇô¾ß ÇÑ´Ù ( escape )
		 * 
		 *  1. .  : ¸ğµç ¹®ÀÚ  ¡Ø [] ¹Û¿¡ ½á¾ß ¸ğµç ¹®ÀÚ
		 *  2. \d : ¸ğµç ¼ıÀÚ
		 *  3. \D : ¼ıÀÚ¸¦ Á¦¿ÜÇÑ ¸ğµç °Í
		 *  4. \s : ¸ğµç °ø¹é (\t\n .. µîÀÇ ¸ğµç °ø¹éµé)
		 *  5. \S : °ø¹éÀ» Á¦¿ÜÇÑ ¸ğµç °Í
		 *  6. \w : ÀÏ¹İÀûÀÎ ¹®ÀÚµéÀ» Çã¿ë [a-zA-Z0-9_]   ( º¯¼ö·Î »ç¿ëÇßÀ»¶§ º° ÀÌ»ó ¾øÀ» ¾Öµé (¼ıÀÚ °¡´É))
		 *  7. \W : \wÀÇ ¹İ´ë
		 */
		
		System.out.println(Pattern.matches("s.eep", "sheep"));		// true 	¸ğµç ¹®ÀÚ
		System.out.println(Pattern.matches("s[.]eep", "sheep"));	// false  	. ¸¸Çã¿ë
		System.out.println(Pattern.matches("s\\.eep", "sheep"));	// false  	. ¸¸Çã¿ë
		
		System.out.println(Pattern.matches("s\\deep", "s9eep"));	// true  	¼ıÀÚ¸¸ Çã¿ë			\d
		System.out.println(Pattern.matches("\\D\\D\\D", "Cat"));	// true  	¼ıÀÚ¸¦ Á¦¿ÜÇÑ ¸ğµç °Í  	\D
		System.out.println(Pattern.matches("s\\seep", "s\teep"));	// true  	°ø¹é¸¸ Çã¿ë 			\s	
		System.out.println(Pattern.matches("s\\Seep", "s\teep"));	// false  	°ø¹éÀ» Á¦¿ÜÇÑ ¸ğµç °Í	\S
		
		
		/*
		 * 	ÇØ´ç ÆĞÅÏÀÌ Àû¿ëµÉ ¹®ÀÚÀÇ °¹¼ö¸¦ Á¤ÀÇÇÏ´Â ¹æ¹ı
		 *  
		 *  1. [ex]{n}  : {}¾ÕÀÇ ÆĞÅÏÀÌ n°³ ÀÏÄ¡ÇØ¾ß ÇÑ´Ù.
		 *  2. [ex]{n,m}: {}¾ÕÀÇ ÆĞÅÏÀÌ ÃÖ¼Ò n°³ ÀÌ»ó, ÃÖ´ë m°³(mÆ÷ÇÔ) ÀÏÄ¡ÇØ¾ß ÇÑ´Ù
		 *  3. [ex]{n,} : {} ¾ÕÀÇ ÆĞÅÏÀÌ ÃÖ¼Ò n°³ ÀÌ»ó ÀÏÄ¡ÇØ¾ß ÇÑ´Ù
		 *  4. [ex]?    : 0¹ø ¶Ç´Â ÇÑ¹ø
		 *  5. [ex]+ 	: ÃÖ¼Ò ÇÑ¹ø ÀÌ»ó
		 *  6. [ex]* 	: 0¹ø ¶Ç´Â ¿©·¯¹ø
		 *  
		 */
		
		System.out.println(Pattern.matches("[\\D3-5]{5}","ca3t5"));		// {5}¾ÕÀÇ ±ÛÀÚ´Â 5°³ ÀÌ¾î¾ßÇÏ°í, ¼ıÀÚ¸¦ Á¦¿Ü ÇÏ°í , 3,4,5 ´Â Æ÷ÇÔÇÒ ¼ö ÀÖÀ¸¸é true
		System.out.println(Pattern.matches("[\\D3-5]{5}\\.txt","ca3t5.txt"));		// ex) ÆÄÀÏ¸í °Ë»çÇÒ ¶§ ÆÄÀÏ¸íÀº 5±ÛÀÚ, 3,4,5 ¸¦ Á¦¿ÜÇÑ ¼ıÀÚ X È®ÀåÀÚ´Â .txt
		System.out.println(Pattern.matches("[\\D3-5]{2,5}\\.txt","3!.txt"));		// ¾ÕÀÇ ±ÛÀÚ {2±ÛÀÚ¿¡¼­ 5±ÛÀÚ±îÁö Çã¿ë}
		System.out.println(Pattern.matches("[\\°¡-ÆR]{2,}","¾È³çÇÏ¼¼ÆR"));		// ¾ÕÀÇ ±ÛÀÚ {2±ÛÀÚ ÀÌ»ó}
		System.out.println(Pattern.matches("[\\°¡-ÆR]?",""));			// ? ¾ÕÀÇ ±ÛÀÚ°¡ 0¶Ç´Â ÇÑ±ÛÀÚ

		// ÀüÈ­¹øÈ£ Á¤±ÔÇ¥Çö½Ä
		// ¾Õ¿¡´Â 0À¸·Î ½ÃÀÛÇØ¼­ ¼ıÀÚ µÎ±ÛÀÚ ´õ 
		// - ¸¦ ½áµµ, ¾È½áµµ ±¦Âú°í Áß°£ÀÚ¸®´Â 3~4ÀÚ¸® 
		// µŞÀÚ¸®´Â À§¿Í µ¿ÀÏÇÑ ÆĞÅÏ
		System.out.println(Pattern.matches("0\\d{2}-?\\d{3,4}-?\\d{4}","010-234-1344"));		
		
		
		// ¿¬½À ¹®Á¦ : ÀÚ¹Ù¿¡¼­ Çã¿ëÇÏ´Â º¯¼ö¸íÀ» °Ë»çÇÒ ¼ö ÀÖ´Â Á¤±ÔÇ¥Çö½ÄÀ» ¸¸µé±â
		System.out.println(Pattern.matches("[a-zA-Z°¡-ÆR_$]+[0-9a-zA-Z°¡-ÆR_]*", "ÆR0_"));
		
		
		/*
		 *	# Pattern.compile(regex)
		 *
		 *	 - Àü´ŞÇÑ Á¤±Ô Ç¥Çö½ÄÀ» ÇØ¼®ÇÏ¿© Pattern ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ°í ¹İÈ¯ÇÑ´Ù
		 *	 - Pattern Å¸ÀÔ ÀÎ½ºÅÏ½º¸¦ ¿ä±¸ÇÏ´Â °÷¿¡ »ç¿ëÇÒ ¼ö ÀÖ´Ù.
		 *
		 *	# split() : ÄÄÆÄÀÏµÈ ÆĞÅÏ ÀÎ½ºÅÏ½º·Î split()À» ÁøÇàÇÑ´Ù
		 *
		 *	# matcher() : Matcher ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ¿© ¹İÈ¯ÇÑ´Ù
		 *
		 *	# find() : ´ÙÀ½ °ªÀÌ ÀÖÀ¸¸é true ¾øÀ¸¸é false    (whileÀÌ¶û °°ÀÌ ¾²±â ÆíÇÔ)
		 *
		 *	# group
		 */
		
		String fruit_text = "apple/banana/orange/grape/pineapple/peach/mango/redapple";
		
		Pattern regex = Pattern.compile("/");
		// split 
		String[] fruits = regex.split(fruit_text);
		System.out.println(Arrays.toString(fruits));
		
		// matcher : °Ë»ö ´À³¦ 
//		Pattern regex2 = Pattern.compile("apple");		// apple °Ë»ö
//		Pattern regex2 = Pattern.compile("a.{3}e");		// a·Î ½ÃÀÛÇØ¼­ e·Î ³¡³ª°í ±× »çÀÌ¿¡ ¹®ÀÚ°¡ ¼¼°³ ÀÖ´Â°ÍÀ» °Ë»ö
		Pattern regex2 = Pattern.compile("[a-zA-Z]+");	// a~z ±îÁö ÀÕ´Â °ÍÀ» °Ë»ö (´Ù¸¥ ¹®ÀÚ°¡ ÀÖÀ»¶§±îÁö ) 
		
		Matcher matcher = regex2.matcher(fruit_text);
		
		while(matcher.find()) {
			System.out.println("Ã£Àº °Í: " + matcher.group());
			System.out.println("À§Ä¡ : " + matcher.start() + " ºÎÅÍ " + matcher.end() + "±îÁö");
		}
		
		
		
		
		
		
		
	}
}
