package day03;

public class For02 {

	public static void main(String[] args) {
		// for ����
		// 1���� 10���� ���
		// for(�ʱ�ȭ; ���ǽ�; ������) {
		// ���๮;
		// }
		// ���ǽ��� ���̾�� ���� (true�� �� �� �ְ� ����)
		// �ʱ�ȭ�� ������ ���ǽ��� �����ϸ� ���� -> ������(����/����)
		// ������ ������ �ٽ� ���ǽ� �� -> �����ϸ� ���� -> ������(����/����)
		// ... ���ǽ� �� -> �Ҹ����ϸ� ����

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		System.out.println("-----------------");
		// 1���� 10���� ¦���� ���
		for (int i = 1; i <= 5; i++) {
			System.out.println(2 * i);
		}
		
		System.out.println("-----------------");
		// 1���� 10������ �հ� ���
		// �⺻ �ڷ����� ���� ������ �ݵ�� �ʱ갪�� �־�� �Ѵ�. ���ڴ� ���� 0�̳� 1, ����(String)�� null�� ���
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println("-----------------");
		// 1~10�� ¦�� ��, Ȧ�� ���� ���� ���
		int even = 0;
		int odd = 0;
		
		for(int i = 1; i <= 10; i++) {
			switch(i%2) {
				case 0:
					even += i;
					break;
				default:
					odd += i;
			}
		}
		System.out.println("¦�� �� : " + even);
		System.out.println("Ȧ�� �� : " + odd);
		
		System.out.println("-----------------");
	}

}
