package day01;

public class HelloWorld {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		// �ּ�: ���α׷��� ���� �ʴ� ���� ctrl + / => �� �� �ּ�
		/* ���� �� �ּ�
		 * console: ���
		 * println(): �ٹٲ��� �����ϴ� ���
		 * print(): �ٹٲ��� ���� ���
		 * printf(): ������ ������ ��� (C���� �ַ� ���)
		 * 
		 * ���ڿ��� "" / �� ���ڴ� '' / ���ڴ� ����ǥ ����
		 * */
		System.out.println("Hello World!!!!"); // �⺻ ��� ����
		System.out.println(123);
		System.out.println('a');
		System.out.println("a");
		
		char ch = 97;
		System.out.println(ch); //a
		
		String s = "abc";
		System.out.println(s);
		
		int a = 1;
		a = a + 1;
		System.out.println(a);
		a += 1;
		System.out.println(a);
		
//		-------------------------------------
		
		//����
		int num = 100;
//		int num = 200; //�ߺ� ���� �Ұ���.
		num = 200; //���� �������� ����� �ȴ�.
		
		int num1, num2, num3;
		num1 = 10;
		num2 = 20;
		num3 = 30;
		
		System.out.println(num1 + num2 + num3);
		
		num1++; //num1 += 1
		
		int num4; // ����.
		
		// �⺻ �ڷ���(8����)�� �ʱ갪�� ������ ������ ����
		//System.out.println(num4);
	}

}
