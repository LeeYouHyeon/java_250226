package day14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Set01 {
	public static void main(String[] args) {
		/* Set : 순서를 보장하지 않음 (index가 없음)
		 * 	=> 중복, 정렬 불가능
		 * HashSet(대표) / TreeSet(정렬이 가능한 set)
		 * */
		
		HashSet<String> set = new HashSet<String>();
		
		//add() : set에 객체 추가
		set.add("apple");
		set.add("banana");
		set.add("apple");
		set.add("peach");
		set.add("orange");
		set.add("apple");
		System.out.println(set);
		
		// get(), set() 등등 index를 쓰는 메서드를 쓸 수 없음
		for(String fruit : set) {
			System.out.println(fruit);
		}
		System.out.println();
		
		// Iterator 출력 가능
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
		// 정렬 : set은 순서가 없기 때문에 정렬 불가능
		// set => list로 변환하여 정렬
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		System.out.println(list);
		
		// list.sort()로 내림차순 정렬
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println(list);
	}
}
