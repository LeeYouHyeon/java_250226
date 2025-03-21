package examStd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentController {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();
	Scanner scan = new Scanner(System.in);
	
	//�⺻�� �߰�
	public void addStudent() {
		studentList.add(new Student("111", "ȫ�浿", "20", "010-1111-1111", "�����"));
		studentList.add(new Student("222", "�����", "20", "010-1111-2222", "�����"));
		studentList.add(new Student("333", "��ö��", "21", "010-1111-3333", "��⵵"));
		studentList.add(new Student("444", "�̿�ö", "20", "010-1111-4444", "�����"));
		studentList.add(new Student("555", "��¯��", "21", "010-1111-5555", "��⵵"));
	}
	public void addSubject() {
		subjectList.add(new Subject("1111", "java", 3, 2, "ȫ�浿", "ȭ��/2��~4��", "1������"));
		subjectList.add(new Subject("2222", "DB", 3, 2, "�̼���", "����/2��~4��", "2������"));
		subjectList.add(new Subject("3333", "HTML", 2, 3, "�迵��", "ȭ��/2��~4��", "3������"));
		subjectList.add(new Subject("4444", "CSS", 2, 3, "Ȳ�⵿", "����/2��~4��", "4������"));
		subjectList.add(new Subject("5555", "javascript", 3, 3, "�ڼ�ö", "����/2��~4��", "5������"));
	}
	
	public int menuPrint() {
		System.out.println("--menu--");
		System.out.println("1. �л���� | 2. �л� ��� ��� | 3. �л� �˻�");
		System.out.println("4. �л� ���� ���� | 5. �л� ����");
		System.out.println("6. ������û | 7. ����öȸ");
		System.out.println("8. ���� �л� ���");
		System.out.println("9. ���� ���(������)");
		System.out.println("10. ����ǥ ���(�л���)");
		System.out.println("11. ����");
		System.out.print("> ");
		try {
			return Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			return 0;
		}
	}

	public void insertStudnet() {
		// �л� �߰�
		try {
			System.out.println("�й�> ");
			String num = scan.nextLine();
			for(Student s : studentList) {
				if(s.equals(new Student(num))) {
					throw new Exception("�̹� ��ϵ� �й��Դϴ�.");
				}
			}
			
			System.out.println("�̸�> ");
			String name = scan.nextLine();
			System.out.println("����> ");
			String age = scan.nextLine();
			System.out.println("��ȭ��ȣ> ");
			String phone = scan.nextLine();
			System.out.println("�ּ�> ");
			String address = scan.nextLine();
			
			studentList.add(new Student(num, name, age, phone, address));
			System.out.println("�л� ��� �Ϸ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void printStudent() {
		// �л� ����Ʈ ���
		if(studentList.isEmpty()) {
			System.out.println("�л��� �����ϴ�.");
		} else {
			System.out.println("--�л���ü���--");
			for(Student s : studentList) {
				System.out.println(s);
			}
		}
		System.out.println("------------");
	}
	// ������û�� Ȯ���ϴ� �뵵
	public void printSubjectList() {
		if(subjectList.isEmpty()) {
			System.out.println("�غ����Դϴ�.");
		} else {
			System.out.println("--������û���� ���--");
			for(Subject s : subjectList) {
				System.out.println(s);
			}
			System.out.println("----------------");
		}
	}
	
	public void searchStudent() {
		// �л��˻�
		System.out.print("�˻� �й�> ");
		String num = scan.nextLine();
		
		for(Student student : studentList) {
			if(student.equals(new Student(num))) {
				System.out.println(student);
				// ���� ��ϵ� ���
				student.subjectPrint();
				return;
			}
		}
		System.out.println("�л��� ã�� �� �����ϴ�.");
	}

	public void searchSubject() {
		// ������ �ְ�, �ش� ������ �����ϴ� �л� ��� ���
		// ��� : �л����
		// ���� : �������� �˻� ��� ������ �����ϴ���
		System.out.print("�˻� ���� ��ȣ> ");
		String subNum = scan.nextLine();
		
		boolean found = false;
		for(Subject s : subjectList) {
			if(s.equals(new Subject(subNum))) {
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("������ ã�� �� �����ϴ�.");
			return;
		}
		
		ArrayList<Student> stds = new ArrayList<Student>();
		for(Student s : studentList) {
			if(s.getSubject().contains(new Subject(subNum))) {
				stds.add(s);
			}
		}
		if(stds.isEmpty()) {
			System.out.println("��û�� �л��� �����ϴ�.");
		} else {
			stds.stream()
				.sorted(new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					return o1.getStdNum().compareTo(o2.getStdNum());
				}
			}).forEach(s -> System.out.println(s));
		}
	}

	public void removeSubject() {
		// �������
		// ����? ���� ������?
		System.out.print("�й�> ");
		String num = scan.nextLine();
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				// ���� ��û�� ���� ���
				s.subjectPrint();
				System.out.print("���� ���� ��ȣ> ");
				s.deleteSub(scan.nextLine());
				return;
			}
		}
		System.out.println("�л��� ã�� �� �����ϴ�.");
	}

	public void removeStudent() {
		// �л� ����
		System.out.print("���� �й�> ");
		String num = scan.nextLine();
		if (studentList.remove(new Student(num))) {
			System.out.println("���� �Ϸ�");
		} else {
			System.out.println("���� �й��Դϴ�.");
		}
	}

	public void modifyStudent() {
		// �л����� => ���� �� �ٽ� �߰�
		
	}

	public void insertSubject() {
		// ������û
		// ����? �й��� �޾�,
		// � ����? Student class method => �Ű����� ����
		// �� �л� ��ü�� subject ����Ʈ�� ���� �߰�
		
		// �й� �Է�
		System.out.print("������û �й�> ");
		String num = scan.nextLine();
		
		// �й� �˻�
		Student std = null;
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				std = s;
			}
		}
		if(std == null) {
			System.out.println("�л��� �����ϴ�.");
			return;
		}
		
		// ���� ����Ʈ ���
		printSubjectList();
		
		// �����ȣ �Է�
		System.out.print("������û ���� ��ȣ> ");
		String subNum = scan.nextLine();
		for(Subject s : subjectList) {
			if(s.equals(new Subject(subNum))) {
				std.insertSubject(new Subject(s));
				return;
			}
		}
		System.out.println("���� �����Դϴ�.");
	}

	public void insertScore() {
		// �л� ���� ���
		// ����? ���� ����?
		System.out.print("�й�> ");
		String num = scan.nextLine();
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				// ���� �����ϴ� ����
				s.subjectPrint();
				System.out.print("�����ȣ> ");
				String subNum = scan.nextLine();
				s.insertScore(subNum, scan);
				return;
			}
		}
		System.out.println("�л��� ã�� �� �����ϴ�.");
	}
	
	public void printScore() {
		// ����ǥ ���
		System.out.print("�й�> ");
		String num = scan.nextLine();
		
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				s.subjectPrint();
				System.out.println("��� : " + s.getTotal()/(double)s.getSubject().size());
				return;
			}
		}
		
		System.out.println("�л��� ã�� �� �����ϴ�.");
	}
	
	// �л� ����Ʈ�� �ֱ�, ����, ����, ���
	// ���� ����Ʈ�� �ֱ�, ����, ����, ���
	
	
}
