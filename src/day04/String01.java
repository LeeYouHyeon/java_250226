package day04;

public class String01 {

	public static void main(String[] args) {
		/* String class : ���ڿ��� �ٷ�� ���� Ŭ���� => �⺻ �ڷ����� �ƴ�
		 * class : �ش� Ŭ���� �ȿ� �������� ����� ��� ����
		 * class : Ŭ������ ��ü�� = new Ŭ������();
		 * String str = new String();
		 * */

		String str = new String();
		str = "456789";
		System.out.println(str);
		String str2 = "123 456";
		System.out.println(str2);

		// str1 == str2; : �� �����M �ּҸ� ����� ��
		// STring�� �迭ó�� ���

		// length : ��ü ���ڼ�(������ ����)
		System.out.println("--length--");
		System.out.println(str2.length());

		// charAt(index) : index ������ �ִ� ���� ��ȯchar
		System.out.println("--charAt()--");
		System.out.println(str2.charAt(3));

		// substring() : ���ڿ� ����
		System.out.println("--substring()");
		System.out.println(str2.substring(2, 5));

		// str.compareTo(str2) : str�� str2���� ���̸� -1, ������ 0, �ڸ� 1
		// ���� ���� �� ���
		System.out.println("--compareTo");
		System.out.println("a".compareTo("b"));
		System.out.println("apple".compareTo("banana"));

		// equals() : �� ���ڰ� ������ ��(��ҹ��� ����)
		// ������ true / �ٸ��� false
		// �����ڷ����� ==�� ���ϸ� �ּҸ� ��
		System.out.println("--equals()--");
		System.out.println("abc".equals("abc"));
		System.out.println("hello".equals("java"));

		// indexOf() : ������ ��ġ�� ã���ִ� ���
		// ã�� ���ڰ� ������ -1�� return
		System.out.println("--indexOf()--");
		System.out.println("HelloWorld!!".indexOf('W'));
		System.out.println("HelloWorld!!".indexOf('o'));
		System.out.println("HelloWorld!!".indexOf('a'));
		System.out.println("HelloWorld!!".lastIndexOf('o'));
		
		//substring, indexOf�� ����Ͽ� id�� ����
		String email = "abc12345@naver.com";
		System.out.println(email.substring(0, email.indexOf('@')));
		
		// �ֹε�� ��ȣ�� ������ϸ� ����
		String regNum = "990101-1234567";
		System.out.println(regNum.substring(0, regNum.indexOf('-')));
		
		// contains : �ش� ���ڸ� �����ϴ��� üũ
		String file = "HelloWorldjava.html";
		System.out.println(file.contains("java"));
		
		// concat : �̾���̱� (+ ���Ῥ���ڿ� ���� �ǹ�)
		System.out.println("--concat--");
		System.out.println("abc".concat("def"));
	}
}
