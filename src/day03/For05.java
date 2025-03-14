package day03;

import java.util.Scanner;

public class For05 {

	public static void main(String[] args) {
		// 최대공약수, 최소공배수
		
		Scanner scan = new Scanner(System.in);
		int num1, num2, gcd = 1;
		
		System.out.println("최대공약수와 최소공배수를 구하고 싶은 두 자연수를 입력하세요.");
		System.out.print("첫 번째 자연수> ");
		num1 = scan.nextInt();
		System.out.print("두 번째 자연수> ");
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
		
		System.out.println("최대공약수 : " + gcd);
		System.out.println("최소공배수 : " + num1*num2/gcd);
		
		scan.close();
	}

}
