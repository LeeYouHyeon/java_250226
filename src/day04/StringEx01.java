package day04;

public class StringEx01 {

	public static void main(String[] args) {
		// regNum�� �ֹε�Ϲ�ȣ�� �����Ͽ�
		// ������ϰ� ������ ���
		
		String regNum = "990101-12344567";
		String regNum1 = "020101-4567896";
		
		System.out.println("1");
		System.out.println("������� : " + regNum.substring(0, 6));
		System.out.println((int)(regNum.charAt(7))%2 == 0 ? "����" : "����");
		System.out.println("2");
		System.out.println("������� : " + regNum1.substring(0, 6));
		System.out.println((int)(regNum1.charAt(7))%2 == 0 ? "����" : "����");
	}

}
