package day07;

public class Method03 {
	
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int mul(int num1, int num2) {
		return num1*num2;
	}
	
	public static double div(int num1, int num2) {
		return (num2 == 0) ? 0 : num1/(double)num2;
	}
	
	public static int mod(int num1, int num2) {
		return (num2 == 0) ? 0 : num1%num2;
	}
	
	public static void main(String[] args) {
		/* + - * / % 기능을 하는 메서드를 생성
		 * main에서 호출 => 리턴받은 값을 출력
		 * */
		
		int num1 = 10, num2 = 20;
		
		System.out.println(add(num1, num2));
		System.out.println(sub(num1, num2));
		System.out.println(mul(num1, num2));
		System.out.println((num2 == 0) ? "피연산자가 0입니다." : div(num1, num2));
		System.out.println((num2 == 0) ? "피연산자가 0입니다." : mod(num1, num2));
		
		// 다른 클래스에 있는 메서드를 호출할 경우 클래스명.메서드명(); => static일 경우
		System.out.println("------------------------");
		Method04.times();
	}
}
