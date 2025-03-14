package day04;

import java.util.Scanner;

public class DoWhile03 {

	public static void main(String[] args) {
		/* 숫자 2개를 입력받고,
		 * num1 = 2, num2 = 3
		 * menu 
		 * 1. + | 2. - | 3. * | 4. / | 5. % | 6. 종료
		 * menu에 따라 두 수의 연산 결과를 출력
		 * 1 => 2 + 3 = 5
		 * 2 => 2 - 3 = -1
		 * ...
		 * 4 => 2/0 = num2를 다시 입력해주세요.
		 * 5 => 2%0 = num2를 다시 입력해주세요.
		 * */

		Scanner scan = new Scanner(System.in);
		int num1, num2;

		// 숫자 입력
		System.out.println("두 숫자를 입력해주세요.");
		System.out.print("첫 번째 숫자> ");
		num1 = scan.nextInt();
		System.out.print("두 번째 숫자> ");
		num2 = scan.nextInt();

		int menu;
		do {
			char cal = 0;
			int answer = 0;

			// 메뉴 입력
			System.out.println("menu");
			System.out.println("1. + | 2. - | 3. * | 4. / | 5. % | 6. 종료");
			menu = scan.nextInt();

			switch (menu) {
				case 1:
					cal = '+';
					answer = num1 + num2;
					break;
				case 2:
					cal = '-';
					answer = num1 - num2;
					break;
				case 3:
					cal = '*';
					answer = num1 * num2;
					break;
				case 4:
					if (num2 == 0) {
						System.out.println("0으로 나눌 수 없습니다.");
						continue;
					}
					cal = '/';
					answer = num1 / num2;
					break;
				case 5:
					if (num2 == 0) {
						System.out.println("0으로 나눌 수 없습니다.");
						continue;
					}
					cal = '%';
					answer = num1 % num2;
					break;
				case 6:
					System.out.println("종료합니다.");
					continue;
				default:
					System.out.println("메뉴를 다시 입력하세요.");
					continue;
			}

			// 결과 출력
			String strNum1 = (num1 >= 0) ? "" + num1 : "(" + num1 + ')'; // 음수일 경우 소괄호를 붙임
			String strNum2 = (num2 >= 0) ? "" + num2 : "(" + num2 + ')'; // 음수일 경우 소괄호를 붙임
			System.out.println(strNum1 + ' ' + cal + ' ' + strNum2 + " = " + answer);

		} while (menu != 6);

		scan.close();
	}

}
