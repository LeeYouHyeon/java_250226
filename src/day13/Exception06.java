package day13;

public class Exception06 {
	public static void main(String[] args) {
		int start = -100, count = 100, size = 2;
		try {
			for (int num : new Exception06().randoms(size, start, count)) {
				System.out.print(num + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/* size�� �Է¹޾� size��ŭ�� ���̸� ������ �迭�� ����
	 * �������� ä�� �迭�� ����
	 * �������� ������ start ~ start + count
	 * - size�� 0���� ������ ���ܹ߻�
	 * - count�� 0���� ������ ���ܹ߻�
	 * */

	public int[] randoms(int size, int start, int count) {
		if (size <= 0) {
			throw new RuntimeException("�迭�� ���̰� 0 �����Դϴ�.");
		} else if (count < 0) {
			throw new RuntimeException("���� ���� ������ 0���� �۽��ϴ�.");
		}

		int answer[] = new int[size];

		for (int i = 0; i < size; i++) {
			answer[i] = start + (int) (Math.random() * count);
		}
		return answer;
	}
}