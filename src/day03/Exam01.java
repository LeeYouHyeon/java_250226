package day03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* up/down ����
		 * 
		 * 1~50�� ���� �� �����Ͽ� ���ߴ� ����
		 * ��ǻ�Ͱ� ���� �� ���� : 23
		 * �Է�> 10
		 * up!!
		 * �Է�> 20
		 * up!!
		 * �Է�> 30
		 * down!!
		 * �Է�> 25
		 * down!!
		 * �Է�> 23
		 * ����!!
		 * */

		int answer = (int) (50 * Math.random()) + 1, count = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("5ȸ �ȿ� ������ ���纸����! ���� 1���� 50������ �����Դϴ�.");
		while (true) {
			count++;
			System.out.print(count + ". �Է�> ");
			int input = scan.nextInt();
			if (input > answer) {
				System.out.println("down!!");
			} else if (input < answer) {
				System.out.println("up!!");
			} else {
				System.out.println("����!!");
				break;
			}
			
			if (count == 5) {
				System.out.println("����!!");
				break;
			}
		}
		scan.close();
	}

}
