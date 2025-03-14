package day07;

import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		// day06.ArrayEx01�� �޼���� �и��� �� ����

		int comNum[] = new int[3], myNum[] = new int[3], count = 0, strike, ball;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			comNum[i] = -1;
		}

		// 1. ���� ����
		System.out.println("�� �ڸ� ���� 3���� ����� �����Ͽ� �Է����ּ���.");
		System.out.println("�Է��ϴ� ���ڵ��� �ߺ��Ǹ� �� �˴ϴ�.");
		System.out.println("��)1 2 0");

		// 2. �ߺ����� �ʴ� 3���� �� �ڸ� ���ڸ� ����
		fill(comNum);

		// ���� ����
		input: while (true) {
			// 3. ���� �Է�
			System.out.print(count + 1 + "> ");
			for (int i = 0; i < 3; i++) {
				myNum[i] = scan.nextInt();
			}
			// 3-1. �ߺ����� �Է��ϸ� �Է��� �ٽ� ����
			for (int i = 0; i < myNum.length - 1; i++) {
				for (int j = i + 1; j < myNum.length; j++) {
					if (myNum[i] == myNum[j]) {
						System.out.println("�ߺ��� ���� �Է��ϼ̽��ϴ�.");
						continue input;
					}
				}
			}
			count++; // ����� �Է��� �޾����� count�� ����

			// 4. ���� ���
			strike = countStrike(comNum, myNum);
			if (strike == 3) { // ����
				break;
			}
			ball = countBall(comNum, myNum);

			// 5. ����� �ۼ�
			String result = "";
			if (strike == 0 && ball == 0) {
				result = "out";
			} else {
				if (strike > 0) {
					result += strike + "S";
				}
				if (strike * ball > 0) {
					result += " ";
				}
				if (ball > 0) {
					result += ball + "B";
				}
			}

			System.out.println(result);
		}

		// ���� ó��
		System.out.println("����");
		System.out.println("Ƚ�� : " + count);
		scan.close();
	}

	/* �� �迭�� �Է¹޾� �������� ���� �ߺ����� �ʰ� ä��� 
	 * ���� ���� 0~9
	 * */
	public static void fill(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int insert = Method06.random(0, 9);
			if (contains(arr, insert)) {
				i--;
			} else {
				arr[i] = insert;
			}
		}
	}

	/* �ߺ�Ȯ�� �޼���
	 * �̿ϼ� �迭�� �������� �Է¹���
	 * �迭�� �������� �����ϸ� true, ������ false
	 * */
	public static boolean contains(int[] arr, int num) {
		for (int in : arr) {
			if (in == num) {
				return true;
			}
		}

		return false;
	}

	/* ��Ʈ����ũ ������ ���� �޼���
	 * �Ű����� : int[] comNum, int[] myNum
	 * count ���� ����
	 * */
	public static int countStrike(int[] comNum, int[] myNum) {
		int answer = 0;
		for (int i = 0; i < comNum.length; i++) {
			if (comNum[i] == myNum[i]) {
				answer++;
			}
		}

		return answer;
	}

	/* �� ������ ���� �޼���
	 * �Ű����� : int[] comNum, int[]myNum
	 * count ���� ����
	 * */
	public static int countBall(int[] comNum, int[] myNum) {
		int answer = 0;
		for (int i = 0; i < comNum.length; i++) {
			for (int j = 0; j < myNum.length; j++) {
				if (i != j && comNum[i] == myNum[j]) {
					answer++;
				}
			}
		}

		return answer;
	}
}
