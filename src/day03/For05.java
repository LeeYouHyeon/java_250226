package day03;

import java.util.Scanner;

public class For05 {

	public static void main(String[] args) {
		// �ִ�����, �ּҰ����
		
		Scanner scan = new Scanner(System.in);
		int num1, num2, gcd = 1;
		
		System.out.println("�ִ������� �ּҰ������ ���ϰ� ���� �� �ڿ����� �Է��ϼ���.");
		System.out.print("ù ��° �ڿ���> ");
		num1 = scan.nextInt();
		System.out.print("�� ��° �ڿ���> ");
		num2 = scan.nextInt();
		

//		for (int i = 1; i <= num2; i++) {
//			if (num1%i == 0 && num2%i == 0) {
//				gcd = i;
//			}
//		}
		
		for (int i = num1; ; i--) {
			if (num1%i == 0 && num2%i == 0) {
				gcd = i;
				break;
			}
		}
		
		System.out.println("�ִ����� : " + gcd);
		System.out.println("�ּҰ���� : " + num1*num2/gcd);
		
		scan.close();
	}

}
