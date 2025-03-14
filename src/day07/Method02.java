package day07;

// 하나의 .java 파일에 class를 여러 개 정의할 수 있다.
// 단, public class는 파일명과 같은 하나의 클래스만 가능하다.
public class Method02 {

	/* 두 정수가 주어지면 두 수의 합을 리턴하는 메서드
	 * 리턴 타입	: int
	 * 메서드명	: sum
	 * 매개변수	: int num1, int num2
	 * */
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	/* 리턴이 없는 케이스
	 * 두 정수가 주어지면 두 수의 합을 출력하는 메서드
	 * 리턴타입	: void
	 * 메서드명	: sum1
	 * 매개변수	: int num1, int num2
	 * */
	public static void sum1(int num1, int num2) {
		System.out.println(sum(num1, num2));
	}
	
	/* 매개변수가 없는 케이스
	 * 합을 출력하는 메서드
	 * 리턴타입 	: 없음 void
	 * 메서드명 	: sum2
	 * 매개변수 	: 없음
	 * */
	public static void sum1() {
		sum1(5, 6);
	}

	public static void main(String[] args) {
		/* sum 메서드를 호출하여 출력
		 * */
		
		System.out.println(sum(6, 8));
		sum1(6, 8);
		sum1();
	}

}
