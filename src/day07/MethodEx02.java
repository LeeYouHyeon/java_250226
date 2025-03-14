package day07;

import memos.Randoms;

public class MethodEx02 {

	// �ԷµǴ� ���� �迭�� ����ϴ� �޼���
	public static void printArray(int[] arr) {
		System.out.print("arr : " + arr[0]);
		for (int i = 1; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}

		System.out.println();
	}

	// �ԷµǴ� ���� �迭�� �������� �����ϴ� �޼���
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

		// arr�� ���
		printArray(arr);

		// arr�� �����ϰ� ���
		sortArray(arr);
		System.out.println("���� ��");
		printArray(arr);
	}

}
