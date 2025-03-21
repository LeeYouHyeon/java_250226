package memos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DistinctNumsArray {
	public static int random(int start, int end) {
		return (int) (Math.random() * (end - start) + start);
	}

	// start부터 end까지의 중복하지 않는 랜덤 수들의 array ... 실패
	public static int[] randomDistinctArray(int n, int start, int end) throws Exception {
		// 입력조건 검증
		// start <= end이고, 범위가 n 이상이어야 한다.
		if (start > end)
			return randomDistinctArray(n, end, start);
		if (end - start + 1 < n)
			throw new Exception();

		int answer[] = new int[n];

		for (int i = 0; i < n; i++) {
			answer[i] = random(start, end - i);
			for (int j = 0; j < i; j++) {
				if (answer[i] >= answer[j]) {
					answer[i]++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n, start, end, answer[];

		System.out.println("중복하지 않는 랜덤 숫자 생성기");
		
		while (true) {
			try {
				System.out.print("숫자를 몇 개 뽑고 싶은지 입력하세요.> ");
				while (true) {
					try {
						n = scan.nextInt();
						if (n <= 0) {
							throw new InputMismatchException();
						}
						break;
					} catch (InputMismatchException e) {
						System.out.println("자연수를 입력해주세요.");
					}
				}
				
				// start 입력
				while (true) {
					try {
						System.out.print("최솟값을 입력하세요.> ");
						start = scan.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("정수를 입력해주세요.");
					}
				}
				
				// end 입력
				while (true) {
					try {
						System.out.print("최댓값을 입력하세요.> ");
						end = scan.nextInt();
						if (end < start) {
							throw new Exception();
						}
						break;
					} catch (InputMismatchException e) {
						System.out.println("정수를 입력해주세요.");
					} catch (Exception e) {
						System.out.println("최댓값은 최솟값 이상이어야 합니다.");
					}
				}
				
				// array 생성
				answer = randomDistinctArray(n, start, end);
				break;
			} catch (Exception e) {
				System.out.println("범위보다 더 많이 뽑을 수 없습니다.");
			}
		}
		
		// array 출력
		for(int num : answer) {
			System.out.print(num + " ");
		}
		scan.close();
	}
}
