package day02;

public class Switch01 {

	public static void main(String[] args) {
		/*
		 * switch(���� / ��) { case �� : ���๮; break; case �� : ���๮; break; case �� : ���๮;
		 * break; case �� : ���๮; break; ... default : ���๮; } break;�� ������ �������� �� ���, ����
		 * ���ǹ��� ����Ѵ�.(switch�� ��ü������ ���ǹ��� ������)
		 */

		// ¦�� Ȧ�� switch �������� ����
		int num;

		num = 2;

		switch (num % 2) {
			case 0:
				System.out.println("¦��");
				break;
			case 1:
				System.out.println("Ȧ��");
				break;
			default:
				System.out.println("�߸��� ���Դϴ�.");
		}

		System.out.println("----------------");

		/*
		 * num1�� ���� 1, 2, 3�̶�� ���� 1�̸� 1ĭ ����, 2�� 2ĭ ����, 3�̸� 3ĭ ���� ������ ���� �ٽ� �Է��϶�� ���
		 */
		int num1;

		num1 = 2;

//		switch (num1) {
//			case 1:
//				System.out.println("�� ĭ ����");
//				break;
//			case 2:
//				System.out.println("�� ĭ ����");
//				break;
//			case 3:
//				System.out.println("�� ĭ ����");
//				break;
//			default:
//				System.out.println("�ٽ� �Է��ϼ���.");
//		}

		switch (num1) {
			case 1:
			case 2:
			case 3:
				System.out.println(num1 + "ĭ ����");
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ���.");
		}

		System.out.println("----------------");
		/*
		 * 3������ ��, 6������ ����, 9������ ����, 12������ �ܿ�
		 */
		int month = 13;

		switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.println("��");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("����");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("����");
				break;
			case 12:
			case 1:
			case 2:
				System.out.println("�ܿ�");
				break;
			default:
				System.out.println("�߸��� ��¥�Դϴ�.");
		}

	}

}
