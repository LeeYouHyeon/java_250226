package day05;

import java.text.DecimalFormat;

public class Array03 {

	public static void main(String[] args) {
		// arr �迭�� �հ�� ��� ���
		// �ִ񰪰� �ּڰ� ���

		// arr: ������ ������ �迭. ������ ������ 1~20
		int length = (int) (Math.random() * 20 + 1);
		int arr[] = new int[length];

		// arr�� �� ���� ������ 0~100
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 101);
		}

		int sum = 0, max = arr[0], min = arr[0];
		System.out.print("arr[" + length + "] = ");
		for (int num : arr) {
			// �迭 ���
			System.out.print(num + " ");

			// �հ� ���
			sum += num;

			// �ִ� ����
			if (num > max) {
				max = num;
			}

			// �ּڰ� ����
			if (num < min) {
				min = num;
			}
		}

		// ������ ������ ����
		// �ֿܼ��� ���� ���� �ٲٴ� �޼���. �ǹ����� �� ���� ����
		DecimalFormat df = new DecimalFormat("#.0");

		// ���
		System.out.println();
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + df.format(sum / (double) length));
		System.out.println("�ִ� : " + max);
		System.out.println("�ּڰ� : " + min);
	}

}
