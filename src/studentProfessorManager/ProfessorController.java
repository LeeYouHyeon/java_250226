package studentProfessorManager;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProfessorController {
	private Professor current;
	private Map<String, Subject> subjects;
	Scanner scan;

	public ProfessorController(Professor current, Map<String, Subject> subjects, Scanner scan) {
		this.current = current;
		this.subjects = subjects;
		this.scan = scan;
	}

	// 0. 메인
	public void run() {
		int input = 0;
		while (input != 6) {
			try {
				System.out.println(" ┌──────────────────────────────────────────────────────────────────────┐");
				System.out.println(" │ [교수 전용]\t \t\t\t\t\t\t\t│");
				System.out.println(" │  1. 개인정보 확인  |  2. 개인정보 수정  |  3. 담당 과목 목록  |  4. 과목 점수 입력\t│");
				System.out.println(" │  5. 학생 점수 수정 |  6. 로그아웃\t\t\t\t\t\t│");
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
					insertScore();
					break;
				case 5:
					updateScore();
					break;
				case 6:
					System.out.println("로그아웃합니다.");
					break;
				default:
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못 입력하셨습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 1. 교수 개인정보 출력
	private void printInfo() {
		System.out.println("ID : " + current.ID);
		System.out.println("이름 : " + current.name);
		System.out.println("휴대전화 : " + current.phone);
		System.out.println("주소 : " + current.address);
		System.out.println("이메일 : " + current.email);
		System.out.println("연구실 : " + current.labAddress);
	}

	// 2. 교수 개인정보 수정
	private void updateInfo() {
		//id, 이름, 휴대전화, 주소, 이메일, 연구실
		while (true) {
			System.out.println("  ※수정 가능한 정보");
			System.out.println("  ───────────────────────────────────────────────────────────────");
			System.out.println("    1. 전화번호 변경 | 2. 주소 변경 | 3. e-mail 변경 | 4. 연구실 주소 변경");
			System.out.println("  ───────────────────────────────────────────────────────────────");
			System.out.print("  해당하는 번호를 입력해주세요 ▶ ");

			try {
				switch (Integer.parseInt(scan.nextLine())) {
				case 1:
					System.out.println("  변경하실 전화번호를 입력해주세요 : ");
					String phone = scan.nextLine();
					if (current.getPhone().equals(phone)) {
						System.out.println("  변경된 내역이 없습니다.");
					} else {
						current.setPhone(phone);
						System.out.println("  전화번호가 " + phone + "으로 변경되었습니다.");
					}
					break;
				case 2:
					System.out.println("  변경하실 주소를 입력해주세요 : ");
					String address = scan.nextLine();
					if (current.getAddress().equals(address)) {
						System.out.println("  변경된 내역이 없습니다.");
					} else {
						current.setAddress(address);
						System.out.println("  주소가 " + address + "로 변경되었습니다.");
					}
					break;
				case 3:
					System.out.println("  변경하실 email 주소를 입력해주세요 : ");
					String email = scan.nextLine();
					if (current.getEmail().equals(email)) {
						System.out.println("  변경된 내역이 없습니다.");
					} else {
						current.setEmail(email);
						System.out.println("  e-mail 주소가 " + email + "로 변경되었습니다.");
					}
					break;
				case 4:
					System.out.println("  변경하실 연구실 주소를 입력해주세요 : ");
					String labAddress = scan.nextLine();
					if (current.getLabAddress().equals(labAddress)) {
						System.out.println("  변경된 내역이 없습니다.");
					} else {
						current.setLabAddress(labAddress);
						System.out.println("  연구실 주소가 " + labAddress + "로 변경되었습니다.");
					}
					break;
				default:
					throw new NumberFormatException();
				}

				System.out.print("  정보를 계속 수정하시겠습니까? ('Y'=예 || 그 외 입력은 아니오로 인식됩니다.) : ");
				String change = scan.nextLine();
				if (change.length() != 1 || change.charAt(0) != 'Y') {
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("  잘못 입력하셨습니다. 번호를 다시 확인해주세요.");
			}
		}
	}

	// 3. 담당 과목 출력
	private void printSubjects() {
		List<String> teach = current.getSubjects();
		if (teach.isEmpty()) {
			System.out.println("담당하는 과목이 없습니다.");
			return;
		}

		for (String subCode : teach) {
			System.out.println(subjects.get(subCode));
		}
	}

	// 4. 점수 입력
	private void insertScore() {
		List<String> teach = current.getSubjects();
		if (teach.isEmpty()) {
			System.out.println("담당하는 과목이 없습니다.");
			return;
		}

		printSubjects();
		
		System.out.print("과목 코드를 입력해주세요. > ");
		String subCode = scan.nextLine();

		if (!teach.contains(subCode)) {
			System.out.println("담당하지 않거나 없는 과목입니다.");
			return;
		}

		Subject toInsert = subjects.get(subCode);
		Map<String, String> scores = toInsert.getStudents();
		int count = 0;
		for (String stdCode : scores.keySet()) {
			if (scores.get(stdCode).equals("I")) {
				count++;
			}
		}
		if (count == 0) {
			System.out.println("모든 학생의 점수가 입력되어있습니다.");
			return;
		}

		System.out.println("점수 입력을 시작합니다. 학번을 보여주면 점수를 입력해주세요.");
		for (String stdCode : scores.keySet()) {
			if(scores.get(stdCode).equals("I")) {
				System.out.print(stdCode + " : ");
				scores.put(stdCode, scan.nextLine());
			}
		}
		System.out.println("점수 입력 완료");
	}

	// 5. 점수 수정
	private void updateScore() {
		List<String> teach = current.getSubjects();
		if (teach.isEmpty()) {
			System.out.println("담당하는 과목이 없습니다.");
			return;
		}

		// 과목 선택
		System.out.print("과목 코드를 입력해주세요. > ");
		String subCode = scan.nextLine();
		if (!teach.contains(subCode)) {
			System.out.println("담당하지 않거나 없는 과목입니다.");
			return;
		}
		
		// 학생들의 점수 출력
		Subject subjectToUpdate = subjects.get(subCode);
		subjectToUpdate.printScores();

		// 수정할 학생의 학번 입력
		System.out.print("점수를 수정할 학생의 학번을 입력해주세요. > ");
		String stdCode = scan.nextLine();
		if (!subjectToUpdate.hasApplied(stdCode)) {
			System.out.println("수강하지 않은 학생입니다.");
			return;
		}

		// 점수 수정
		System.out.print("점수를 새로 입력해주세요. > ");
		subjectToUpdate.getStudents().put(stdCode, scan.nextLine());
		System.out.println("점수 수정 완료");
	}

}
