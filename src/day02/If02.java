package day02;

import java.util.Scanner;

public class If02 {

	public static void main(String[] args) {
		/*
		 * ����, ����, ���� ������ �Է¹޾� �հ�, ���, pass ���θ� ���
		 * 80 �̻��̸� �հ�, if ���
		 * ������ �Է¹��� �� 100������ ũ�ų� 0���� ������ ���� ��� �� ��� ����
		 */
		
		Scanner scan = new Scanner(System.in);
		System.out.println("����, ����, ���� ������ �������, ����� �����Ͽ� �Է����ּ���.");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
		if (kor > 100 || kor < 0) {
			System.out.println("���� ������ �߸��Ǿ����ϴ�.");
		} else if (eng > 100 || eng < 0) {
			System.out.println("���� ������ �߸��Ǿ����ϴ�.");
		} else if (math > 100 || math < 0) {
			System.out.println("���� ������ �߸��Ǿ����ϴ�.");
		} else {
			int sum = kor + eng + math;
			double avg = sum / 3.0;
			System.out.println("�հ� : " + sum);
			System.out.println("��� : " + avg);
			
			if (avg >= 80) {
				System.out.println("�հ�");
			}
		}
		
		scan.close();

		
		//main���� return ����
//		int kor, eng, math;
//		Scanner scan = new Scanner(System.in);
//
//		System.out.print("���� ������ �Է����ּ���.> ");
//		kor = scan.nextInt();
//		if (kor < 0 || kor > 100) {
//			System.out.println("�߸��� �Է��Դϴ�.");
//			scan.close();
//			return;
//		}
//		System.out.print("���� ������ �Է����ּ���.> ");
//		eng = scan.nextInt();
//		if (eng < 0 || eng > 100) {
//			System.out.println("�߸��� �Է��Դϴ�.");
//			scan.close();
//			return;
//		}
//		System.out.print("���� ������ �Է����ּ���> ");
//		math = scan.nextInt();
//		if (math < 0 || math > 100) {
//			System.out.println("�߸��� �Է��Դϴ�.");
//			scan.close();
//			return;
//		}
//
//		int sum = kor + eng + math;
//		double avg = sum / 3.0;
//
//		System.out.println("�հ� : " + sum);
//		System.out.println("��� : " + avg);
//		if (avg > 100 || avg < 0) {
//			System.out.println("�� �� ���� ����");
//		} else if (avg >= 80) {
//			System.out.println("�հ�");
//		} else if (avg >= 0) {
//			System.out.println("���հ�");
//		}
//		scan.close();
	}

}
