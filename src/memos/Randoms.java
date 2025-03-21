package memos;

public class Randoms {
	// arr에서 num이 있는지 확인하는 메서드
	// 있으면 true, 없으면 false
	public boolean contains(int[] arr, int num) {
		for (int n : arr) {
			if (num == n)
				return true;
		}
		return false;
	}

	// start~end에서 랜덤한 정수 하나를 return
	public int random(int start, int end) {
		if (start > end)
			return random(end, start);
		return (int) (Math.random() * (end - start + 1) + start);
	}

	// 랜덤 수가 여러 개 필요할 때
	// 중복 허용
	public int[] randoms(int n, int start, int end) {
		if (start > end)
			return randoms(n, end, start);

		int arr[] = new int[n];
		randoms(arr, start, end);
		return arr;
	}

	// 랜덤 수가 여러 개 필요할 때
	// 중복 불허
	// 범위보다 더 많이 뽑으려 할 경우 n을 강제로 줄임
	public int[] randomsD(int n, int start, int end) {
		if (start > end)
			return randomsD(n, end, start);

		if (n >= end - start)
			n = end - start + 1;

		int arr[] = new int[n];

		randomsD(arr, start, end);
		return arr;
	}

	// 이미 있는 배열을 받을 경우의 randoms
	public void randoms(int[] arr, int start, int end) {
		if (start > end) {
			randoms(arr, end, start);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random(start, end);
		}
	}

	// 이미 있는 배열을 받을 경우의 randomsD
	// arr가 너무 길다면 아무 일도 하지 않음
	public void randomsD(int[] arr, int start, int end) {
		if (start > end) {
			randomsD(arr, end, start);
			return;
		}

		if (arr.length > end - start + 1) {
			return;
		}

		// 초기화
		for (int i = 0; i < arr.length; i++) {
			arr[i] = start - 1;
		}

		// 랜덤 수 채우기
		for (int i = 0; i < arr.length; i++) {
			int num;
			do {
				num = random(start, end);
			} while (contains(arr, num));
			arr[i] = num;
		}
	}
}
