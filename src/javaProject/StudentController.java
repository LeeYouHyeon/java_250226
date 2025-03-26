package javaProject;

import java.util.Map;
import java.util.Scanner;

// 학생 계정으로 로그인
public class StudentController {
	private Student current; // 현재 로그인한 학생
	private Map<String, Subject> subjects; // 전체 과목 목록(수강중인 과목은 current가 가지고 있음)
	private Scanner scan;

	public StudentController(Student current, Map<String, Subject> subs, Scanner scan) {
		this.current = current;
		this.subjects = subs;
		this.scan = scan;
	}

	// 0. 학생의 메인
	public void run() {
		int input = 0;
		while (input != 7) {
			try {
				System.out.println();
				System.out.println(" ┌──────────────────────────────────────────────────────────────────────┐");
				System.out.println(" │ [학생 전용]\t \t\t\t\t\t\t\t│");
				System.out.println(" │  1. 개인정보 확인  |  2. 개인정보 수정  |  3. 수강 정보 확인  |  4. 수강 신청 \t│");
				System.out.println(" │  5. 수강 철회 신청 |  6. 과목 성적 확인 |  7. 로그아웃\t\t\t\t│");
				System.out.println(" └──────────────────────────────────────────────────────────────────────┘");
				System.out.print("  실행할 메뉴의 번호를 입력해주세요 ▶ ");
				input = Integer.parseInt(scan.nextLine());
				System.out.println();
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
				System.out.println("  잘못 입력하셨습니다.");
			} catch (Exception e) {
				System.out.println("  알 수 없는 오류");
			}
		}
	}

	// 1. 학생의 개인정보 출력
	private void printInfo() {
		System.out.println("  ─<나의 개인 정보>─");
		System.out.println("  ID\t : " + current.ID);
		System.out.println("  학번\t : " + current.stdCode);
		System.out.println("  이름\t : " + current.name);
		System.out.println("  휴대전화\t : " + current.phone);
		System.out.println("  주소\t : " + current.address);
		System.out.println("  이메일\t : " + current.email);
	}

	// 2. 개인정보 수정
	private void updateInfo() {
		//id, 이름, 휴대전화, 주소, 이메일
		while (true) {
			try {
				System.out.println("  ※수정 가능한 정보");
				System.out.println("  ─────────────────────────────────────────────");
				System.out.println("    1. 전화번호 변경 | 2. 주소 변경 | 3. e-mail 변경");
				System.out.println("  ─────────────────────────────────────────────");
				System.out.print("  해당하는 번호를 입력해주세요 ▶ ");
				String comm = scan.nextLine();
				
				switch (Integer.parseInt(comm)) {
				case 1:
					System.out.print("  변경하실 전화번호를 입력해주세요 : ");
					String phone = scan.nextLine();
					if (current.getPhone().equals(phone)) {
						System.out.println("  변경된 내역이 없습니다.");
					} else {
						current.setPhone(phone);
						System.out.println("  전화번호가 " + phone + "으로 변경되었습니다.");
					}
					break;
				case 2:
					System.out.print("  변경하실 주소를 입력해주세요 : ");
					String address = scan.nextLine();
					if (current.getAddress().equals(address)) {
						System.out.println("  변경된 내역이 없습니다.");
					} else {
						current.setAddress(address);
						System.out.println("  주소가 " + address + "로 변경되었습니다.");
					}
					break;
				case 3:
					System.out.print("  변경하실 email 주소를 입력해주세요 : ");
					String email = scan.nextLine();
					if (current.getEmail().equals(email)) {
						System.out.println("  변경된 내역이 없습니다.");
					} else {
						current.setEmail(email);
						System.out.println("  e-mail 주소가 " + email + "로 변경되었습니다.");
					}
					break;
				default:
					throw new NumberFormatException();
				}
				
				System.out.println();
				System.out.println("  정보를 계속 수정하려면 'Y'를, 초기화면 돌아가려면 그 외의 키를 입력해주세요.");
				System.out.print("  ▶ ");
				String change = scan.nextLine().toUpperCase();
				if (change.length() != 1 || change.charAt(0) != 'Y') {
					System.out.println("  !초기화면으로 돌아갑니다.");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  잘못 입력하셨습니다. 번호를 다시 확인해주세요.");
			}
		}
	}

	// 3. 수강중인 과목 출력
	private void printSubjects() {
		if (current.subjectList.isEmpty()) {
			System.out.println("  현재 수강중인 과목이 없습니다.");
		} else {
			int count = 0;
			System.out.println("  ───────[현재 수강 중인 과목]───────");
			for (String subCode : current.subjectList) {
				count++;
				System.out.print("   "+count+". ");
				System.out.println(subjects.get(subCode));
			}
		}
	}

	// 4. 수강신청
	private void insertSubject() {
		// 1. 전체 과목 출력
		// 수강중인 과목은 출력에서 제외
		int count = 0;
		for (String subCode : subjects.keySet()) {
			if (current.subjectList.contains(subCode)) {
				continue;
			}
			count++;
			System.out.print("  "+count+". ");
			System.out.println(subjects.get(subCode));
		}

		// 2. 수강할 과목을 코드로 입력
		System.out.println();
		System.out.println("  신청할 과목의 코드를 입력해주세요. (ex. COSE001) ");
		System.out.print("  >");
		String subCode = scan.nextLine();
		Subject toRegister = subjects.get(subCode);

		// 2-1. 없는 과목은 불가능
		if (subjects.get(subCode) == null) {
			System.out.println("  "+subCode+"는(은) 없는 과목입니다.");
			return;
		}
		// 2-2. 이미 신청한 과목은 신청 불가
		if (current.isRegistered(subCode)) {
			System.out.println("  이미 신청한 과목입니다.");
			return;
		}

		// 3. 과목 등록
		// 3-1. current에 과목을 등록
		current.insertSubject(subCode);
		// 3-2. subject에 학생을 등록
		toRegister.addStudent(current.getStdCode());
		System.out.println("  수강 신청이 완료되었습니다.");
	}

	// 5. 수강취소
	private void deleteSubject() {
		// 1. 현재 수강중이고 점수가 "I"인 과목을 출력
		int count = 0;
		for (String subCode : current.subjectList) {
			Subject check = subjects.get(subCode);
			if (check.getStudents().get(current.stdCode).equals("I")) {
				count++;
				if (count == 1) {
					System.out.println("  ───────[수강 철회 가능 목록]───────");
				}
				System.out.print("   "+count+". ");
				System.out.println(check);
			}
		}
		if(count >= 1) {
			System.out.println();
		}
		
		// 1-1. 해당 과목이 없으면 종료
		if (count == 0) {
			System.out.println("  취소할 수 있는 과목이 없습니다.");
			return;
		}

		// 2. 수강 취소할 과목의 코드를 입력
		System.out.print("  수강 취소할 과목의 코드를 입력하세요. > ");
		String subCode = scan.nextLine();

		// 3. 수강 신청 취소
		try {
			Subject toCancel = subjects.get(subCode);
			String score = toCancel.getStudents().get(current.stdCode);
			
			if(score == null) {
				System.out.println("  수강하지 않은 과목입니다.");
				return;
			}
			
			if (score.equals("I")) {
				current.deleteSubject(subCode);
				toCancel.removeStudent(current.ID);
				System.out.println("  수강취소가 완료되었습니다.");
			} else {
				System.out.println("  이미 점수가 입력된 과목입니다.");
			}
		} catch (NullPointerException e) {
			System.out.println("  없는 과목입니다.");
		}
	}

	// 6. 성적표
	private void printScores() {
		// 번외. 아예 수강한 과목 자체가 없을 경우 에러 메시지 출력
		if (current.subjectList.isEmpty()) {
			System.out.println("  수강한 과목이 없습니다.");
			return;
		}
		
		double sum = 0;
		int count = 0;
		int index = 0;

		// 1. 학생이 수강하는 과목들을 훑으면서 점수를 출력하고, 가능한 경우 수치화
		for (String subCode : current.subjectList) {
			// 1-1. 평점을 출력
			index++;
			Subject sub = subjects.get(subCode);
			String score = sub.getStudents().get(current.stdCode);
			System.out.println("  "+index+". (" + sub.getSubCode() + ")"+ sub.getSubName() + "\r\t>성적 : " + score);

			// 1-2. 평점이 수치화할 수 있는 경우 계산에 포함
			double value = Main.scoreMap.getOrDefault(score, -1.0); // 수치화할 수 없는 경우 -1
			if (value > -1) {
				sum += value;
				count++;
			}
		}

		// 2. 수치화된 평점이 존재할 경우 평균 평점 출력
		if (count > 0) {
			System.out.println("  평균 평점 : " + sum / count + " / 4.3");
		}
	}

}
