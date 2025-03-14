package memos;

public class Randoms {
	// arr���� num�� �ִ��� Ȯ���ϴ� �޼���
	// ������ true, ������ false
	public boolean contains(int[] arr, int num) {
		for (int n : arr) {
			if (num == n)
				return true;
		}
		return false;
	}

	// start~end���� ������ ���� �ϳ��� return
	public int random(int start, int end) {
		if (start > end)
			return random(end, start);
		return (int) (Math.random() * (end - start + 1) + start);
	}

	// ���� ���� ���� �� �ʿ��� ��
	// �ߺ� ���
	public int[] randoms(int n, int start, int end) {
		if (start > end)
			return randoms(n, end, start);

		int arr[] = new int[n];
		randoms(arr, start, end);
		return arr;
	}

	// ���� ���� ���� �� �ʿ��� ��
	// �ߺ� ����
	// �������� �� ���� ������ �� ��� n�� ������ ����
	public int[] randomsD(int n, int start, int end) {
		if (start > end)
			return randomsD(n, end, start);

		if (n >= end - start)
			n = end - start + 1;

		int arr[] = new int[n];

		randomsD(arr, start, end);
		return arr;
	}

	// �̹� �ִ� �迭�� ���� ����� randoms
	public void randoms(int[] arr, int start, int end) {
		if (start > end) {
			randoms(arr, end, start);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random(start, end);
		}
	}

	// �̹� �ִ� �迭�� ���� ����� randomsD
	// arr�� �ʹ� ��ٸ� �ƹ� �ϵ� ���� ����
	public void randomsD(int[] arr, int start, int end) {
		if (start > end) {
			randomsD(arr, end, start);
			return;
		}

		if (arr.length > end - start + 1) {
			return;
		}

		// �ʱ�ȭ
		for (int i = 0; i < arr.length; i++) {
			arr[i] = start - 1;
		}

		// ���� �� ä���
		for (int i = 0; i < arr.length; i++) {
			int num;
			do {
				num = random(start, end);
			} while (contains(arr, num));
			arr[i] = num;
		}
	}
}
