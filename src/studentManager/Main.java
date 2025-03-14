package studentManager;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		StudentController controller = new StudentController(new Subject("101", "���������� Ǯ����"), new Subject("102", "java"),
				new Subject("103", "DB"), new Subject("104", "JavaScript"), new Subject("105", "Python"), new Subject("106", "Node.js"));

		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println("�л� ��� ���α׷�");
		while (input != 6) {
			System.out.println();
			System.out.println("--menu--");
			System.out.println("1. �л� ��� | 2. �л� ����Ʈ ��� | 3. �л� �˻� | 4. ���� ��û | 5. ���� ��û ��� | 6. ����");
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
					System.out.println("�߸��� �Է�");
			}
		}

		scan.close();
	}
}
