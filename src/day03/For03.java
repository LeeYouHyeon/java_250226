package day03;

import java.util.Scanner;

public class For03 {

	public static void main(String[] args) {
		// ������ 2�� ���
		
		//int num = 3;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("�����ܿ��� �� ���� ���� ������ �� �ڸ� ���ڷ� �Է��ϼ���.");
		
		int num = scan.nextInt();
		
		if (num < 2 || num > 10) {
			System.out.println("�������� ���� ���Դϴ�.");
		} else {
			for (int i = 1; i < 10; i++) {
				System.out.println(num + "*" + i + " = " + num*i);
			}
		}
		
		scan.close();
		
		System.out.println("----------------");

	}

}
