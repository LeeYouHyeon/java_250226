package day06;

import java.util.Scanner;

public class MultiArrayEx01 {
	public static void main(String[] args) {
		/* ����ǥ
		 * �� ���� ������ �Է��� �� ���� > 3
		 * �̸�, ����, ����, ����, ����, ���, ����
		 * ������ ���� ����
		 * "\t" : ��
		 * */

		// �Է¹��� �л� �� ����
		System.out.print("������ �Է��� �л� ���� �Է��ϼ���.> ");
		Scanner scan = new Scanner(System.in);
		int numOfStudents = scan.nextInt();

		String	name[]	= new String[numOfStudents];
		int		kor[]	= new int[numOfStudents],
				eng[] 	= new int[numOfStudents],
				math[]	= new int[numOfStudents],
				sum[]	= new int[numOfStudents],
				rank[]	= new int[numOfStudents];
		double	avg[]	= new double[numOfStudents];

		// �л� ������ �Է¹޾� �̸�, ����, ����, ��� ���
		System.out.println("�л��� �̸�, ����, ����, ���� ������ �Է����ּ���.");
		for (int i = 0; i < numOfStudents; i++) {
			// �Է�
			System.out.println(i + 1 + "�� �л�");
			scan.nextLine(); // nextInt()���� ó������ ���� ����Ű�� ����
			
			System.out.print("�̸�> ");
			name[i] = scan.nextLine();
			System.out.print("���� ����> ");
			kor[i] = scan.nextInt();
			System.out.print("���� ����> ");
			eng[i] = scan.nextInt();
			System.out.print("���� ����> ");
			math[i] = scan.nextInt();

			// ����, ��� ���
			sum[i] = kor[i] + eng[i] + math[i];
			avg[i] = sum[i] / 3.0;
			rank[i] = 1;
			System.out.println();
		}
		scan.close();

		// ������ �������� ������ ���
		for (int i = 0; i < numOfStudents; i++) {
			for (int j = 0; j < numOfStudents; j++) {
				if (sum[i] < sum[j]) {
					rank[i]++;
				}
			}
		}

		System.out.println("=============================================");
		// �Է¹��� ������� ���
		System.out.printf("�̸�\t����\t����\t����\t����\t���\t����\n");
		for (int i = 0; i < numOfStudents; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%d\n",
					name[i], kor[i], eng[i], math[i], sum[i], avg[i], rank[i]);
		}
	}
}
