package day05;

import java.util.Scanner;

public class Exam01 {
	public static void extra() {
		String table[] = { "가위", "바위", "보" },
				resultTable[] = { "무승부", "승리", "패배" },
				user;
		int userInt, comInt;

		// 사전 출력
		System.out.println("가위, 바위, 보 중 하나를 입력하세요.");
		System.out.println("Q/q를 누르면 종료합니다.");

		Scanner scan = new Scanner(System.in);
		while (true) {
			// 컴퓨터 결정
			comInt = (int) (Math.random() * 3);

			// 유저의 입력을 받음
			System.out.print("입력> ");
			user = scan.next();
			if (user.toLowerCase().equals("q")) {
				// Q/q를 누르면 종료
				break;
			}

			// 유저 입력을 정수(userInt)로 변환
			// userInt의 기본값은 잘못 입력한 경우를 판별하기 위함
			// 정상적으로 입력했으면 0~2 사이의 값이 된다.
			userInt = -1;
			for (int i = 0; i < 3; i++) {
				if (user.equals(table[i])) {
					userInt = i;
				}
			}

			if (userInt == -1) {
				// 에러 케이스
				System.out.println("잘못된 입력입니다.");
			} else {
				// 승패 결정
				int result = userInt - comInt;
				if (result < 0) {
					result += 3;
				}

				// 결과 출력
				System.out.println("컴퓨터 : " + table[comInt] + " / 유저 : " + user);
				System.out.println(resultTable[result]);
			}

		}
		
		System.out.println("종료합니다.");
		scan.close();
	}

	public static void main(String[] args) {
		/* 컴퓨터와 가위바위보 게임
		 * 컴퓨터는 랜덤으로 가위/바위/보 중 하나를 선택 (0 = 가위 / 1 = 바위 / 2 = 보)
		 * 가위바위보 중 하나를 선택하여 입력
		 * ex)
		 * com = 0(가위) me = 보 => com 승리
		 * 컴퓨터와 나의 선택, 패배 / 무승부 / 승리 출력
		 * */
		extra();
//		String table[] = { "가위", "바위", "보" };
//
//		// 유저 입력
//		Scanner scan = new Scanner(System.in);
//		System.out.print("가위, 바위, 보 중 하나를 입력하세요.> ");
//		String user = scan.next(), result = "";
//		scan.close();
//
//		// 컴퓨터 결정
//		int comInt = (int) (Math.random() * 3);
//
//		// 입력 확인 및 승패 판정
//		boolean valid = true;
//		switch (comInt) {
//			case 0: // 가위
//				if (user.equals("가위")) {
//					result = "무승부";
//				} else if (user.equals("바위")) {
//					result = "승리";
//				} else if (user.equals("보")) {
//					result = "패배";
//				} else {
//					valid = false;
//					result = "잘못된 입력";
//				}
//				break;
//			case 1: // 바위
//				if (user.equals("가위")) {
//					result = "패배";
//				} else if (user.equals("바위")) {
//					result = "무승부";
//				} else if (user.equals("보")) {
//					result = "승리";
//				} else {
//					valid = false;
//					result = "잘못된 입력";
//				}
//				break;
//			case 2: // 보
//				if (user.equals("가위")) {
//					result = "승리";
//				} else if (user.equals("바위")) {
//					result = "패배";
//				} else if (user.equals("보")) {
//					result = "무승부";
//				} else {
//					valid = false;
//					result = "잘못된 입력";
//				}
//				break;
//			default:
//				valid = false;
//				System.out.println("알 수 없는 오류");
//		}
//
//		// 결과 출력
//		if (valid) {
//			System.out.println("컴퓨터 : " + table[comInt] + " / 유저 : " + user);
//		}
//		System.out.println(result);

	}

}
