package day03;

public class While01 {

	public static void main(String[] args) {
		// while��
		/* while���� for���� ������ ������ ����
		 * for : ���� Ƚ���� ������ �ִ� ��� ���
		 * while : ���� Ƚ���� �������� ���� ��� ���
		 * 
		 * while(���ǽ�) { //���ǽ��� true�� �� �ݺ�
		 * 	���๮;
		 * }
		 * ���๮ �ȿ� ���ǽ��� �ٲ� �� �ִ� ��ȭ�� �־�� ��
		 * 
		 * */

		// 1���� 10���� ���
		int i = 1;
		while (i <= 10) {
			System.out.println(i++);
		}

		System.out.println("--------------");
		// 1���� 10���� �� ¦�� ���
		i = 2;
		while (i <= 10) {
			System.out.println(i);
			i += 2;
		}
		
		System.out.println("--------------");
		
	}

}
