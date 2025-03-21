package day16_StudentManager_List;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Controller sc = new Controller();
		
		// 기본값
		String subNames[] = {
				"java", "python", "C", "SQL", "JS"
		};
		
		for(int i = 0; i < subNames.length; i++) {
			sc.insertSubject(new Subject(i + 1 + "", subNames[i], 3));
		}
		
		int choice = 0;
		
		while (choice != 11) {
			try {
				System.out.println("--menu--");
				System.out.println("1. 학생 등록 | 2. 학생 목록 | 3. 학생 검색 | 4. 학생 정보 수정");
				System.out.println("5. 학생 삭제 | 6. 과목 목록 | 7. 수강 신청 | 8. 수강 철회");
				System.out.println("9. 과목별 학생 | 10. 학생 성적표 | 11. 종료");
				System.out.print("> ");
				choice = Integer.parseInt(scan.nextLine());
				
				switch(choice) {
				case 1:
					sc.insertStudent(scan);
					break;
				case 2:
					sc.printStudents();
					break;
				case 3:
					sc.searchStudent(scan);
					break;
				case 4:
					sc.updateStudent(scan);
					break;
				case 5:
					sc.deleteStudent(scan);
					break;
				case 6:
					sc.printSubjects();
					break;
				case 7:
					sc.insertSubject(scan);
					break;
				case 8:
					sc.deleteSubject(scan);
					break;
				case 9:
					sc.studentsOfSubject(scan);
					break;
				case 10:
					sc.printStudentScore(scan);
					break;
				case 11:
					System.out.println("종료");
					break;
				default:
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("입력 오류");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		scan.close();
	}
}