package day04;

import java.util.Arrays;

public class String02 {

	public static void main(String[] args) {
		/* String 메서드
		 * */
		String str = "홍길동~~~!!!", str2 = "";

		// toLowerCase(), toUpperCase() : 대소문자 변환
		System.out.println("--toLowerCase/toUpperCase--");
		System.out.println("toLower".toLowerCase());
		System.out.println("toLower".toUpperCase());

		// isEmpty() : 값이 비었는지 확인
		System.out.println("--isEmpty()--");
		System.out.println(str.isEmpty());
		System.out.println(str2.isEmpty());

		// trim() : 불필요한 공백 제거
		System.out.println("--trim()--");
		System.out.println("           hello          ".trim());

		// replace() : 글자를 치환
		System.out.println("--replace()--");
		String str3 = "apple, banana, kiwi";
		System.out.println(str3.replace(",", " /"));
		
		// split() : 특정 값을 기준으로 나누기 => 배열로 return
		System.out.println("--split()--");
		String[] arr = str3.split(", ");
		System.out.println(Arrays.toString(arr));
		
		// 문자를 숫자로
		String num1 = "1";
		int num2 = Integer.parseInt(num1);
		
		// 숫자를 문자로. String.valueOf()
		// instanceof : 객체의 형이 일치하는지 체크
		String as = String.valueOf(num2);
		
		System.out.println(as);
		System.out.println(as instanceof String);
	}

}
