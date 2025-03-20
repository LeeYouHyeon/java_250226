package studentManager_List_Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student�� Subject�� Map���� ����?(�ߺ� ����)
public class StudentController implements Program {
	private List<Student> stds;
	private List<Subject> subs;
	private int nextCode; 
	
	public StudentController(Subject...subjects) {
		stds = new ArrayList<>();
		subs = new ArrayList<>();
		for(Subject sub : subjects) {
			subs.add(sub);
		}
		nextCode = 1;
	}

	@Override
	public void insertStudent(Scanner scan) throws Exception {
		// 1. ���� �Է�
		String message[] = new String[] {
				"�̸�> ", "��ȭ��ȣ> ", "�ּ�> ", "����> "
		};
		String info[] = new String[4];
		for(int i = 0; i < 4; i++) {
			System.out.print(message[i]);
			info[i] = scan.nextLine();
		}
		
		int age = Integer.parseInt(info[3]);
		if(age < 0) {
			throw new Exception("���̰� �����Դϴ�.");
		}
		
		stds.add(new Student(String.valueOf(nextCode), info[0], info[1], info[2], age, new ArrayList<Subject>()));
		nextCode++;
		System.out.println("��� �Ϸ�");
	}

	@Override
	public void printStudents() {
		if(stds.isEmpty()) {
			System.out.println("�л��� �����ϴ�.");
		} else {
			for(Student std : stds) {
				System.out.println(std);
			}
		}
	}
	
	private Student getStudent(Scanner scan) {
		System.out.print("�л� ��ȣ> ");
		return stds.get(Integer.parseInt(scan.nextLine()) - 1);
	}

	@Override
	public void searchStudent(Scanner scan) {
		System.out.println(getStudent(scan));
	}

	@Override
	public void insertSubject(Scanner scan) {
		// 1. ��û�� �л� ����
		Student s = getStudent(scan);
		
		// 2. ��û�� ���� ����
		for(Subject sub : subs) {
			System.out.println(sub);
		}
		System.out.print("��û�� ���� �ڵ�> ");
		String subCode = scan.nextLine();
		
		// 3. �Է¹��� ������ ��û
		for(Subject sub : subs) {
			if(sub.getSubCode().equals(subCode)) {
				s.insertSubject(sub);
				return;
			}
		}
		
		// 4. ������ �ȳ��� ���
		System.out.println("���� �����Դϴ�.");
	}

	@Override
	public void deleteSubject(Scanner scan) {
		// 1. ����öȸ�� �л� ����
		Student s = getStudent(scan);
		
		// 2. öȸ�� ���� ����
		for(Subject sub : s.getSubjects()) {
			System.out.println(sub);
		}
		System.out.print("öȸ�� ���� �ڵ�> ");
		String subCode = scan.nextLine();
		
		// 3. �Է¹��� ������ öȸ
		for(Subject sub : s.getSubjects()) {
			if(sub.getSubCode().equals(subCode)) {
				s.cancelSubject(sub);
				return;
			}
		}
		
		// 4. ������ �ȳ��� ���
		System.out.println("��û���� ���� �����Դϴ�.");
	}

}
