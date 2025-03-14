package day04;

import java.util.Scanner;

public class Exam01 {
	public static void extra() {
		Scanner scan = new Scanner(System.in);
		int input, sum = 0;
		double count = 0.0;
		String total = ""; // 수식 제공

		System.out.println("정수를 입력해주세요.");
		System.out.println("0이나 음수를 입력할 때까지 계속 입력할 수 있으며,");
		System.out.println("직전 입력까지의 합과 평균이 출력됩니다.");

		while (true) {
			System.out.print("> ");
			input = scan.nextInt();
			if (input <= 0) {
				break;
			}
			total += "+" + input;
			count++;
			sum += input;
		}

		scan.close();

		if (count == 0.0) {
			System.out.println("양수를 입력받지 못했습니다. 종료합니다.");
		} else {
			System.out.println("계산식 : " + total.substring(1));
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + sum / count);
		}
	}

	public static void main(String[] args) {
		extra();

//		// 숫자를 입력받아 (0이나 음수를 입력받으면 종료)
//		// 입력받은 숫자의 합계와 평균을 출력
//		
//		Scanner scan = new Scanner(System.in);
//		int input, sum = 0;
//		double count = 0.0;
//		
//		// 사전 출력
//		System.out.println("정수를 입력해주세요.");
//		System.out.println("0이나 음수를 입력할 때까지 계속 입력할 수 있으며,");
//		System.out.println("직전 입력까지의 합과 평균이 출력됩니다.");
//		
//		// 정수 입력
//		System.out.print("> ");
//		input = scan.nextInt();
//		while (input <= 0) {
//			System.out.println("첫 입력은 반드시 양수여야 합니다.");
//			System.out.print("> ");
//			input = scan.nextInt();
//		} // 첫 입력은 반드시 양수
//		
//		do {
//			// 입력받은 수를 count와 sum에 반영
//			count++;
//			sum += input;
//			
//			// 다음 정수 입력
//			System.out.print("> ");
//			input = scan.nextInt();
//		} while (input > 0);
//		
//		scan.close();
//		
//		System.out.println("합계 : " + sum);
//		System.out.println("평균 : " + sum/count);
	}

}
