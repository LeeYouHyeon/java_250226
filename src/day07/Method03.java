package day07;

public class Method03 {
	
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int mul(int num1, int num2) {
		return num1*num2;
	}
	
	public static double div(int num1, int num2) {
		return (num2 == 0) ? 0 : num1/(double)num2;
	}
	
	public static int mod(int num1, int num2) {
		return (num2 == 0) ? 0 : num1%num2;
	}
	
	public static void main(String[] args) {
		/* + - * / % ����� �ϴ� �޼��带 ����
		 * main���� ȣ�� => ���Ϲ��� ���� ���
		 * */
		
		int num1 = 10, num2 = 20;
		
		System.out.println(add(num1, num2));
		System.out.println(sub(num1, num2));
		System.out.println(mul(num1, num2));
		System.out.println((num2 == 0) ? "�ǿ����ڰ� 0�Դϴ�." : div(num1, num2));
		System.out.println((num2 == 0) ? "�ǿ����ڰ� 0�Դϴ�." : mod(num1, num2));
		
		// �ٸ� Ŭ������ �ִ� �޼��带 ȣ���� ��� Ŭ������.�޼����(); => static�� ���
		System.out.println("------------------------");
		Method04.times();
	}
}
