package day07;

// �ϳ��� .java ���Ͽ� class�� ���� �� ������ �� �ִ�.
// ��, public class�� ���ϸ�� ���� �ϳ��� Ŭ������ �����ϴ�.
public class Method02 {

	/* �� ������ �־����� �� ���� ���� �����ϴ� �޼���
	 * ���� Ÿ��	: int
	 * �޼����	: sum
	 * �Ű�����	: int num1, int num2
	 * */
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	/* ������ ���� ���̽�
	 * �� ������ �־����� �� ���� ���� ����ϴ� �޼���
	 * ����Ÿ��	: void
	 * �޼����	: sum1
	 * �Ű�����	: int num1, int num2
	 * */
	public static void sum1(int num1, int num2) {
		System.out.println(sum(num1, num2));
	}
	
	/* �Ű������� ���� ���̽�
	 * ���� ����ϴ� �޼���
	 * ����Ÿ�� 	: ���� void
	 * �޼���� 	: sum2
	 * �Ű����� 	: ����
	 * */
	public static void sum1() {
		sum1(5, 6);
	}

	public static void main(String[] args) {
		/* sum �޼��带 ȣ���Ͽ� ���
		 * */
		
		System.out.println(sum(6, 8));
		sum1(6, 8);
		sum1();
	}

}
