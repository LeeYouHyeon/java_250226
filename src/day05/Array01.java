package day05;

public class Array01 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* �迭 : ���� Ÿ��, ���� �ǹ̸� ������ �������� ���� (���� ����)
		 * ��ü�� �����ϴ� Ű���� => new
		 * 
		 * - �迭�� �����ϴ� ���
		 * Ÿ��[] �迭��;
		 * Ÿ�� �迭��[];
		 * 
		 * - ���� �� �ʱ�ȭ : ��ü�� �����ϸ� �ڵ� �ʱ�ȭ(0, null)
		 * Ÿ��[] �迭�� = new Ÿ��[����];				: ���� ���� ����ϴ� ���
		 * Ÿ��[] �迭�� = new Ÿ��[]{��, ��, ��, ..., ��};	: ���̸� ���� ����
		 * Ÿ��[] �迭�� = {��, ��, ��, ..., ��};			: ������
		 * 
		 * - �迭�� ���̴� 0 �̻�
		 * - �迭�� ����(index)�� 0���� ����
		 * - �迭��[5] => 0 1 2 3 4
		 * - �迭�� �� ���� => �迭��.length
		 * */

		int arr[]; // ����
		arr = new int[5]; // ���� �� ����

		int[] arr1 = new int[5]; // ����� ���ÿ� ����
		int arr2[] = new int[] { 1, 2, 3, 4, 5 };
		int arr3[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

		/* �迭�� ���̰� 5 => 0 1 2 3 4
		 * - ��� �迭�� ������ index = length - 1
		 * �迭�� ����ϴ� ����
		 * - ������ ���ϴ�.
		 * - �ݺ����� ����� �� �ֱ� ������ ���� ���� �����͸� ���� ������ �� �ִ�.
		 * */

		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
//		arr[5] = 60; // arr�� ���̸� ���
		System.out.println(arr[0]);
		System.out.println(arr1[0]); // �⺻��

		System.out.println("--for���� �̿��� array ���--");
		System.out.println("arr");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("arr3");
		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();

		arr[0] = 99; // �����
		System.out.println("arr");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// arr1�� 1 2 3 4 5 ���� ���� �� ���
		System.out.println("--arr1�� ���� �ְ� ���--");
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = i + 1;
		}
		for(int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		
		// arr4 �迭�� ���� [10]
		// 1~10 ���� �� ���
		int[] arr4 = new int[10];
		for(int i = 0; i < arr4.length; i++) {
			arr4[i] = i + 1;
		}
		System.out.println("--arr4 ���� �� ���� �ְ� ���--");
		for(int i = 0; i < arr4.length; i++) {
			System.out.print(arr4[i] + " ");
		}

	}

}
