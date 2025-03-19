package day15;

import java.util.HashMap;

public class Lambda02 {
	public static void main(String[] args) {
		// map�� �����Ͽ� forEach�� ���

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String name : new String[] { "�浿", "����", "����", "ö��", "��ö", "����" }) {
			map.put(name, (int)(Math.random()*101));
		}
		
		map.forEach((name, score) -> System.out.println(name + " : " + score));
		
		Number max = (a, b) -> (a > b) ? a : b;
		
		int hap = max.add(10, 30);
		System.out.println(hap);
		
		System.out.println(max.add(50, 60));
	}
}

// ���ٿ� �Լ��� �������̽� ����
// �޼���� 1����
@FunctionalInterface
interface Number {
	// �޼��� �߰�
	int add(int a, int b);
}