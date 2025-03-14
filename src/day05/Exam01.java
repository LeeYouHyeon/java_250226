package day05;

import java.util.Scanner;

public class Exam01 {
	public static void extra() {
		String table[] = { "����", "����", "��" },
				resultTable[] = { "���º�", "�¸�", "�й�" },
				user;
		int userInt, comInt;

		// ���� ���
		System.out.println("����, ����, �� �� �ϳ��� �Է��ϼ���.");
		System.out.println("Q/q�� ������ �����մϴ�.");

		Scanner scan = new Scanner(System.in);
		while (true) {
			// ��ǻ�� ����
			comInt = (int) (Math.random() * 3);

			// ������ �Է��� ����
			System.out.print("�Է�> ");
			user = scan.next();
			if (user.toLowerCase().equals("q")) {
				// Q/q�� ������ ����
				break;
			}

			// ���� �Է��� ����(userInt)�� ��ȯ
			// userInt�� �⺻���� �߸� �Է��� ��츦 �Ǻ��ϱ� ����
			// ���������� �Է������� 0~2 ������ ���� �ȴ�.
			userInt = -1;
			for (int i = 0; i < 3; i++) {
				if (user.equals(table[i])) {
					userInt = i;
				}
			}

			if (userInt == -1) {
				// ���� ���̽�
				System.out.println("�߸��� �Է��Դϴ�.");
			} else {
				// ���� ����
				int result = userInt - comInt;
				if (result < 0) {
					result += 3;
				}

				// ��� ���
				System.out.println("��ǻ�� : " + table[comInt] + " / ���� : " + user);
				System.out.println(resultTable[result]);
			}

		}
		
		System.out.println("�����մϴ�.");
		scan.close();
	}

	public static void main(String[] args) {
		/* ��ǻ�Ϳ� ���������� ����
		 * ��ǻ�ʹ� �������� ����/����/�� �� �ϳ��� ���� (0 = ���� / 1 = ���� / 2 = ��)
		 * ���������� �� �ϳ��� �����Ͽ� �Է�
		 * ex)
		 * com = 0(����) me = �� => com �¸�
		 * ��ǻ�Ϳ� ���� ����, �й� / ���º� / �¸� ���
		 * */
		extra();
//		String table[] = { "����", "����", "��" };
//
//		// ���� �Է�
//		Scanner scan = new Scanner(System.in);
//		System.out.print("����, ����, �� �� �ϳ��� �Է��ϼ���.> ");
//		String user = scan.next(), result = "";
//		scan.close();
//
//		// ��ǻ�� ����
//		int comInt = (int) (Math.random() * 3);
//
//		// �Է� Ȯ�� �� ���� ����
//		boolean valid = true;
//		switch (comInt) {
//			case 0: // ����
//				if (user.equals("����")) {
//					result = "���º�";
//				} else if (user.equals("����")) {
//					result = "�¸�";
//				} else if (user.equals("��")) {
//					result = "�й�";
//				} else {
//					valid = false;
//					result = "�߸��� �Է�";
//				}
//				break;
//			case 1: // ����
//				if (user.equals("����")) {
//					result = "�й�";
//				} else if (user.equals("����")) {
//					result = "���º�";
//				} else if (user.equals("��")) {
//					result = "�¸�";
//				} else {
//					valid = false;
//					result = "�߸��� �Է�";
//				}
//				break;
//			case 2: // ��
//				if (user.equals("����")) {
//					result = "�¸�";
//				} else if (user.equals("����")) {
//					result = "�й�";
//				} else if (user.equals("��")) {
//					result = "���º�";
//				} else {
//					valid = false;
//					result = "�߸��� �Է�";
//				}
//				break;
//			default:
//				valid = false;
//				System.out.println("�� �� ���� ����");
//		}
//
//		// ��� ���
//		if (valid) {
//			System.out.println("��ǻ�� : " + table[comInt] + " / ���� : " + user);
//		}
//		System.out.println(result);

	}

}
