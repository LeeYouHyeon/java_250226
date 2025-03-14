package day09;

public class Exam01 {
	public static void main(String[] args) {
		/* �޼���� �۾�
		 * �� ������ ���� �־��� ��
		 * �� ���� ������ ��� ������ ���� �����ϴ� �޼���
		 * */
		Exam01 e1 = new Exam01();

		System.out.println(e1.sumBetween(3, 5));
		System.out.println(e1.sumRecur(3, 3));
	}
	
	// ��� �޼��带 �Է��� ������ �����ϴ� �뵵�θ� ���
	public int sumBetween(int num1, int num2) {
		if (num1 > num2) {
			return sumBetween(num2, num1);
		}

		int answer = 0;
		for (int i = num1; i <= num2; i++) {
			answer += i;
		}

		return answer;
	}

	// ������ ��� �޼���� ����
	public int sumRecur(int num1, int num2) {
		if (num1 > num2) {
			return sumRecur(num2, num1);
		}

		return (num1 == num2) ? num1 : num1 + sumRecur(num1 + 1, num2);
	}
}
