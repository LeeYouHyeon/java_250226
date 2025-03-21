package day04;

public class String01 {

	public static void main(String[] args) {
		/* String class : 문자열을 다루기 위한 클래스 => 기본 자료형이 아님
		 * class : 해당 클래스 안에 여러가지 기능을 담고 있음
		 * class : 클래스명 객체명 = new 클래스명();
		 * String str = new String();
		 * */

		String str = new String();
		str = "456789";
		System.out.println(str);
		String str2 = "123 456";
		System.out.println(str2);

		// str1 == str2; : 각 객제츼 주소를 물어보는 것
		// STring은 배열처럼 사용

		// length : 전체 글자수(글자이 길이)
		System.out.println("--length--");
		System.out.println(str2.length());

		// charAt(index) : index 번지에 있는 문자 반환char
		System.out.println("--charAt()--");
		System.out.println(str2.charAt(3));

		// substring() : 문자열 추출
		System.out.println("--substring()");
		System.out.println(str2.substring(2, 5));

		// str.compareTo(str2) : str이 str2보다 앞이면 -1, 같으면 0, 뒤면 1
		// 문자 정렬 시 사용
		System.out.println("--compareTo");
		System.out.println("a".compareTo("b"));
		System.out.println("apple".compareTo("banana"));

		// equals() : 두 문자가 같은지 비교(대소문자 구분)
		// 같으면 true / 다르면 false
		// 참조자료형을 ==로 비교하면 주소를 비교
		System.out.println("--equals()--");
		System.out.println("abc".equals("abc"));
		System.out.println("hello".equals("java"));

		// indexOf() : 문자의 위치를 찾아주는 기능
		// 찾는 문자가 없으면 -1을 return
		System.out.println("--indexOf()--");
		System.out.println("HelloWorld!!".indexOf('W'));
		System.out.println("HelloWorld!!".indexOf('o'));
		System.out.println("HelloWorld!!".indexOf('a'));
		System.out.println("HelloWorld!!".lastIndexOf('o'));
		
		//substring, indexOf를 사용하여 id를 추출
		String email = "abc12345@naver.com";
		System.out.println(email.substring(0, email.indexOf('@')));
		
		// 주민등록 번호의 생년월일만 추출
		String regNum = "990101-1234567";
		System.out.println(regNum.substring(0, regNum.indexOf('-')));
		
		// contains : 해당 문자를 포함하는지 체크
		String file = "HelloWorldjava.html";
		System.out.println(file.contains("java"));
		
		// concat : 이어붙이기 (+ 연결연산자와 같은 의미)
		System.out.println("--concat--");
		System.out.println("abc".concat("def"));
	}
}
