package day06;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* �߱�����
		 * ��ǻ�Ͱ� 3�ڸ��� ���ڸ� ���� => �迭�� ����
		 * - �� �ڸ����� 0~9, �ߺ����� ����
		 * ������ 3�ڸ� ���ڸ� �Է��Ͽ� ���ߴ� ����
		 * - �ߺ����� �ʰ� 3�ڸ� �Է�
		 * �ڸ��� ���ڰ� ��ġ�ϸ� S, ���ڴ� ������ �ڸ��� �ٸ��� B, ������ out
		 * -> ��S ��B / out / ���� ���
		 * */

		int game		= 3, 				// ������ �� ������ ����
			com[]		= new int[game],	// ���� ���� ���
			user[]		= new int[game],	// ���� �Է�
			result[]	= new int[2],		// result = {��Ʈ����ũ, ��} (input: while)
			list[],							// ������ ���ڵ��� ���(0~9)
			count		= 0;				// ���߱���� �ɸ� Ƚ��
		String resultStr; 					// �� �Է� �� ����� �����(1S 1B, out, ...)
		Scanner scan = new Scanner(System.in);

		// 0. ���� ����
		System.out.println("�� �ڸ� ���� " + game + "���� ����� �����Ͽ� �Է����ּ���.");
		System.out.println("�Է��ϴ� ���ڵ��� �ߺ��Ǹ� �� �˴ϴ�.");
		System.out.println("��)1 2 3");

		// 1. �ߺ����� �ʴ� 3���� �� �ڸ� ���ڸ� ����
		// 1-1) 0~9������ array�� ���� : list
		list = new int[10];
		for (int i = 0; i < 10; i++) {
			list[i] = i;
		}
		// 1-2) �����ϰ� �� ���ڸ� �̰�, �̸� list���� ����
		// �����ϴ� ��� : ���õ� ���� ���� ��ü���� ���� ���ڵ� �� ������ ��ü�� �� ������ ������ ����
		for (int i = 0; i < game; i++) {
			int choice = (int) (Math.random() * (10 - i)), temp = list[choice];
			com[i] = temp;
			list[choice] = list[9 - i];
			list[9 - i] = temp;
		}

		input: while (true) {
			// 2. ������, ����� �ʱ�ȭ
			result[0] = 0;
			result[1] = 0;
			resultStr = "";

			// 3. ���� �Է�
			System.out.print(count + 1 + "> ");
			for (int i = 0; i < game; i++) {
				user[i] = scan.nextInt();
			}
			// 3-1. �ߺ����� �Է��ϸ� �Է��� �ٽ� ����
			for (int i = 0; i < game - 1; i++) {
				for (int j = i + 1; j < game; j++) {
					if (user[i] == user[j]) {
						System.out.println("�ߺ��� ���� �Է��ϼ̽��ϴ�.");
						continue input;
					}
				}
			}
			count++; // ����� �Է��� �޾����� count�� ����

			// 4. ���� ���
			for (int i = 0; i < game; i++) {
				if (user[i] == com[i]) {
					result[0]++;
				} else {
					for (int j = 0; j < game; j++) {
						if (user[i] == com[j]) {
							result[1]++;
						}
					}
				}
			}
			
			// ���� ��Ʈ����ũ�� ���� ����
			if (result[0] == game) {
				break;
			}
			
			// 5. ����� �ۼ�
			boolean bothSB = false;
			// 5-1. ��Ʈ����ũ�� ������ ��Ʈ����ũ ���� �߰�
			if (result[0] > 0) {
				resultStr += result[0] + "S";
				bothSB = true;
			}
			// 5-2. ���� ������ �� ���� �߰�
			if (result[1] > 0) {
				// ��Ʈ����ũ�� ���� �� �� ���� ��� ���̿� ���� �߰�
				if (bothSB) {
					resultStr += " ";
				}
				resultStr += result[1] + "B";
			}

			// 6. ����� ���
			System.out.println(resultStr.isBlank() ? "out" : resultStr);
		}

		System.out.println("����");
		System.out.println("Ƚ�� : " + count);
		scan.close();
	}

}
