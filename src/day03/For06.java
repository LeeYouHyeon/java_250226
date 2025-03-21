package day03;

import java.util.Scanner;

public class For06 {
	
	public static void main(String[] args) {
		/* 배수 : 값을 곱해서 나오는 값
		 * 10의 배수 : 10, 20, 30, ...
		 * */
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		
		System.out.println("최대공약수와 최소공배수를 구하고 싶은 두 자연수를 입력하세요.");
		System.out.print("첫 번째 자연수> ");
		num1 = scan.nextInt();
		System.out.print("두 번째 자연수> ");
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
