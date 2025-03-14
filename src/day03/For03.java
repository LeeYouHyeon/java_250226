package day03;

import java.util.Scanner;

public class For03 {

	public static void main(String[] args) {
		// 구구단 2단 출력
		
		//int num = 3;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("구구단에서 몇 단을 보고 싶은지 한 자리 숫자로 입력하세요.");
		
		int num = scan.nextInt();
		
		if (num < 2 || num > 10) {
			System.out.println("구구단의 범위 밖입니다.");
		} else {
			for (int i = 1; i < 10; i++) {
				System.out.println(num + "*" + i + " = " + num*i);
			}
		}
		
		scan.close();
		
		System.out.println("----------------");

	}

}
