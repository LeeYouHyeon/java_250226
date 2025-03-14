package day08;

import java.util.Scanner;

import memos.Randoms;

public class MethodEx03 {
	public static Randoms r = new Randoms();

	/* 배열 출력 메서드
	 * user : 1 2 3 4 5 6
	 * 당첨 : 1 2 3 4 5 6 [7]
	 * */
	public static void printLotto(int[] arr) {
		if (arr.length < 5 || arr.length > 8)
			return;

		if (arr.length == 7) {
			System.out.print("당첨 번호 : ");
		} else {
			System.out.print("입력 번호 : ");
		}

		for (int i = 0; i < 6; i++) {
			System.out.print(arr[i] + " ");
		}

		if (arr.length == 7) {
			System.out.println("[" + arr[6] + "]");
		} else {
			System.out.println();
		}
	}

	/* 등수 확인 메서드
	 * 당첨 번호와 사용자 번호 비교 후 등수 추출
	 * 6개 모두 일치 : 1등
	 * 5개 일치 + 보너스 : 2등
	 * 5개 일치 : 3등
	 * 4개 일치 : 4등
	 * 3개 일치 : 5등
	 * 나머지 : 꽝 
	 * */
	public static String rank(int[] lotto, int[] user) {
		if (lotto.length != 7 || user.length != 6) {
			return "에러가 발생했습니다. 본사에 문의해주세요.";
		}

		int count = 0; // user가 맞춘 기본 번호의 수

		// 기본번호들(lotto[0] ~ lotto[5])을 user에서 찾아 그 수를 count에 저장
		for (int i = 0; i < 6; i++) {
			if (r.contains(user, lotto[i])) {
				count++;
			}
		}

		// 등수 처리
		switch (count) {
			case 6:
				return "1등";
			case 5:
				return r.contains(user, lotto[6]) ? "2등" : "3등";
			case 4:
				return "4등";
			case 3:
				return "5등";
			default:
				return "꽝";
		}
	}

	public static void main(String[] args) {
		// 1. 당첨 번호 생성
		int lotto[] = r.randomsD(7, 1, 45), user[] = new int[6];
		boolean manual;

		Scanner scan = new Scanner(System.in);

		System.out.println("로또를 구매해주셔서 감사합니다.");
		System.out.print("번호를 직접 입력하시겠습니까? ");

		// 2. 옵션 확인
		option: while (true) {
			while (true) {
				String choice = "";
				System.out.println("Y/N으로 입력해주세요.");

				// 2-1. 유저 입력. 공백은 무시
				while (choice.isBlank()) {
					choice = scan.nextLine().trim().toLowerCase();
				}
				char first = choice.charAt(0);

				// 2-2. 입력 검증
				// 2-2-1. 입력이 "Y", "N", "y", "n"이라면 manual에 값을 저장하고 option while문을 탈출
				if (choice.length() == 1) {
					switch (first) {
						case 'y':
							manual = true;
							break option;
						case 'n':
							manual = false;
							break option;
						default:
					}
				}

				// 2-2-2. 아니라면 다시 입력
				System.out.print("잘못된 입력입니다. ");
			}
		}

		// 3. 번호 생성
		if (manual) {
			// 3-1. 직접 입력
			System.out.println("로또 번호를 입력해주세요. 번호는 1~45입니다.");
			for (int i = 0; i < user.length; i++) {
				while (true) {
					// 3-1-1. 숫자 입력을 받음 => input
					// 이미 입력한 숫자들을 확인하기 쉽도록 이전까지 입력받은 숫자들을 앞에 출력
					if (i == 0) {
						System.out.print("> ");
					} else {
						for (int j = 0; j < i; j++) {
							System.out.print(user[j] + ", ");
						}
					}
					int input = scan.nextInt();

					// 3-1-2. input의 범위 확인
					if (input < 1 || input > 45) {
						System.out.println("범위(1~45)를 벗어났습니다. 다시 입력해주세요.");
						continue;
					}

					// 3-1-3. input의 중복 확인
					if (r.contains(user, input)) {
						System.out.println("이미 사용한 번호입니다. 다시 입력해주세요.");
						continue;
					}

					// 3-1-4. 유효한 입력이라면 user에 숫자를 넣고 while문 종료
					user[i] = input;
					break;
				}
				scan.nextLine(); // 한 번에 한 숫자씩만 입력받음
			}
		} else {
			// 3-2. 랜덤 생성
			System.out.println("컴퓨터가 숫자를 뽑습니다.");
			r.randomsD(user, 1, 45);
		}

		// 3. 출력
		printLotto(lotto);
		printLotto(user);
		System.out.println(rank(lotto, user));

		scan.close();
	}
}
