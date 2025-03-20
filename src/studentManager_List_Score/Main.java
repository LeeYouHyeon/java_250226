package studentManager_List_Score;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String subCode[] = { "101", "102", "103", "104", "105" }, subName[] = { "����������", "java", "python", "javascript", "DB" };
		Subject subs[] = new Subject[subCode.length];
		for(int i = 0; i < subCode.length; i++) {
			subs[i] = new Subject(subCode[i], subName[i]);
		}
		
		StudentController sc = new StudentController(subs);
		Exception inputError = new Exception("�߸��� �Է�");

		int menu = 0;
		do {
			try {
				// �޴� ���
				System.out.println("1. �л���� | 2. �л���� | 3. �л��˻� | 4. ������û | 5. ����öȸ | 6. ����");
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
