package day06;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// MultiArrayEx01�� Student Ŭ������ �̿��� ����
		
		System.out.print("������ �Է��� �л� ���� �Է��ϼ���.> ");
		Scanner scan = new Scanner(System.in);
		int numOfStudents = scan.nextInt();
		
		// �л� ������ �޾� �̸�, ���� ���
		// ����, ����� ���� setter�� ����Ǿ�����
		Student[] students = new Student[numOfStudents];
		System.out.println("�л��� �̸�, ����, ����, ���� ������ �Է����ּ���.");
		for (int i = 0; i < numOfStudents; i++) {
			// �Է�
			System.out.println(i + 1 + "��° �л�");
			scan.nextLine(); // nextInt()���� ó������ ���� ����Ű�� ����
			
			String name;
			int kor, eng, math;
			
			System.out.print("�̸�> ");
			name = scan.nextLine();
			System.out.print("���� ����> ");
			kor = scan.nextInt();
			System.out.print("���� ����> ");
			eng = scan.nextInt();
			System.out.print("���� ����> ");
			math = scan.nextInt();
			
			students[i] = new Student(name, kor, eng, math);
		}
		scan.close();
		
		// ������ �������� ���� ���
		for(Student a : students) {
			for(Student b : students) {
				if(a.sum() < b.sum()) {
					a.rankDown();
				}
			}
		}
		
		System.out.println("=============================================");
		System.out.printf("�̸�\t����\t����\t����\t����\t���\t����\n");
		for(Student s : students) {
			s.print();
		}
	}

}
