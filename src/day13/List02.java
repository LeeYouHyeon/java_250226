package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class List02 {
	public static void main(String[] args) {
		/* List 생성 후 1~10 채운 후 출력
		 * */
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}
		System.out.println(list);
		
		// for문으로 요소 출력
		for (int i = 0; i < 10; i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// 향상된 for문으로 요소 출력
		for (int num : list) { // 오토 언박싱
			System.out.print(num + " ");
		}
		System.out.println("\n");
		
		// Iterator : index가 없는 값을 출력하기 위해 사용
		// list는 index가 있지만, set이나 map은 index가 없어서 iterator나 향상된 for문을 사용해야 함
		// 순서와 상관없이 값을 가져올 수 있는 구문을 사용
		// map은 향상된 for, iterator 직접 사용 불가능
		System.out.println("iterator");
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		
		// indexOf(값) : 해당 값의 index / 없으면 -1
		System.out.println(list.indexOf(11));
		
		// Collections.sort(list) : 정렬 => 오름차순만 가능
		list.clear();
		list.add(45);
		list.add(78);
		list.add(12);
		list.add(56);
		list.add(35);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		// list.sort(Comparator를 구현한 객체); : 정렬
		// Comparator 인터페이스를 구현한 구현체를 넣어야 함(주로 익명 클래스 사용)
		// compareTo() 메서드를 구현하여 객체를 정렬
		// - compareTo : 사전상 앞에 있으면 -1, 뒤에 있으면 1
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// o1 - o2 : 오름차순, o2 - o1 : 내림차순
				// 결과가 -면 앞으로 보내고, +면 뒤로 보내는 역할
				return o2 - o1;
			}
		});
		System.out.println(list);
	}
}