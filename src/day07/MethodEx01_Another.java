package day07;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MethodEx01_Another {
	// 메뉴 출력 및 입력
	// 1~6을 입력받을 때까지 반복
	public static int getMenu(Scanner scan) {
		int menu;
		while (true) {
			// 메뉴 출력
			System.out.println("--menu--");
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6. 종료");

			// 메뉴 입력
			System.out.print(">> 메뉴선택> ");
			menu = scan.nextInt();

			// 정상적인 입력이라면 return
			if (menu >= 1 && menu <= 6) {
				return menu;
			}

			// 잘못된 입력이라면 경고문을 출력한 후 다시 입력받음
			System.out.println("잘못된 입력입니다.");
		}
	}

	// 두 수를 입력받아 array 형태로 return
	// 나눗셈이나 나머지를 골랐을 경우, 두번째 입력(== answer[1])이 0이 아니도록 함
	public static int[] getNums(Scanner scan, int menu) {
		int[] answer = new int[2];

		// 첫번째 숫자 입력
		System.out.print("첫번째 숫자 입력> ");
		answer[0] = scan.nextInt();

		// 두번째 숫자 입력
		System.out.print("두번째 숫자 입력> ");
		answer[1] = scan.nextInt();
		// 나눗셈이나 나머지 계산일 경우, 두번째 입력이 0이 아닐 때까지 다시 입력받음
		if (menu == 4 || menu == 5) {
			while (answer[1] == 0) {
				System.out.print("0으로 나눌 수 없습니다. 다시 입력하세요.> ");
				answer[1] = scan.nextInt();
			}
		}

		return answer;
	}

	// 연산자와 숫자를 가지고 계산
	// 예외처리는 getNums에서 하므로 별도로 처리하지 않음
	// 나눗셈을 포함하기 위해 double로 return하고, 이후 printResult에서 이를 처리함
	public static double calc(int menu, int[] num) {
		int num1 = num[0], num2 = num[1];
		switch (menu) {
			case 1:
				return Method03.add(num1, num2);
			case 2:
				return Method03.sub(num1, num2);
			case 3:
				return Method03.mul(num1, num2);
			case 4:
				return Method03.div(num1, num2);
			case 5:
				return Method03.mod(num1, num2);
			default: // 도달 불가능
				return -1;
		}
	}

	// 양수면 그대로, 음수면 소괄호를 붙임
	public static String addBracket(int num) {
		return (num >= 0) ? num + "" : "(" + num + ")";
	}

	// 연산자와 숫자를 받아와서 결과를 출력
	public static void printResult(int menu, int[] num) {
		String[] oper = { " + ", " - ", "*", "/", " % " };
		double result = calc(menu, num); // 계산 결과를 double로 받아옴

		// 예시
		// 1. "2/(-3) = "
		// 2. "(-7) + 15 = "
		String output = addBracket(num[0]) + oper[menu - 1] + addBracket(num[1]) + " = ";

		// 나눗셈이면 result의 소숫점을 둘째 자리까지 살리고, 아니면 정수로 처리
		if (menu == 4) {
			output += new DecimalFormat("0.00").format(result);
		} else {
			output += (int) result;
		}
		System.out.println(output);
	}

	public static void main(String[] args) {
		/* 계산기 만들기
		 * 
		 * --menu--
		 * 1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 나눗셈 | 5. 나머지 | 6. 종료
		 * >> 메뉴선택 1
		 * >> 숫자 입력 > 1 5
		 * 결과 : 1 + 5 = 6
		 * */
		Scanner scan = new Scanner(System.in);
		int menu;

		while (true) {
			// 메뉴 출력 및 선택
			menu = getMenu(scan);

			// 메뉴 처리
			if (menu == 6) {
				System.out.println("종료합니다.");
				break;
			} else {
				printResult(menu, getNums(scan, menu));
			}

		}

		scan.close();
	}
}