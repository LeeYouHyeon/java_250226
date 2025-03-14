package day05;

public class ArrayEx03 {
	public static void main(String[] args) {
		// 배열 10개 => 1부터 100까지의 랜덤 수 저장
		// 출력
		// 오름차순 정렬 후 출력

		// 1. 배열 초기화
		int arr[] = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 100 + 1);
		}

		// 2. 배열 출력
		System.out.print("arr : ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		// 3. 배열 정렬
		for (int i = 0; i < 9; i++) {
			for (int j = i; j < 10; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		// 4. 정렬한 배열 출력
		System.out.print("arr : ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
