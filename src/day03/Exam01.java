package day03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* up/down 게임
		 * 
		 * 1~50의 랜덤 수 생성하여 맞추는 게임
		 * 컴퓨터가 랜덤 수 생성 : 23
		 * 입력> 10
		 * up!!
		 * 입력> 20
		 * up!!
		 * 입력> 30
		 * down!!
		 * 입력> 25
		 * down!!
		 * 입력> 23
		 * 정답!!
		 * */

		int answer = (int) (50 * Math.random()) + 1, count = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("5회 안에 정답을 맞춰보세요! 답은 1부터 50까지의 정수입니다.");
		while (true) {
			count++;
			System.out.print(count + ". 입력> ");
			int input = scan.nextInt();
			if (input > answer) {
				System.out.println("down!!");
			} else if (input < answer) {
				System.out.println("up!!");
			} else {
				System.out.println("정답!!");
				break;
			}
			
			if (count == 5) {
				System.out.println("실패!!");
				break;
			}
		}
		scan.close();
	}

}
