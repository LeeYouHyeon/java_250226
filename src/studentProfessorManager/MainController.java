package studentProfessorManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainController {
	private Map<String, Professor> professors;
	private Map<String, Subject> subjects;
	private Map<String, Student> students;
	Scanner scan = new Scanner(System.in);
	private boolean valid, runned;

	public MainController() {
		professors = new HashMap<String, Professor>();
		subjects = new HashMap<String, Subject>();
		students = new HashMap<String, Student>();

		// professors.txt, subjects.txt, students.txt 파일을 읽어서 세 Map들을 초기화
		// 파일이 없으면 각 map은 빈 채로 남겨둠

		try {
			// 1. 파일 읽기
			BufferedReader proFile = new BufferedReader(new FileReader("professors.txt")),
					subFile = new BufferedReader(new FileReader("subjects.txt")),
					stdFile = new BufferedReader(new FileReader("students.txt"));

			// 교수와 과목 정보 생성
			while (true) {
				// 1. 교수를 한 줄 읽음
				String professorLine = proFile.readLine();
				if (professorLine == null || professorLine.isBlank()) {
					break;
				}

				// 2. 교수의 기본정보로 계정을 생성
				//ID;password;name;phone;address;email;labAddress;과목코드;과목코드;...
				String proInfo[] = professorLine.split(";");
				Professor curr = new Professor(proInfo[0], proInfo[1], proInfo[2], proInfo[3], proInfo[4], proInfo[5],
						proInfo[6]);
				professors.put(proInfo[0], curr);

				// 3. 교수가 담당하는 강좌를 생성
				for (int i = 7; i < proInfo.length; i++) {
					// 3-1. 강좌 생성
					//subCode;subName;professorID;professorName;table;place;point;학생ID;학생점수;학생ID;학생점수;....
					String subInfo[] = subFile.readLine().split(";");
					Subject sub = new Subject(subInfo[0], subInfo[1], subInfo[2], subInfo[3], subInfo[4], subInfo[5],
							Integer.parseInt(subInfo[6]));
					curr.registerSubject(subInfo[0]);
					subjects.put(subInfo[0], sub);

					// 3-2. 학생별 점수 등록
					for (int j = 7; j < subInfo.length; j += 2) {
						sub.addStudent(subInfo[j], subInfo[j + 1]);
					}
				}
			}
			proFile.close();
			subFile.close();

			// 학생 정보 생성
			while (true) {
				// 1. 학생을 한 줄 읽음
				String stdLine = stdFile.readLine();
				if (stdLine == null || stdLine.isBlank()) {
					break;
				}

				// 2. 학생 정보 등록
				//ID;password;name;phone;address;email;stdCode;과목코드;과목코드;...
				String stdInfo[] = stdLine.split(";");
				List<String> subList = new ArrayList<String>();
				for(int i = 7; i < stdInfo.length; i++) {
					subList.add(stdInfo[i]);
				}
				Student curr = new Student(stdInfo[0], stdInfo[1], stdInfo[2], stdInfo[3], stdInfo[4], stdInfo[5],
						stdInfo[6], subList);
				students.put(stdInfo[0], curr);
			}
			stdFile.close();
			valid = true;
		} catch (Exception e) {
			valid = false;
		}
	}

	// 0. 메인 컨트롤러 기동
	public void run() {
		if (!valid) {
			System.out.println("DB에 접근할 수 없습니다. 종료합니다.");
			return;
		}
		if(runned) {
			System.out.println("다시 시작해주세요.");
			return;
		}

		int input = 0;
		while (input != 3) {
			try {
				/*로그인 화면*/
				System.out.println("\t┌───────────────────────────────────────────────┐");
				System.out.println("\t│　1. 학생 로그인  |  2. 교수 로그인  | 3. 종료   \t│");
				System.out.println("\t└───────────────────────────────────────────────┘");
				System.out.print("\t로그인 메뉴를 선택해주세요 > ");

				input = Integer.parseInt(scan.nextLine());
				switch (input) {
				case 1:
					studentLogin();
					break;
				case 2:
					professorLogin();
					break;
				case 3:
					break;
				default:
					throw new NumberFormatException();
				}

			} catch (NumberFormatException e) {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

		// 저장 후 종료
		try {
			BufferedWriter proFile = new BufferedWriter(new FileWriter("professors.txt")),
					subFile = new BufferedWriter(new FileWriter("subjects.txt")),
					stdFile = new BufferedWriter(new FileWriter("students.txt"));
			StringBuffer buffer = new StringBuffer();
			String data = "";
			
			// 1. 교수 저장
			//ID;password;name;phone;address;email;labAddress;과목코드;과목코드;...
			for(Professor p : professors.values().stream().sorted(new Comparator<Professor>() {

				@Override
				public int compare(Professor o1, Professor o2) {
					return o1.getID().compareTo(o2.getID());
				}
			}).collect(Collectors.toList())) {
				data += p.ID + ";";
				data += p.password + ";";
				data += p.name + ";";
				data += p.phone + ";";
				data += p.address + ";";
				data += p.email + ";";
				data += p.labAddress + ";";
				for(String s : p.getSubjects()) {
					data += s + ";";
				}
				data += "\r\n";
				buffer.append(data);
				data = "";
			}
			proFile.write(buffer.toString());
			buffer = null;
			buffer = new StringBuffer();
			
			// 2. 과목 저장
			//subCode;subName;professor;professorName;table;place;point;학번;학생점수;학번;학생점수;....
			for(Subject s : subjects.values().stream().sorted(new Comparator<Subject>() {

				@Override
				public int compare(Subject o1, Subject o2) {
					return o1.getProfessor().compareTo(o2.getProfessor());
				}
			}).collect(Collectors.toList())) {
				data += s.getSubCode() + ";";
				data += s.getSubName() + ";";
				data += s.getProfessor() + ";";
				data += s.getProfessorName() + ";";
				data += s.getTable() + ";";
				data += s.getPlace() + ";";
				data += s.getPoint() + ";";
				Map<String, String> scores = s.getStudents();
				for(String stdCode : scores.keySet()) {
					data += stdCode + ";";
					data += scores.get(stdCode) + ";";
				}
				data += "\r\n";
				buffer.append(data);
				data = "";
			}
			subFile.write(buffer.toString());
			buffer = null;
			buffer = new StringBuffer();
			
			// 3. 학생 저장
			//ID;password;name;phone;address;email;stdCode;과목코드;과목코드;...
			for(Student s : students.values()) {
				data += s.getID() + ";";
				data += s.getPassword() + ";";
				data += s.getName() + ";";
				data += s.getPhone() + ";";
				data += s.getAddress() + ";";
				data += s.getEmail() + ";";
				data += s.getStdCode() + ";";
				for(String subCode : s.getSubjectList()) {
					data += subCode + ";";
				}
				data += "\r\n";
				buffer.append(data);
				data = "";
			}
			stdFile.write(buffer.toString());
			
			proFile.close();
			subFile.close();
			stdFile.close();
			scan.close();
			runned = true;
		} catch (Exception e) {
			System.out.println("저장에 실패했습니다.");
		} finally {
			System.out.println("종료합니다.");
		}
	}

	// 1. 학생 로그인
	private void studentLogin() {
		System.out.println("\t[학생 로그인을 선택하셨습니다.]");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			System.out.println("시스템 에러가 발생했습니다. 다시 시도해주세요.");
			return;
		}

		//ID, 비밀번호 입력
		System.out.println();
		System.out.print("\t>ID를 입력해주세요 : ");
		String id = scan.nextLine();
		System.out.print("\t>비밀번호를 입력해주세요 : ");
		String pw = scan.nextLine();

		try {
			// 로딩중(가짜)
			Thread.sleep(150);
			System.out.print("\t로");
			Thread.sleep(150);
			System.out.print("그");
			Thread.sleep(150);
			System.out.print("인 ");
			Thread.sleep(150);
			System.out.print("중");
			Thread.sleep(150);
			System.out.print("입");
			Thread.sleep(150);
			System.out.print("니");
			Thread.sleep(150);
			System.out.print("다");
			Thread.sleep(150);
			System.out.print(".");
			Thread.sleep(150);
			System.out.print(".");
			Thread.sleep(150);
			System.out.print(".  ");
			Thread.sleep(100);

			// 로그인 체크
			Student current = students.get(id);
			if (current.passCheck(pw)) {
				System.out.println("로그인 완료!");
				new StudentController(current, professors, subjects, scan).run();
			} else {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("ID나 비밀번호가 틀렸습니다.");
		} catch (InterruptedException e) {
			System.out.println("시스템 에러가 발생했습니다. 다시 시도해주세요.");
		}
	}

	// 2. 교수 로그인
	private void professorLogin() {
		System.out.println("\t[교수 로그인을 선택하셨습니다.]");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			System.out.println("시스템 에러가 발생했습니다. 다시 시도해주세요.");
			return;
		}

		//ID, 비밀번호 입력
		System.out.println();
		System.out.print("\t>ID를 입력해주세요 : ");
		String id = scan.nextLine();
		System.out.print("\t>비밀번호를 입력해주세요 : ");
		String pw = scan.nextLine();

		try {
			// 로딩중(가짜)
			Thread.sleep(150);
			System.out.print("\t로");
			Thread.sleep(150);
			System.out.print("그");
			Thread.sleep(150);
			System.out.print("인 ");
			Thread.sleep(150);
			System.out.print("중");
			Thread.sleep(150);
			System.out.print("입");
			Thread.sleep(150);
			System.out.print("니");
			Thread.sleep(150);
			System.out.print("다");
			Thread.sleep(150);
			System.out.print(".");
			Thread.sleep(150);
			System.out.print(".");
			Thread.sleep(150);
			System.out.print(".  ");
			Thread.sleep(100);

			// 로그인 체크
			Professor current = professors.get(id);
			if (current.passCheck(pw)) {
				System.out.println("로그인 완료!");
				new ProfessorController(current, subjects, scan).run();
				;
			} else {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("ID나 비밀번호가 틀렸습니다.");
		} catch (InterruptedException e) {
			System.out.println("시스템 에러가 발생했습니다. 다시 시도해주세요.");
		}
	}

}
