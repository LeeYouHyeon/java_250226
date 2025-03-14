package day02;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		/* 과제
		 * 정수 2개와 연산자 1개를 입력받아 두 정수의 연산 결과를 출력
		 * ex) 2 3 + => 5
		 * ex) 2 3 * => 6
		 * ex) 2 3 ! => 잘못된 연산
		 * 연산자는 +, -, *, /, %
		 * 다른 종류의 특수문자가 들어오면 "잘못된 연산" 출력
		 */

		// 문자로 받는 케이스 : String => 비교 불가 ""
		// 한 글자만 받는 케이스 : char => 비교 가능 ''

		Scanner scan = new Scanner(System.in);

		System.out.println("두 정수와 연산자를 입력해주세요.");
		System.out.println("예)2 3 +");

		int num1 = scan.nextInt();
		String strNum1 = (num1 > 0) ? "" + num1 : "(" + num1 + ')'; // 음수일 경우 소괄호를 붙임
		int num2 = scan.nextInt();
		String strNum2 = (num2 > 0) ? "" + num2 : "(" + num2 + ')'; // 음수일 경우 소괄호를 붙임
		char cal = scan.next().charAt(0);
		String result = strNum1 + ' ' + cal + ' ' + strNum2 + " = ";

		switch (cal) {
			case '+':
				result += num1 + num2;
				break;
			case '-':
				result += num1 - num2;
				break;
			case '*':
				result += num1 * num2;
				break;
			case '/':
				result = (num2 == 0) ? "0으로 나눌 수 없습니다." : result + (num1/num2);
				break;
			case '%':
				result = (num2 == 0) ? "0으로 나눌 수 없습니다." : result + (num1%num2);
				break;
			default:
				result = "잘못된 연산자입니다.";
		}

		System.out.println(result);
		scan.close();
	}

}
