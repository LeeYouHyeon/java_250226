package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/* �ֻ��� ����
		 * �ֻ����� ������ �� 30ĭ�� �̵��ϴ� ����
		 * �ֻ����� �������� ���� (1~6)
		 * ��)
		 * �ֻ��� : 3
		 * 3ĭ ���� => 27ĭ ���ҽ��ϴ�.
		 * �ֻ��� : 1
		 * 1ĭ ���� => 26ĭ ���ҽ��ϴ�.
		 * ...
		 * ����~!!	�� �̵� Ƚ�� : 10�� => �ֻ����� ���� Ƚ��
		 * */

		System.out.println("�ֻ��� ����. �� 30ĭ�� �̵��մϴ�.");
		int goal = 30, count = 0, dice;
		Scanner scan = new Scanner(System.in);

		while (goal > 0) {
			System.out.printf("����Ű�� �ֻ����� �����ּ���.> ");
			scan.nextLine();

			dice = (int) (5 * Math.random()) + 1;
			count++;

			System.out.println("�ֻ��� : " + dice);
			System.out.print(dice + "ĭ ���� => ");
			goal -= dice;

			if (goal > 0) {
				System.out.println(goal + "ĭ ���ҽ��ϴ�.");
			}
		}

		System.out.println("����~!!");
		System.out.println("�� �̵� Ƚ�� : " + count + "��");
		scan.close();
	}

}
