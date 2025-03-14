package day08;

import java.util.Scanner;

import memos.Randoms;

public class MethodEx03 {
	public static Randoms r = new Randoms();

	/* �迭 ��� �޼���
	 * user : 1 2 3 4 5 6
	 * ��÷ : 1 2 3 4 5 6 [7]
	 * */
	public static void printLotto(int[] arr) {
		if (arr.length < 5 || arr.length > 8)
			return;

		if (arr.length == 7) {
			System.out.print("��÷ ��ȣ : ");
		} else {
			System.out.print("�Է� ��ȣ : ");
		}

		for (int i = 0; i < 6; i++) {
			System.out.print(arr[i] + " ");
		}

		if (arr.length == 7) {
			System.out.println("[" + arr[6] + "]");
		} else {
			System.out.println();
		}
	}

	/* ��� Ȯ�� �޼���
	 * ��÷ ��ȣ�� ����� ��ȣ �� �� ��� ����
	 * 6�� ��� ��ġ : 1��
	 * 5�� ��ġ + ���ʽ� : 2��
	 * 5�� ��ġ : 3��
	 * 4�� ��ġ : 4��
	 * 3�� ��ġ : 5��
	 * ������ : �� 
	 * */
	public static String rank(int[] lotto, int[] user) {
		if (lotto.length != 7 || user.length != 6) {
			return "������ �߻��߽��ϴ�. ���翡 �������ּ���.";
		}

		int count = 0; // user�� ���� �⺻ ��ȣ�� ��

		// �⺻��ȣ��(lotto[0] ~ lotto[5])�� user���� ã�� �� ���� count�� ����
		for (int i = 0; i < 6; i++) {
			if (r.contains(user, lotto[i])) {
				count++;
			}
		}

		// ��� ó��
		switch (count) {
			case 6:
				return "1��";
			case 5:
				return r.contains(user, lotto[6]) ? "2��" : "3��";
			case 4:
				return "4��";
			case 3:
				return "5��";
			default:
				return "��";
		}
	}

	public static void main(String[] args) {
		// 1. ��÷ ��ȣ ����
		int lotto[] = r.randomsD(7, 1, 45), user[] = new int[6];
		boolean manual;

		Scanner scan = new Scanner(System.in);

		System.out.println("�ζǸ� �������ּż� �����մϴ�.");
		System.out.print("��ȣ�� ���� �Է��Ͻðڽ��ϱ�? ");

		// 2. �ɼ� Ȯ��
		option: while (true) {
			while (true) {
				String choice = "";
				System.out.println("Y/N���� �Է����ּ���.");

				// 2-1. ���� �Է�. ������ ����
				while (choice.isBlank()) {
					choice = scan.nextLine().trim().toLowerCase();
				}
				char first = choice.charAt(0);

				// 2-2. �Է� ����
				// 2-2-1. �Է��� "Y", "N", "y", "n"�̶�� manual�� ���� �����ϰ� option while���� Ż��
				if (choice.length() == 1) {
					switch (first) {
						case 'y':
							manual = true;
							break option;
						case 'n':
							manual = false;
							break option;
						default:
					}
				}

				// 2-2-2. �ƴ϶�� �ٽ� �Է�
				System.out.print("�߸��� �Է��Դϴ�. ");
			}
		}

		// 3. ��ȣ ����
		if (manual) {
			// 3-1. ���� �Է�
			System.out.println("�ζ� ��ȣ�� �Է����ּ���. ��ȣ�� 1~45�Դϴ�.");
			for (int i = 0; i < user.length; i++) {
				while (true) {
					// 3-1-1. ���� �Է��� ���� => input
					// �̹� �Է��� ���ڵ��� Ȯ���ϱ� ������ �������� �Է¹��� ���ڵ��� �տ� ���
					if (i == 0) {
						System.out.print("> ");
					} else {
						for (int j = 0; j < i; j++) {
							System.out.print(user[j] + ", ");
						}
					}
					int input = scan.nextInt();

					// 3-1-2. input�� ���� Ȯ��
					if (input < 1 || input > 45) {
						System.out.println("����(1~45)�� ������ϴ�. �ٽ� �Է����ּ���.");
						continue;
					}

					// 3-1-3. input�� �ߺ� Ȯ��
					if (r.contains(user, input)) {
						System.out.println("�̹� ����� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
						continue;
					}

					// 3-1-4. ��ȿ�� �Է��̶�� user�� ���ڸ� �ְ� while�� ����
					user[i] = input;
					break;
				}
				scan.nextLine(); // �� ���� �� ���ھ��� �Է¹���
			}
		} else {
			// 3-2. ���� ����
			System.out.println("��ǻ�Ͱ� ���ڸ� �̽��ϴ�.");
			r.randomsD(user, 1, 45);
		}

		// 3. ���
		printLotto(lotto);
		printLotto(user);
		System.out.println(rank(lotto, user));

		scan.close();
	}
}
