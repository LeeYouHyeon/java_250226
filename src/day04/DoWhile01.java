package day04;

import java.util.Scanner;

public class DoWhile01 {

	public static void main(String[] args) {
		/* 반복문 : for, while, do~while
		 * for, while : 조건을 만족하지 않으면 한 번도 실행되지 않을 수 있음
		 * do~while : 실행문을 먼저 실행하고, 조건식을 나중에 비교
		 * 무조건 한 번은 실행 후 비교하는 구조
		 * 
		 * do {
		 * 	실행문;
		 * } while(조건식);
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		/* 한 글자를 입력받아서 출력
		 * y => 종료
		 * */
		
		char ch; // do 안에서 선언하면 while에서 읽을 수 없음
		do {
			System.out.print("한 글자 입력> ");
			ch = scan.next().charAt(0);
		} while (ch != 'y');
		
		System.out.println("종료");
		scan.close();
	}

}
