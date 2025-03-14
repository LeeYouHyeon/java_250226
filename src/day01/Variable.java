package day01;

public class Variable {

	public static void main(String[] args) {
		/* 변수 선언
		 * 자료형 변수명;
		 * 
		 * 변수 선언 + 초기화
		 * 자료형 면수명 = 값;
		 * 
		 * 기본 데이터 타입은초기화 해야 사용가능
		 * */
		
		int num1;
//		in num =-3; // 중복 선언 불가능
		
		// char : 아스키코드(유니코드) 표의 한글자만 가능
		// "문자열", '한글자'
		
		char ch = 'a';
		System.out.println(ch);
		System.out.println((int)ch); // char -> int로 현변환
		
		// double
		double dou = 3.1;
		System.out.println(dou);
		
		byte b = 3; // 범위를 넘어가면 오류
		System.out.println(b);
		
		boolean boo = true; // true false로만 저장 가능
		System.out.println(boo);
		
		// float / long : 접미사를 붙여야 사용 가능
		// float(f F) / long(l L)
		
		float f = 1.2f;
		System.out.println(f);
		
		long l = 2147483648L; // int 범위를 넘어가는 literal 뒤에 L을 붙임
		System.out.println(l);
		
		num1 = 010; // 8진수로 인식
		System.out.println(num1);
		
		num1 = 0x10; // 16진수
		System.out.println(num1);
		
		// 기본 자료형 8가지는 지역변수의 범위를 가진다.
		// 지역변수의 범위는 해당 변수가 선언된 중괄호 안
		// 괄호 밖에서 선언한 건 안에서 사용 가능
		
		{
			int a = 100;
			System.out.println(a);
		}
		
		int a = 50;
		System.out.println(a);
	}
}
