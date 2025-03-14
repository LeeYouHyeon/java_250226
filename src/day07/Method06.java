package day07;

public class Method06 {
	// start���� end���� �� ������ ����
	public static int random(int start, int end) {
		if (start > end)
			return random(end, start);
		return (int) (Math.random() * (end - start + 1)) + 1;
	}

	// 1. �����ϰ� ������ ��� �迭�� �����Ͽ� �����ϴ� �޼���
	// ������ �� �ְų� n�� �� ���� �ִ�.
	// �⺻��: n = 5, start = 0, end = 100
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

	// 2. �迭�� �޾Ƽ� ����� �����ϴ� �޼���
	public static double avg(int[] arr) {
		int sum = 0;
		for (int num : arr) {
			sum += num;
		}
		return sum / (double) arr.length;
	}

	// 3. �迭 �� ��� ���
	// �迭�� ���� ������ ���Ƿ� �����ؼ� ���
	public static void printArr(int[] arr) {
		// �迭 ���
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		// ��� ���
		System.out.println(avg(arr));
	}

	public static void printArr() {
		printArr(randoms());
	}

	public static void main(String[] args) {
		// �޼��忡���� �迭 Ȱ��
		/* 1. �����ϰ� ����(1~50) 5���� ��� �迭�� �����Ͽ� �����ϴ� �޼���
		 * 2. �� �迭�� �Է¹޾Ƽ� ����� �����ϴ� �޼���
		 * 3. 1.���� ���� �迭�� ����ϰ�, 2.���� ���� ����� ����ϴ� �޼���*/
		printArr();
	}

}
