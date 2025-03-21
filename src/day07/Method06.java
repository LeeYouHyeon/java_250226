package day07;

public class Method06 {
	// start부터 end까지 중 랜덤한 정수
	public static int random(int start, int end) {
		if (start > end)
			return random(end, start);
		return (int) (Math.random() * (end - start + 1)) + 1;
	}

	// 1. 랜덤하게 정수를 담는 배열을 생성하여 리턴하는 메서드
	// 변수를 안 주거나 n만 줄 수도 있다.
	// 기본값: n = 5, start = 0, end = 100
	public static int[] randoms(int n, int start, int end) {
		if (start > end)
			return randoms(n, end, start);

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = random(start, end);
		}
		return arr;
	}

	public static int[] randoms(int n) {
		return randoms(n, 0, 100);
	}

	public static int[] randoms() {
		return randoms(5);
	}

	// 2. 배열을 받아서 평균을 리턴하는 메서드
	public static double avg(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		return sum / (double) arr.length;
	}

	// 3. 배열 및 평균 출력
	// 배열을 주지 않으면 임의로 생성해서 출력
	public static void printArr(int[] arr) {
		// 배열 출력
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		// 평균 출력
		System.out.println(avg(arr));
	}

	public static void printArr() {
		printArr(randoms());
	}

	public static void main(String[] args) {
		// 메서드에서의 배열 활용
		/* 1. 랜덤하게 정수(1~50) 5개를 담는 배열을 생성하여 리턴하는 메서드
		 * 2. 그 배열을 입력받아서 평균을 리턴하는 메서드
		 * 3. 1.에서 만든 배열을 출력하고, 2.에서 만든 평균을 출력하는 메서드*/
		printArr();
	}

}
