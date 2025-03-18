package day14;

import java.util.HashMap;
import java.util.Iterator;

public class Map01 {
	public static void main(String[] args) {
		/* Map
		 * - 값을 2개 쌍으로 저장 key / value
		 * - key : 중복 불가, value : 중복 가능
		 * - HashMap을 가장 많이 사용
		 * 
		 * HashMap<클래스, 클래스> map = new HashMap<>();
		 * - 값이 2개이기 때문에, 향상된 for문이나 iterator를 쓸 수 없음
		 * - map => key => set으로 구성 후 출력
		 * 
		 * list, set => 추가 add() / map => 추가 put()
		 * get(key) => value
		 * remove(key) => 삭제하면서 value를 리턴
		 * */
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("apple", 2000);
		map.put("banana", 3000);
		map.put("orange", 1000);
		map.put("apple", 5000);
		map.put("peach", 4000);
		map.put("kiwi", 1500);
		
		System.out.println(map);
		System.out.println(map.keySet()); // 자주 사용
		System.out.println(map.values());
		
		//get(key) => value
		System.out.println(map.get("apple"));
		
		// 향상된 for
		int sum = 0;
		for(String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
			sum += map.get(key);
		}
		System.out.println("총 " + sum);	
		System.out.println();
		
		// Iterator 출력
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		
		// remove(object) : key값을 주면 삭제 => value 리턴
		System.out.println(map.remove("apple"));
		System.out.println(map);
		System.out.println(map.remove("a")); // null
		System.out.println(map);
		System.out.println(map.remove("banana", 3000)); // true/false
		System.out.println(map);
	}
}
