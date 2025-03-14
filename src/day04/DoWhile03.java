package day04;

import java.util.Scanner;

public class DoWhile03 {

	public static void main(String[] args) {
		/* ���� 2���� �Է¹ް�,
		 * num1 = 2, num2 = 3
		 * menu 
		 * 1. + | 2. - | 3. * | 4. / | 5. % | 6. ����
		 * menu�� ���� �� ���� ���� ����� ���
		 * 1 => 2 + 3 = 5
		 * 2 => 2 - 3 = -1
		 * ...
		 * 4 => 2/0 = num2�� �ٽ� �Է����ּ���.
		 * 5 => 2%0 = num2�� �ٽ� �Է����ּ���.
		 * */

		Scanner scan = new Scanner(System.in);
		int num1, num2;

		// ���� �Է�
		System.out.println("�� ���ڸ� �Է����ּ���.");
		System.out.print("ù ��° ����> ");
		num1 = scan.nextInt();
		System.out.print("�� ��° ����> ");
		num2 = scan.nextInt();

		int menu;
		do {
			char cal = 0;
			int answer = 0;

			// �޴� �Է�
			System.out.println("menu");
			System.out.println("1. + | 2. - | 3. * | 4. / | 5. % | 6. ����");
			menu = scan.nextInt();

			switch (menu) {
				case 1:
					cal = '+';
					answer = num1 + num2;
					break;
				case 2:
					cal = '-';
					answer = num1 - num2;
					break;
				case 3:
					cal = '*';
					answer = num1 * num2;
					break;
				case 4:
					if (num2 == 0) {
						System.out.println("0���� ���� �� �����ϴ�.");
						continue;
					}
					cal = '/';
					answer = num1 / num2;
					break;
				case 5:
					if (num2 == 0) {
						System.out.println("0���� ���� �� �����ϴ�.");
						continue;
					}
					cal = '%';
					answer = num1 % num2;
					break;
				case 6:
					System.out.println("�����մϴ�.");
					continue;
				default:
					System.out.println("�޴��� �ٽ� �Է��ϼ���.");
					continue;
			}

			// ��� ���
			String strNum1 = (num1 >= 0) ? "" + num1 : "(" + num1 + ')'; // ������ ��� �Ұ�ȣ�� ����
			String strNum2 = (num2 >= 0) ? "" + num2 : "(" + num2 + ')'; // ������ ��� �Ұ�ȣ�� ����
			System.out.println(strNum1 + ' ' + cal + ' ' + strNum2 + " = " + answer);

		} while (menu != 6);

		scan.close();
	}

}
