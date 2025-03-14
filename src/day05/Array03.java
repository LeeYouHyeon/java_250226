package day05;

import java.text.DecimalFormat;

public class Array03 {

	public static void main(String[] args) {
		// arr 배열의 합계와 평균 출력
		// 최댓값과 최솟값 출력

		// arr: 랜덤한 길이의 배열. 길이의 범위는 1~20
		int length = (int) (Math.random() * 20 + 1);
		int arr[] = new int[length];

		// arr의 각 값의 범위는 0~100
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 101);
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
