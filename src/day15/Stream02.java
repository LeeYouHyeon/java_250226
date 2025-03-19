package day15;

import java.util.Arrays;

public class Stream02 {
	public static void main(String[] args) {
		/* �迭���� ¦���� �����Ͽ� ���
		 * */
		
		int arr[] = new memos.Randoms().randoms(20, 1, 20);
		
		// ���
		Arrays.stream(arr)
			.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// �ߺ� ����, ���� �� ¦���� ���
		Arrays.stream(arr)
			.distinct()
			.filter(n -> n % 2 == 0)
			.sorted()
			.forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		// ��Ʈ������ �����Ͽ�, �ߺ� �����ϰ� �����Ͽ� Ȧ���� �迭�� ����
		int arr2[] = Arrays.stream(arr)
				.filter(n -> n % 2 == 1)
				.distinct()
				.sorted()
				.toArray();
		
		for(int num : arr2) {
			System.out.print(num + " ");
		}
	}
}
