package day09;

public class Method08 {
	public static void main(String[] args) {
		/* �������� �޼���
		 * - �Ű������� ������ �����Ǿ� ���� �ʴ� ��� ���
		 * */
		Method08 m8 = new Method08();
		
		System.out.println(m8.sum(1, 2, 3, 4, 5, 6, 7));
		System.out.println(m8.sum(9718,8671,4156,97182,452,2135,374186,86371));
		System.out.println(m8.sum(new int[]{1, 2, 3}));
	}

	public int sum(int... num) {
		// num�� int[]
		int result = 0;
		for (int tmp : num) {
			result += tmp;
		}
		return result;
	}
}
