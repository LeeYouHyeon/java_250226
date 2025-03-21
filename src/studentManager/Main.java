package studentManager;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentController controller = new StudentController(new Subject("101", "공공데이터 풀스택"), new Subject("102", "java"),
				new Subject("103", "DB"), new Subject("104", "JavaScript"), new Subject("105", "Python"), new Subject("106", "Node.js"));

		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println("학생 등록 프로그램");
		while (input != 6) {
			System.out.println();
			System.out.println("--menu--");
			System.out.println("1. 학생 등록 | 2. 학생 리스트 출력 | 3. 학생 검색 | 4. 수강 신청 | 5. 수강 신청 취소 | 6. 종료");
			System.out.print("> ");
			input = scan.nextInt();
			scan.nextLine();

			switch (input) {
				case 1:
					controller.insertStudent(scan);
					break;
				case 2:
					controller.printStudents();
					break;
				case 3:
					controller.searchStudent(scan);
					break;
				case 4:
					controller.insertSubject(scan);
					break;
				case 5:
					controller.deleteSubject(scan);
					break;
				case 6:
					break;
				default:
					System.out.println("잘못된 입력");
			}
		}

		scan.close();
	}
}
