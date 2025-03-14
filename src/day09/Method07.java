package day09;

public class Method07 {
	public static void main(String[] args) {
		/* 메서드 오버로딩
		 * 	- 동일한 이름의 메서드를 여러 개 만드는 것
		 * 	- 오버로딩의 조건
		 * 		1. 매개변수의 갯수가 다르면 가능
		 * 		2. 매개변수의 타입이 다르면 가능
		 * 	- 리턴 타입, 매개변수의 이름은 영향을 주지 않음.
		 * */
		int num1 = 10, num2 = 20;

		// 내 클래스의 객체를 생성
		Method07 m7 = new Method07();
		int hap = m7.sum(num1, num2);
		System.out.println(hap);
		System.out.println(m7.sum(10, 20, 30));
		System.out.println(m7.sum(1.2, 3.5));
	}

	public int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public double sum(double num1, double num2) {
		return num1 + num2;
	}
	
	public int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
