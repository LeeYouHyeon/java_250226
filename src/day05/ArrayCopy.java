package day05;

public class ArrayCopy {
	public static void main(String[] args) {
		/* �迭����
		 * ���� �迭�� 2�� ����
		 * �迭�� ���̴� ������ ����.
		 * */
		int arr[] = { 1, 2, 3, 4 }, arr1[] = arr;
		System.out.println(arr);
		System.out.println(arr1); // arr�� ���� �迭�� ����

		int[] arr2 = new int[4];
		System.out.println(arr2);

		System.out.println();
		System.out.print("arr : ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		arr[0] = 10;
		System.out.print("arr1 : ");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();

		// arr => arr2 ����

		for (int i = 0; i < arr.length; i++) {
			arr2[i] = arr[i];
		}
		System.out.print("arr2 : ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();
		
		// arraycopy() : arr => arr3
		int arr3[] = new int[7];
		System.arraycopy(arr, 1, arr3, 2, arr.length - 1);
		System.out.print("arr3 : ");
		for(int num : arr3) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
