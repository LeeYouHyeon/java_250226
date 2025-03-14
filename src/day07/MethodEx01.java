package day07;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MethodEx01 {
	// �� ���� �Է¹޾� array ���·� return
	// �������̳� �������� ����� ���, �ι�° �Է�(== answer[1])�� 0�� �ƴϵ��� ��
	public static int[] getNums(Scanner scan, int menu) {
		int[] answer = new int[2];

		// ù��° ���� �Է�
		System.out.print("ù��° ���� �Է�> ");
		answer[0] = scan.nextInt();

		// �ι�° ���� �Է�
		System.out.print("�ι�° ���� �Է�> ");
		answer[1] = scan.nextInt();
		// �������̳� ������ ����� ���, �ι�° �Է��� 0�� �ƴ� ������ �ٽ� �Է¹���
		if (menu == 4 || menu == 5) {
			while (answer[1] == 0) {
				System.out.print("0���� ���� �� �����ϴ�. �ٽ� �Է��ϼ���.> ");
				answer[1] = scan.nextInt();
			}
		}

		return answer;
	}

	// �����ڿ� ���ڸ� ������ ���
	// ����ó���� main���� �ϹǷ� ������ ó������ ����
	// �������� �����ϱ� ���� double�� return�ϰ�, ���� printResult���� �̸� ó����
	public static double calc(int menu, int num1, int num2) {
		switch (menu) {
			case 1:
				return num1 + num2;
			case 2:
				return num1 - num2;
			case 3:
				return num1 * num2;
			case 4:
				return num1 / num2;
			case 5:
				return num1 % num2;
			default: // ���� �Ұ���
				return -1;
		}
	}

	// ����� �״��, ������ �Ұ�ȣ�� ����
	public static String addBracket(int num) {
		return (num >= 0) ? num + "" : "(" + num + ")";
	}

	// �����ڿ� ���ڸ� �޾ƿͼ� ����� ���
	public static void printResult(int menu, int num1, int num2) {
		String[] oper = { " + ", " - ", "*", "/", " % " };
		double result = calc(menu, num1, num2); // ��� ����� double�� �޾ƿ�

		// ����
		// 1. "2/(-3) = "
		// 2. "(-7) + 15 = "
		String output = addBracket(num1) + oper[menu - 1] + addBracket(num2) + " = ";

		// �������̸� result�� �Ҽ����� ��° �ڸ����� �츮��, �ƴϸ� ������ ó��
		if (menu == 4) {
			output += new DecimalFormat("0.00").format(result);
		} else {
			output += (int) result;
		}
		System.out.println(output);
	}

	public static void main(String[] args) {
		/* ���� �����
		 * 
		 * --menu--
		 * 1. ���� | 2. ���� | 3. ���� | 4. ������ | 5. ������ | 6. ����
		 * >> �޴����� 1
		 * >> ���� �Է� > 1 5
		 * ��� : 1 + 5 = 6
		 * */
		Scanner scan = new Scanner(System.in);
		int menu, num1, num2;

		do {
			// 1. �޴� �Է�
			while (true) {
				// �޴� ���
				System.out.println("--menu--");
				System.out.println("1. ���� | 2. ���� | 3. ���� | 4. ������ | 5. ������ | 6. ����");

				// �޴� �Է�
				System.out.print(">> �޴�����> ");
				menu = scan.nextInt();

				// �������� �Է��̸� 1�� ���� ����
				if (menu > 0 && menu < 7) {
					break;
				}

				// �߸��� �Է��̶�� ����� ����� �� �ٽ� �Է¹���
				System.out.println("�߸��� �Է��Դϴ�.");
			}

			// cf) ���� ó��
			if (menu == 6) {
				System.out.println("�����մϴ�.");
			} else {
				// 2. ���� �Է�
				// ù��° ���� �Է�
				System.out.print("ù��° ���� �Է�> ");
				num1 = scan.nextInt();

				// �ι�° ���� �Է�
				System.out.print("�ι�° ���� �Է�> ");
				num2 = scan.nextInt();
				// �������̳� ������ ����� ���, �ι�° �Է��� 0�� �ƴ� ������ �ٽ� �Է¹���
				if (menu == 4 || menu == 5) {
					while (num2 == 0) {
						System.out.print("0���� ���� �� �����ϴ�. �ٽ� �Է��ϼ���.> ");
						num2 = scan.nextInt();
					}
				}

				// 3. ��� ��� ���
				printResult(menu, num1, num2);
			}

		} while (menu != 6);

		scan.close();
	}
}