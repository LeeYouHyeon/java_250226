package day13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListEx01 {
	public static void main(String[] args) {
		String[] arr1 = new String[] {"c", "f", "a", "d"};
		String[] arr2 = new String[] {"e", "b", "g", "f"};
		
		// �� �迭(arr1, arr2)�� ���ļ� �ϳ��� list�� ����
		// ���� �� ���
		List<String> list = new ArrayList<String>();
		
		for(String c : arr1) {
			list.add(c);
		}
		for(String c : arr2) {
			list.add(c);
		}
		
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		
		System.out.println(list);
	}
}
