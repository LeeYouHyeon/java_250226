package studentProfessorManager;

import java.util.Map;
import java.util.Scanner;

// 학생 계정으로 로그인
public class StudentController {
	Student current; // 현재 로그인한 학생
	Map<String, Professor> professors;
	Map<String, Subject> subjects;
	Scanner scan;

	public StudentController(Student current, Map<String, Professor> profs, Map<String, Subject> subs, Scanner scan) {
		this.current = current;
		this.professors = profs;
		this.subjects = subs;
		this.scan = scan;
	}

	// 0. 학생의 메인
	public void run() {
		int input = 0;
		while (input != 7) {
			try {
				System.out.println(" ┌──────────────────────────────────────────────────────────────────────┐");
				System.out.println(" │ [학생 전용]\t \t\t\t\t\t\t\t│");
				System.out.println(" │  1. 개인정보 확인  |  2. 개인정보 수정  |  3. 수강 정보 확인  |  4. 수강 신청 \t│");
				System.out.println(" │  5. 수강 철회 신청 |  6. 과목 성적 확인 |  7. 로그아웃\t\t\t\t│");
				System.out.println(" └──────────────────────────────────────────────────────────────────────┘");
				System.out.print(" 실행할 메뉴의 번호를 입력해주세요 > ");
				input = Integer.parseInt(scan.nextLine());
				switch (input) {
				case 1:
					printInfo();
					break;
				case 2:
					updateInfo();
					break;
				case 3:
					printSubjects();
					break;
				case 4:
					insertSubject();
					break;
				case 5:
					deleteSubject();
					break;
				case 6:
					printScores();
					break;
				case 7:
					//로그아웃
					break;
				default:
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 1. 학생의 개인정보 출력
	private void printInfo() {
		System.out.println("ID : " + current.ID);
		System.out.println("학번 : " + current.stdCode);
		System.out.println("이름 : " + current.name);
		System.out.println("휴대전화 : " + current.phone);
		System.out.println("주소 : " + current.address);
		System.out.println("이메일 : " + current.email);
	}

	// 2. 개인정보 수정
	private void updateInfo() {
		System.out.println("1. 이름 | 2. 휴대전화 | 3. 주소 | 4. 이메일 ");
		System.out.print("수정할 개인정보를 선택해주세요 > ");
		try {
			switch (Integer.parseInt(scan.nextLine())) {
			case 1:
				System.out.print("이름 > ");
				current.setName(scan.nextLine());
				break;
			case 2:
				System.out.print("휴대전화 > ");
				current.setPhone(scan.nextLine());
				break;
			case 3:
				System.out.print("주소 > ");
				current.setAddress(scan.nextLine());
				break;
			case 4:
				System.out.println("이메일 > ");
				current.setEmail(scan.nextLine());
				break;
			default:
				throw new NumberFormatException();
			}
			System.out.println("수정되었습니다.");
		} catch (NumberFormatException e) {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	// 3. 수강중인 과목 출력
	private void printSubjects() {
		if (current.subjectList.isEmpty()) {
			System.out.println("수강중인 과목이 없습니다.");
		} else {
			for (String subCode : current.subjectList) {
				System.out.println(subjects.get(subCode));
			}
		}
	}

	// 4. 수강신청
	private void insertSubject() {
		// 1. 전체 과목 출력
		// 수강중인 과목은 출력에서 제외
		for (String subCode : subjects.keySet()) {
			if (current.subjectList.contains(subCode)) {
				continue;
			}
			System.out.println(subjects.get(subCode));
		}

		// 2. 수강할 과목을 코드로 입력
		System.out.print("신청할 과목의 코드를 입력해주세요. > ");
		String subCode = scan.nextLine();
		Subject toRegister = subjects.get(subCode);

		// 2-1. 없는 과목은 불가능
		if (subjects.get(subCode) == null) {
			System.out.println("없는 과목입니다.");
			return;
		}
		// 2-2. 이미 신청한 과목은 신청 불가
		if (current.isRegistered(subCode)) {
			System.out.println("이미 신청한 과목입니다.");
			return;
		}

		// 3. 과목 등록
		// 3-1. current에 과목을 등록
		current.insertSubject(subCode);
		// 3-2. subject에 학생을 등록
		toRegister.addStudent(current.getStdCode());

		System.out.println("신청 완료");
	}

	// 5. 수강취소
	private void deleteSubject() {
		// 1. 현재 수강중이고 점수가 "I"인 과목을 출력
		int count = 0;
		for (String subCode : current.subjectList) {
			Subject check = subjects.get(subCode);
			if (check.getStudents().get(current.stdCode).equals("I")) {
				count++;
				System.out.println(check);
			}
		}

		// 1-1. 해당 과목이 없으면 종료
		if (count == 0) {
			System.out.println("취소할 수 있는 과목이 없습니다.");
			return;
		}

		// 2. 수강 취소할 과목의 코드를 입력
		System.out.print("수강 취소할 과목의 코드를 입력하세요. > ");
		String subCode = scan.nextLine();
		// 2-1. 수강하지 않았으면 종료
		if (!current.isRegistered(subCode)) {
			System.out.println("수강하지 않은 과목입니다.");
			return;
		}

		// 3. 수강 취소
		// 3-1. current에서 과목을 취소
		current.deleteSubject(subCode);
		// 3-2. toCancel에서 학생을 제거
		subjects.get(subCode).removeStudent(current.ID);
		System.out.println("수강 취소 완료");
	}

	// 6. 성적표
	private void printScores() {
		double sum = 0;
		int count = 0;
		for (String subCode : current.subjectList) {
			try {
				Subject sub = subjects.get(subCode);
				String score = sub.getStudents().get(current.stdCode);
				System.out.println(sub.getSubCode() + ". " + sub.getSubName() + " : " + score);
				double value = Main.scoreMap.getOrDefault(score, -1.0);
				if (value > -1) {
					sum += value;
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (count > 0) {
			System.out.println("평균 평점 : " + sum / count);
		}

		if (current.subjectList.isEmpty()) {
			System.out.println("수강한 과목이 없습니다.");
		}
	}

}
