package studentManager_List_Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student와 Subject를 Map으로 관리?(중복 관리)
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
		// 1. 정보 입력
		String message[] = new String[] {
				"이름> ", "전화번호> ", "주소> ", "나이> "
		};
		String info[] = new String[4];
		for(int i = 0; i < 4; i++) {
			System.out.print(message[i]);
			info[i] = scan.nextLine();
		}
		
		int age = Integer.parseInt(info[3]);
		if(age < 0) {
			throw new Exception("나이가 음수입니다.");
		}
		
		stds.add(new Student(String.valueOf(nextCode), info[0], info[1], info[2], age, new ArrayList<Subject>()));
		nextCode++;
		System.out.println("등록 완료");
	}

	@Override
	public void printStudents() {
		if(stds.isEmpty()) {
			System.out.println("학생이 없습니다.");
		} else {
			for(Student std : stds) {
				System.out.println(std);
			}
		}
	}
	
	private Student getStudent(Scanner scan) {
		System.out.print("학생 번호> ");
		return stds.get(Integer.parseInt(scan.nextLine()) - 1);
	}

	@Override
	public void searchStudent(Scanner scan) {
		System.out.println(getStudent(scan));
	}

	@Override
	public void insertSubject(Scanner scan) {
		// 1. 신청할 학생 결정
		Student s = getStudent(scan);
		
		// 2. 신청할 과목 결정
		for(Subject sub : subs) {
			System.out.println(sub);
		}
		System.out.print("신청할 과목 코드> ");
		String subCode = scan.nextLine();
		
		// 3. 입력받은 과목을 신청
		for(Subject sub : subs) {
			if(sub.getSubCode().equals(subCode)) {
				s.insertSubject(sub);
				return;
			}
		}
		
		// 4. 없으면 안내문 출력
		System.out.println("없는 과목입니다.");
	}

	@Override
	public void deleteSubject(Scanner scan) {
		// 1. 수강철회할 학생 결정
		Student s = getStudent(scan);
		
		// 2. 철회할 과목 결정
		for(Subject sub : s.getSubjects()) {
			System.out.println(sub);
		}
		System.out.print("철회할 과목 코드> ");
		String subCode = scan.nextLine();
		
		// 3. 입력받은 과목을 철회
		for(Subject sub : s.getSubjects()) {
			if(sub.getSubCode().equals(subCode)) {
				s.cancelSubject(sub);
				return;
			}
		}
		
		// 4. 없으면 안내문 출력
		System.out.println("신청하지 않은 과목입니다.");
	}

}
