package day05;

public class ArrayEx03 {
	public static void main(String[] args) {
		// �迭 10�� => 1���� 100������ ���� �� ����
		// ���
		// �������� ���� �� ���

		// 1. �迭 �ʱ�ȭ
		int arr[] = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random() * 100 + 1);
		}

		// 2. �迭 ���
		System.out.print("arr : ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();

		// 3. �迭 ����
		for (int i = 0; i < 9; i++) {
			for (int j = i; j < 10; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		// 4. ������ �迭 ���
		System.out.print("arr : ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
