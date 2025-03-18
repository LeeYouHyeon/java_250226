package studentManager_List;

import java.util.Scanner;

public class Main {
	public static int getInt(Scanner scan) {
		return Integer.parseInt(scan.nextLine());
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentController sc = new StudentController();
		Exception inputError = new Exception("잘못된 입력");

		int menu = 0;
		do {
			try {
				// 메뉴 출력
				System.out.println("1. 학생등록 | 2. 학생목록 | 3. 학생검색 | 4. 수강신청 | 5. 수강철회 | 6. 종료");
				menu = getInt(scan);
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
