package day05;

import java.text.DecimalFormat;

public class Array04 {

	public static void main(String[] args) {
		/* 10개의 값을 가지는 배열을 생성
		 * 1~50까지의 랜덤 수를 배열에 저장 => 출력
		 * 합계, 평균, 최대, 최소 출력
		 * */

		int length = 10;
		int arr[] = new int[length];

		// arr의 각 값의 범위는 1~50
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 50) + 1;
		}

		int sum = 0, max = arr[0], min = arr[0];
		System.out.print("arr[" + length + "] = ");
		for (int num : arr) {
			// 배열 출력
			System.out.print(num + " ");

			// 합계 계산
			sum += num;

			// 최댓값 갱신
			if (num > max) {
				max = num;
			}

			// 최솟값 갱신
			if (num < min) {
				min = num;
			}
		}

		// 정수의 형식을 변경
		// 콘솔에서 보기 좋게 바꾸는 메서드. 실무에선 잘 쓰지 않음
		DecimalFormat df = new DecimalFormat("#.0");

		// 출력
		System.out.println();
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + df.format(sum / (double) length));
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
	}

}
