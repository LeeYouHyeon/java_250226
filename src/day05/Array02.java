package day05;

import java.util.Scanner;

public class Array02 {

	public static void main(String[] args) {
		/* 5명의 점수를 입력
		 * 1. 배열을 생성
		 * 2. 배열에 점수 입력받기
		 * 3. 배열을 출력
		 * 4. 점수의 합계 / 평균
		 * */
		
		// 1. 배열을 생성
		Scanner scan = new Scanner(System.in);
		int scores[] = new int[5], sum = 0;

		// 2. 배열에 점수 입력받기
		System.out.println("5명의 점수를 입력해주세요.");
		for (int i = 0; i < scores.length; i++) {
			System.out.print(i + 1 + "> ");
			scores[i] = scan.nextInt();
			sum += scores[i];
		}

		// 3. 배열을 출력
		System.out.print("점수 : ");
		for (int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();

		// 4. 점수의 합계와 평균 출력
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum / (double)scores.length);
		scan.close();
		
		// 향상된 for문
		// 번지로 접근이 불가능한 경우 사용
		// index를 활용한 기능을 쓸 수 없고 전체 탐색만 가능
		for(int num : scores) {
			System.out.print(num + " ");
		}
	}

}
