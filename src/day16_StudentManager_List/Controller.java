package day16_StudentManager_List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Controller implements TODO {
	private int code;
	private List<Student> stds;
	private List<Subject> subs;
	private Exception wrongAge;
	private HashMap<String, Double> valueOfScore;

	public Controller() {
		stds = new ArrayList<Student>();
		subs = new ArrayList<Subject>();
		wrongAge = new Exception("�߸��� ����");

		valueOfScore = new HashMap<>();
		valueOfScore.put("F", 0.0);
		String letter[] = new String[] { "D", "C", "B", "A" };
		char app[] = new char[] { '-', '0', '+' };
		for (int i = 0; i < letter.length; i++) {
			valueOfScore.put(letter[i], i + 1.0);
			for (int j = 0; j < app.length; j++) {
				valueOfScore.put(letter[i] + app[j], i + 1 + 0.3 * (j - 1));
			}
		}
	}
	public Controller(Subject... subjects) {
		this();
		insertSubject(subjects);
	}

	// �⺻���� �ֱ� ���� �޼���
	public void insertSubject(Subject... subjects) {
		for (Subject s : subjects) {
			subs.add(s);
		}
	}
	public void insertStudent(Student... students) {
		for (Student s : students) {
			stds.add(s);
		}
	}

	// �л��� �˻��ϴ� ���� �޼���
	private Student searchStudent(String code) throws Exception {
		for (Student s : stds) {
			if (s.getStdCode().equals(code)) {
				return s;
			}
		}
		throw new Exception("�л��� ã�� �� �����ϴ�.");
	}
	// ������ �˻��ϴ� ���� �޼���
	private Subject searchSubject(String code) throws Exception {
		for (Subject sub : subs) {
			if (sub.getSubCode().equals(code)) {
				return sub;
			}
		}

		throw new Exception("������ ã�� �� �����ϴ�.");
	}

	@Override
	public void insertStudent(Scanner scan) {
		try {
			String name, phone, place;
			int age;

			System.out.println("�л� ���� �Է�");
			System.out.print("�̸�> ");
			name = scan.nextLine();
			System.out.print("����> ");
			age = Integer.parseInt(scan.nextLine());
			if (age <= 0) {
				throw wrongAge;
			}
			System.out.print("�ڵ�����ȣ> ");
			phone = scan.nextLine();
			System.out.print("�ּ�> ");
			place = scan.nextLine();

			code++;
			stds.add(new Student(String.valueOf(code), name, phone, place, age));
			System.out.println("�л� ��� �Ϸ�");
		} catch (NumberFormatException e) {
			System.out.println("�߸��� ����");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void printStudents() {
		if (stds.isEmpty()) {
			System.out.println("�л��� �����ϴ�.");
		} else {
			for (Student s : stds) {
				System.out.println(s);
			}
		}
	}

	@Override
	public void searchStudent(Scanner scan) {
		System.out.print("�й�> ");
		try {
			System.out.println(searchStudent(scan.nextLine()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateStudent(Scanner scan) {
		System.out.print("�й�> ");
		try {
			Student s = searchStudent(scan.nextLine());

			System.out.println("�л��� ã�ҽ��ϴ�. ������ �⺻������ �Է��ϼ���.");
			System.out.println("������ ������ ������ ���ͷ� ��ŵ�� �� �ֽ��ϴ�.");

			System.out.print("�̸�> ");
			String name = scan.nextLine();
			if (!name.isBlank()) {
				s.setStdName(name);
			}

			System.out.print("����> ");
			String ageStr = scan.nextLine();
			if (!ageStr.isBlank()) {
				int age = Integer.parseInt(ageStr);
				if (age < 0) {
					throw wrongAge;
				}
				s.setAge(age);
			}

			System.out.print("��ȭ��ȣ> ");
			String phone = scan.nextLine();
			if (!phone.isBlank()) {
				s.setStdPhone(phone);
			}

			System.out.print("�ּ�> ");
			String address = scan.nextLine();
			if (!address.isBlank()) {
				s.setStdAddress(address);
			}

			System.out.println("�����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteStudent(Scanner scan) {
		try {
			System.out.print("�й�> ");
			Student s = searchStudent(scan.nextLine());
			stds.remove(s);
			System.out.println("�����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void printSubjects() {
		if (subs.isEmpty()) {
			System.out.println("�غ����Դϴ�.");
		} else {
			for (Subject sub : subs) {
				System.out.println(sub);
			}
		}
	}

	@Override
	public void insertSubject(Scanner scan) {
		try {
			System.out.print("�й�> ");
			Student std = searchStudent(scan.nextLine());

			System.out.print("���� �ڵ�> ");
			Subject sub = searchSubject(scan.nextLine());

			if (std.isLearned(sub)) {
				throw new Exception("�̹� ��û�� �����Դϴ�.");
			}

			System.out.print("����> ");
			String score = scan.nextLine();

			std.addSubject(sub);
			sub.addStudent(std, score);
			System.out.println("������û �Ϸ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteSubject(Scanner scan) {
		try {
			System.out.print("�й�> ");
			Student std = searchStudent(scan.nextLine());

			System.out.print("���� �ڵ�> ");
			Subject sub = searchSubject(scan.nextLine());

			if (!std.deleteSubject(sub)) {
				throw new Exception("��û���� ���� �����Դϴ�.");
			}
			sub.deleteStudent(std);
			System.out.println("����öȸ �Ϸ�");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void studentsOfSubject(Scanner scan) {
		try {
			System.out.print("�����ڵ�> ");
			searchSubject(scan.nextLine()).printStduents();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void printStudentScore(Scanner scan) {
		try {
			System.out.print("�й�> ");
			searchStudent(scan.nextLine()).printScores(valueOfScore);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
