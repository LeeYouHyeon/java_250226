package day14;

import java.util.HashMap;
import java.util.Iterator;

public class Map01 {
	public static void main(String[] args) {
		/* Map
		 * - ���� 2�� ������ ���� key / value
		 * - key : �ߺ� �Ұ�, value : �ߺ� ����
		 * - HashMap�� ���� ���� ���
		 * 
		 * HashMap<Ŭ����, Ŭ����> map = new HashMap<>();
		 * - ���� 2���̱� ������, ���� for���̳� iterator�� �� �� ����
		 * - map => key => set���� ���� �� ���
		 * 
		 * list, set => �߰� add() / map => �߰� put()
		 * get(key) => value
		 * remove(key) => �����ϸ鼭 value�� ����
		 * */
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("apple", 2000);
		map.put("banana", 3000);
		map.put("orange", 1000);
		map.put("apple", 5000);
		map.put("peach", 4000);
		map.put("kiwi", 1500);
		
		System.out.println(map);
		System.out.println(map.keySet()); // ���� ���
		System.out.println(map.values());
		
		//get(key) => value
		System.out.println(map.get("apple"));
		
		// ���� for
		int sum = 0;
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
			sum += map.get(key);
		}
		System.out.println("�� " + sum);	
		System.out.println();
		
		// Iterator ���
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		
		// remove(object) : key���� �ָ� ���� => value ����
		System.out.println(map.remove("apple"));
		System.out.println(map);
		System.out.println(map.remove("a")); // null
		System.out.println(map);
		System.out.println(map.remove("banana", 3000)); // true/false
		System.out.println(map);
	}
}
