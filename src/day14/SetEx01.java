package day14;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx01 {
	public static void main(String[] args) {
		/* Set�� �ζ� ��ȣ 6�� ���� �� ���
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
		
		// first() : ���� �տ� �ִ� ��(���� ���� ��)
		// last() : ���� �ڿ� �ִ� ��(���� ū ��)
		
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		
		// headSet(���ذ�) / tailSet(���ذ�) : ���ذ��� ����, ���� ���� ���
		System.out.println(treeSet.headSet(20));
		System.out.println(treeSet.tailSet(20));
		
		// subSet(���۰�, ����) : �˻� ���� ���(���۰��� ����, ������ ������)
		System.out.println(treeSet.subSet(10, 20));
	}
}
