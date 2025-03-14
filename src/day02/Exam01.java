package day02;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* ����
		 * ���� 2���� ������ 1���� �Է¹޾� �� ������ ���� ����� ���
		 * ex) 2 3 + => 5
		 * ex) 2 3 * => 6
		 * ex) 2 3 ! => �߸��� ����
		 * �����ڴ� +, -, *, /, %
		 * �ٸ� ������ Ư�����ڰ� ������ "�߸��� ����" ���
		 */

		// ���ڷ� �޴� ���̽� : String => �� �Ұ� ""
		// �� ���ڸ� �޴� ���̽� : char => �� ���� ''

		Scanner scan = new Scanner(System.in);

		System.out.println("�� ������ �����ڸ� �Է����ּ���.");
		System.out.println("��)2 3 +");

		int num1 = scan.nextInt();
		String strNum1 = (num1 > 0) ? "" + num1 : "(" + num1 + ')'; // ������ ��� �Ұ�ȣ�� ����
		int num2 = scan.nextInt();
		String strNum2 = (num2 > 0) ? "" + num2 : "(" + num2 + ')'; // ������ ��� �Ұ�ȣ�� ����
		char cal = scan.next().charAt(0);
		String result = strNum1 + ' ' + cal + ' ' + strNum2 + " = ";

		switch (cal) {
			case '+':
				result += num1 + num2;
				break;
			case '-':
				result += num1 - num2;
				break;
			case '*':
				result += num1 * num2;
				break;
			case '/':
				result = (num2 == 0) ? "0���� ���� �� �����ϴ�." : result + (num1/num2);
				break;
			case '%':
				result = (num2 == 0) ? "0���� ���� �� �����ϴ�." : result + (num1%num2);
				break;
			default:
				result = "�߸��� �������Դϴ�.";
		}

		System.out.println(result);
		scan.close();
	}

}
