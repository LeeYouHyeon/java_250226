package day09;

public class Method07 {
	public static void main(String[] args) {
		/* �޼��� �����ε�
		 * 	- ������ �̸��� �޼��带 ���� �� ����� ��
		 * 	- �����ε��� ����
		 * 		1. �Ű������� ������ �ٸ��� ����
		 * 		2. �Ű������� Ÿ���� �ٸ��� ����
		 * 	- ���� Ÿ��, �Ű������� �̸��� ������ ���� ����.
		 * */
		int num1 = 10, num2 = 20;

		// �� Ŭ������ ��ü�� ����
		Method07 m7 = new Method07();
		int hap = m7.sum(num1, num2);
		System.out.println(hap);
		System.out.println(m7.sum(10, 20, 30));
		System.out.println(m7.sum(1.2, 3.5));
	}

	public int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public double sum(double num1, double num2) {
		return num1 + num2;
	}
	
	public int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
