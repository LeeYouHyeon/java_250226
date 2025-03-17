package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class List03 {
	public static void main(String[] args) {
		/* ���� �Ϸ� �ϰ�(String)�� �����ϴ� list�� ����
		 * ��� => ���� for / iterator
		 * */
		List<String> day = new ArrayList<String>();
		for (String work : new String[] { "���", "���", "����", "����", "����", "���", "����", "����" }) {
			day.add(work);
		}

		// �Ϲ� for��
		for (int i = 0; i < day.size(); i++) {
			System.out.print(day.get(i) + " ");
		}
		System.out.println();

		// ���� for��
		for (String work : day) {
			System.out.print(work + " ");
		}
		System.out.println();

		// iterator
		Iterator<String> it = day.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

		// ����
		Collections.sort(day);
		System.out.println(day);
		day.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// compareTo
				// o1.compareTo(o2) : ��������
				// o2.compareTo(o1) : ��������
				return o2.compareTo(o1);
			}
		});

		System.out.println(day);
	}
}