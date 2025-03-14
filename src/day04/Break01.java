package day04;

import java.util.Scanner;

public class Break01 {

	public static void main(String[] args) {
		/* break; : �ݺ����� ���������� �ϴ� Ű����
		 * - �ݺ������� ���ǹ�(if)�� �����Ͽ� ������ ���� �� ����� �ϴ� ����
		 * for, while
		 * */

		// 1~10 ���
		// for���� ���ѷ��� ����, break�� ��������
		for(int i = 1; ; i++) {
			System.out.print(i + " ");
			if(i == 10) break;
		}
		
		System.out.println();
		System.out.println("---------------");
		// �� ���ڸ� �Է¹޾� ��� (�ݺ�)
		// y�� �Է¹����� ����(break)
		Scanner scan = new Scanner(System.in);
		char input;
		
		while(true) {
			System.out.print("> ");
			input = scan.next().charAt(0);
			if(input == 'y') {
				break;
			}
		}
		
		scan.close();
		
		// ��ø �ݺ��� ��� break;�� ���� ���δ� ���� �� ���� �ݺ����� ���
		// �ݺ����� �̸��� �� �� ����.
		int i = 0, j = 0, k = 0;
		a: for(;;) {
			j++;
			for(;;) {
				k++;
				for(;;) {
					i++;
					System.out.println("i:" + i + ", k:" + k + ", j:" + j);
					if(i == 10) {
						break a;
					}
				}
			}
		}
	}

}
