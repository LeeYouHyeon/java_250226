package day04;

public class For07 {

	public static void main(String[] args) {
		// for / while
		/* for���� �̿��Ͽ� ������ 5���� ���
		 * 
		 * */

		// ���� for��
//		for(int dan = 2; dan <= 9; dan++) {
//			for(int i = 1; i <= 9; i++) {
//				System.out.print(dan + "*" + i + " = " + dan*i + " ");
//			}
//			System.out.println("");
//		}

		for (int i = 1; i <= 9; i++) {
			for (int dan = 2; dan <= 9; dan++) {
				System.out.print(dan + "*" + i + " = " + dan * i + " 	");
			}
			System.out.println("");
		}
	}

}
