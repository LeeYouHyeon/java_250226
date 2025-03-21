package day13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception03 {
	// main도 메서드이므로 throws 가능
	// 모든 메서드는 throws로 내보내거나 try - catch로 처리하거나 둘 중에 하나는 해야 함 
	public static void main(String[] args) {
		// 0으로 나누었을 때 발생하는 예외 처리
		// ex) num1 = 1, num2 = 3, op = '+' => 4
		// num1 = 3, num2 = 0, op = '/' => 오류 메세지
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char op;
		for (int i = 0; i < 3; i++) {
			try {
				System.out.print("첫번째 숫자> ");
				num1 = sc.nextInt();
				System.out.print("두번째 숫자> ");
				num2 = sc.nextInt();
				System.out.print("연산자> ");
				sc.nextLine();
				op = sc.nextLine().charAt(0);
				System.out.println(new Exception03().cal(num1, num2, op));
			} catch (InputMismatchException e){
				System.out.println("정수가 아닙니다.");
				sc.nextLine();
			} catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}

	/* 메서드에서 임의로 예외 발생시키기 : throw new
	 * - throw : 예외를 떠넘기기 (예외를 나를 호출하는 메서드로 넘김)
	 * - 예외를 발생시키게 되면 메서드 선언부 끝에 throws를 적고, 발생할 수 있는 예외를 반드시 적어줘야 함
	 * - throws문에서 RuntimeException은 생략 가능하며,
	 * 		RuntimeException만 발생할 경우 throws문을 통째로 생략 가능
	 * */
	/* 메서드 : 두 수를 입력받고 연산자를 입력받아 사칙연산의 결과를 리턴하는 메서드
	 * 매개변수 : int num1, int num2, char
	 * op 리턴타입 : double
	 */
	/* cal의 Exception 종류
	 * - ArithmeticException : 0으로 나누려고 할 때
	 * - (임의)RuntimeException : 연산자 입력이 잘못되었을 때
	 * */
//	public Num cal(int num1, int num2, char op) throws RuntimeException {
	public Num cal(int num1, int num2, char op) {
		Num answer = new Num();
		switch (op) {
		case '+':
			answer.setValue(num1 + num2);
			break;
		case '-':
			answer.setValue(num1 - num2);
			break;
		case '*':
			answer.setValue(num1 * num2);
			break;
		case '/':
			if (num1 % num2 == 0) {
				answer.setValue(num1 / num2);
			} else {
				answer.setValue(num1 / (double) num2);
				answer.setDouble(true);
			}
			break;
		case '%':
			answer.setValue(num1 % num2);
			break;
		default:
			throw new RuntimeException("유효하지 않은 연산자입니다.");
		}
		return answer;
	}
}

class Num {
	double value;
	boolean isDouble;

	public Num() {
		;
	}

	public Num(double value, boolean isDouble) {
		this.value = value;
		this.isDouble = isDouble;
	}

	@Override
	public String toString() {
		return isDouble ? String.valueOf(value) : String.valueOf((int) value);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public boolean isDouble() {
		return isDouble;
	}

	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}
}
