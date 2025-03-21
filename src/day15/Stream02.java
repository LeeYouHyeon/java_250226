package day15;

import java.util.Arrays;

public class Stream02 {
	public static void main(String[] args) {
		/* 배열에서 짝수만 정렬하여 출력
		 * */
		
		int arr[] = new memos.Randoms().randoms(20, 1, 20);
		
		// 출력
		Arrays.stream(arr)
			.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// 중복 제거, 정렬 후 짝수만 출력
		Arrays.stream(arr)
			.distinct()
			.filter(n -> n % 2 == 0)
			.sorted()
			.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// 스트림으로 생성하여, 중복 제거하고 정렬하여 홀수만 배열로 리턴
		int arr2[] = Arrays.stream(arr)
				.filter(n -> n % 2 == 1)
				.distinct()
				.sorted()
				.toArray();
		
		for(int num : arr2) {
			System.out.print(num + " ");
		}
	}
}
