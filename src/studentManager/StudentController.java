package studentManager;

import java.util.Scanner;

public class StudentController implements Program {
	private Student[] students = new Student[100];
	private Subject[] subjects; // ������� controller�� ���� �� �������� ��
	private int numStudents;

	public StudentController(Subject... subjects) {
		this.subjects = subjects;
	}

	@Override
	public void insertStudent(Scanner scan) {
		// �ʿ��ϸ� ���� Ȯ��
		if (numStudents == students.length) {
			Student[] students = new Student[numStudents + 100];
			for (int i = 0; i < numStudents; i++) {
				students[i] = this.students[i];
			}
			this.students = students;
		}

		// ����� �Է�
		String id, name, phone, place;
		int age;
		System.out.println("����� �л��� ������ �Է��ϼ���.");
		System.out.print("�̸�> ");
		name = scan.nextLine();
		System.out.print("��ȭ��ȣ> ");
		phone = scan.nextLine();
		System.out.print("����> ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("�ּ�> ");
		place = scan.nextLine();

		id = String.valueOf(numStudents + 1);
		students[numStudents] = new Student(id, name, phone, place, age);
		numStudents++;
	}

	@Override
	public void printStudents() {
		for (Student s : students) {
			if (s == null) {
				break;
			}

			System.out.println(s);
		}
	}

	@Override
	public void searchStudent(Scanner scan) {
		System.out.println("�л��� �˻��� ����� �����ϼ���.");
		System.out.println("1. �л� ���� | 2. ���� ����");
		System.out.print("> ");
		int input = scan.nextInt();
		scan.nextLine();
		switch (input) {
			case 1:
				// �л� ������ �˻�
				// �� ������ returnStudent() ����
				Student[] answer = returnStudents(scan);
				if (answer != null) {
					for (Student s : answer) {
						System.out.println(s);
					}
				} else {
					System.out.println("�ش� ������ ��ġ�ϴ� �л��� �����ϴ�.");
				}
				return;
				
			case 2:
				// ���� ������ �˻�
				Subject sub = chooseSubject(scan, subjects);
				int subcount = 0;
				for (int i = 0; i < numStudents; i++) {
					for (Subject subject : students[i].getSubjects()) {
						if (subject != null && subject.getCode().equals(sub.getCode())) {
							System.out.println(students[i]);
							subcount++;
						}
					}
				}
				if (subcount == 0) {
					System.out.println("�ش� ������ ��� �л��� �����ϴ�.");
				}
		}

	}

	@Override
	public void insertSubject(Scanner scan) {
		if (subjects == null) {
			System.out.println("�غ����Դϴ�.");
			return;
		}

		System.out.println("������û�� �л��� �˻��մϴ�.");
		Student found[] = returnStudents(scan), student;
		if (found == null) {
			System.out.println("�˻� ����� �����ϴ�.");
			return;
		}

		student = (found.length > 1) ? decideOne(scan, found) : found[0];
		student.insertSubject(chooseSubject(scan, subjects));
	}

	@Override
	public void deleteSubject(Scanner scan) {
		if (subjects == null) {
			System.out.println("�غ����Դϴ�.");
			return;
		}

		System.out.println("������û�� ����� �л��� �˻��մϴ�.");
		Student found[] = returnStudents(scan), student;
		if (found == null) {
			System.out.println("�˻� ����� �����ϴ�.");
			return;
		}

		student = (found.length > 1) ? decideOne(scan, found) : found[0];
		Subject sub = chooseSubject(scan, student.getSubjects());
		if (sub == null) {
			System.out.println("������ ������ �����ϴ�.");
		} else {
			student.deleteSubject(sub);
		}
	}

	public int numStudents() {
		return numStudents;
	}

	public Subject[] getSubjects() {
		return subjects;
	}

	// �˻� ����� Student�� array�� ��ȯ
	// �˻� ����� ������ null
	private Student[] returnStudents(Scanner scan) {
		System.out.println("�й����� �˻��Ϸ��� 1, �̸����� �˻��Ϸ��� 2�� �����ּ���.");
		int choice;
		while (true) {
			System.out.print("> ");
			choice = scan.nextInt();

			Student[] result;
			int count = 0;
			String input;
			switch (choice) {
				case 1:
					result = new Student[1];
					System.out.println("�˻��� �й��� �Է����ּ���.");
					System.out.print("> ");
					scan.nextLine();
					input = scan.nextLine();
					for (int i = 0; i < this.numStudents; i++) {
						if (students[i].getId().equals(input)) {
							result[0] = students[i];
							return result;
						}
					}
					return null;
				case 2:
					result = new Student[students.length];
					System.out.println("�˻��� �̸��� �Է����ּ���.");
					System.out.print("> ");
					scan.nextLine();
					input = scan.nextLine();
					for (int i = 0; i < this.numStudents; i++) {
						if (students[i].getName().equals(input)) {
							result[count] = students[i];
							count++;
						}
					}
					if (count == 0) {
						return null;
					} else {
						Student[] answer = new Student[count];
						for (int i = 0; i < count; i++) {
							answer[i] = result[i];
						}
						return answer;
					}
				default:
					System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}

	// ���� ���� �л��� �� �� ���� ���� �ϴ� �޼���
	private Student decideOne(Scanner scan, Student[] found) {
		System.out.println(found.length + "���� �л��� �˻��Ǿ����ϴ�. �й��� ���� ��û�� �л��� �����ּ���.");
		for (int i = 0; i < found.length; i++) {
			System.out.println(found[i]);
		}
		String input;
		System.out.print("�й� �Է�> ");
		while (true) {
			input = scan.nextLine();
			for (Student s : found) {
				if (s.getId().equals(input)) {
					return s;
				}
			}
			System.out.print("��� ���� �й��� �����ϴ�. �ٽ� �Է��ϼ���.> ");
		}
	}

	// ����ڰ� �־��� ����� �� �ϳ��� ���� �ϴ� �޼���
	private Subject chooseSubject(Scanner scan, Subject[] subjects) {
		int subcount = 0;
		for (Subject subject : subjects) {
			if (subject != null) {
				System.out.println(subject);
				subcount++;
			}
		}
		if (subcount == 0) {
			return null;
		}

		System.out.println("�� ����� �߿� �ϳ��� �����ڵ带 �Է����ּ���.");
		System.out.print("�����ڵ�> ");

		String input;
		while (true) {
			input = scan.nextLine();
			for (Subject subject : subjects) {
				if (subject.getCode().equals(input)) {
					return subject;
				}
			}

			System.out.print("���� �����Դϴ�. �ٽ� �Է��ϼ���.> ");
		}
	}
}
