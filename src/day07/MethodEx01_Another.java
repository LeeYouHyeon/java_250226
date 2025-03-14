package day07;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MethodEx01_Another {
	// �޴� ��� �� �Է�
	// 1~6�� �Է¹��� ������ �ݺ�
	public static int getMenu(Scanner scan) {
		int menu;
		while (true) {
			// �޴� ���
			System.out.println("--menu--");
			System.out.println("1. ���� | 2. ���� | 3. ���� | 4. ������ | 5. ������ | 6. ����");

			// �޴� �Է�
			System.out.print(">> �޴�����> ");
			menu = scan.nextInt();

			// �������� �Է��̶�� return
			if (menu >= 1 && menu <= 6) {
				return menu;
			}

			// �߸��� �Է��̶�� ����� ����� �� �ٽ� �Է¹���
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}

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
	// ����ó���� getNums���� �ϹǷ� ������ ó������ ����
	// �������� �����ϱ� ���� double�� return�ϰ�, ���� printResult���� �̸� ó����
	public static double calc(int menu, int[] num) {
		int num1 = num[0], num2 = num[1];
		switch (menu) {
			case 1:
				return Method03.add(num1, num2);
			case 2:
				return Method03.sub(num1, num2);
			case 3:
				return Method03.mul(num1, num2);
			case 4:
				return Method03.div(num1, num2);
			case 5:
				return Method03.mod(num1, num2);
			default: // ���� �Ұ���
				return -1;
		}
	}

	// ����� �״��, ������ �Ұ�ȣ�� ����
	public static String addBracket(int num) {
		return (num >= 0) ? num + "" : "(" + num + ")";
	}

	// �����ڿ� ���ڸ� �޾ƿͼ� ����� ���
	public static void printResult(int menu, int[] num) {
		String[] oper = { " + ", " - ", "*", "/", " % " };
		double result = calc(menu, num); // ��� ����� double�� �޾ƿ�

		// ����
		// 1. "2/(-3) = "
		// 2. "(-7) + 15 = "
		String output = addBracket(num[0]) + oper[menu - 1] + addBracket(num[1]) + " = ";

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
		int menu;

		while (true) {
			// �޴� ��� �� ����
			menu = getMenu(scan);

			// �޴� ó��
			if (menu == 6) {
				System.out.println("�����մϴ�.");
				break;
			} else {
				printResult(menu, getNums(scan, menu));
			}

		}

		scan.close();
	}
}