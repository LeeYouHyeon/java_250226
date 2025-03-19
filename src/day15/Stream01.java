package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Stream01 {
	public static void main(String[] args) {
		/* Stream(��Ʈ��)
		 * - �ڷᱸ���� �����Ͽ� ��Ʈ�� ��ü�� ����
		 * - ��Ʈ���� �̿��Ͽ� ������ ����
		 * - ������ ������ ��Ʈ���� �Ҹ��
		 * - ��Ʈ���� ���� �ڷḦ ������ �� ����
		 * - �޼��� ü�̴� ����� ���
		 * - ��Ʈ������ ������ ������ ����
		 * - �߰����� / ��������
		 * - �� ��Ʈ���� ����� ���̿��� ���� �̸��� ������ ����� �� ����
		 * 
		 * - �߰����� : �޼��带 �̾ ��밡��, ������ ������� ��찡 ����
		 * 	- filter() : ���ǿ� �´� ���� ���� �޼���� �ѱ�
		 * 	- distinct() : �ߺ� ����
		 *  - limit() : ��Ʈ���� �Ϻθ� �߶�
		 *  - sorted() : ����
		 *  - map() : �ַ� ����ȯ
		 *  - peek() : �۾�����
		 *  - skip() : ��Ʈ�� �Ϻθ� �ǳʶ�
		 * 
		 * - �������� : �ݵ�� �������� �ϳ���
		 * 	- forEach(), count(), sum(), average(), max(), min()
		 * 	- allMatch() : ��Ʈ�� ��Ұ� ��� ��ġ�ϴ���
		 * 	- anyMatch() : �ϳ��� ��ġ�ϴ���
		 * 	- toArray() : array�� ��ȯ
		 * 	- toList() : ����Ʈ�� ��ȯ
		 *  - collect() : ����
		 * */

		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(Arrays.stream(arr).sum());
		System.out.println(Arrays.stream(arr).count());
		System.out.println(Arrays.stream(arr).average());

		// 5 �̻� �հ�
		System.out.println(Arrays.stream(arr).filter(n -> n >= 5).sum());

		// ���� �迭�� ������ �� 70�� �̻� ������ �հ�, ���
		// ���� ���� ������ ���
		int arr2[] = new memos.Randoms().randoms(5, 0, 100);
		for (int num : arr2) {
			System.out.print(num + " ");
		}
		System.out.println();

		// �հ�
		System.out.print("70�� �̻��� �հ� : ");
		System.out.println(Arrays.stream(arr2).filter(n -> n >= 70).sum());
		System.out.print("70�� �̻��� ��� : ");
		System.out.println(Arrays.stream(arr2).filter(n -> n >= 70).average().orElse(0));
		System.out.print("1�� : ");
		System.out.println(Arrays.stream(arr2).max().orElse(0));

		// 
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num : new memos.Randoms().randoms(15, 1, 9)) {
			list.add(num);
		}

		// list�� ��Ʈ������ ����
		list.stream()
			.sorted()
			.forEach(n -> System.out.print(n + " "));
		System.out.println();
		// �ߺ�����
		list.stream()
			.distinct()
			.forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		// �ߺ����� �� �հ�
		System.out.println(list.stream()
								.distinct()
								.mapToInt(n -> n.intValue())
								.sum());
		
		// ��Ʈ�� ��ü ����
		Stream<Integer> stream01 = Stream.of(10, 20, 30, 40, 50);
		System.out.println(stream01.mapToInt(n -> n.intValue()).sum());
		
		// �̹� ��Ʈ���� �Ҹ��. ���� stream01 ���Ұ�
		System.out.println(Stream.of(10, 20, 30, 40, 50)
								.mapToInt(n -> n.intValue())
								.average().orElse(0));
	}
}
