package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class List02 {
	public static void main(String[] args) {
		/* List ���� �� 1~10 ä�� �� ���
		 * */
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}
		System.out.println(list);
		
		// for������ ��� ���
		for (int i = 0; i < 10; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// ���� for������ ��� ���
		for (int num : list) { // ���� ��ڽ�
			System.out.print(num + " ");
		}
		System.out.println("\n");
		
		// Iterator : index�� ���� ���� ����ϱ� ���� ���
		// list�� index�� ������, set�̳� map�� index�� ��� iterator�� ���� for���� ����ؾ� ��
		// ������ ������� ���� ������ �� �ִ� ������ ���
		// map�� ���� for, iterator ���� ��� �Ұ���
		System.out.println("iterator");
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		// indexOf(��) : �ش� ���� index / ������ -1
		System.out.println(list.indexOf(11));
		
		// Collections.sort(list) : ���� => ���������� ����
		list.clear();
		list.add(45);
		list.add(78);
		list.add(12);
		list.add(56);
		list.add(35);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		// list.sort(Comparator�� ������ ��ü); : ����
		// Comparator �������̽��� ������ ����ü�� �־�� ��(�ַ� �͸� Ŭ���� ���)
		// compareTo() �޼��带 �����Ͽ� ��ü�� ����
		// - compareTo : ������ �տ� ������ -1, �ڿ� ������ 1
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// o1 - o2 : ��������, o2 - o1 : ��������
				// ����� -�� ������ ������, +�� �ڷ� ������ ����
				return o2 - o1;
			}
		});
		System.out.println(list);
	}
}