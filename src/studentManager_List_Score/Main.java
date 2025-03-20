package studentManager_List_Score;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String subCode[] = { "101", "102", "103", "104", "105" }, subName[] = { "공공데이터", "java", "python", "javascript", "DB" };
		Subject subs[] = new Subject[subCode.length];
		for(int i = 0; i < subCode.length; i++) {
			subs[i] = new Subject(subCode[i], subName[i]);
		}
		
		StudentController sc = new StudentController(subs);
		Exception inputError = new Exception("잘못된 입력");

		int menu = 0;
		do {
			try {
				// 메뉴 출력
				System.out.println("1. 학생등록 | 2. 학생목록 | 3. 학생검색 | 4. 수강신청 | 5. 수강철회 | 6. 종료");
				System.out.print("> ");
				menu = Integer.parseInt(scan.nextLine());
				switch (menu) {
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
					sc.insertSubject(scan);
					break;
				case 5:
					sc.deleteSubject(scan);
					break;
				case 6:
					break;
				default:
					throw inputError;
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} while (menu != 6);

		scan.close();
	}
}
