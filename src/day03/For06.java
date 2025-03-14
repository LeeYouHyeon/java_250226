package day03;

import java.util.Scanner;

public class For06 {
	
	public static void main(String[] args) {
		/* ��� : ���� ���ؼ� ������ ��
		 * 10�� ��� : 10, 20, 30, ...
		 * */
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("�ִ������� �ּҰ������ ���ϰ� ���� �� �ڿ����� �Է��ϼ���.");
		System.out.print("ù ��° �ڿ���> ");
		num1 = scan.nextInt();
		System.out.print("�� ��° �ڿ���> ");
		num2 = scan.nextInt();
		
		int max = Math.max(num1, num2);
		int min = num1 + num2 - max;
		
		for(int i = max; ; i += max) {
			if (i%min == 0) {
				System.out.println(i);
				break;
			}
		}
		
		scan.close();
	}
	
}
