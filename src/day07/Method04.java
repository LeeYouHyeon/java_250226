package day07;

public class Method04 {
	
	/* ����([2, 9] �� �ϳ�)�� �Է¹޾�
	 * ������ �ش��ϴ� �������� ����ϴ� �޼���
	 * ���� Ÿ�� : void
	 * �Ű� ���� : int num
	 * */
	public static void times(int num) {
		if(num < 2 || num > 9) {
			System.out.println("�������� �ʴ� �����Դϴ�.");
		} else {
			for(int i = 1; i <= 9; i++) {
				System.out.print(num + "*" + i + " = " + num*i + ' ');
			}
		}
	}
	
	/* ������ ��� �޼���
	 * 
	 * */
	
	public static void times() {
		for(int i = 2; i <= 9; i++) {
			times(i);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		times();
	}
}
