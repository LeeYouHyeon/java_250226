package memos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DistinctNumsArray {
	public static int random(int start, int end) {
		return (int) (Math.random() * (end - start) + start);
	}

	// start���� end������ �ߺ����� �ʴ� ���� ������ array ... ����
	public static int[] randomDistinctArray(int n, int start, int end) throws Exception {
		// �Է����� ����
		// start <= end�̰�, ������ n �̻��̾�� �Ѵ�.
		if (start > end)
			return randomDistinctArray(n, end, start);
		if (end - start + 1 < n)
			throw new Exception();

		int answer[] = new int[n];

		for (int i = 0; i < n; i++) {
			answer[i] = random(start, end - i);
			for (int j = 0; j < i; j++) {
				if (answer[i] >= answer[j]) {
					answer[i]++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, start, end, answer[];

		System.out.println("�ߺ����� �ʴ� ���� ���� ������");
		
		while (true) {
			try {
				System.out.print("���ڸ� �� �� �̰� ������ �Է��ϼ���.> ");
				while (true) {
					try {
						n = scan.nextInt();
						if (n <= 0) {
							throw new InputMismatchException();
						}
						break;
					} catch (InputMismatchException e) {
						System.out.println("�ڿ����� �Է����ּ���.");
					}
				}
				
				// start �Է�
				while (true) {
					try {
						System.out.print("�ּڰ��� �Է��ϼ���.> ");
						start = scan.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("������ �Է����ּ���.");
					}
				}
				
				// end �Է�
				while (true) {
					try {
						System.out.print("�ִ��� �Է��ϼ���.> ");
						end = scan.nextInt();
						if (end < start) {
							throw new Exception();
						}
						break;
					} catch (InputMismatchException e) {
						System.out.println("������ �Է����ּ���.");
					} catch (Exception e) {
						System.out.println("�ִ��� �ּڰ� �̻��̾�� �մϴ�.");
					}
				}
				
				// array ����
				answer = randomDistinctArray(n, start, end);
				break;
			} catch (Exception e) {
				System.out.println("�������� �� ���� ���� �� �����ϴ�.");
			}
		}
		
		// array ���
		for(int num : answer) {
			System.out.print(num + " ");
		}
		scan.close();
	}
}
