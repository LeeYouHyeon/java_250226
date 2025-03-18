package day14;

import java.util.HashMap;
import java.util.Map;

public class MapEx01 {
	// 1.
	public void fill(Map<String, Integer> map) {
		map.put("����", 500);
		map.put("����", 1000);
		map.put("����", 3000);
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
		System.out.println("�հ� " + sum);
	}
	
	public static void main(String[] args) {
		/* ��ǰ�� ������ �߰��Ͽ� �հ踦 ���Ͻÿ�.
		 * 1. main�� map�� �����ϰ�, �޼���� �����͸� ä��
		 * 	=> �Ű������� map�� �޾� �����͸� ä��� �޼���
		 * 
		 * 2. �޼��� ���ο��� map�� �����Ͽ� main���� �����ϴ� ����
		 * 
		 * 3. map�� �޾Ƽ� ����ϴ� �޼���(�հ赵 ���)
		 * ex)
		 * ���� 500
		 * ���� 1000
		 * ���� 3000
		 * �հ� : 4500
		 * */
		MapEx01 m = new MapEx01();
		Map<String, Integer> map = new HashMap<String, Integer>();
		m.fill(map);
		m.printMap(map);
	}
	
}
