package day03;

import java.util.Scanner;

public class For04 {

	public static void main(String[] args) {
		/* ��� : ����� �������� ���� ����
		 * 6�� ��� : 1, 2, 3, 6
		 * */
		
		System.out.println("����� ���ϰ� ���� �ڿ����� �Է����ּ���.");
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			int num = scan.nextInt();
			if(num <= 0) {
				System.out.println("�ڿ����� �Է����ּ���.");
			} else {
				for(int i = 1; i <= num; i++) {
					if(num%i == 0) {
						System.out.println(i);
					}
				}
				break;
			}
		}
		
		scan.close();
	}

}
