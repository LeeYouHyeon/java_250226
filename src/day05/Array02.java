package day05;

import java.util.Scanner;

public class Array02 {

	public static void main(String[] args) {
		/* 5���� ������ �Է�
		 * 1. �迭�� ����
		 * 2. �迭�� ���� �Է¹ޱ�
		 * 3. �迭�� ���
		 * 4. ������ �հ� / ���
		 * */
		
		// 1. �迭�� ����
		Scanner scan = new Scanner(System.in);
		int scores[] = new int[5], sum = 0;

		// 2. �迭�� ���� �Է¹ޱ�
		System.out.println("5���� ������ �Է����ּ���.");
		for (int i = 0; i < scores.length; i++) {
			System.out.print(i + 1 + "> ");
			scores[i] = scan.nextInt();
			sum += scores[i];
		}

		// 3. �迭�� ���
		System.out.print("���� : ");
		for (int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();

		// 4. ������ �հ�� ��� ���
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + sum / (double)scores.length);
		scan.close();
		
		// ���� for��
		// ������ ������ �Ұ����� ��� ���
		// index�� Ȱ���� ����� �� �� ���� ��ü Ž���� ����
		for(int num : scores) {
			System.out.print(num + " ");
		}
	}

}
