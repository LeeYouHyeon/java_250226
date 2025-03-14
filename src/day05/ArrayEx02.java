package day05;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* ���� �迭[10]
		 * 1~10���� ���� �� ���
		 * */

		int arr[] = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}

		// �迭�� ���� ���� �ڵ�
		// ������ �� index�� ��� ���� ���� �ٲ�
		for (int i = 0; i < 20; i++) { // ���ǽ��� ���ڴ� ���� Ƚ��
			int i1 = (int) (10 * Math.random()), i2 = (int) (10 * Math.random()), temp = 0;
			temp = arr[i1];
			arr[i1] = arr[i2];
			arr[i2] = temp;
		}

		// �ٲ� ���� ��� ���
		System.out.println();
		System.out.println("---------------------");
		for (int num : arr) {
			System.out.print(num + " ");
		}

		// ���� ���� ������� ���� (����)
		// ���� ������ ���� => �������� (�⺻��)
		// ū ������ ���� => ��������

		// ���� ���
		// 5 8 4 2 7 9 6 10 3 1
		// 1 8 5 4 7 9 6 10 3 2 - pass 1
		// 1 2 8 5 7 9 6 10 4 3 - pass 2
		// 1 2 3 8 7 9 6 10 5 4 - pass 3
		// 1 2 3 4 8 9 7 10 6 5 - pass 4
		// 1 2 3 4 5 9 8 10 7 6 - pass 5
		// 1 2 3 4 5 6 9 10 8 7 - pass 6
		// 1 2 3 4 5 6 7 10 9 8 - pass 7
		// 1 2 3 4 5 6 7 8 10 9 - pass 8
		// 1 2 3 4 5 6 7 8 9 10 - pass 9

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {	// > �������� / < ��������
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println();
		System.out.println("---------------------");
		for (int num : arr) {
			System.out.print(num + " ");
		}

	}

}
