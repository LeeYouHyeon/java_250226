package day01;

public class Variable {

	public static void main(String[] args) {
		/* ���� ����
		 * �ڷ��� ������;
		 * 
		 * ���� ���� + �ʱ�ȭ
		 * �ڷ��� ����� = ��;
		 * 
		 * �⺻ ������ Ÿ�����ʱ�ȭ �ؾ� ��밡��
		 * */
		
		int num1;
//		in num =-3; // �ߺ� ���� �Ұ���
		
		// char : �ƽ�Ű�ڵ�(�����ڵ�) ǥ�� �ѱ��ڸ� ����
		// "���ڿ�", '�ѱ���'
		
		char ch = 'a';
		System.out.println(ch);
		System.out.println((int)ch); // char -> int�� ����ȯ
		
		// double
		double dou = 3.1;
		System.out.println(dou);
		
		byte b = 3; // ������ �Ѿ�� ����
		System.out.println(b);
		
		boolean boo = true; // true false�θ� ���� ����
		System.out.println(boo);
		
		// float / long : ���̻縦 �ٿ��� ��� ����
		// float(f F) / long(l L)
		
		float f = 1.2f;
		System.out.println(f);
		
		long l = 2147483648L; // int ������ �Ѿ�� literal �ڿ� L�� ����
		System.out.println(l);
		
		num1 = 010; // 8������ �ν�
		System.out.println(num1);
		
		num1 = 0x10; // 16����
		System.out.println(num1);
		
		// �⺻ �ڷ��� 8������ ���������� ������ ������.
		// ���������� ������ �ش� ������ ����� �߰�ȣ ��
		// ��ȣ �ۿ��� ������ �� �ȿ��� ��� ����
		
		{
			int a = 100;
			System.out.println(a);
		}
		
		int a = 50;
		System.out.println(a);
	}
}
