package day04;

import java.util.Scanner;

public class Exam01 {
	public static void extra() {
		Scanner scan = new Scanner(System.in);
		int input, sum = 0;
		double count = 0.0;
		String total = ""; // ���� ����

		System.out.println("������ �Է����ּ���.");
		System.out.println("0�̳� ������ �Է��� ������ ��� �Է��� �� ������,");
		System.out.println("���� �Է±����� �հ� ����� ��µ˴ϴ�.");

		while (true) {
			System.out.print("> ");
			input = scan.nextInt();
			if (input <= 0) {
				break;
			}
			total += "+" + input;
			count++;
			sum += input;
		}

		scan.close();

		if (count == 0.0) {
			System.out.println("����� �Է¹��� ���߽��ϴ�. �����մϴ�.");
		} else {
			System.out.println("���� : " + total.substring(1));
			System.out.println("�հ� : " + sum);
			System.out.println("��� : " + sum / count);
		}
	}

	public static void main(String[] args) {
		extra();

//		// ���ڸ� �Է¹޾� (0�̳� ������ �Է¹����� ����)
//		// �Է¹��� ������ �հ�� ����� ���
//		
//		Scanner scan = new Scanner(System.in);
//		int input, sum = 0;
//		double count = 0.0;
//		
//		// ���� ���
//		System.out.println("������ �Է����ּ���.");
//		System.out.println("0�̳� ������ �Է��� ������ ��� �Է��� �� ������,");
//		System.out.println("���� �Է±����� �հ� ����� ��µ˴ϴ�.");
//		
//		// ���� �Է�
//		System.out.print("> ");
//		input = scan.nextInt();
//		while (input <= 0) {
//			System.out.println("ù �Է��� �ݵ�� ������� �մϴ�.");
//			System.out.print("> ");
//			input = scan.nextInt();
//		} // ù �Է��� �ݵ�� ���
//		
//		do {
//			// �Է¹��� ���� count�� sum�� �ݿ�
//			count++;
//			sum += input;
//			
//			// ���� ���� �Է�
//			System.out.print("> ");
//			input = scan.nextInt();
//		} while (input > 0);
//		
//		scan.close();
//		
//		System.out.println("�հ� : " + sum);
//		System.out.println("��� : " + sum/count);
	}

}
