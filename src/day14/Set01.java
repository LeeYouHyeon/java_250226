package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Set01 {
	public static void main(String[] args) {
		/* Set : ������ �������� ���� (index�� ����)
		 * 	=> �ߺ�, ���� �Ұ���
		 * HashSet(��ǥ) / TreeSet(������ ������ set)
		 * */
		
		HashSet<String> set = new HashSet<String>();
		
		//add() : set�� ��ü �߰�
		set.add("apple");
		set.add("banana");
		set.add("apple");
		set.add("peach");
		set.add("orange");
		set.add("apple");
		System.out.println(set);
		
		// get(), set() ��� index�� ���� �޼��带 �� �� ����
		for(String fruit : set) {
			System.out.println(fruit);
		}
		System.out.println();
		
		// Iterator ��� ����
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
		// ���� : set�� ������ ���� ������ ���� �Ұ���
		// set => list�� ��ȯ�Ͽ� ����
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		System.out.println(list);
		
		// list.sort()�� �������� ����
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(list);
	}
}
