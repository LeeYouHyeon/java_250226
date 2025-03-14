package day01;

public class Casting {
	public static void main(String[] args) {
		/* casting : �ڷ��� ��ȯ
		 * a = b���� �� ������ �ڷ����� ���� �ʴٸ� ����
		 * ������ �ڷ����� �����ִ� ����
		 * 
		 * �ڵ� �ڷ��� ��ȯ(auto casting)
		 * byte < short < char < int < long < float < double
		 * 
		 * ����� �ڷ��� ��ȯ: ���ͷ� �� �տ� (Ÿ��)
		 * */
		
		byte b = 1;
		short sh = b; // �ڵ� ����ȯ
		System.out.println(sh);
		
		char ch = (char)sh; // ����� ����ȯ
		System.out.println(ch);
		
		double num1 = 3.64;
		int num = (int)num1; // �Ҽ����� ���ư�
		System.out.println(num1);
		System.out.println(num);
		
		int i = ch;
		System.out.println(i);
		long l = i;
		float f = l;
		double d = f;
		System.out.println(d);
		
		double d2 = 314.1234;
		float f2 = (float)d2;
		System.out.println(f2);
		long l2 = (long)f2;
		int i2 = (int)l2;
		char ch2 = (char)i2;
		System.out.println(l2);
		System.out.println(i2);
		System.out.println(ch2);
		// ���� �� ũ�Ⱑ ������ �ʰ��� ��� ǥ�ð� �� ��, error
		short sh2 = (short)ch2;
		System.out.println(sh2);
		byte b2 = (byte)257;
		System.out.println(b2);
		
		// ���ڸ� ���ڷ�
		String str = "1234";
		int strNum = Integer.parseInt(str);
		System.out.println(str + 10);
		System.out.println(strNum + 10);
		
		// ���ڸ� ���ڷ�
		int numStr = 123456;
		String numStr2 = String.valueOf(numStr);
		System.out.println(numStr2 + 10);
	}
}
