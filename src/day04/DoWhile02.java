package day04;

import java.util.Scanner;

public class DoWhile02 {

	public static void main(String[] args) {
		/* �޴� ������ �� do~while���� ���� ���
		 * 
		 * menu 1. �����ϱ�, 2. ���� �����, 3. �����ϱ�
		 * */

		Scanner scan = new Scanner(System.in);
		
		int menu;
		do {
			System.out.println("--menu--");
			System.out.println("1. �����ϱ� | 2. ���� ����� | 3. ����");
			System.out.println("menu>> ");
			menu = scan.nextInt();
			
			// ���� ó��
			switch (menu) {
				case 1:
					System.out.println("�����߽��ϴ�.");
					break;
				case 2:
					System.out.println("���� ��������ϴ�.");
					break;
				case 3:
					System.out.println("�����մϴ�.");
					break;
				default:
					System.out.println("�ٽ� �Է����ּ���.");
			}

		} while (menu != 3);

		scan.close();
	}

}
