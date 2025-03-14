package day01;

public class Operator {
	public static void main(String[] args) {
		// ������
		/* ���� ������: =, +=, -=, ...
		 * = �� �������� �����ʿ� �ִ� ���� ���� ������ ����
		 * ������ �ݵ�� �������� �Ѵ�.
		 * �������� ������ ��� ������ �ִ� ���� ���� ������ �ִ´�.
		 * int a = 1;
		 * int b = 2;
		 * a = b;
		 * a = 1;
		 * 1 = a; (x)
		 * a += b; // a = a + b;
		 * 
		 * */
		
		int a = 1;
		int b = 5;
		a = b;
		System.out.println(a);
		a += 10;
		System.out.println(a);
		
		// ���� ������: ++(1 ����), --(1 ����)
		a++;
		System.out.println(a); // 16
		System.out.println(a++); // 16 ��� �� ����
		System.out.println(a); // 17
		System.out.println(++a); // ���� �� ���
		
		// ��� ������: +, -, *, /, %(������)
		/* ������ (/, %)
		 * ���� / ���� = ���� (10/3 == 3)
		 * ���� / �Ǽ� = �Ǽ� (10/3.0 == 3.3333...)
		 * �Ǽ� / ���� = �Ǽ�
		 * �Ǽ� / �Ǽ� = �Ǽ�
		 * 
		 * ���� / 0 => ���� �߻� (Exception)
		 * �Ǽ� / 0 => infinity �߻� (���� ó����)
		 * */
		
		System.out.println(3.0/0);
		System.out.println(10/3.0);
		
		/* �� ������: �� ������ ����� �ݵ�� true / false
		 * >=(�̻�), <=(����), >(�ʰ�), <(�̸�), ==(����), !=(�ٸ�)
		 * �� ������ : &&(and), ||(or), !(not)
		 * a && b : a�� b�� ��� ���̾�� true
		 * a || b : a�� b �� �ϳ� �̻� ���̸� true
		 * !a : a ����� �ݴ�
		 * */
		
		System.out.println(3 > 2);
		System.out.println(2 > 3);
		System.out.println((3 > 2) || (4 > 5));
		System.out.println(!(3 > 2));
		
		// ���� ������ : + (�������� ����� ������ ��쿡�� ����)
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(num1 + num2); //��� ������
		System.out.println(num1 + num2 + "��" + num1 + num2);
		
		// ���� ���� ������ : ���ǽ� ? ���� : ������
		System.out.println(3 < 2 ? "3�� �� Ů�ϴ�." : "3�� �� �۽��ϴ�.");
		
		/* ����
		 * num ������ �����ϰ�, ���� �Է�
		 * num�� ¦������ Ȧ������ �Ǻ�.
		 * ���Ǽ��� ������ ���, % ������ ���
		 * */
		int num = -125;
		String result = (num % 2 == 0) ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
		System.out.println(result);
		
		
	}
}
