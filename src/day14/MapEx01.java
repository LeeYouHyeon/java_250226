package day14;

import java.util.HashMap;
import java.util.Map;

public class MapEx01 {
	// 1.
	public void fill(Map<String, Integer> map) {
		map.put("연필", 500);
		map.put("가위", 1000);
		map.put("물감", 3000);
	}

	// 2.
	public Map<String, Integer> fill() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		fill(map);
		return map;
	}
	
	// 3. 
	public <T> void printMap(Map<T, Integer> map) {
		int sum = 0;
		for(T key : map.keySet()) {
			int value = map.get(key);
			System.out.println(key + " " + value);
			sum += value;
		}
		System.out.println("합계 " + sum);
	}
	
	public static void main(String[] args) {
		/* 상품과 가격을 추가하여 합계를 구하시오.
		 * 1. main에 map을 생성하고, 메서드로 데이터를 채움
		 * 	=> 매개변수로 map을 받아 데이터를 채우는 메서드
		 * 
		 * 2. 메서드 내부에서 map을 생성하여 main으로 리턴하는 형태
		 * 
		 * 3. map을 받아서 출력하는 메서드(합계도 출력)
		 * ex)
		 * 연필 500
		 * 가위 1000
		 * 물감 3000
		 * 합계 : 4500
		 * */
		MapEx01 m = new MapEx01();
		Map<String, Integer> map = new HashMap<String, Integer>();
		m.fill(map);
		m.printMap(map);
	}
	
}
