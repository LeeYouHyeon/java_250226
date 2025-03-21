package day07;

import java.util.Scanner;

public class Exam01 {
	public static void main(String[] args) {
		// day06.ArrayEx01을 메서드로 분리한 후 실행

		int comNum[] = new int[3], myNum[] = new int[3], count = 0, strike, ball;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			comNum[i] = -1;
		}

		// 1. 게임 설명
		System.out.println("한 자리 숫자 3개를 띄어쓰기로 구분하여 입력해주세요.");
		System.out.println("입력하는 숫자들은 중복되면 안 됩니다.");
		System.out.println("예)1 2 0");

		// 2. 중복되지 않는 3개의 한 자리 숫자를 생성
		fill(comNum);

		// 게임 진행
		input: while (true) {
			// 3. 유저 입력
			System.out.print(count + 1 + "> ");
			for (int i = 0; i < 3; i++) {
				myNum[i] = scan.nextInt();
			}
			// 3-1. 중복값을 입력하면 입력을 다시 받음
			for (int i = 0; i < myNum.length - 1; i++) {
				for (int j = i + 1; j < myNum.length; j++) {
					if (myNum[i] == myNum[j]) {
						System.out.println("중복된 값을 입력하셨습니다.");
						continue input;
					}
				}
			}
			count++; // 제대로 입력을 받았으면 count를 증가

			// 4. 점수 계산
			strike = countStrike(comNum, myNum);
			if (strike == 3) { // 정답
				break;
			}
			ball = countBall(comNum, myNum);

			// 5. 결과문 작성
			String result = "";
			if (strike == 0 && ball == 0) {
				result = "out";
			} else {
				if (strike > 0) {
					result += strike + "S";
				}
				if (strike * ball > 0) {
					result += " ";
				}
				if (ball > 0) {
					result += ball + "B";
				}
			}

			System.out.println(result);
		}

		// 정답 처리
		System.out.println("정답");
		System.out.println("횟수 : " + count);
		scan.close();
	}

	/* 빈 배열을 입력받아 랜덤으로 값이 중복되지 않게 채우기 
	 * 랜덤 값은 0~9
	 * */
	public static void fill(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int insert = Method06.random(0, 9);
			if (contains(arr, insert)) {
				i--;
			} else {
				arr[i] = insert;
			}
		}
	}

	/* 중복확인 메서드
	 * 미완성 배열과 랜덤값을 입력받음
	 * 배열에 랜덤값이 존재하면 true, 없으면 false
	 * */
	public static boolean contains(int[] arr, int num) {
		for (int in : arr) {
			if (in == num) {
				return true;
			}
		}

		return false;
	}

	/* 스트라이크 갯수를 세는 메서드
	 * 매개변수 : int[] comNum, int[] myNum
	 * count 값을 리턴
	 * */
	public static int countStrike(int[] comNum, int[] myNum) {
		int answer = 0;
		for (int i = 0; i < comNum.length; i++) {
			if (comNum[i] == myNum[i]) {
				answer++;
			}
		}

		return answer;
	}

	/* 볼 갯수를 세는 메서드
	 * 매개변수 : int[] comNum, int[]myNum
	 * count 값을 리턴
	 * */
	public static int countBall(int[] comNum, int[] myNum) {
		int answer = 0;
		for (int i = 0; i < comNum.length; i++) {
			for (int j = 0; j < myNum.length; j++) {
				if (i != j && comNum[i] == myNum[j]) {
					answer++;
				}
			}
		}

		return answer;
	}
}
