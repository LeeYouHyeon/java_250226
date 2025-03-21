package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/* 주사위 게임
		 * 주사위를 던져서 총 30칸을 이동하는 게임
		 * 주사위는 랜덤으로 생성 (1~6)
		 * 예)
		 * 주사위 : 3
		 * 3칸 전진 => 27칸 남았습니다.
		 * 주사위 : 1
		 * 1칸 전진 => 26칸 남았습니다.
		 * ...
		 * 도착~!!	총 이동 횟수 : 10번 => 주사위를 던진 횟수
		 * */

		System.out.println("주사위 게임. 총 30칸을 이동합니다.");
		int goal = 30, count = 0, dice;
		Scanner scan = new Scanner(System.in);

		while (goal > 0) {
			System.out.printf("엔터키로 주사위를 던져주세요.> ");
			scan.nextLine();

			dice = (int) (5 * Math.random()) + 1;
			count++;

			System.out.println("주사위 : " + dice);
			System.out.print(dice + "칸 전진 => ");
			goal -= dice;

			if (goal > 0) {
				System.out.println(goal + "칸 남았습니다.");
			}
		}

		System.out.println("도착~!!");
		System.out.println("총 이동 횟수 : " + count + "번");
		scan.close();
	}

}
