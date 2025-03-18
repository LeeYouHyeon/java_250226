package studentManager_List;

import java.util.Scanner;

public class Main {
	public static int getInt(Scanner scan) {
		return Integer.parseInt(scan.nextLine());
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StudentController sc = new StudentController();
		Exception inputError = new Exception("�߸��� �Է�");

		int menu = 0;
		do {
			try {
				// �޴� ���
				System.out.println("1. �л���� | 2. �л���� | 3. �л��˻� | 4. ������û | 5. ����öȸ | 6. ����");
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
