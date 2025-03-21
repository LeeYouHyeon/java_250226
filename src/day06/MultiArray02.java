package day06;

public class MultiArray02 {
	public static void main(String[] args) {
		/* 2차원 배열
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9
		 * 10 11 12
		 * 13 14 15
		 * */

		int arrs[][] = new int[5][3];

		for (int i = 0; i < arrs.length; i++) {
			for (int j = 0; j < arrs[0].length; j++) {
				arrs[i][j] = i * 3 + j + 1;
			}
		}
		for (int[] arr : arrs) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		System.out.println("--------------------------");

		int arr1[][] = new int[5][3];
		// 1~50까지의 랜덤 수를 채워 출력
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				arr1[i][j] = (int) (Math.random() * 50 + 1);
			}
		}

		for (int[] nums : arr1) {
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}
}
