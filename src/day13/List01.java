package day13;

import java.util.ArrayList;
import java.util.List;

public class List01 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// List => ArrayList
		// List<Ŭ������> ��ü�� = new ����Ŭ����<Ŭ������>();
		List<Integer> list = new ArrayList<Integer>();
		
		// add() : ��Ҹ� �߰�
		list.add(1); // ���� �ڽ� : int => Integer �ڽ̵ż� ����
		list.add(new Integer(2)); // ���� ��ü ���� �� ����
		list.add(3);
		
		System.out.println(list); // ��ü������ toString() ����
		
		// get(index) : index ������ ���� ��������
		System.out.println(list.get(0));	// arr[0]�� ���� �ǹ�
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		// set(index, ��) : index ������ �� �����ϱ�
		list.set(0, 5);
		// size() : list�� �� ����
		System.out.println("---for���� �̿��Ͽ� ���---");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// remove(index) : index ������ ���� ����
		// remove(object) : object ��Ҹ� ����
		list.remove(0);	// index�� ����
		System.out.println(list);
		list.remove(Integer.valueOf(3));
		System.out.println(list);
		
		// list1�� �����Ͽ�, 1~10���� �߰��ϰ� ���
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++) {
			list1.add(i);
		}
		System.out.println(list1);
		
		// index 4�� �ִ� ���� 11�� ����
		list1.set(4, 11);
		System.out.println(list1);
		
		// index 0�� �ִ� ��Ҹ� ����
		list1.remove(0);
		System.out.println(list1);
		
		list1.remove(Integer.valueOf(3));
		System.out.println(list1);
		
		// contains(object) : list�� object ���� �ִ��� üũ
		System.out.println(list1.contains(11));
		
		// clear() : ����Ʈ ���� (��� ���� ����)
		list1.clear();
		System.out.println(list1);
		
		// isEmpty() : ����Ʈ�� ����ִ��� üũ
		System.out.println(list1.isEmpty());
		System.out.println(list.isEmpty());
	}
}
