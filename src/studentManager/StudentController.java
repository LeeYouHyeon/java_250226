package studentManager;

import java.util.Scanner;

public class StudentController implements Program {
	private Student[] students = new Student[100];
	private Subject[] subjects; // 과목들은 controller를 만들 때 등록해줘야 함
	private int numStudents;

	public StudentController(Subject... subjects) {
		this.subjects = subjects;
	}

	@Override
	public void insertStudent(Scanner scan) {
		// 필요하면 공간 확보
		if (numStudents == students.length) {
			Student[] students = new Student[numStudents + 100];
			for (int i = 0; i < numStudents; i++) {
				students[i] = this.students[i];
			}
			this.students = students;
		}

		// 사용자 입력
		String id, name, phone, place;
		int age;
		System.out.println("등록할 학생의 정보를 입력하세요.");
		System.out.print("이름> ");
		name = scan.nextLine();
		System.out.print("전화번호> ");
		phone = scan.nextLine();
		System.out.print("나이> ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("주소> ");
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
		System.out.println("학생을 검색할 방법을 선택하세요.");
		System.out.println("1. 학생 정보 | 2. 수강 정보");
		System.out.print("> ");
		int input = scan.nextInt();
		scan.nextLine();
		switch (input) {
			case 1:
				// 학생 정보로 검색
				// 상세 정보는 returnStudent() 참조
				Student[] answer = returnStudents(scan);
				if (answer != null) {
					for (Student s : answer) {
						System.out.println(s);
					}
				} else {
					System.out.println("해당 정보와 일치하는 학생이 없습니다.");
				}
				return;
				
			case 2:
				// 수강 정보로 검색
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
					System.out.println("해당 과목을 듣는 학생이 없습니다.");
				}
		}

	}

	@Override
	public void insertSubject(Scanner scan) {
		if (subjects == null) {
			System.out.println("준비중입니다.");
			return;
		}

		System.out.println("수강신청할 학생을 검색합니다.");
		Student found[] = returnStudents(scan), student;
		if (found == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}

		student = (found.length > 1) ? decideOne(scan, found) : found[0];
		student.insertSubject(chooseSubject(scan, subjects));
	}

	@Override
	public void deleteSubject(Scanner scan) {
		if (subjects == null) {
			System.out.println("준비중입니다.");
			return;
		}

		System.out.println("수강신청을 취소할 학생을 검색합니다.");
		Student found[] = returnStudents(scan), student;
		if (found == null) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}

		student = (found.length > 1) ? decideOne(scan, found) : found[0];
		Subject sub = chooseSubject(scan, student.getSubjects());
		if (sub == null) {
			System.out.println("수강한 과목이 없습니다.");
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

	// 검색 결과를 Student의 array로 반환
	// 검색 결과가 없으면 null
	private Student[] returnStudents(Scanner scan) {
		System.out.println("학번으로 검색하려면 1, 이름으로 검색하려면 2를 눌러주세요.");
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
					System.out.println("검색할 학번을 입력해주세요.");
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
					System.out.println("검색할 이름을 입력해주세요.");
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
					System.out.println("다시 입력해주세요.");
			}
		}
	}

	// 여러 명의 학생들 중 한 명을 고르게 하는 메서드
	private Student decideOne(Scanner scan, Student[] found) {
		System.out.println(found.length + "명의 학생이 검색되었습니다. 학번을 통해 신청할 학생을 정해주세요.");
		for (int i = 0; i < found.length; i++) {
			System.out.println(found[i]);
		}
		String input;
		System.out.print("학번 입력> ");
		while (true) {
			input = scan.nextLine();
			for (Student s : found) {
				if (s.getId().equals(input)) {
					return s;
				}
			}
			System.out.print("결과 내에 학번이 없습니다. 다시 입력하세요.> ");
		}
	}

	// 사용자가 주어진 과목들 중 하나를 고르게 하는 메서드
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

		System.out.println("위 과목들 중에 하나의 과목코드를 입력해주세요.");
		System.out.print("과목코드> ");

		String input;
		while (true) {
			input = scan.nextLine();
			for (Subject subject : subjects) {
				if (subject.getCode().equals(input)) {
					return subject;
				}
			}

			System.out.print("없는 과목입니다. 다시 입력하세요.> ");
		}
	}
}
