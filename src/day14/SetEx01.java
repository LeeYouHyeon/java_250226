package day14;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx01 {
	public static void main(String[] args) {
		/* Set에 로또 번호 6개 생성 후 출력
		 * */

		Set<Integer> set = new HashSet<Integer>();

		while (set.size() < 6) {
			set.add((int) (Math.random() * 45) + 1);
		}
		System.out.println(set);

		System.out.println("-----------------------");

		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		while (treeSet.size() < 6) {
			treeSet.add((int) (Math.random() * 45) + 1);
		}
		System.out.println(treeSet);
		
		// first() : 가장 앞에 있는 값(가장 작은 값)
		// last() : 가장 뒤에 있는 값(가장 큰 값)
		
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		
		// headSet(기준값) / tailSet(기준값) : 기준값의 앞쪽, 뒷쪽 값을 출력
		System.out.println(treeSet.headSet(20));
		System.out.println(treeSet.tailSet(20));
		
		// subSet(시작값, 끝값) : 검색 범위 출력(시작값은 포함, 끝값은 미포함)
		System.out.println(treeSet.subSet(10, 20));
	}
}
