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
	private HashMap<String, Double> valueOfScore; // 4.3점 기준

	public Controller() {
		stds = new ArrayList<Student>();
		subs = new ArrayList<Subject>();
		wrongAge = new Exception("잘못된 나이");

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

	// 기본값을 넣기 위한 메서드
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

	// 학생을 검색하는 보조 메서드
	private Student searchStudent(String code) throws Exception {
		for (Student s : stds) {
			if (s.getStdCode().equals(code)) {
				return s;
			}
		}
		throw new Exception("학생을 찾을 수 없습니다.");
	}
	// 과목을 검색하는 보조 메서드
	private Subject searchSubject(String code) throws Exception {
		for (Subject sub : subs) {
			if (sub.getSubCode().equals(code)) {
				return sub;
			}
		}

		throw new Exception("과목을 찾을 수 없습니다.");
	}

	@Override
	public void insertStudent(Scanner scan) {
		try {
			String name, phone, place;
			int age;

			System.out.println("학생 정보 입력");
			System.out.print("이름> ");
			name = scan.nextLine();
			System.out.print("나이> ");
			age = Integer.parseInt(scan.nextLine());
			if (age <= 0) {
				throw wrongAge;
			}
			System.out.print("핸드폰번호> ");
			phone = scan.nextLine();
			System.out.print("주소> ");
			place = scan.nextLine();

			code++;
			stds.add(new Student(String.valueOf(code), name, phone, place, age));
			System.out.println("학생 등록 완료");
		} catch (NumberFormatException e) {
			System.out.println("잘못된 나이");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void printStudents() {
		if (stds.isEmpty()) {
			System.out.println("학생이 없습니다.");
		} else {
			for (Student s : stds) {
				System.out.println(s);
			}
		}
	}

	@Override
	public void searchStudent(Scanner scan) {
		System.out.print("학번> ");
		try {
			System.out.println(searchStudent(scan.nextLine()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateStudent(Scanner scan) {
		System.out.print("학번> ");
		try {
			Student s = searchStudent(scan.nextLine());

			System.out.println("학생을 찾았습니다. 수정할 기본정보를 입력하세요.");
			System.out.println("변경을 원하지 않으면 엔터로 스킵할 수 있습니다.");

			System.out.print("이름> ");
			String name = scan.nextLine();
			if (!name.isBlank()) {
				s.setStdName(name);
			}

			System.out.print("나이> ");
			String ageStr = scan.nextLine();
			if (!ageStr.isBlank()) {
				int age = Integer.parseInt(ageStr);
				if (age < 0) {
					throw wrongAge;
				}
				s.setAge(age);
			}

			System.out.print("전화번호> ");
			String phone = scan.nextLine();
			if (!phone.isBlank()) {
				s.setStdPhone(phone);
			}

			System.out.print("주소> ");
			String address = scan.nextLine();
			if (!address.isBlank()) {
				s.setStdAddress(address);
			}

			System.out.println("수정되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteStudent(Scanner scan) {
		try {
			System.out.print("학번> ");
			Student s = searchStudent(scan.nextLine());
			stds.remove(s);
			System.out.println("삭제되었습니다.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void printSubjects() {
		if (subs.isEmpty()) {
			System.out.println("준비중입니다.");
		} else {
			for (Subject sub : subs) {
				System.out.println(sub);
			}
		}
	}

	@Override
	public void insertSubject(Scanner scan) {
		try {
			System.out.print("학번> ");
			Student std = searchStudent(scan.nextLine());

			System.out.print("과목 코드> ");
			Subject sub = searchSubject(scan.nextLine());

			if (std.isLearned(sub)) {
				throw new Exception("이미 신청한 과목입니다.");
			}

			System.out.print("평점> ");
			String score = scan.nextLine();

			std.addSubject(sub);
			sub.addStudent(std, score);
			System.out.println("수강신청 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteSubject(Scanner scan) {
		try {
			System.out.print("학번> ");
			Student std = searchStudent(scan.nextLine());

			System.out.print("과목 코드> ");
			Subject sub = searchSubject(scan.nextLine());

			if (!std.deleteSubject(sub)) {
				throw new Exception("신청하지 않은 과목입니다.");
			}
			sub.deleteStudent(std);
			System.out.println("수강철회 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void studentsOfSubject(Scanner scan) {
		try {
			System.out.print("과목코드> ");
			searchSubject(scan.nextLine()).printStduents();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void printStudentScore(Scanner scan) {
		try {
			System.out.print("학번> ");
			searchStudent(scan.nextLine()).printScores(valueOfScore);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
