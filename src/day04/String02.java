package day04;

import java.util.Arrays;

public class String02 {

	public static void main(String[] args) {
		/* String �޼���
		 * */
		String str = "ȫ�浿~~~!!!", str2 = "";

		// toLowerCase(), toUpperCase() : ��ҹ��� ��ȯ
		System.out.println("--toLowerCase/toUpperCase--");
		System.out.println("toLower".toLowerCase());
		System.out.println("toLower".toUpperCase());

		// isEmpty() : ���� ������� Ȯ��
		System.out.println("--isEmpty()--");
		System.out.println(str.isEmpty());
		System.out.println(str2.isEmpty());

		// trim() : ���ʿ��� ���� ����
		System.out.println("--trim()--");
		System.out.println("           hello          ".trim());

		// replace() : ���ڸ� ġȯ
		System.out.println("--replace()--");
		String str3 = "apple, banana, kiwi";
		System.out.println(str3.replace(",", " /"));
		
		// split() : Ư�� ���� �������� ������ => �迭�� return
		System.out.println("--split()--");
		String[] arr = str3.split(", ");
		System.out.println(Arrays.toString(arr));
		
		// ���ڸ� ���ڷ�
		String num1 = "1";
		int num2 = Integer.parseInt(num1);
		
		// ���ڸ� ���ڷ�. String.valueOf()
		// instanceof : ��ü�� ���� ��ġ�ϴ��� üũ
		String as = String.valueOf(num2);
		
		System.out.println(as);
		System.out.println(as instanceof String);
	}

}
