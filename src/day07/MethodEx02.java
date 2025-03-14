package day07;

import memos.Randoms;

public class MethodEx02 {

	// 입력되는 정수 배열을 출력하는 메서드
	public static void printArray(int[] arr) {
		System.out.print("arr : " + arr[0]);
		for (int i = 1; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

		System.out.println();
	}

	// 입력되는 정수 배열을 오름차순 정렬하는 메서드
	public static void sortArray(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		Randoms ran = new Randoms();
		int arr[] = ran.randoms(5, 0, 100);

		// arr을 출력
		printArray(arr);

		// arr을 정렬하고 출력
		sortArray(arr);
		System.out.println("정렬 후");
		printArray(arr);
	}

}
