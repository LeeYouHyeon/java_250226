package day12;

import java.util.Calendar;

public class Date01 {
	public static void main(String[] args) {
		/* ��¥/�ð� Ŭ����
		 * Date Ŭ����(Deprecated) / Calendar Ŭ���� / LocalDateTime Ŭ����
		 * 
		 * Calendar : �߻� Ŭ���� => new ��ü�� ������ �� ����.
		 * 	- �̱��� ���� : ��ü�� �������� �ʰ� Ŭ������.getInstance() �޼���� ���� => static
		 * 
		 * */
		
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		
		System.out.println(c.get(Calendar.MONTH) + 1);		//0~11
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));	//1(��)~7(��)
		
		// 2025-03-14(��)
//		System.out.println(c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH) + "("
//				+ new char[] {'��', '��', 'ȭ', '��', '��', '��', '��'}[c.get(Calendar.DAY_OF_WEEK) - 1] + ")");
		
		System.out.println(String.format("%d-%02d-%d(%c)",
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH) + 1,
				c.get(Calendar.DAY_OF_MONTH),
				new char[] {'��', '��', 'ȭ', '��', '��', '��', '��'}[c.get(Calendar.DAY_OF_WEEK) - 1]));
		System.out.println();
		
		System.out.println(String.format("%s %d�� %d�� %02d��", 
				(c.get(Calendar.AM_PM) == Calendar.AM ? "����" : "����"),
				c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND)));
		
		
	}
}
