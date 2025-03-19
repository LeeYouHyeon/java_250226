package day15;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda01 {
	public static void main(String[] args) {
		// �ַ� javascript�̳� Spring Boot���� ���
		// Lambda + Stream : ���ٽ� (���� �ܼ��ϰ� ǥ���ϴ� ���)
		
		/* lambda : �ܺ� �ڷῡ �μ����� ����(side effect)�� ���� �ʵ��� �����ϴ� ���
		 * stream : �ڷ��� ���� ������� ������ ������ ������ �� �ֵ��� ���ִ� �ݺ���
		 * - �޼��� ü�̴� ����� ���
		 * 
		 * lambda functions : ���� �Լ� => �͸� Ŭ������ ����Ͽ� ���� �Լ�
		 * ���� : �ڵ� ���Ἲ, ���� ó�� ����, ���ʿ��� ���� �ּ�ȭ
		 * ���� : �������� ������. �ݺ��� ��� �� ���� ����
		 * 
		 * - ���� ǥ����
		 * (�Ű�����) -> {����;}
		 * �Ű������� 1���� () ���� ����
		 * a -> {return a + 1;}
		 * (a, b) -> {return a + b;}
		 * 
		 * return�� ���� ��� {} ���� ����
		 * (a, b) -> a+b;
		 * x -> return x+1;	// ����
		 * 
		 * */
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 8; i++) {
			list.add(10*(i + 1));
		}
		
		for(Integer t : list) {
			System.out.print(t + " ");
		}
		System.out.println();
		
		// ���ٽ� ǥ��
		list.forEach(n -> System.out.print(n + " "));
		
		Consumer<Integer> print = n -> System.out.print(n + " ");
		System.out.println();
		list.forEach(print);
	}
}
