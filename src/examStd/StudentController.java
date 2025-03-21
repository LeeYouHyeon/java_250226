package examStd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentController {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private ArrayList<Subject> subjectList = new ArrayList<Subject>();
	Scanner scan = new Scanner(System.in);
	
	//기본값 추가
	public void addStudent() {
		studentList.add(new Student("111", "홍길동", "20", "010-1111-1111", "서울시"));
		studentList.add(new Student("222", "김순이", "20", "010-1111-2222", "서울시"));
		studentList.add(new Student("333", "박철수", "21", "010-1111-3333", "경기도"));
		studentList.add(new Student("444", "이영철", "20", "010-1111-4444", "서울시"));
		studentList.add(new Student("555", "신짱구", "21", "010-1111-5555", "경기도"));
	}
	public void addSubject() {
		subjectList.add(new Subject("1111", "java", 3, 2, "홍길동", "화목/2시~4시", "1강의장"));
		subjectList.add(new Subject("2222", "DB", 3, 2, "이순신", "월수/2시~4시", "2강의장"));
		subjectList.add(new Subject("3333", "HTML", 2, 3, "김영이", "화금/2시~4시", "3강의장"));
		subjectList.add(new Subject("4444", "CSS", 2, 3, "황기동", "월목/2시~4시", "4강의장"));
		subjectList.add(new Subject("5555", "javascript", 3, 3, "박순철", "수목/2시~4시", "5강의장"));
	}
	
	public int menuPrint() {
		System.out.println("--menu--");
		System.out.println("1. 학생등록 | 2. 학생 목록 출력 | 3. 학생 검색");
		System.out.println("4. 학생 정보 수정 | 5. 학생 삭제");
		System.out.println("6. 수강신청 | 7. 수강철회");
		System.out.println("8. 과목별 학생 목록");
		System.out.println("9. 성적 등록(교수용)");
		System.out.println("10. 성적표 출력(학생용)");
		System.out.println("11. 종료");
		System.out.print("> ");
		try {
			return Integer.parseInt(scan.nextLine());
		} catch (Exception e) {
			return 0;
		}
	}

	public void insertStudnet() {
		// 학생 추가
		try {
			System.out.println("학번> ");
			String num = scan.nextLine();
			for(Student s : studentList) {
				if(s.equals(new Student(num))) {
					throw new Exception("이미 등록된 학번입니다.");
				}
			}
			
			System.out.println("이름> ");
			String name = scan.nextLine();
			System.out.println("나이> ");
			String age = scan.nextLine();
			System.out.println("전화번호> ");
			String phone = scan.nextLine();
			System.out.println("주소> ");
			String address = scan.nextLine();
			
			studentList.add(new Student(num, name, age, phone, address));
			System.out.println("학생 등록 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void printStudent() {
		// 학생 리스트 출력
		if(studentList.isEmpty()) {
			System.out.println("학생이 없습니다.");
		} else {
			System.out.println("--학생전체목록--");
			for(Student s : studentList) {
				System.out.println(s);
			}
		}
		System.out.println("------------");
	}
	// 수강신청시 확인하는 용도
	public void printSubjectList() {
		if(subjectList.isEmpty()) {
			System.out.println("준비중입니다.");
		} else {
			System.out.println("--수강신청과목 목록--");
			for(Subject s : subjectList) {
				System.out.println(s);
			}
			System.out.println("----------------");
		}
	}
	
	public void searchStudent() {
		// 학생검색
		System.out.print("검색 학번> ");
		String num = scan.nextLine();
		
		for(Student student : studentList) {
			if(student.equals(new Student(num))) {
				System.out.println(student);
				// 수강 목록도 출력
				student.subjectPrint();
				return;
			}
		}
		System.out.println("학생을 찾을 수 없습니다.");
	}

	public void searchSubject() {
		// 과목을 주고, 해당 과목을 수강하는 학생 명단 출력
		// 출력 : 학생명단
		// 조건 : 수강과목에 검색 대상 과목이 존재하는지
		System.out.print("검색 과목 번호> ");
		String subNum = scan.nextLine();
		
		boolean found = false;
		for(Subject s : subjectList) {
			if(s.equals(new Subject(subNum))) {
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("과목을 찾을 수 없습니다.");
			return;
		}
		
		ArrayList<Student> stds = new ArrayList<Student>();
		for(Student s : studentList) {
			if(s.getSubject().contains(new Subject(subNum))) {
				stds.add(s);
			}
		}
		if(stds.isEmpty()) {
			System.out.println("신청한 학생이 없습니다.");
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
		// 수강취소
		// 누가? 무슨 과목을?
		System.out.print("학번> ");
		String num = scan.nextLine();
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				// 내가 신청한 과목 출력
				s.subjectPrint();
				System.out.print("삭제 과목 번호> ");
				s.deleteSub(scan.nextLine());
				return;
			}
		}
		System.out.println("학생을 찾을 수 없습니다.");
	}

	public void removeStudent() {
		// 학생 삭제
		System.out.print("삭제 학번> ");
		String num = scan.nextLine();
		if (studentList.remove(new Student(num))) {
			System.out.println("삭제 완료");
		} else {
			System.out.println("없는 학번입니다.");
		}
	}

	public void modifyStudent() {
		// 학생수정 => 삭제 후 다시 추가
		
	}

	public void insertSubject() {
		// 수강신청
		// 누가? 학번을 받아,
		// 어떤 과목? Student class method => 매개변수 전달
		// 그 학생 객체의 subject 리스트에 값을 추가
		
		// 학번 입력
		System.out.print("수강신청 학번> ");
		String num = scan.nextLine();
		
		// 학번 검색
		Student std = null;
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				std = s;
			}
		}
		if(std == null) {
			System.out.println("학생이 없습니다.");
			return;
		}
		
		// 과목 리스트 출력
		printSubjectList();
		
		// 과목번호 입력
		System.out.print("수강신청 과목 번호> ");
		String subNum = scan.nextLine();
		for(Subject s : subjectList) {
			if(s.equals(new Subject(subNum))) {
				std.insertSubject(new Subject(s));
				return;
			}
		}
		System.out.println("없는 과목입니다.");
	}

	public void insertScore() {
		// 학생 성적 등록
		// 누구? 무슨 과목?
		System.out.print("학번> ");
		String num = scan.nextLine();
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				// 내가 수강하는 과목
				s.subjectPrint();
				System.out.print("과목번호> ");
				String subNum = scan.nextLine();
				s.insertScore(subNum, scan);
				return;
			}
		}
		System.out.println("학생을 찾을 수 없습니다.");
	}
	
	public void printScore() {
		// 성적표 출력
		System.out.print("학번> ");
		String num = scan.nextLine();
		
		for(Student s : studentList) {
			if(s.equals(new Student(num))) {
				s.subjectPrint();
				System.out.println("평균 : " + s.getTotal()/(double)s.getSubject().size());
				return;
			}
		}
		
		System.out.println("학생을 찾을 수 없습니다.");
	}
	
	// 학생 리스트에 넣기, 빼기, 수정, 출력
	// 과목 리스트에 넣기, 빼기, 수정, 출력
	
	
}
