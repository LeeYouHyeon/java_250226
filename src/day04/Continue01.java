package day04;

public class Continue01 {

	public static void main(String[] args) {
		// continue : ���, pass, skip ����
		/* 1~10���� ���, 5�� ����
		 * */

		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();

		/* 1~10 ¦���� ���(continue �̿�)
		 * */

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				continue;
			}
			System.out.println(i);
		}
	}

}
