package day15;

import java.util.HashMap;

public class Lambda02 {
	public static void main(String[] args) {
		// map을 구성하여 forEach로 출력

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String name : new String[] { "길동", "영이", "순이", "철수", "영철", "순자" }) {
			map.put(name, (int)(Math.random()*101));
		}
		
		map.forEach((name, score) -> System.out.println(name + " : " + score));
		
		Number max = (a, b) -> (a > b) ? a : b;
		
		int hap = max.add(10, 30);
		System.out.println(hap);
		
		System.out.println(max.add(50, 60));
	}
}

// 람다용 함수형 인터페이스 생성
// 메서드는 1개만
@FunctionalInterface
interface Number {
	// 메서드 추가
	int add(int a, int b);
}