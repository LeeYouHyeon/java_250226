package day01;

public class Exam01 {
	public static void main(String[] args) {
		/* ī�信 ����
		 * ����, ����, ���� ���� �Է�
		 * �հ�� ����� ���
		 * 
		 * ���� ���� �����ڸ� �̿��Ͽ�
		 * ����� 80�� �̻��̸� �հ�, �ƴϸ� ���հ�
		 */
		int kor, eng, math, sum;
		double average;
		String pass;
		
		// ���� �Է¹޴� �ڵ�� ����
		kor = 78;
		eng = 96;
		math = 156;
		
		sum = kor + eng + math;
		average = (double)sum/3;
		pass = (average >= 80) ? "�հ�" : "���հ�";
		
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + average);
		System.out.println(pass);
		
		
		System.out.println("---------------");
		//if (���ǽ�) { ���๮; } else { ���๮; }
		//����� 100���� ũ�ų� 0���� �۴ٸ� ����
		//80�� �̻��̸� ���, 60�� �̻��̸� �հ�, �������� ���հ�
		
		//���ô�� 1
		if(average > 100 || average < 0) {
			System.out.println("����");
		} else if(average >= 80) {
			System.out.println("���");
		} else if(average >= 60) {
			System.out.println("�հ�");
		} else {
			System.out.println("���հ�");
		}
		
		//���ô�� 2
		//���� �� ������ ���̵� ����� ����
		System.out.println("---------------");
		if(average > 100 || average < 0) {
			System.out.println("����");
		} else {
			if(average >= 80) {
				System.out.println("���");
			} else if(average >= 60) {
				System.out.println("�հ�");
			} else {
				System.out.println("���հ�");
			}
			
		}
		
	}
}