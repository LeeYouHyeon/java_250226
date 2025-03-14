package day04;

public class String01 {

	public static void main(String[] args) {
		/* String class : ¹®ÀÚ¿­À» ´Ù·ç±â À§ÇÑ Å¬·¡½º => ±âº» ÀÚ·áÇüÀÌ ¾Æ´Ô
		 * class : ÇØ´ç Å¬·¡½º ¾È¿¡ ¿©·¯°¡Áö ±â´ÉÀ» ´ã°í ÀÖÀ½
		 * class : Å¬·¡½º¸í °´Ã¼¸í = new Å¬·¡½º¸í();
		 * String str = new String();
		 * */

		String str = new String();
		str = "456789";
		System.out.println(str);
		String str2 = "123 456";
		System.out.println(str2);

		// str1 == str2; : °¢ °´Á¦¯M ÁÖ¼Ò¸¦ ¹°¾îº¸´Â °Í
		// STringÀº ¹è¿­Ã³·³ »ç¿ë

		// length : ÀüÃ¼ ±ÛÀÚ¼ö(±ÛÀÚÀÌ ±æÀÌ)
		System.out.println("--length--");
		System.out.println(str2.length());

		// charAt(index) : index ¹øÁö¿¡ ÀÖ´Â ¹®ÀÚ ¹İÈ¯char
		System.out.println("--charAt()--");
		System.out.println(str2.charAt(3));

		// substring() : ¹®ÀÚ¿­ ÃßÃâ
		System.out.println("--substring()");
		System.out.println(str2.substring(2, 5));

		// str.compareTo(str2) : strÀÌ str2º¸´Ù ¾ÕÀÌ¸é -1, °°À¸¸é 0, µÚ¸é 1
		// ¹®ÀÚ Á¤·Ä ½Ã »ç¿ë
		System.out.println("--compareTo");
		System.out.println("a".compareTo("b"));
		System.out.println("apple".compareTo("banana"));

		// equals() : µÎ ¹®ÀÚ°¡ °°ÀºÁö ºñ±³(´ë¼Ò¹®ÀÚ ±¸ºĞ)
		// °°À¸¸é true / ´Ù¸£¸é false
		// ÂüÁ¶ÀÚ·áÇüÀ» ==·Î ºñ±³ÇÏ¸é ÁÖ¼Ò¸¦ ºñ±³
		System.out.println("--equals()--");
		System.out.println("abc".equals("abc"));
		System.out.println("hello".equals("java"));

		// indexOf() : ¹®ÀÚÀÇ À§Ä¡¸¦ Ã£¾ÆÁÖ´Â ±â´É
		// Ã£´Â ¹®ÀÚ°¡ ¾øÀ¸¸é -1À» return
		System.out.println("--indexOf()--");
		System.out.println("HelloWorld!!".indexOf('W'));
		System.out.println("HelloWorld!!".indexOf('o'));
		System.out.println("HelloWorld!!".indexOf('a'));
		System.out.println("HelloWorld!!".lastIndexOf('o'));
		
		//substring, indexOf¸¦ »ç¿ëÇÏ¿© id¸¦ ÃßÃâ
		String email = "abc12345@naver.com";
		System.out.println(email.substring(0, email.indexOf('@')));
		
		// ÁÖ¹Îµî·Ï ¹øÈ£ÀÇ »ı³â¿ùÀÏ¸¸ ÃßÃâ
		String regNum = "990101-1234567";
		System.out.println(regNum.substring(0, regNum.indexOf('-')));
		
		// contains : ÇØ´ç ¹®ÀÚ¸¦ Æ÷ÇÔÇÏ´ÂÁö Ã¼Å©
		String file = "HelloWorldjava.html";
		System.out.println(file.contains("java"));
		
		// concat : ÀÌ¾îºÙÀÌ±â (+ ¿¬°á¿¬»êÀÚ¿Í °°Àº ÀÇ¹Ì)
		System.out.println("--concat--");
		System.out.println("abc".concat("def"));
	}
}
