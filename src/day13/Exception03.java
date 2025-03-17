package day13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception03 {
	// main�� �޼����̹Ƿ� throws ����
	// ��� �޼���� throws�� �������ų� try - catch�� ó���ϰų� �� �߿� �ϳ��� �ؾ� �� 
	public static void main(String[] args) {
		// 0���� �������� �� �߻��ϴ� ���� ó��
		// ex) num1 = 1, num2 = 3, op = '+' => 4
		// num1 = 3, num2 = 0, op = '/' => ���� �޼���
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char op;
		for (int i = 0; i < 3; i++) {
			try {
				System.out.print("ù��° ����> ");
				num1 = sc.nextInt();
				System.out.print("�ι�° ����> ");
				num2 = sc.nextInt();
				System.out.print("������> ");
				sc.nextLine();
				op = sc.nextLine().charAt(0);
				System.out.println(new Exception03().cal(num1, num2, op));
			} catch (InputMismatchException e){
				System.out.println("������ �ƴմϴ�.");
				sc.nextLine();
			} catch (ArithmeticException e) {
				System.out.println("0���� ���� �� �����ϴ�.");
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}

	/* �޼��忡�� ���Ƿ� ���� �߻���Ű�� : throw new
	 * - throw : ���ܸ� ���ѱ�� (���ܸ� ���� ȣ���ϴ� �޼���� �ѱ�)
	 * - ���ܸ� �߻���Ű�� �Ǹ� �޼��� ����� ���� throws�� ����, �߻��� �� �ִ� ���ܸ� �ݵ�� ������� ��
	 * - throws������ RuntimeException�� ���� �����ϸ�,
	 * 		RuntimeException�� �߻��� ��� throws���� ��°�� ���� ����
	 * */
	/* �޼��� : �� ���� �Է¹ް� �����ڸ� �Է¹޾� ��Ģ������ ����� �����ϴ� �޼���
	 * �Ű����� : int num1, int num2, char
	 * op ����Ÿ�� : double
	 */
	/* cal�� Exception ����
	 * - ArithmeticException : 0���� �������� �� ��
	 * - (����)RuntimeException : ������ �Է��� �߸��Ǿ��� ��
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
			throw new RuntimeException("��ȿ���� ���� �������Դϴ�.");
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
