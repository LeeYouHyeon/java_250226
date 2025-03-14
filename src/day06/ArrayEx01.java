package day06;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* 야구게임
		 * 컴퓨터가 3자리의 숫자를 생성 => 배열로 저장
		 * - 각 자릿수는 0~9, 중복되지 않음
		 * 유저는 3자리 숫자를 입력하여 맞추는 게임
		 * - 중복되지 않게 3자리 입력
		 * 자리와 숫자가 일치하면 S, 숫자는 있으나 자리가 다르면 B, 없으면 out
		 * -> ㅁS ㅁB / out / 정답 출력
		 * */

		int game		= 3, 				// 맞혀야 할 숫자의 갯수
			com[]		= new int[game],	// 실제 숫자 목록
			user[]		= new int[game],	// 유저 입력
			result[]	= new int[2],		// result = {스트라이크, 볼} (input: while)
			list[],							// 가능한 숫자들의 목록(0~9)
			count		= 0;				// 맞추기까지 걸린 횟수
		String resultStr; 					// 각 입력 당 출력할 결과문(1S 1B, out, ...)
		Scanner scan = new Scanner(System.in);

		// 0. 게임 설명
		System.out.println("한 자리 숫자 " + game + "개를 띄어쓰기로 구분하여 입력해주세요.");
		System.out.println("입력하는 숫자들은 중복되면 안 됩니다.");
		System.out.println("예)1 2 3");

		// 1. 중복되지 않는 3개의 한 자리 숫자를 생성
		// 1-1) 0~9까지의 array를 생성 : list
		list = new int[10];
		for (int i = 0; i < 10; i++) {
			list[i] = i;
		}
		// 1-2) 랜덤하게 한 숫자를 뽑고, 이를 list에서 제외
		// 제외하는 방법 : 선택된 수를 아직 교체되지 않은 숫자들 중 끝점과 교체한 후 랜덤의 범위를 줄임
		for (int i = 0; i < game; i++) {
			int choice = (int) (Math.random() * (10 - i)), temp = list[choice];
			com[i] = temp;
			list[choice] = list[9 - i];
			list[9 - i] = temp;
		}

		input: while (true) {
			// 2. 점수판, 결과문 초기화
			result[0] = 0;
			result[1] = 0;
			resultStr = "";

			// 3. 유저 입력
			System.out.print(count + 1 + "> ");
			for (int i = 0; i < game; i++) {
				user[i] = scan.nextInt();
			}
			// 3-1. 중복값을 입력하면 입력을 다시 받음
			for (int i = 0; i < game - 1; i++) {
				for (int j = i + 1; j < game; j++) {
					if (user[i] == user[j]) {
						System.out.println("중복된 값을 입력하셨습니다.");
						continue input;
					}
				}
			}
			count++; // 제대로 입력을 받았으면 count를 증가

			// 4. 점수 계산
			for (int i = 0; i < game; i++) {
				if (user[i] == com[i]) {
					result[0]++;
				} else {
					for (int j = 0; j < game; j++) {
						if (user[i] == com[j]) {
							result[1]++;
						}
					}
				}
			}
			
			// 전부 스트라이크면 게임 종료
			if (result[0] == game) {
				break;
			}
			
			// 5. 결과문 작성
			boolean bothSB = false;
			// 5-1. 스트라이크가 있으면 스트라이크 정보 추가
			if (result[0] > 0) {
				resultStr += result[0] + "S";
				bothSB = true;
			}
			// 5-2. 볼이 있으면 볼 정보 추가
			if (result[1] > 0) {
				// 스트라이크와 볼이 둘 다 있을 경우 사이에 공백 추가
				if (bothSB) {
					resultStr += " ";
				}
				resultStr += result[1] + "B";
			}

			// 6. 결과문 출력
			System.out.println(resultStr.isBlank() ? "out" : resultStr);
		}

		System.out.println("정답");
		System.out.println("횟수 : " + count);
		scan.close();
	}

}
