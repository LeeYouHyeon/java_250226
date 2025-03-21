package day13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListEx01 {
	public static void main(String[] args) {
		String[] arr1 = new String[] {"c", "f", "a", "d"};
		String[] arr2 = new String[] {"e", "b", "g", "f"};
		
		// 두 배열(arr1, arr2)을 합쳐서 하나의 list로 생성
		// 정렬 후 출력
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
